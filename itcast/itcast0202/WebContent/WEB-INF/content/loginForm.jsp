<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
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
	<!-- ʹ��form��ǩ���ɱ�Ԫ�� -->
	<s:form action="login">
		<!-- ����һ���û����ı������ -->
		<s:textfield name="username" key="user" />
		<!-- ����һ�������ı������ -->
		<s:textfield name="password" key="pass" />
		<!-- ����һ���ύ��ť -->
		<s:submit key="login" />
	</s:form>
</body>
</html>

