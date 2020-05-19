<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.net.*"%>

<html>
<head>
<title>java web 获取客户端的计算机名称</title>
</head>
<body>
	<h1>使用request对象的方法获取信息</h1>

	<!-- 服务器 -->
	<%
	String localName=request.getLocalName();
	String serverName = request.getServerName();
	String localAddr=request.getLocalAddr();
	int localPort=request.getLocalPort();
	int serverPort = request.getServerPort();%>

	<b>服务器</b>:<%= localName %><br />
	<b>服务器端IP</b>:<%= localAddr %><br />
	<b>服务器端口</b>:<%= localPort %><p />
	<!-- 客户端信息 -->
	<%
	String remoteHost=request.getRemoteHost(); 
	String remoteAddr=request.getRemoteAddr(); 
	int remotePort=request.getRemotePort();%>

	<b>浏览器端</b>:<%= remoteHost %><br />
	<b>浏览器端IP是</b>:<%= remoteAddr %><br />
	<b>浏览器端口</b>:<%= remotePort %><p />

	<!-- 协议相关 -->
	<%
	String pro=request.getProtocol();
	String pro1=request.getScheme();
	int len=request.getContentLength();
	String type=request.getContentType();
	String charEncode=request.getCharacterEncoding();
	Map map=Thread.getAllStackTraces();
	%>
	<b>协议版本</b>:<%= pro %><br />
	<b>协议</b>:<%= pro1 %><br />
	<b>数据内容长度</b>:<%= len %><br />
	<b>数据类型</b>:<%= type %><br />
	<b>字符编码方式</b>:<%= charEncode %><p />
	<b>字符编码方式</b>:<%= map.size() %><p />
</body>
</html>