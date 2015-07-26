<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String table=request.getParameter("table");
	String pageID=request.getParameter("page");
	String reportID=request.getParameter("report");
	String tupianzhonglei=request.getParameter("tupianzhonglei");
	String tupiansuoshu=java.net.URLEncoder.encode(request.getParameter("tupiansuoshu"), "UTF-8");
	tupianzhonglei=java.net.URLEncoder.encode(tupianzhonglei, "UTF-8");
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>Upload</title>

		<!--装载文件-->
		<link href="uploadify-v3.1/uploadify.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="uploadify-v3.1/jquery.uploadify-3.1.js"></script>
		<script type="text/javascript" src="js/swfobject.js"></script>
		<script type="text/javascript" src="webresources/script/wabacus_api.js"></script>
		<script type="text/javascript" src="webresources/script/gbk/wabacus_api.js"></script>
		<script type="text/javascript" src="webresources/script/wabacus_editsystem.js"></script>
		<script type="text/javascript" src="webresources/component/artDialog/artDialog.js"></script>
		<script type="text/javascript" src="webresources/component/artDialog/jquery.artDialog.js"></script>
		

		<!--ready事件-->
		<script type="text/javascript">
		 	$(document).ready(function () {
				$("#uploadify").uploadify({
					'swf': 'uploadify-v3.1/uploadify.swf', 
					  'uploader':'servlet/upload?table=<%=table%>&tupiansuoshu=<%=tupiansuoshu%>&tupianzhonglei=<%=tupianzhonglei%>', 
				'queueID' : 'fileQueue', //和存放队列的DIV的id一致  
						method: 'get', 
					'auto'  : false, //是否自动开始  
					'multi': true, //是否支持多文件上传  
					  'buttonText': '选择图片', //按钮上的文字  
					'simUploadLimit' : 1, //一次同步上传的文件数目  
					'fileSizeLimit' : '6000KB',
					  'queueSizeLimit' : 10, //队列中同时存在的文件个数限制  
					'fileTypeExts': '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
					  'fileTypeDesc': '支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
					'onUploadSuccess': function ( fileObj, response, data) {  
							alert("文件:" + fileObj.name + "上传成功"+response);
							$("#divPreview").append($("<img src='" + response + "'/>"));
							
					},  
					'onUploadError': function(event, queueID, fileObj) {  
							alert("文件:" + fileObj.name + "上传失败");  
					},  
					'onCancel': function(event, queueID, fileObj){  
							alert("取消了" + fileObj.name);  
					} ,
					'onQueueComplete' : function(queueData) {
           								 alert(queueData.uploadsSuccessful + "文件上传成功");
           								 parent.refreshComponentDisplay("<%=pageID%>","<%=reportID%>");
										parent.closePopupWin();
       					},
       					'onUploadStart': function (file) {  
                   						 //$("#uploadify").uploadify("settings", "formData",{ 'table': '<%=table%>','tupiansuoshu':'<%=tupiansuoshu%>','tupianzhonglei':'<%=tupianzhonglei%>'}); 
                   						 // $("#uploadify").uploadify("settings", "tupiansuoshu","<%=tupiansuoshu%>"); 
                   						
                   						alert($("#uploadify").uploadify("settings", "tupiansuoshu")); //在onUploadStart事件中，也就是上传之前，把参数写好传递到后台。  
               			 }  
				});
				
			});

    	</script>

	</head>

	<body>
		<%=pageID%>+<%=reportID%>+<%=table%>+<%=tupiansuoshu%>+<%=tupianzhonglei%>
		<div id="fileQueue" style="width:30%"></div>

		<input type="file" name="uploadify" id="uploadify" />

		<p>

			<a href="javascript:jQuery('#uploadify').uploadify('upload','*')">开始上传</a>&nbsp;

			<a href="javascript:jQuery('#uploadify').uploadifyClearQueue()">取消所有上传</a>

		</p>
		<div class="file-box"> 
		         <div id="divPreview">
		                <span style="float:left">（最多可上传五张图片）</span>
		         </div>
		</div> 
	</body>

</html>

