<%@page import="com.github.support.utils.PtResoult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.github.support.utils.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>打分12345</title>
<style>
.wrapper
	{
	width: 300px;
	 margin: 10px auto;
	 font: 14px/1.5 arial;
}
/*tab*/
#star {
	overflow: hidden;
	list-style-type: none;
	
}

#star li {
	float: left;
	width: 20px;
	height: 20px;
	margin: 2px;
	display：inline-block;
	float: left;
	color: #999;
	font: bold 18px arial;
	cursor: pointer
}

#star .act {
	color: #c00
}

#star_word {
	width: 80px;
	height: 30px;
	line-height: 30px;
	border: 1px solid  #ccc;
	margin: 10px;
	
	text-align: center;
	display: none
}
</style>
<script>
	window.onload = function() {
		var star = document.getElementById("star");
		var star_li = star.getElementsByTagName("li");
		var star_word = document.getElementById("star_word");
		var result = document.getElementById("result");
		var i = 0;
		var j = 0;
		var len = star_li.length;
		var word = [ '很差', '差', '一般', "好du", "很好" ]
		for (i = 0; i < len; i++) {
			star_li[i].index = i;
			star_li[i].onmouseover = function() {
				star_word.style.display = "block";
				star_word.innerHTML = word[this.index];
				for (i = 0; i <= this.index; i++) {
					star_li[i].className = "act";
				}
			}
			star_li[i].onmouseout = function() {
				star_word.style.display = "none";
				for (i = 0; i < len; i++) {
					star_li[i].className = "";
				}
			}
			star_li[i].onclick = function() {
				result.innerHTML = (this.index + 1) + "分";
			}
		}
	}
</script>
</head>
<body>
		<div class="wrapper">
				打分结果指导 <span id="result"></span>
				<ul id="star">
						<li>★</li>
						<li>★</li>
						<li>★</li>
						<li>★</li>
						<li>★</li>
				</ul>
				<div id="star_word">一般</div>
		</div>
		
		<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
</body>
</html>