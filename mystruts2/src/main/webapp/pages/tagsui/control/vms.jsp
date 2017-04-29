<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制标签</title>
<link rel="stylesheet" href="/struts2/3rd/bootstrap/css/bootstrap.css">
<script src="/struts2/3rd/jquery/jquery-1.11.3.min.js"></script>
<script src="/struts2/3rd/bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="/struts2/3rd/bootstrap/buttons/css/buttons.css">

<script type="text/javascript"
	src="/struts2/3rd/bootstrap/buttons/js/buttons.js"></script>

<script type="text/javascript"
	src="/struts2/pages/tagsui/control/vms.js"></script>
<!-- 只有使用字体图标时才需要加载 Font-Awesome -->
<link
	href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<h2>控制标签 - s:iterator</h2>
	<s:debug />
	<p>有序列表：</p>

	<%-- 	<s:select list="#catelogs.bookCatlogs" name="category" --%>
	<%-- 		onchange="showBooks(this)"></s:select> --%>






  <div class="table-responsive">
		<table class="table table-condensed table-hover">
			<thead>
				<tr class="active">
					<th>服务名称</th>
					<th>阶段【Stage】</th>
					<th>端口</th>
					<th>dubbo-端口</th>
					<th>URL</th>
				</tr>
			</thead>
			<tbody>

					<tr class="alert-success">
						<td>consle</td>
						<td>double</td>
						<td>es</td>
						<td>db</td>
						<td>${vm.url}</td>
					</tr>
			</tbody>
		</table>
	</div>








	<div class="ui-widget">
		<label>您喜欢的编程语言：</label> <select id="combobox"
			onchange="showVms(this)">
			<option value="">请选择...</option>
			<s:iterator value="micService" var="ms">
				<option value=${ms}>${ms}</option>
			</s:iterator>
		</select>
	</div>

	<button class="button button-3d button-box button-jumbo">
		<i class="fa fa-thumbs-up"></i>
	</button>
	<a href="http://www.bootcss.com/"
		class="button button-3d button-primary button-rounded">Alpha</a>
	<a href="http://www.bootcss.com/"
		class="button button-3d button-action button-pill">Beta</a>
	<button
		class="button button-3d button-action button-circle button-jumbo">
		<i class="fa fa-thumbs-up"></i>
	</button>
	<a href="http://www.bootcss.com/"
		class="button button-3d button-caution"><i class="fa fa-camera"></i>
		Go</a>
	<a href="http://www.bootcss.com/" class="button button-3d button-royal">Say
		Hi!</a>

	<div class="table-responsive">
		<table class="table table-condensed table-hover">
			<thead>
				<tr class="active">
					<th>服务名称</th>
					<th>阶段【Stage】</th>
					<th>端口</th>
					<th>dubbo-端口</th>
					<th>URL</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="virtualMechines" var="vm">
					<!--         <s:set var="myAge" value="42"></s:set> -->
					<!-- 	<s:if test="#myAge >40"> 中年人</s:if> -->

					<!--         <s:if test="#myAge >40"> <tr class="alert-success"></s:if> -->
					<!--         <s:if test="#myAge >40"> <tr class="alert-success"></s:if> -->
					<!--         <s:if test="#myAge >40"> <tr class=“alert-info"></s:if> -->
					<!--         <s:if test="#myAge >40"> <tr class="alert-success"></s:if> -->
					<tr class="alert-success">
						<td>${vm.name}</td>
						<td>${vm.stage}</td>
						<td>${vm.port}</td>
						<td>${vm.dubboPort}</td>
						<td>${vm.url}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>