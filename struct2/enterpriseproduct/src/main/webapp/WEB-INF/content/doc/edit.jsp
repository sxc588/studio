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
	<title>Struts2+MyFaces+Spring����</title>	
</head>
<body>
<f:view>  
<h3>Struts2+MyFaces+Spring����</h3>	
<h3>�޸�/����ͼ��</h3>
<h:form>
	<h:inputHidden value="#{action.editId}"/>
	<h:panelGrid columns="3">
		<h:outputText value="ͼ��ID"/>
		<h:inputText id="id" size="5" required="true"
			disabled="true" value="#{action.currentBook.id}"/>
		<h:message for="id" />
		<h:outputText value="ͼ����:"/>
		<h:inputText id="name" size="30" required="true" 
			value="#{action.currentBook.name}">
			<f:validateLength minimum="2" maximum="100" />
		</h:inputText>
		<h:message for="name" />
		<h:outputText value="ͼ��������"/>
		<h:inputTextarea id="desc" rows="4" cols="30"
			required="true" value="#{action.currentBook.desc}" >
			<f:validateLength minimum="2" maximum="100" />
		</h:inputTextarea>
		<h:message for="desc"/>
	</h:panelGrid>
	<h:commandButton value="����" action="#{action.save}"/>
<br />
</h:form>
</f:view>
</body>
</html>