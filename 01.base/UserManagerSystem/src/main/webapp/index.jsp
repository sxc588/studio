<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">
<TITLE>管理中心 V1.0</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META http-equiv=Pragma content=no-cache>
<META http-equiv=Cache-Control content=no-cache>
<META http-equiv=Expires content=-1000>
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<FRAMESET border=0 frameSpacing=0 rows="60, *" frameBorder=0>
	<FRAME name=header src="header.jsp" frameBorder=0 noResize scrolling=no>
	<FRAMESET cols="170, *">
		<FRAME name=menu src="menu.jsp" frameBorder=0 noResize>
		<s:if test="#session.user.roleId==0">
			<FRAME name=main src="main.jsp" frameBorder=0 noResize scrolling=yes>
		</s:if>
		<s:else>
			<FRAME name=main src="adminselectuser.jsp" frameBorder=0 noResize scrolling=yes>
		</s:else>
	</FRAMESET>
</FRAMESET>
<noframes>
</noframes>
</HTML>
