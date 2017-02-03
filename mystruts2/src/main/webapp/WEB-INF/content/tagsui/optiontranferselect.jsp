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
		<s:optiontransferselect  label="请选择学历" cssStyle="width:120px" name="aa"
			list="#xueliList.xueliList" listKey="id" listValue="name"
			doubleList="{'武松','潘金莲','武大郎'}" doubleName="bb" ></s:optiontransferselect>
	</s:form>
</body>
</html>