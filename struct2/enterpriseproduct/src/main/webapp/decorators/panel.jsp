<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator" %>
<p>
<table width="250" border="0" cellpadding="0" cellspacing="0">
<tr>
	<th class="panelTitle">
		<decorator:title default="小面板页面" />
	</th>
</tr>
<tr>
	<td class="panelBody">
		<decorator:body />
	</td>
</tr>
</table>
</p>