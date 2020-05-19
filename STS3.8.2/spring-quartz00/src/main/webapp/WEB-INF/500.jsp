<%@page import="java.io.PrintStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="tag" uri="custmTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>500 服务器内部错误</title>
<style>
.app {
	font-size: 20px;
	font-family: "微软雅黑";
	font-style: oblique;
	color: red;
	border: #909090 1px solid;
}
</style>
</head>
<body>
	<div class="ui-alert-panel">
		<h1>服务器内部错误</h1>
		<p>处理您的请求时发生错误！请确认您通过正确途径操作。</p>
	</div>
	<div style="display: none;">
		<%
			//此处输出异常信息
			exception.printStackTrace();
			ByteArrayOutputStream ostr = new ByteArrayOutputStream();
			exception.printStackTrace(new PrintStream(ostr));
			out.print(ostr);
		%>
	</div>

	<div class="app">
		<tag:i18n key="ddd" />
	</div>

	<div class="app">
		<tag:config key="ddd" />
	</div>
</body>
</html>
