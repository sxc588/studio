<%@page import="com.github.support.utils.PtResoult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.github.support.utils.*"%>




<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>jQueryStudy</title>
<style>
.int {
	height: 30px;
	text-align: left;
	width: 600px;
}

label {
	width: 200px;
	margin-left: 20px;
}

.high {
	color: red;
}

.msg {
	font-size: 13px;
}

.onError {
	color: red;
}

.onSuccess {
	color: green;
}

textarea {
	white-space: pre;
	overflow-wrap: normal;
	overflow-x: scroll;
	width: 70%;
	height: 200px
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="webapp/jqvalidate.js"></script>
<%
	String name = request.getParameter("name");
	

	if (name == null) {
		name = "127.0.0.1";
	}
		PtResoult kk=PingUtils.ping(name);

	String address = kk.getDescription();

	java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String dt = format1.format(new Date());
%>

</head>
<body>
	<form action="" method="get">
            <div id="t1">
                <h1>一、填空题</h1>
                <h3>html语义化标签自带缩进的是哪个标签？</h3>
                <input type="text" name="tiankong" id="tiankong" >  
            </div>
        
            <div id="t2">
                <h1>二、单选题</h1>
                <h3>下面哪个属性不会让 div 脱离文档流（normal flow）？</h3>
                <input type="radio" name="danxuan" value="A">A.position: absolute;
                <input type="radio" name="danxuan" value="B">B.position: fixed;
                <br>
                <input type="radio" name="danxuan" value="C">C.position: relative;
                <input type="radio" name="danxuan" value="D">D.float:left;          
            </div>
        
            <div id="t3">
                <h1>三、多选题</h1>
                <h3>可继承的样式属性包括哪些</h3>
                <input type="checkbox" name="duoxuan" value="A">A.color
                <input type="checkbox" name="duoxuan" value="B">B.background-color
                <br>
                <input type="checkbox" name="duoxuan" value="C">C.font-size
                <input type="checkbox" name="duoxuan" value="D">D.border
            </div>
            
            <div id="t4">
                <h1>四、判断题</h1>
                <h3>中国是伟大的</h3>
                <input type="radio" name="panduan" value="true">是的
                <input type="radio" name="panduan" value="false">不是
            </div>
            
            <button type="submit">提交答案</button>
        </form>
</body>
</html>