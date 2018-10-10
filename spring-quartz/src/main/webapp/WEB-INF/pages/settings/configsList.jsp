<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
<body>
	<p class="lead">注册表列表(${dtoList.size()})</p>
	<table border=1>
		<tr>
			<th>键</th>
			<th>值</th>
			<th>注册表配置项描述</th>
		</tr>
		<c:forEach items="${dtoList}" var="item" varStatus="id" >
			<tr>
				<td>${item.key}</td>
				<td>${item.value}</td>
				<td>${item.description}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>