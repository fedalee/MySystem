package ajaxServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import com.wabacus.util.* ;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CeDian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CeDian() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/*
		receive parameters from js:
		@id 测点的id
		@s1 用户输入第一个测点值
		@s2 用户输入第二个测点值
		*/
		String id=request.getParameter("id");
		String s1=request.getParameter("s1");
		String s2=request.getParameter("s2");

		
		//System.out.println("s1:"+s1);
		//System.out.println("s2 :"+s2 );
			CeDianBean b1 = new CeDianBean(s1);
			CeDianBean b2 = new CeDianBean(s2);
			
			if(b1.compareTo(b2)==1)
			{out.print(" <font color='red'> Warning :please reverse the input ,the result is invalid !</font> <br>");}
			System.out.println("您刚才选择的是 : " + b1.getValue() + "Hz 和" + b2.getValue()+" Hz");
			List<CeDianBean> l = new ArrayList<CeDianBean>();

			String sql = "select * from ZBGL_ZXSY_CEDIAN";

			try {
				Statement stmt = null;
				Dao dao = Dao.getInstance();
				Connection conn = dao.getConnection();
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				//获取database中存储的字段名
				ResultSetMetaData data = rs.getMetaData();
				for (int i = 1; i <= data.getColumnCount(); i++) {
					// 获指定列字段名
					String columnName = data.getColumnName(i);
					CeDianBean b = new CeDianBean(columnName);
					if ((b.getValue() != 0 && b.compareTo(b1) == 1
							&& b.compareTo(b2) == -1)||b.compareTo(b2)==0||b.compareTo(b1)==0) {
						l.add(b);
					}
				}
				//out.println(l);

				String sql_all = "select * from ZBGL_ZXSY_CEDIAN where id='"+id+"'";
				//System.out.println(sql_all);
				ResultSet rs1 = stmt.executeQuery(sql_all);
				Iterator<CeDianBean> itr = l.iterator();
				rs1.next();

				List<Double> CeDianValues = new ArrayList<Double>();
				Boolean warning=false;
				while (itr.hasNext()) {
					String value = itr.next().getName();
					if(rs1.getDouble(value)!=0)
					{CeDianValues.add(rs1.getDouble(value));
					//			out.println("<br><br> 测点  " + value + " 的值 : "
					//				+ rs1.getDouble(value));
					}
					else
					{
						warning=true;
			
					}
				}
				if(warning)
				{			out.print("<font color='red'> Warning :some values are not in the form above,which may conrrupt the result !"
						+ "we treat empty entries as 0 for calculation anyway</font> <br>");}
				//out.print(CeDianValues);
				
				double calculatedResult=Tools_ZGC.ceDianCalculator(CeDianValues);
				//System.out.println("<h1>运算结果 : "+ calculatedResult+ "</h1>");

				rs1.close();
				rs.close();
				stmt.close();
				conn.close();
				out.write("result : "+calculatedResult);
			} catch (SQLException e) {
				e.printStackTrace();
				out.write("SQL exception ");
				
			} 
			finally {

			}
		 

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
