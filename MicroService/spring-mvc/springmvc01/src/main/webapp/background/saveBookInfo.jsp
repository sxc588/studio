<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="com.wangwang.entity.BookType"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����ͼ����Ϣ-�ƹ��������̳�</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
    <style type="text/css">
    	table td {
    		text-align:left;
		}
		
    </style>
  </head>
  
  <body>
  <br><br><br>
  
    <form action="<%=request.getContextPath()%>/SaveBookInfoServlet" name="saveBookType" method="post">
    	<table>
    	<caption>����ͼ����Ϣ</caption>
    		<tr>
    			<td>ͼ������:</td>
    			<td ><input name="bookName" size="35" ></td>
    		</tr>
    		<tr>
    			<td>ͼ������ţ�</td>
    			<td>
    			<select name="bookTypeId" >
   			<%
   				List<BookType> bookTypes = (List<BookType>)request.getAttribute("bookTypes");
   				for (BookType bookType : bookTypes) {%>
   					<option value="<%=bookType.getBookTypeId()%>"><%=bookType.getBookTypeName()%></option>
   			<%	}
   			%>
    			</select>
    			Ӧ���ǿ�ѡ��</td>
    		</tr>
    		<tr>
    			<td>���������ƣ�</td>
    			<td><input name="pbName" size="35">*</td>
    		</tr>
    		<tr>
    			<td>���ߣ�</td>
    			<td><input name="author" size="35">*</td>
    		</tr>
    		<tr>
    			<td>��ͼƬ��</td>
    			<td><input name="bigImg" size="35">�ļ��ϴ�</td>
    		</tr>
    		<tr>
    			<td>СͼƬ��</td>
    			<td><input name="smallImg" size="35">�ļ��ϴ�</td>
    		</tr>
    		<tr>
    			<td>��Ǯ��</td>
    			<td><input name="price" size="35"></td>
    		</tr>
    		<tr>
    			<td>�ƹ����ؼۣ�</td>
    			<td><input name="ygcPrice" size="35"></td>
    		</tr>
    		<tr>
    			<td>���������ƣ�</td>
    			<td><input name="pbDate" size="35"></td>
    		</tr>
    		<tr>
    			<td>ͼ��״̬��</td>
    			<td><input type="radio" name="bookStates" value="1" checked>���� 
    				<input type="radio" name="bookStates" value="2">�ϼ�
    				<input type="radio" name="bookStates" value="3">������
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
