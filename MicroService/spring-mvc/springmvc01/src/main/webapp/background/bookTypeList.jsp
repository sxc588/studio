<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="com.wangwang.entity.BookType"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>云工厂网上商城</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
  </head>
  
  <body>
    	<%
    		List<BookType> bookTypes = (List<BookType>)request.getAttribute("bookTypes");
    	%>
    	<table>
    		<caption>图书类别信息列表</caption>
    		<tr>
    			<th>bookTypeId</th>
    			<th>parentId</th>
    			<th>isDelete</th>
    			<th>bookTypeName</th>
    			<th>context</th>
    		</tr>
    		<%
    		for (BookType bookType : bookTypes) {%>
    			<tr onmouseover="this.bgColor='#E6EB00'" onmouseout="this.bgColor='white'">
    				<td><%=bookType.getBookTypeId() %></td>
    				<td><%=bookType.getParentId() %></td>
    				<td><%=bookType.getIsDelete() %></td>
    				<td><%=bookType.getBookTypeName() %></td>
    				<td><%=bookType.getContext() %></td>
    			</tr>
    		<%}%>
    		<tr>
    			<td colspan="5" align="left">
    				<p align="left"><a href="background/saveBookType.jsp">新增</a></p>
    			</td>
    		</tr>
    	</table>
  </body>
</html>
