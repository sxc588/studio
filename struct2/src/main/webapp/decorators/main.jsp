<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title></decorator:title></title>
</head>
<body>
	<h2>人力资源系统</h2>
	<hr />
	<table border="1">
		<tr>
			<td><page:applyDecorator name="panel" page="/decorators/zuzhi.jsp"></page:applyDecorator></td>
			<td><decorator:body></decorator:body></td>
		</tr>
	</table>
	<hr />
	<h2>版权所有 2017</h2>
</body>
</html>