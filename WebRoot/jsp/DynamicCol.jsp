
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="wabacus" prefix="wx"%>
<%@page import="com.wabacus.util.* "%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wabacus.system.*"%>
<%! String xinghao="";String jieduan=""; %>
<%
	String num=request.getParameter("testbox");
	if(request.getParameter("suoshu")!=null){
	   xinghao = request.getParameter("suoshu");
	  }
	  if(request.getParameter("suoshujieduan")!=null){
	     jieduan = request.getParameter("suoshujieduan");
	  }

    Dao d = Dao.getInstance();
    if(request.getParameter("type")!=null)
	    if(request.getParameter("type").equals("0"))
	    {
		    List<String> col = new ArrayList();
			List<String> value = new ArrayList();
			col.add("SUOSHU");
			col.add("SUOSHUJIEDUAN");
			value.add(xinghao);
			value.add(jieduan);
			List result = d.getRecoed("ZBGL_ZBJBXX_ZTTX_SMBQDNUM", col,value);
			if(result.size()>0)
			{
				Map r = (Map) result.get(0);
				String i = (String) r.get("NUM");
				
				System.out.println("+++++++++++++++++++++++++++++++"+i);
				request.setAttribute("suoshu", xinghao);
		  		request.setAttribute("suoshujieduan", jieduan);
				getServletContext().getRequestDispatcher("/ShowReport.wx?PAGEID=shengmubiaoqiangdu_"+i).forward(request,response);
			}
	    }
	
	if (num == null) {
		num = "";
		out.println("型号：" + xinghao + "\n阶段："+jieduan);
	}
	String type = null;
	List<String> cols = new ArrayList();
	List<String> values = new ArrayList();
	cols.add("ID");
	cols.add("SUOSHU");
	cols.add("SUOSHUJIEDUAN");
	cols.add("NUM");
	values.add(IdentifierGenerator.getStringId());
	values.add(xinghao);
	values.add(jieduan);
	values.add(num);
	if (num != "") {
		if (d.insert("ZBGL_ZBJBXX_ZTTX_SMBQDNUM", cols, values)
				.contains("FAIL")) {

			String sql = String
					.format("update ZBGL_ZBJBXX_ZTTX_SMBQDNUM set num=%s where suoshu='%s' and suoshujieduan='%s'",
							num, xinghao, jieduan);
			System.out.println(sql);
			d.exeSql(sql);
		}
	}
%>
<br/><br/>
<body align="center">
  <%if (num=="") {%>
	 <form name="frm" action="/MySystem/jsp/DynamicCol.jsp">
	   请选择工况的列数：<input type="text" name="testbox" value="<%=num%>"/>
		<input type="submit" value="提交"/>
	 </form>
   <%} else{
   	 System.out.println("+++++++++++++++++++++++++++++++"+jieduan);
  	//response.sendRedirect("../ShowReport.wx?PAGEID=shengmubiaoqiangdu_"+num+"&suoshu="+java.net.URLEncoder.encode(xinghao)+"&suoshujieduan="+java.net.URLEncoder.encode(jieduan));
  	request.setAttribute("suoshu", xinghao);
  	request.setAttribute("suoshujieduan", jieduan);

  	getServletContext().getRequestDispatcher("/ShowReport.wx?PAGEID=shengmubiaoqiangdu_"+num).forward(request,response);
  	return;

   }
   %>

	 
 </body>