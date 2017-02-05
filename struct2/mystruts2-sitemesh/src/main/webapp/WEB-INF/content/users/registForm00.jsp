<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery.js"></script> 
<script type="text/javascript">
	function validateName(value) {
		//alert(value);
		//向validateName 发送请求，请求参数名userName，参数值value
		//服务器响应后，返回值放到 ID为 result元素中
		$("#result").load("validateName", {userName:value})	
	}
</script>

</head>
<body>
	<h2>请输入用户信息01</h2>
	<div id="result">123</div>
	<s:form action="registPro" method="post">
		<s:textfield label="用户名" name="user.name" onblur="validateName(this.value)"></s:textfield>
		<s:textfield label="密  码" name="user.pass"></s:textfield>
		<s:textfield label="体  重" name="user.weight"></s:textfield>
		<s:textfield label="生  日" name="user.birth"></s:textfield>
		<s:submit value="提  交"></s:submit>
	</s:form>
	<a href="${pageContent.requert.contextPath}/mystruts2/login/viewUsers">查看所有的用户信息</a>
</body>
</html>