<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<html>
  <head>
    <title>��Ϣ��ʾҳ��-�ƹ��������̳�</title>
<link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
  </head>
  
  <body>
<br><br>	   
	   <p align="center">
	   	<font color="red" size="12"><%=request.getAttribute("msg")%><br><br>
	   	<a href="<%=request.getContextPath()%><%=request.getAttribute("returnPath")%>">����</a>
	   	</font>
	   </p>
</body>
</html>
