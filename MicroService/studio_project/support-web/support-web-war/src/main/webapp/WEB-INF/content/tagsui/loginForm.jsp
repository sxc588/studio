<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UI 标签</title>
</head>
<body>
	<h2>集合并 - s:merge</h2>
	<s:debug />


	<p>有序列表：</p>
	<s:append var='newList'>
		<s:param value="{'孙悟空','白骨精','唐僧','猪八戒','牛魔王'}"></s:param>
		<s:param value="{'孙艺欣','孙艺凡'}"></s:param>
	</s:append>

	<s:form>
		<s:textfiled name="user.name" label="用户名"></s:textfiled>
		<s:password name="user.pass" label="密码"></s:password>
		<s:file name="user.smallImg" label="上传图像"></s:file>
		<s:checkbox name="user.married" label="婚否"></s:checkbox>
	</s:form>

	<ul>
		<s:iterator value="#newList" var="name">
			<li>${name}</li>
		</s:iterator>
	</ul>
</body>
</html>