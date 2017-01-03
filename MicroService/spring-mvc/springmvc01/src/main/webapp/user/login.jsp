<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user/login.do" method="post">
  <table>
    <tr>
      <th colspan=2>登录</th>
    </tr>
    <tr>
      <td>用户名</td>
      <td><input type="text" name="username" /></td>
    </tr>
    <tr>
      <td>密码</td>
      <td><input type="text" name="password"/></td>
    </tr>
    <tr>
      <td><input type="hidden" name="id" ></td>
      <td><input type="submit" value="登录" /></td>
    </tr>
  </table>
</form>
</body>
</html>