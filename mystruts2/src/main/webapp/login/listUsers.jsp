<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出所有的用户！</title>
</head>
<body>
	<h2>当前的用户列表</h2>
	<table width="600" border="1">
		<tr>
			<th>工号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>体重</th>
			<th>生日</th>
		</tr>
		<s:iterator value="users" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.pass}</td>
				<td>${user.weight}</td>
				<td>${user.birth}</td>
			</tr>
		</s:iterator>
	</table>
	<a href="{pageContent.requert.contextPaht}/viewUsers">查看所有的用户信息</a>
</body>
</html>