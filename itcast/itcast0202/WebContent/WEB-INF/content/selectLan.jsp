<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:debug></s:debug>
<s:bean var="huitailang" name="org.crazyit.demo.Locales"></s:bean>
<html>
<head>
<title>用户选择语言实例</title>
</head>

<body style="height: 378px; ">
	<h1>用户选择语言</h1>
	<s:select list="#huitailang.locales"   listKey="value" listValue="key" ></s:select>
</body>
</html>
	