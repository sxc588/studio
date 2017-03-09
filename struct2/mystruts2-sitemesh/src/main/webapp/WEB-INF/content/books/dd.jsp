<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面包屑导航</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/bootstrap/css/app.css"
	rel="stylesheet">

<script type="text/javascript">
	function showBooks(catelog) {
		//alert(value);
		//向validateName 发送请求，请求参数名userName，参数值value
		//服务器响应后，返回值放到 ID为 result元素中
		//$("#result").load("validateName", {userName:catelog})	
		$.post("/struts2/books/getBooksByCategory",
				$(catelog).serializeArray(), function(data)//服务器响应后，返回值的数据 data
				{

					$("#books").empty();
					for (var i = 0; i < data.books.length; i++)
					//for (var book in data.books)
					{
						// 				$("#showBooks").append("<tr>" 
						// 		+ "<td>" + data.books[i].id   + "</td>"
						// 		+ "<td>" + data.books[i].name + "</td>"
						// 		+ "<td>" + data.books[i].auth + "</td>"
						// 		+ "<td>" + data.books[i].price + "</td>"
						// 		+ "</tr>");

						var a = "<tr>";
						a = a + "<td>" + data.books[i].id + "</td>";
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

	<div class="onepage">

		<div class="onepage-bg" id="onpagebg"></div>
		<div class="container">
			<div class="row">
				<div class="title-text">
					<div class="col-md-12 headfontsize">
						<h1 class="headh1content">极客学院</h1>
					</div>
				</div>
			</div>


		</div>


	</div>


	
</html>