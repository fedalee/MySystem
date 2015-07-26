package ajaxServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wabacus.util.Dao;

/**
 * Servlet implementation class DynamicColumn
 */
public class DynamicColumn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DynamicColumn() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		//存储一个ArrayList，一边对应到数据库中的字段名
		List<String> cols = new ArrayList<String>();
		cols.add("GONGKUANGYI");
		cols.add("GONGKUANGER");
		cols.add("GONGKUANGSAN");
		cols.add("GONGKUANGSI");
		cols.add("GONGKUANGWU");
		cols.add("GONGKUANGLIU");

		String values=request.getParameter("values");
		System.out.println(values);
		String[] tmp=values.split(",");
		List<String> colNames = new ArrayList<String>();
		List<String> colValues = new ArrayList<String>();
		int i=0;
		for(String s:tmp)
		{
			colValues.add(s);
			colNames.add(cols.get(i));
			i++;
		}
		//System.out.println(colValues);
		//System.out.println(colNames);

		Dao dao = Dao.getInstance();
		String feedback = dao.insert("SCOTT.ZBGL_ZBJBXX_ZTTX_SMBQD", colNames, colValues);

		System.out.println(feedback);

		response.setContentType("application/json");
		response.getWriter().write("hahaha");
		System.out.println("sever is called");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
