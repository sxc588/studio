<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>

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
	String email = request.getParameter("email");

	if (name == null) {
		name = "kk";
	}
	if (email == null) {
		email = "jj";
	}

	String address = name + email;

	java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String dt = format1.format(new Date());
%>

</head>
<body>
	<form method="post" action="encrypt.jsp">
		<div class="int">
			<label for="name">姓名：</label> <input type="text" name="name"
				class="required" value=<%=name%> />
		</div>
		<div class="int">
			<label for="email">邮箱：</label> <input type="text" name="email"
				class="required" value=<%=email%> />
		</div>
		<div class="int">
			<label for="address">住址：</label> <input type="text" name="address"
				value=<%=address%> />

		</div>
		<div>
			<label>建议：</label>
			<textarea row="4" cols="100">请在这里输入您的建议</textarea>

			<p>
				单选框：<input type="radio" name="sex" value="nan">男 <input
					type="radio" name="sex" value="nv">女
			</p>
			<p>
				多选框：<input type="checkbox" name="n">吃饭 <input
					type="checkbox" name="n">睡觉 <input type="checkbox" name="n">打豆豆
				<input type="checkbox" name="n">喝水
			</p>
			
			<p>
			用户名：<input type="text" name="username"></br>

密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password">
</p>
<p>
<datalist id="browsers">
   <option value="Internet Explorer">
   <option value="Firefox">
   <option value="Chrome">
   <option value="Opera">
   <option value="Safari">
</datalist> 
</p>

 <input type="number" name="quantity" min="1" max="5">
 <input type="date" name="bday">
 
 请输入 1980-01-01 之前的日期：<br>
<input type="date" name="bday" max="1979-12-31"><br><br>
请输入 2000-01-01 之后的日期：<br>
<input type="date" name="bday" min="2000-01-02"><br><br>
<input type="submit"> 
 
<p>

<select>
  <option value ="volvo">Volvo</option>
  <option value ="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</p>
		</div>






		<div class="int">
			<input type="submit" value="提交" id="send" style="margin-left: 70px;" />
			<input type="reset" value="重置" id="res" /> <label for="address"><%=dt%></label>
		</div>
	</form>
</body>
</html>