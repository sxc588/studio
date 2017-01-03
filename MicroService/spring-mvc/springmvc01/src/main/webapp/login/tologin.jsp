<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>
<body>
	<form action="http://localhost:7050/SpringMvc01A/user/login2.do" method="get">
		username:<input type="text" name="username"><br /> Password:<input
			type="password" name="password"><br /> <input type="submit"
			value="登陆">
	</form>
</body>
</html>