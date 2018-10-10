<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>注册表编辑</title>
<script src="<%=request.getContextPath()%>/3rd/My97DatePicker/WdatePicker.js"></script>
<style>

.hse1{ color:red}
.hse2{ color:#F00}
.hse3{ color:#FF0000}
</style>
<body>
	<sf:form modelAttribute="configDto" method="post">
		<table  >
			<tr>
				<td>注册表-Key:</td>
				<td><sf:input path="key" /></td>
				<td class="hse1">*<sf:errors path="key" /></td>
			</tr>
			<tr>
				<td>注册表-Value:</td>
				<td><sf:input path="value" /></td>
				<td class="hse1">*<sf:errors path="value" /></td>
			</tr>
			
			<tr>
				<td>注册表-描述:</td>
				<td><sf:input path="description" /></td>
				<td class="hse1">*<sf:errors path="description" /></td>
			</tr>
			<tr>
				<td colspan=3><input type="submit" value="提交"></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>