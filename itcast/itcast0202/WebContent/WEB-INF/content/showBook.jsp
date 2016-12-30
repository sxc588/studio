<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<!-- 导入Struts 2的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>作者李刚的图书</title>
</head>
<body>
	<table border="1" style="width: 360px">
		<caption>作者李刚的图书</caption>
		<!-- 迭代输出ValueStack中的books对象，其中status是迭代的序号 -->
		<s:iterator value="books" status="index">
			<!-- 判断序号是否为奇数 -->
			<s:if test="#index.odd == true">
				<tr style="background-color: #cccccc">
			</s:if>
			<!-- 判断迭代元素的序号是否不为偶数 -->
			<s:else>
				<tr>
			</s:else>
			<td>书名：</td>
			<td><s:property /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
