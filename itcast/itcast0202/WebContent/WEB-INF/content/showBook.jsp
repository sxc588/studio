<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<!-- ����Struts 2�ı�ǩ�� -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>������յ�ͼ��</title>
</head>
<body>
	<table border="1" style="width: 360px">
		<caption>������յ�ͼ��</caption>
		<!-- �������ValueStack�е�books��������status�ǵ�������� -->
		<s:iterator value="books" status="index">
			<!-- �ж�����Ƿ�Ϊ���� -->
			<s:if test="#index.odd == true">
				<tr style="background-color: #cccccc">
			</s:if>
			<!-- �жϵ���Ԫ�ص�����Ƿ�Ϊż�� -->
			<s:else>
				<tr>
			</s:else>
			<td>������</td>
			<td><s:property /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
