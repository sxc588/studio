<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<title>测试</title>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>


<style>
.circle {
	width: 20px;
	height: 20px; <!--
	background: #7fee1d; -->
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
}

.red {
	background: red;
}

.yellow {
	background: yellow;
}

.green {
	background: green;
}
</style>
</head>
<body>
	<jsp:include page="../top.vm.jsp"></jsp:include>

	<input type="button" name="request" value="请求后台"
		style="width: 200px; height: 50px; background-color: red; margin-bottom: 20px;">
	<div name="rs"></div>
	<input type="checkbox" name="se" value="1">hafiz.zhang
	<br />
	<input type="checkbox" name="se" value="2">jack.chen
	<br />
	<input type="checkbox" name="se" value="3">lili.wang
	<br />
	<script type="text/javascript">
		$("input[name='request']").click(function() {
			var data = [];
			$("input[name='se']").each(function() {
				if ($(this).prop("checked")) {
					data.push($(this).val());
				}
			});
			var json_data = JSON.stringify(data);

			$.ajax({
				type : "post",
				url : "/springmvc/setting/config2/index",
				contentType : "application/json",
				data : json_data,
				dataType : "json",
				success : function(data) {
					var str = "";
					for (var i = 0; i < data.length; i++) {
						str += ";name=" + data[i];
					}
					$("div[name='rs']").html(str);
				},
				error : function() {
					alert("出错啦");
				}
			});
		});
	</script>


	<form action="/springmvc/upload/upload" enctype="multipart/form-data"
		method="post">
		<input type="file" name="file"><br> <br> <input
			type="submit" value="上传">
	</form>



	<form action="/springmvc/upload/uploads" enctype="multipart/form-data"
		method="post">
		<fieldset>
			<legend>主机信息</legend>
			<table>
				<tr>
					<td>机器名</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Ip</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>上联CI</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>下联CI</td>
					<td><input type="text" /></td>
				</tr>

			</table>
			<div class="circle red"></div>
		</fieldset>
		<fieldset>
			<legend>选择文件: </legend>
			<table>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="上传">
	</form>

	<form action="/springmvc/upload/uploads" enctype="multipart/form-data"
		method="post">

		<fieldset>
			<legend>健康信息</legend>
			<table>
				<tr>
					<td>身高:<input type="text" /></td>
				</tr>
				<tr>
					<td>体重：<input type="text" /></td>
				</tr>
			</table>
			<div class="circle red"></div>
		</fieldset>
		<fieldset>
			<legend>选择文件: </legend>
			<table>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="上传">
	</form>

	

	<jsp:include page="<%=request.getContextPath()%>/foot.vm.jsp"></jsp:include>
</body>
</html>