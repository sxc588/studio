<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集合合并</title>
</head>
<body>
	<h2>集合并 - s:merge</h2>
	<s:debug />

	<s:generator val="abc:def:def:warwar" separator =":" var="newList" />
	
	<ul>
		<s:iterator value="#newList" var="name">
			<li>${name}</li>
		</s:iterator>
	</ul>
</body>
</html>