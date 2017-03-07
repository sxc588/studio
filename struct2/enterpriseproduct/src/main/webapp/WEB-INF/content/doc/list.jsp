<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> Struts 2+MyFaces+Spring����</title>
</head>
<body>
<f:view>
<h3>Struts 2+MyFaces+Spring����</h3>	
<h3>�г�����ͼ��</h3>
<!-- ʹ��dataTable������action�е�allBook���� -->
<h:dataTable value="#{action.allBook}" var="b" 
	style="text-align:center;width:500px" border="1">
	<h:column>
		<f:facet name="header">
			<h:outputText value="ͼ��ID"/>
		</f:facet>
		<!-- ����һ���������ӣ����ӵ�edit.action������b����id������Ϊ���� -->
		<h:outputLink value="edit.action">
			<f:param name="editId" value="#{b.id}"/>
			<h:outputText value="#{b.id}"/>
		</h:outputLink>	
	</h:column>
	<h:column>
		<f:facet name="header">
			<h:outputText value="ͼ����"/>
		</f:facet>
		<h:outputText value="#{b.name}"/>
	</h:column>
	<h:column>
		<f:facet name="header">
			<h:outputText value="ͼ����"/>
		</f:facet>
		<h:outputText value="#{b.desc}"/>
	</h:column>
</h:dataTable>	
<p><!-- ����һ���������ӣ����ӵ�edit.action -->
<h:outputLink value="edit.action">
	<h:outputText value="����ͼ��"/>
</h:outputLink></p>
</f:view>
</body>
</html>
