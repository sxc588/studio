<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="sf"
uri="http://www.springframework.org/tags/form"%> <%
request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>注册表编辑</title>
<script
	src="<%=request.getContextPath()%>/3rd/My97DatePicker/WdatePicker.js"></script>
<style>
.hse1 {
	color: red;
	width: 10px;
}

.hse2 {
	color: #F00;
	width: 50%;
}

.hse3 {
	color: #FF0000
}

table, table tr th, table tr td {
	border: 1px solid #0094ff;
}

table {
	width: 100%;
	min-height: 25px;
	line-height: 25px;
	text-align: left;
/* 	border-collapse: collapse; */
}

.container input:focus, .container input:HOVER {
	border-style: solid;
	border-color: #03a9f4;
	box-shadow: 0 0 15px #03a9f4;
}

.container input {
	width: 100%
}
</style>
<body>
	<jsp:include page="../top.vm.jsp"></jsp:include>

	<div class="container" role="main">
		<div class="container" role="main">
			<sf:form modelAttribute="configDto" method="post">
				<table>
					<tr>
						<td>注册表-Key:</td>
						<td><sf:input path="key" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="key" /></td>
					<tr>
						<td>注册表-Value:</td>
						<td><sf:input path="value" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="value" /></td>
					</tr>
					<tr>
						<td>注册表-描述:</td>
						<td><sf:input path="description" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="description" /></td>
					</tr>
					<tr>
						<td>注册表-最后更新人:</td>
						<td><sf:input path="lastUpdateBy" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="lastUpdateBy" /></td>
					</tr>
					<tr>
						<td>注册表-最后更新时间:</td>
						<td><sf:input path="lastUpdateTime" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="lastUpdateTime" /></td>
					</tr>
					<tr>
						<td colspan=4><input type="submit" value="提交"></td>
					</tr>
				</table>
							</sf:form>
				<form role="form">
  <div class="form-group">
    <label for="name">名称</label>
    <input type="text" class="form-control" id="name" placeholder="请输入名称">
  </div>
  <div class="form-group">
    <label for="inputfile">文件输入</label>
    <input type="file" id="inputfile">
    <p class="help-block">这里是块级帮助文本的实例。</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox">请打勾
    </label>
  </div>
  <button type="submit" class="btn btn-default">提交</button>
</form>

		</div>
	</div>
	
	
	
	<jsp:include page="../foot.vm.jsp"></jsp:include>
</body>
</html>