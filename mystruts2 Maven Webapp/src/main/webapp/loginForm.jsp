<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<h2>请用户登录</h2>
	<form action="loginPro.action" method="post">
		<table>
			<tr>
				<td>用户：</td>
				<td><input type="text" name = "user.name"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name = "user.pass"></td>
			</tr>
			<tr align ="center">
				<td colspan="2"><input type="submit" value ="登录"></td>
			</tr
		</table>
	</form>
</body>
</html>