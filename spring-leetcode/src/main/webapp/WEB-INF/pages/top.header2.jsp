<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath();
%>
<!-- Bootstrap -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style type="text/css">
.jumbotron-margin-top {
	margin-top: 95px;
}

.table-margin-top {
	margin-top: 15px;
}

.status-color {
	color: red;
	font-weight: bold;
}

.circle {
	width: 20px;
	height: 20px; <!--
	background: #7fee1d; -->
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
}

.red {
	background: red;
}

.yellow {
	background: yellow;
}

.green {
	background: green;
}

thead tr th {
	text-align: center;
}
</style>