package com.lis.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.pub.util.DateUtil;

/**
 *����˵��:
 * 
 * @author:lishun
 *@date:2012-7-30
 */
public class upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public upload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doGetAndPost(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doGetAndPost(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	/**
	 * get��post�ύ��ʽ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException 
	 */
	public void doGetAndPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		String str="";
		request.setCharacterEncoding("utf-8");
		
		System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥"+request.getParameter("table"));
		System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥"+request.getParameter("tupiansuoshu"));
		String table = request.getParameter("table");
		

		String tupiansuoshu = request.getParameter("tupiansuoshu");
		String tupianzhonglei = request.getParameter("tupianzhonglei");
		File tempDirPath = new File(request.getSession().getServletContext()
				.getRealPath("/")
				+ "/upload/images/");
		if (!tempDirPath.exists()) {
			tempDirPath.mkdirs();
		}
	       Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
		DiskFileItemFactory fac = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(fac);
		
		upload.setHeaderEncoding("utf-8"); 
		
		List fileList = null;
		 try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            //conn = DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=12345678");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@222.27.254.64:1521:MyOracle", "scott", "tiger");
	            stmt = conn.createStatement();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
		
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			ex.printStackTrace();
			return;
		}
		// �������ļ���
		String imageName = null;
		// �����ǰ̨�õ����ļ��б�
		Iterator<FileItem> it = fileList.iterator();
		
		PrintWriter out = null;
		try {
			out = encodehead(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (it.hasNext()) {
			
			FileItem item = it.next();
			// �������ͨ�?�򣬵����ļ���������
			if (!item.isFormField()) {
				//�����λ�����
				Random r = new Random();
				int rannum = (int) (r.nextDouble() * (9999 - 1000 + 1)) + 1000; 
				
				imageName = DateUtil.getNowStrDate() +  rannum
						+ item.getName();

				BufferedInputStream in = new BufferedInputStream(item
						.getInputStream());
				BufferedOutputStream out1 = new BufferedOutputStream(
						new FileOutputStream(new File(tempDirPath + "/"
								+ imageName)));
				Streams.copy(in, out1, true);
				String sql = "insert INTO "+table+"(photo,id,tupiansuoshu,tupianzhonglei) VALUES('/MySystem/upload/images/"+imageName+"','/MySystem/upload/images/"+imageName+"','"+tupiansuoshu+"','"+tupianzhonglei+"')";
				System.out.println("********************"+sql);
				rs = stmt.executeQuery(sql); 
				
                if(rs.next()){
                    System.out.println("/upload/images/"+ imageName+"********************插入成功");
                    
                }
                rs.close();
                rs = null;
				

			}
		}
		//   
		
		out.write(tempDirPath + "/"+ imageName);
		out.close();
	}
	/**
	 * Ajax���� ��ȡ PrintWriter
	 * 
	 * @return
	 * @throws IOException
	 * @throws IOException
	 *             request.setCharacterEncoding("utf-8");
	 *             response.setContentType("text/html; charset=utf-8");
	 */
	private PrintWriter encodehead(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		return response.getWriter();
	}
	
	public static String unicode2String(String unicode) {

		StringBuffer string = new StringBuffer();

		String[] hex = unicode.split("\\\\u");

		for (int i = 1; i < hex.length; i++) {

			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);

			// 追加成string
			string.append((char) data);
		}

		return string.toString();
	}

}
