<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>按种类查看图书</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery.js"></script>
<script type="text/javascript">
	function showBooks(catelog) {
		//alert(value);
		//向validateName 发送请求，请求参数名userName，参数值value
		//服务器响应后，返回值放到 ID为 result元素中
		//$("#result").load("validateName", {userName:catelog})	
		$.post("/struts2/books/getBooksByCategory", $(catelog).serializeArray()
		, function(data)//服务器响应后，返回值的数据 data
		{
		
		$("#books").empty();
		for (var i=0; i<data.books.length;i++)
		//for (var book in data.books)
		{
		
// 				$("#showBooks").append("<tr>" 
// 		+ "<td>" + data.books[i].id   + "</td>"
// 		+ "<td>" + data.books[i].name + "</td>"
// 		+ "<td>" + data.books[i].auth + "</td>"
// 		+ "<td>" + data.books[i].price + "</td>"
// 		+ "</tr>");
		
		
		var a= "<tr>";
		a = a + "<td>" + data.books[i].id   + "</td>";
		a = a + "<td>" + data.books[i].name + "</td>";
		a = a + "<td>" + data.books[i].auth + "</td>";
		a = a + "<td>" + data.books[i].price + "</td>";
		a = a + "</tr>";
		
		$("#books").append(a);
		}
		console.log(data.books);
		//alert(data.books)
		}, "json")
	}
</script>

</head>
<body>
<!-- 	<h2> -->
<!-- 		请输入用户信息01<br>38-json 时一个轻量级的数据对象<br>--{} 对象<br>--[] 数组<br> -->
<!-- 		<br>开发步骤： 添加Json 插件<br> <br> -->
<!-- 	</h2> -->

	<s:action var="catelogs" name="listCatelogs" />
	<s:select list="#catelogs.bookCatlogs" name="category"
		onchange="showBooks(this)"></s:select>

	<p>map 迭代：</p>
	<table width="600" border="1"
	<tr>
		<th>图书ID</th>
		<th>图书名</th>
		<th>作者</th>
		<th>价格</th>
	</tr>
	<tbody id ="books" />
	
	
	</table>
	
	
		<s:iterator value="#catelogs.bookCatlogs" var="value" status="st">
		<tr>
		<td <s:if test="#st.odd"> style="background-color:red"</s:if>>${value}</td>
		</s:iterator>
</body>
</html>