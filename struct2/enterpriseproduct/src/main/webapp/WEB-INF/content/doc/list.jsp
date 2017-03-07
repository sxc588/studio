<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
	<title> Struts 2+MyFaces+Spring整合</title>
</head>
<body>
<f:view>
<h3>Struts 2+MyFaces+Spring整合</h3>	
<h3>列出所有图书</h3>
<!-- 使用dataTable组件输出action中的allBook属性 -->
<h:dataTable value="#{action.allBook}" var="b" 
	style="text-align:center;width:500px" border="1">
	<h:column>
		<f:facet name="header">
			<h:outputText value="图书ID"/>
		</f:facet>
		<!-- 定义一个超级链接，链接到edit.action，传入b对象id属性作为参数 -->
		<h:outputLink value="edit.action">
			<f:param name="editId" value="#{b.id}"/>
			<h:outputText value="#{b.id}"/>
		</h:outputLink>	
	</h:column>
	<h:column>
		<f:facet name="header">
			<h:outputText value="图书名"/>
		</f:facet>
		<h:outputText value="#{b.name}"/>
	</h:column>
	<h:column>
		<f:facet name="header">
			<h:outputText value="图书简介"/>
		</f:facet>
		<h:outputText value="#{b.desc}"/>
	</h:column>
</h:dataTable>	
<p><!-- 定义一个超级链接，链接到edit.action -->
<h:outputLink value="edit.action">
	<h:outputText value="新增图书"/>
</h:outputLink></p>
</f:view>
</body>
</html>
