package interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.wabacus.config.Config;
import com.wabacus.system.intercept.AbsFileUploadInterceptor;
import com.wabacus.system.intercept.AbsPageInterceptor;

public class ZhuangBeiweixiuGaihuanFileupInterceptor extends AbsFileUploadInterceptor {

    String filename=null;
	@Override
	public boolean beforeDisplayFileUploadInterface(HttpServletRequest request,
			Map<String, String> mFormAndConfigValues, PrintWriter out) {
		// TODO Auto-generated method stub
		String beizhu=null;
        String param_leibie=null;
        String param_fujiansuoshu=null;

        String oldvalue=null;
        param_leibie=(String) request.getAttribute("leibie");
    	param_fujiansuoshu=request.getParameter("fujiansuoshu");
        if(mFormAndConfigValues!=null)
        {//当前是因为上传失败时显示上传界面
        	
        	beizhu=mFormAndConfigValues.get("beizhu");
            if(beizhu!=null&&!beizhu.trim().equals(""))
            {//当前是在显示文件上传输入框的文件上传界面（注意这个时候不能从request中取如下值，因为这个时候的表单不是普通的表单，而是enctype="multipart/form-data"，必须从mFormAndConfigValues中取传过来的数据）
            	
            	oldvalue=mFormAndConfigValues.get("OLDVALUE");
            }
            filename=mFormAndConfigValues.get("filename");
            System.out.println("当前是上传失败后再次显示的文件上传界面........."+param_leibie+"   "+param_fujiansuoshu);
        }else
        {//当前是第一次访问上传界面
        	beizhu=request.getParameter("beizhu");
            filename=request.getParameter("filename");
            System.out.println("当前是第一次点击文件上传输入框显示的文件上传界面........."+param_leibie+"   "+param_fujiansuoshu);
        }
        
        beizhu=beizhu==null?"":beizhu.trim();
		out.println("备注：<input type='text' name='beizhu' value='"+beizhu+"'><hr>");
		return super.beforeDisplayFileUploadInterface(request, mFormAndConfigValues,
				out);
	}

	@Override
	public boolean beforeDisplayFileUploadPrompt(HttpServletRequest request,
			List lstFieldItems, Map<String, String> mFormAndConfigValues,
			String failedMessage, PrintWriter out) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(lstFieldItems==null||lstFieldItems.size()==0) return true;
        FileItem fItemTmp;
        StringBuffer fileNamesBuf=new StringBuffer();
        for(int i=0;i<lstFieldItems.size();i++)
        {
            fItemTmp=(FileItem)lstFieldItems.get(i);
            if(fItemTmp.isFormField()) continue;//如果是普通表单域
            fileNamesBuf.append(fItemTmp.getName()).append(";");
        }
        
/*       String leibie=(String) request.getAttribute("leibie");*/
       String leibie=(String) request.getSession().getAttribute("leibie");
       String fujiansuoshu=(String) request.getSession().getAttribute("fujiansuoshu");
       String DBTable=(String) request.getSession().getAttribute("DBTable");
       String page=(String) request.getSession().getAttribute("page");
       String report=(String) request.getSession().getAttribute("report");
        if(fileNamesBuf.charAt(fileNamesBuf.length()-1)==';') fileNamesBuf.deleteCharAt(fileNamesBuf.length()-1);
        if(failedMessage!=null&&!failedMessage.trim().equals(""))
        {//如果上传失败
            out.println("<h4>温馨提示：上传文件"+fileNamesBuf.toString()+"失败，"+failedMessage+"</h4>");
        }else
        {//上传成功
            

            String beizhu=mFormAndConfigValues.get("beizhu");
            Connection conn= Config.getInstance().getDataSource("ds_oracle").getConnection();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date=new Date(System.currentTimeMillis());
            
            String sql=String.format("insert into %s (fujian,leibie,beizhu,fujiansuoshu,time) VALUES('%s','%s','%s','%s',to_date('%s','yyyy-mm-dd   hh24:mi:ss'))",DBTable,filename,leibie,beizhu,fujiansuoshu,df.format(date).toString());
            System.out.println(sql);
            Statement stmt=null;
            try
            {
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            { 
            	out.println("<script language='javascript'>");
                out.println("alert('上传文件"+fileNamesBuf.toString()+"成功');");
                out.println("artDialog.open.origin.refreshComponentDisplay('"+page+"','"+report+"');");
                out.println("</script>");
                System.out.println("artDialog.open.origin.refreshComponentDisplay('"+page+"','"+report+"');");
                System.out.println("上传成功........."+leibie+"   "+fujiansuoshu+"  "+beizhu+"   "+mFormAndConfigValues.get(SAVEPATH_KEY));
            }
            else
            {
            	out.println("alert('上传文件"+fileNamesBuf.toString()+"失败');");
            }
            rs.close();
            } catch(SQLException e)
            {
            e.printStackTrace();
             } finally
            {
            //关闭stmt，不用关闭conn
            }
            
            
        }
        return false;//框架不自动提示成功或失败
	}

	@Override
	public boolean beforeFileUpload(HttpServletRequest request,
			FileItem fileitemObj, Map<String, String> mFormAndConfigValues,
			PrintWriter out) {
		try {

			filename = fileitemObj.getName();

			// System.out.println("--------------原文件名："+filename);
			if (filename != null && !filename.trim().equals("")) {
				int pos = filename.lastIndexOf("\\");
				filename = filename.substring(pos + 1);
				String[] filenameSplit = filename.split("\\.");
				if (filenameSplit != null && filenameSplit.length > 0) {
					Calendar ca = Calendar.getInstance();
					filename = filenameSplit[0] + "(" + ca.get(Calendar.YEAR)
							+ (ca.get(Calendar.MONTH) + 1)
							+ ca.get(Calendar.DATE)
							+ ca.get(Calendar.HOUR_OF_DAY)
							+ ca.get(Calendar.MINUTE) + ca.get(Calendar.SECOND)
							+ ")" + "." + filenameSplit[1];
					// + ca.get(Calendar.MILLISECOND)
					mFormAndConfigValues.put(FILENAME_KEY, filename);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;// 表示由框架自动完成文件上传功能

	}

}
