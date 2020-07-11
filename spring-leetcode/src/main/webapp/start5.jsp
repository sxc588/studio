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
<title></title>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function test(myvalue) {
		for (var i = 1; i <= 5; i++) {//将所有都变白星星
			document.getElementById("" + i).innerHTML = "<h1>☆</h1>";
			document.getElementById("" + i)
					.setAttribute("style", "color:black");
		}
		for (var i = 1; i <= myvalue; i++) {//通过传入的id（也是一个数字）确定id以下的div都是橙色星星。
			document.getElementById("" + i).innerHTML = "<h1>★</h1>";
			document.getElementById("" + i).setAttribute("style","color:orange");
		}
	}
</script>

<style type="text/css">
.myfloatleft {
	float: left;
}
</style>
</head>
<body>
 <button οnclick="clik()" value="按钮"></button>

		<div id="showdiv">
				<button id="1" class="myfloatleft" buttonbutton="test('1')" οnmοuseοut="myclear()">
						<h1>☆</h1>
				</button>
				<div id="2" class="myfloatleft" οnmοuseοver="test('2')" οnmοuseοut="myclear()">
						<h1>☆</h1>
				</div>
				<div id="3" class="myfloatleft" οnmοuseοver="test('3')" οnmοuseοut="myclear()">
						<h1>☆</h1>
				</div>
				<div id="4" class="myfloatleft" οnmοuseοver="test('4')" οnmοuseοut="myclear()">
						<h1>☆</h1>
				</div>
				<div id="5" class="myfloatleft" οnmοuseοver="test('5')" οnmοuseοut="myclear()">
						<h1>☆</h1>
				</div>
		</div>
		<div id="mydiv"></div>
		<br>
		<br>
		<br>
		<p>
		<h1>说明:</h1>
		1、制作五个“☆”，并且用div框起来。
		<br> 2、测试当鼠标放在星星div上面时会不会产生反应（给div添加onmouseover事件）
		<br> 3、修改代码:当鼠标放在星星的div上面时，当前的div内容修改为"★"。
		<br> 4、测试：让所有div的星星都是白色的。 5、测试：通过传入一个参数，让指定id的div以下的div内容为"★"。
</body>
</html>