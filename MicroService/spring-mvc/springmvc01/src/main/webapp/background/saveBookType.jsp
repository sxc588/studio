<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="com.wangwang.entity.BookType"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�ƹ��������̳�</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
    <style type="text/css">
    	table td {
    		text-align:left;
		}
		
		
    </style>
  </head>
  
  <body>
  <br><br><br>
  
    <form action="<%=request.getContextPath()%>/SaveBookTypeServlet" name="saveBookType" method="post">
    	<table>
    	<caption>����ͼ�������Ϣ</caption>
    		<tr>
    			<td>��ID:</td>
    			<td ><input name="parentId" size="35" ></td>
    		</tr>
    		<tr>
    			<td>������ƣ�</td>
    			<td><input name="bookTypeName" size="35"></td>
    		</tr>
    		<tr>
    			<td>�Ƿ���ã�</td>
    			<td><input type="radio" name="isDelete" value="1" checked>���� 
    				<input type="radio" name="isDelete" value="2">������
    			</td>
    		</tr>
    		<tr>
    			<td>����:</td>
    			<td><textarea rows="4" cols="35" name="context"></textarea></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="submit"/></td>
    			
    			<td><input type="reset" value="reset"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
