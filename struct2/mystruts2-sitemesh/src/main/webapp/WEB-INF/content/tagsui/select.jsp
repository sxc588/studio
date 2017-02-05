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
	<s:debug />


	<s:action var="xueliList" name="listXueli"></s:action>
	<s:form>
		<s:select list="xueliList" label="请选择学历" list="#xueliList.xueliList"
			listKey="id" listValue="name" name="a" />
		<s:radio list="xueliList" label="请选择学历" list="#xueliList.xueliList"
			listKey="id" listValue="name" name="b" />
		<s:checkboxlist list="xueliList" label="请选择学历"
			list="#xueliList.xueliList" listKey="id" listValue="name" name="c" />

		<s:select list="xueliList" label="请选择学历" list="#xueliList.xueliList"
			listKey="id" listValue="name" name="d">
			<s:optgroup list="xueliList" label="再次选择" list="#xueliList.xueliList"
				listKey="id" listValue="name" />
		</s:select>
	</s:form>

</body>
</html>