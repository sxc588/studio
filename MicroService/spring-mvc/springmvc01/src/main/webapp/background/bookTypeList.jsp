<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="com.wangwang.entity.BookType"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�ƹ��������̳�</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
  </head>
  
  <body>
    	<%
    		List<BookType> bookTypes = (List<BookType>)request.getAttribute("bookTypes");
    	%>
    	<table>
    		<caption>ͼ�������Ϣ�б�</caption>
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
    				<p align="left"><a href="background/saveBookType.jsp">����</a></p>
    			</td>
    		</tr>
    	</table>
  </body>
</html>
