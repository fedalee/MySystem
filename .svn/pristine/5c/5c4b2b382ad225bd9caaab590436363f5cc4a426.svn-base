package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.LoginDao;
import entity.UserBean;


public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置输出中文，解决中文乱码问题
		response.setContentType("text/html;charset=UTF-8");
		//获取用户输入
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		//RequestDispatcher dispatcher;
		
		//调用业务类对象
		LoginDao loginDao=new LoginDao();
		UserBean user= loginDao.validUser(userName, password);
		
		//存在，保存到session中
		if (user!=null) {
			session.setAttribute("user", user);
			System.out.println(user.getRole());
			// 如果用户角色是 管理员或者普通用户则进入main.html，其他的用户进入 另一个html(待定) 
			if(user.getRole().equals("普通用户") || user.getRole().equals("管理员")) {
				//dispatcher = request.getRequestDispatcher("main.html");
				response.sendRedirect("main.html");
			}
			else { 
				//dispatcher = request.getRequestDispatcher("main.html");
				response.sendRedirect("main-temp.html");
			}
			//dispatcher.forward(request, response);
		} else {
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('用户名或密码错误，请重新输入。');history.go(-1);</script>");
			out.flush();
			out.close();
		}
		
	}

}
