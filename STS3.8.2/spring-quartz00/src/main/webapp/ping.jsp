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
	<form method="post" action="ping.jsp">
		<div class="int">
			<label for="name">IP或主机名：</label> <input type="text" name="name"
				class="required" value=<%=name%> />
		</div>
		<div class="int">
			<label for="address">结构：</label> <input type="text" name="address"
				value=<%=address%> />
		</div>
		<div class="int">
			<input type="submit" value="提交" id="send" style="margin-left: 70px;" />
			<input type="reset" value="重置" id="res" /> <label for="address"><%=dt%></label>
		</div>
	</form>
</body>
</html>