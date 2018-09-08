<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
	<c:if test="${tradeList==null}">
		<tr>
			<td colspan="4">还没有人购买过该商品，快来抢购吧！</td>
		</tr>
	</c:if>

	<c:forEach items="${tradeList}" var="item" varStatus="status">
		<tr>
			<td class="center"><span class="center">${item.code}</span></td>
			<td><dfn>￥</dfn>${item.name}</td>
			<td>${item.date}</td>
			<td>${item.money}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>