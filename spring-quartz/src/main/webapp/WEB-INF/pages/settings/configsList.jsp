<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <%
request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
<body>
	<jsp:include page="../top.vm.jsp"></jsp:include>
	<div class="container">
		<p class="lead">注册表列表(${dtoList.size()})</p>
		<table class="table table-bordered table-condensed table-hover">
			<tr>
				<th>序号</th>
				<th>键</th>
				<th>值</th>
				<th>注册表配置项描述</th>
				<th>最后更新人</th>
				<th>最后更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${dtoList}" var="item" varStatus="id">
				<tr>
					<td>${id.index}</td>
					<td>${item.key}</td>
					<td>${item.value}</td>
					<td>${item.description}</td>
					<td>${item.lastUpdateBy}</td>
					<td><fmt:formatDate value="${item.lastUpdateTime}"
							pattern="yyyy-MM-dd HH:mm:ss.SSS" /></td>
					<td><a class="btn-sm btn-danger" role="button"
						href="edit?configId=${item.key}">复制</a> <a
						class="btn-sm btn-danger" role="button"
						href="edit?configId=${item.key}">编辑</a> <a
						class="btn-sm btn-danger" role="button"
						href="delete?configId=${item.key}"><i class="fa fa-reply"
							aria-hidden="true"></i>删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
		<br>
		</ul>
		<br>
	</div>
	<jsp:include page="../foot.vm.jsp"></jsp:include>
</body>
</html>