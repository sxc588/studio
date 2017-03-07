<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery.js"></script>
<script type="text/javascript">
	function validateName(value) {
		//alert(value);
		//向validateName 发送请求，请求参数名userName，参数值value
		//服务器响应后，返回值放到 ID为 result元素中
		$("#result").load("validateName", {
			userName : value
		})
	}
</script>

<style type="text/css">
#breadcrumbs-one {
	background: #eee;
	border-width: 1px;
	border-style: solid;
	border-color: #f5f5f5 #e5e5e5 #ccc;
	border-radius: 5px;
	box-shadow: 0 0 2px rgba(0, 0, 0, .2);
	overflow: hidden;
	width: 100%;
}

#breadcrumbs-one li {
	float: left;
}

#breadcrumbs-one a {
	padding: .7em 1em .7em 2em;
	float: left;
	text-decoration: none;
	color: #444;
	position: relative;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
	background-color: #ddd;
	background-image: linear-gradient(to right, #f5f5f5, #ddd);
}

#breadcrumbs-one li:first-child a {
	padding-left: 1em;
	border-radius: 5px 0 0 5px;
}

#breadcrumbs-one a:hover {
	background: #0f0;
}

#breadcrumbs-one a::after, #breadcrumbs-one a::before {
	content: "";
	position: absolute;
	top: 50%;
	margin-top: -1.5em;
	border-top: 1.5em solid transparent;
	border-bottom: 1.5em solid transparent;
	border-left: 1em solid;
	right: -1em;
}

#breadcrumbs-one a::after {
	z-index: 2;
	border-left-color: #ddd;
}

#breadcrumbs-one a::before {
	border-left-color: #ccc;
	right: -1.1em;
	z-index: 1;
}

#breadcrumbs-one a:hover::after {
	border-left-color: #0f0;
}

#breadcrumbs-one .current, #breadcrumbs-one .current:hover {
	font-weight: bold;
	background: none;
}

#breadcrumbs-one .current::after, #breadcrumbs-one .current::before {
	content: normal;
}
</style>

</head>
<body>
	<h2>请输入用户信息01 -- 通过stream类型的返回实现</h2>
	<ol>
		<li>开发一个Action,让action 返回一个 inputStream 的方法作为响应</li>
		<li>配置Action 为stream 结果类型。制定参数：<result type="stream">tip&lt;/result&gt;</result></li>
	</ol>

	<s:form action="registPro" method="post">
		<tr>
			<td>用户名</td>
			<td><s:textfield label="用户名" name="user.name"
					onblur="validateName(this.value)" theme="simple"></s:textfield><span
				id="result"></span></td>
		</tr>
		<s:textfield label="密  码" name="user.pass"></s:textfield>
		<s:textfield label="体  重" name="user.weight"></s:textfield>
		<s:textfield label="生  日" name="user.birth"></s:textfield>
		<tr>
			<td colspan="2" align="center"><s:submit value="提  交"></s:submit></td>
			</td>
		</tr>
	</s:form>
	<a href="${pageContent.requert.contextPath}/mystruts2/login/viewUsers">查看所有的用户信息</a>

	<ul id="breadcrumbs-one">
		<li><a href="">Lorem ipsum</a></li>
		<li><a href="">Vivamus nisi eros</a></li>
		<li><a href="">Nulla sed lorem risus</a></li>
		<li><a href="" class="current">Nam iaculis commodo</a></li>
		<li><a href="">Current crumb</a></li>
	</ul>
</body>
</html>