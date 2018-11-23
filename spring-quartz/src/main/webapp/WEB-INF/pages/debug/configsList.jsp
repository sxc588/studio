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
	<jsp:include page="../top.vm.jsp"></jsp:include>
	<div class="container" >
		<p class="lead">注册表列表(${dtoList.size()})</p>
		<table border=1>
			<tr>
				<th>键</th>
				<th>值</th>
				<th>注册表配置项描述</th>
					<th>最后更新人</th>
						<th>最后更新时间</th>
			</tr>
			<c:forEach items="${dtoList}" var="item" varStatus="id">
				<tr>
					<td>${item.key}</td>
					<td>${item.value}</td>
					<td>${item.description}</td>
					<td>${item.lastUpdateBy}</td>
					<td><fmt:formatDate value="${item.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss.SSS" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../foot.vm.jsp"></jsp:include>
</body>
</html>