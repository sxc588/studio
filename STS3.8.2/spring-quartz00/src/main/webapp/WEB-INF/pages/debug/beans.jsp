<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<p class="lead">定义的Spring 对象</p>
<table class="table table-bordered table-margin-top">
	<tr>
		<td>序号</td>
		<td>Bean名称</td>
		<td>Bean的类型</td>
	</tr>

		<c:forEach items="${beanMap}" var="map" varStatus="id"  begin="1">
			<tr>
			    <td>${id.index}</td>  
				<td>${map.key}</td>
				<td>${map.value}</td>
			</tr>
		</c:forEach>
</table>