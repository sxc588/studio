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
    </head>
<body>
	<!-- 导航 -->
	<div class="navbar">
		<jsp:include page="../top.vm.jsp"></jsp:include>
	</div>

	<!-- 图片轮播 -->
	<div class="carousel"></div>

	<!-- 内容展示 container 里面分两个 6 -->
	<div class="container" role="main">
		<div class="container col-md-12" role="sub1">
			<sf:form modelAttribute="configDto" method="post">
			<table class="table">
					<tr>
						<td class="col-md-2"><label for="key">注册表-Key:</label></td>
						<td class="col-md-6"><sf:input path="key" type="text" class="form-control" id="name" placeholder="请输入名称"/></td>
						<td class="hse1">*</td>
						<td class="col-md-6"><sf:errors path="key" /></td>
					<tr>
						<td><label for="value">注册表-Value:</td>
						<td><sf:input path="value" type="text" class="form-control" id="value" placeholder="请输入名称"/></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="value" /></td>
					</tr>
					<tr>
						<td><label for="description">注册表-描述:</label></td>
						<td><sf:input path="description" type="text" class="form-control" id="description" placeholder="请输入名称" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="description" /></td>
					</tr>
					<tr>
						<td><label for="lastUpdateBy">注册表-最后更新人:</label></td>
						<td><sf:input path="lastUpdateBy" type="password" class="form-control" id="lastUpdateTime" placeholder="请输入名称"/></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="lastUpdateBy" /></td>
					</tr>
					<tr>
						<td><label for="key">注册表-最后更新时间:</label></td>
						<td><sf:input path="lastUpdateTime" type="text" class="form-control" id="lastUpdateTime" placeholder="请输入名称" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="lastUpdateTime" /></td>
					</tr>
					<tr>
						<td colspan=4><input type="submit" value="提交"></td>
					</tr>
				</table>
			</sf:form>
</div>
	<div class="container col-md-12" role="sub1">
			<sf:form modelAttribute="configDto" method="post">
			<table class="table">
					<tr>
						<td class="col-md-2"><label for="key">Ceph-Host:</label></td>
						<td class="col-md-6"><sf:input path="key" type="text" class="form-control" id="name" placeholder="请输入名称"/></td>
						<td class="hse1">*</td>
						<td class="col-md-6"><sf:errors path="key" /></td>
					<tr>
						<td><label for="value">Ceph-ak:</td>
						<td><sf:input path="value" type="text" class="form-control" id="value" placeholder="请输入名称"/></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="value" /></td>
					</tr>
					<tr>
						<td><label for="description">Ceph-sk:</label></td>
						<td><sf:input path="description" type="text" class="form-control" id="description" placeholder="请输入名称" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="description" /></td>
					</tr>
					<tr>
						<td><label for="lastUpdateBy">Bucket Name:</label></td>
						<td><sf:input path="lastUpdateBy" type="password" class="form-control" id="lastUpdateTime" placeholder="请输入名称"/></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="lastUpdateBy" /></td>
					</tr>
					<tr>
						<td><label for="key">Ceph- Key</label></td>
						<td><sf:input path="lastUpdateTime" type="text" class="form-control" id="lastUpdateTime" placeholder="请输入名称" /></td>
						<td class="hse1">*</td>
						<td class="hse2"><sf:errors path="lastUpdateTime" /></td>
					</tr>
					<tr>
						<td colspan=4><input type="submit" value="提交"></td>
					</tr>
				</table>
			</sf:form>
</div>
			<ul class="pager">
				<li class="previous"><a href="#">&larr; Older</a></li>
				<li class="next"><a href="#">Newer &rarr;</a></li>
			</ul>
		</div>
		</div>
		
	</div>

	<jsp:include page="../foot.vm.jsp"></jsp:include>

	</div>

<h2>创建模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	开始演示模态框
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


</body>
</html>