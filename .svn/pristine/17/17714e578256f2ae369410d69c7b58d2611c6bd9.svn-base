package Xproer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.apache.commons.fileupload.FileItem;

/**
 * 上传对象
 * 更新记录：
 * 	2013-01-25 创建
 *
 */
public class Uploader {
	
	public PageContext m_pc;
	String m_folder;		//上传文件夹。D:\\webapps\\WordPaster\\upload\\
	String m_curBasePath;	//当前文件路径。http://localhost:8080/WordPaster/
	String m_filePathRel;	//文件在服务器中的相对路径。http://localhost:8080/WordPaster/upload/2012/05/24/
	String m_fileName;		//文件名称。11223344.png
	
	/*
	 * 在JSP页面中构造。传入 pageContext
	 * */
	public Uploader(PageContext pc,HttpServletRequest sr)
	{
		this.m_pc = pc;
		String path = sr.getContextPath();
		this.m_curBasePath = sr.getScheme()+"://" + sr.getServerName()+":" + sr.getServerPort() + path+"/";
	}

	/*
	 * 获取文件相对路径。
	 * 返回值：
	 * 		http://localhost:8080/WordPaster/upload/2012/05/24/11223344.png
	 * */
	public String GetFilePathRel()
	{
		return this.m_filePathRel + this.m_fileName;
	}
	
	/*
	 * 创建上传文件夹
	 * 2012\\05\\24\\
	 * */
	public void CreateFolder()
	{
		Date timeCur = new Date();
		SimpleDateFormat fmtYY = new SimpleDateFormat("yyyy");
		SimpleDateFormat fmtMM = new SimpleDateFormat("MM");
		SimpleDateFormat fmtDD = new SimpleDateFormat("dd");
		String strYY = fmtYY.format(timeCur);
		String strMM = fmtMM.format(timeCur);
		String strDD = fmtDD.format(timeCur);
		
		//相对路径/2012/05/24/
		String pathRel = "upload/" + strYY + "/" + strMM + "/" + strDD + "/";
		String pathAbs = "upload\\" + strYY + "\\" + strMM + "\\" + strDD + "\\";
		//文件路径
		this.m_filePathRel = this.m_curBasePath + pathRel;
		
		this.m_folder = this.m_pc.getServletContext().getRealPath("/") + pathAbs;
		
		File f = new File(this.m_folder);
		//文件夹不存在
		if(!f.exists())
		{
			f.mkdirs();
		}		
	}
	
	/*
	 * 根据当前时间生成文件名称。
	 * 返回值：
	 * 		年月日，时分秒
	 * 		2012-05-24-16-06
	 * */
	public String GenerateFileName()
	{
		Date timeCur = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("HHmmssSSSS");
		String timeStr = fmt.format(timeCur);
		return timeStr;
	}
	
	//将文件保存到服务器中
	public void SaveFile(FileItem upFile) throws IOException
	{
		//11223344.png
		String fileName = upFile.getName();
		//如果控件是以UTF-8编码方式提交的数据则使用下面的方式对文件名称进行解码。
		fileName = fileName.replaceAll("\\+","%20");
		//客户端使用的是encodeURIComponent编码
		fileName = URLDecoder.decode(fileName,"UTF-8");
		
		int pos = fileName.indexOf('.');
		String ext = fileName.substring(pos);
		ext.toLowerCase();
		this.m_fileName = this.GenerateFileName() + ext;
		
		this.CreateFolder();
		String filePath = this.m_folder + this.m_fileName;		

		InputStream stream = upFile.getInputStream();			
		byte[] data = new byte[(int)upFile.getSize()];//128k
		int readLen = stream.read(data);//实际读取的大小
		stream.close();
		
		RandomAccessFile raf = new RandomAccessFile(filePath,"rw");
		//定位文件位置
		raf.write(data);
		raf.close();

		
	}

}