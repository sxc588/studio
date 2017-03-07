<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>登录页面</title>
<link rel=stylesheet href="css/login.css" type="text/css">
</head>
<body>
	<h1 align="center">用户登录页面</h1>
	<hr>
	<div align="center">
		<form action="login.lp" method="post">
			<table cellspacing=5 border=5 bodercolor=#ffaa00>
				<tr>
					<th colspan="3" align="center" bgcolor=#ffaa00>用户登录</th>
				</tr>
				<tr>
					<th rowspan="3" background="images/2.jpg" style="width=90px"></th>
					<td>用户名：</td>
					<td><input type="text" class="message" name="username"></td>
				</tr>
				<tr>
					<td>密 码：</td>
					<td><input class="message" type="password" name="userpassword"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="登录">
						<input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
