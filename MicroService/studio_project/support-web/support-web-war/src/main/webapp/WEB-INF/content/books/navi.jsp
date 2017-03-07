<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面包屑导航</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap.min.js"></script>
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

	<ul>
		<li><a href="#">面包屑导航 </a></li>
		<li><a href="#">分页导航 </a></li>
	</ul>

	<ol class="breadcrumb">
		<li><a href="#">首页 </a></li>
		<li><a href="#">新闻 </a></li>
		<li><a href="#">国内新闻 </a></li>
		<li class="active"><a href="#">高考专题 </a></li>
	</ol>

	<ul class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li><a href="#">2013</a></li>
		<li class="active">十一月</li>
	</ul>


	<ul data-am-widget="pagination"
		class="am-pagination am-pagination-default">

		<li class="am-pagination-first "><a href="#" class="">第一页</a></li>

		<li class="am-pagination-prev "><a href="#" class="">上一页</a></li>


		<li class=""><a href="#" class="">1</a></li>
		<li class="am-active"><a href="#" class="am-active">2</a></li>
		<li class=""><a href="#" class="">3</a></li>
		<li class=""><a href="#" class="">4</a></li>
		<li class=""><a href="#" class="">5</a></li>


		<li class="am-pagination-next "><a href="#" class="">下一页</a></li>

		<li class="am-pagination-last "><a href="#" class="">最末页</a></li>
	</ul>


	<hr />
	<ul class=" pagination">
		<li><a href="#">«</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">»</a></li>
	</ul>

	<a href="#1F" name="1F">锚点1</a>
	<a href="#2F" name="2F">锚点2</a>
	<div name="1F">
		<p>
			11111111111 </br> 11111111111 </br>11111111111 </br>11111111111 </br>11111111111 </br>11111111111
			</br>11111111111 </br>11111111111 </br>11111111111 </br>11111111111 </br>11111111111 </br>11111111111
			</br>11111111111 </br>11111111111 </br>11111111111 </br>11111111111 </br>
		</p>
	</div>


	<div name="2F">
		<p>
			222222222222222 </br> 222222222222222 </br>222222222222222 </br>222222222222222 </br>222222222222222
			</br>222222222222222 </br>222222222222222 </br>222222222222222 </br>222222222222222 </br>222222222222222
			</br>222222222222222 </br>222222222222222 </br>222222222222222 </br>222222222222222 </br>222222222222222
			</br>222222222222222 </br>
		</p>
	</div>


</body>
</html>