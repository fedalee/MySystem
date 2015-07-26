<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wabacus.util.* "%>
<%@page import="com.wabacus.system.ReportRequest" %>
<%@ taglib uri="wabacus" prefix="wx"%>


<%
	String pt1 = request.getParameter("point1");
	String pt2 = request.getParameter("point2");
	
	
	String id=request.getParameter("id");
	
	//out.println(id+"<br>");	
	//ReportRequest rrequest=(ReportRequest)request.getAttribute("WX_REPORTREQUEST");
	//String url=rrequest.getUrl();
	//out.println(url);
	//out.println(name);belongto="matoushiyancedianpinlv_report"
	//out.println(rrequest.getUrl());
	//iframe="true"  iframestyleproperty="frameborder='1' width='100%'" height="100%"

%>

<form name="frm" action="/MySystem/jsp/ceDian.jsp" method="get">
<input id="a" type="hidden" value="<%= id %>">
	测点1（Hz）： <select name="point1" id="s1">
		<option selected="selected">请选择</option>
		<option value="SHIHZ">10 Hz</option>
		<option value="SHIERDIANWUHZ">12.5 Hz</option>
		<option value="SHILIUHZ">16 Hz</option>
		<option value="ERSHIHZ">20 Hz</option>
		<option value="ERSHIWUHZ">25 Hz</option>
		<option value="SANSHIYIDIANWUHZ">31.5 Hz</option>
		<option value="SISHIHZ">40 Hz</option>
		<option value="WUSHIHZ">50 Hz</option>
		<option value="LIUSHISANHZ">63 Hz</option>
		<option value="BASHIHZ">80 Hz</option>
		<option value="YIBAIHZ">100 Hz</option>
		<option value="YIBAIERSHIWUHZ">125 Hz</option>
		<option value="YIBAILIUSHIHZ">160 Hz</option>
		<option value="ERBAIHZ">200 Hz</option>
		<option value="ERBAIWUSHIHZ">250 Hz</option>
		<option value="SANBAIYISHIWUHZ">315 Hz</option>
		<option value="SIBAIHZ">400 Hz</option>
		<option value="WUBAIHZ">500 Hz</option>
		<option value="LIUBAISANSHIHZ">630 Hz</option>
		<option value="BABAIHZ">800 Hz</option>
		<option value="YIQIANHZ">1000 Hz</option>
		<option value="YIQIANERBAIWUSHIHZ">1250 Hz</option>
		<option value="YIQIANLIUBAIHZ">1600 Hz</option>
		<option value="ERQIANHZ">2000 Hz</option>
		<option value="ERQINAWUBAIHZ">2500 Hz</option>
		<option value="SANQIANYIBIAWUSHIHZ">3150 Hz</option>
		<option value="SIQIANHZ">4000 Hz</option>
		<option value="WUQIANHZ">5000 Hz</option>
		<option value="LIUQIANSANBAIHZ">6300 Hz</option>
		<option value="BAQIANHZ">8000 Hz</option>
		<option value="YIWANHZ">10000</option>
	</select> 测点2（Hz)： <select name="point2" id="s2">
		<option selected="selected">请选择</option>
		<option value="SHIHZ">10 Hz</option>
		<option value="SHIERDIANWUHZ">12.5 Hz</option>
		<option value="SHILIUHZ">16 Hz</option>
		<option value="ERSHIHZ">20 Hz</option>
		<option value="ERSHIWUHZ">25 Hz</option>
		<option value="SANSHIYIDIANWUHZ">31.5 Hz</option>
		<option value="SISHIHZ">40 Hz</option>
		<option value="WUSHIHZ">50 Hz</option>
		<option value="LIUSHISANHZ">63 Hz</option>
		<option value="BASHIHZ">80 Hz</option>
		<option value="YIBAIHZ">100 Hz</option>
		<option value="YIBAIERSHIWUHZ">125 Hz</option>
		<option value="YIBAILIUSHIHZ">160 Hz</option>
		<option value="ERBAIHZ">200 Hz</option>
		<option value="ERBAIWUSHIHZ">250 Hz</option>
		<option value="SANBAIYISHIWUHZ">315 Hz</option>
		<option value="SIBAIHZ">400 Hz</option>
		<option value="WUBAIHZ">500 Hz</option>
		<option value="LIUBAISANSHIHZ">630 Hz</option>
		<option value="BABAIHZ">800 Hz</option>
		<option value="YIQIANHZ">1000 Hz</option>
		<option value="YIQIANERBAIWUSHIHZ">1250 Hz</option>
		<option value="YIQIANLIUBAIHZ">1600 Hz</option>
		<option value="ERQIANHZ">2000 Hz</option>
		<option value="ERQINAWUBAIHZ">2500 Hz</option>
		<option value="SANQIANYIBIAWUSHIHZ">3150 Hz</option>
		<option value="SIQIANHZ">4000 Hz</option>
		<option value="WUQIANHZ">5000 Hz</option>
		<option value="LIUQIANSANBAIHZ">6300 Hz</option>
		<option value="BAQIANHZ">8000 Hz</option>
		<option value="YIWANHZ">10000</option>
	</select>
	 <input type="button" value="提交" onclick="calculate()"/>
	 <script type="text/javascript" src="/MySystem/js/ajax/ceDian.js">
	 </script>
</form>
<h1 id="result"></h1>