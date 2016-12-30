<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title><s:property value="getText('loginPage')" /></title>
</head>
<body>
	<!-- 使用form标签生成表单元素 -->
	<s:form action="login">
		<!-- 生成一个用户名文本输入框 -->
		<s:textfield name="username" key="user" />
		<!-- 生成一个密码文本输入框 -->
		<s:textfield name="password" key="pass" />
		<!-- 生成一个提交按钮 -->
		<s:submit key="login" />
	</s:form>
</body>
</html>

