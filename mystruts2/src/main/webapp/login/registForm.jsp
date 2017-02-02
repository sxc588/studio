<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<h2>请输入用户信息</h2>
	<form action="registPro" method="post">
		<table>
			<tr>
				<td>用户 名：</td>
				<td><input type="text" name="user.name"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="user.pass"></td>
			</tr>
			<tr>
				<td>体重：</td>
				<td><input type="text" name="user.weight"></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" name="user.birth"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	<a href="${pageContent.requert.contextPath}/mystruts2/login/viewUsers">查看所有的用户信息</a>
</body>
</html>