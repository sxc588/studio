<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><decorator:title default="SiteMesh的装饰器页"/></title>
	<link href="decorators/main.css" rel="stylesheet" type="text/css">
	<decorator:head/>
</head>
<body>


<div>
<div><page:applyDecorator page="/header.jsp" name="header" /></div>
<div><div><page:applyDecorator page="/lefttree.jsp" name="lefttree" /></div><div><decorator:body /></div></div>

<div></div>
<div><page:applyDecorator page="/book.html" name="panel" /></div>

</div>

<table width="100%" height="100%">
</div>
	
	
		<td valign="top">
		<!-- 引入一个页面，临时指定所用的装饰器 -->
<!-- 		<page:applyDecorator page="/book.html" name="panel" /> -->
<!-- 		<page:applyDecorator page="/link.html" name="panel" /> -->
		</td>
		
		<td width="100%">
			<table width="100%" height="100%">
				<tr>
					<td id="pageTitle">
						<decorator:title/>
					</td>
				</tr>
				<tr>
					<td valign="top" height="100%">
						<decorator:body />
					</td>
				</tr>
				<tr>
					<td id="footer">
						<b>被包含的内容</b><br />
						SithMesh提供页面装饰支持
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>