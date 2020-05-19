<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath();
%>
<div class="container1" role="main">
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="list-schedule-job.shtml">基于Quartz的分布式定时任务</a>
			</div>
			
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand" href="index.html">仪表盘</a></li>
					
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">应用监控<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<%=contextPath%>/monitor/http/show">应用监控</a></li>
							<li><a href="extensions/export.html">SLA</a></li>
						</ul>
					</li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">基础组件监控<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="extensions/editable.html">Editable</a></li>
							<li><a href="extensions/export.html">Export</a></li>
						</ul>
					</li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">问题管理<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="extensions/editable.html">告警详情</a></li>
							<li><a href="extensions/export.html">问题工单</a></li>
							<li><a href="extensions/export.html">我已处理</a></li>
							<li><a href="extensions/export.html">待我处理</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">运维报表<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="extensions/editable.html">主机汇总</a></li>
							<li><a href="extensions/export.html">Export</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">CMDB<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="extensions/editable.html">应用管理</a></li>
							<li><a href="extensions/export.html">产品管理</a></li>
							<li><a href="extensions/editable.html">特性管理</a></li>
							<li><a href="extensions/export.html">实例管理</a></li>
							<li><a href="extensions/editable.html">主机管理</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false">系统管理<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="setting/config">注册表</a></li>
							<li><a href="integrate/angular">系统维护窗管理</a></li>
							<li><a href="integrate/angular">用户管理</a></li>
							<li><a href="integrate/angular">用户组管理</a></li>
						</ul></li>
					<li><a class="navbar-brand" href="#">s00318828</a> <a
						class="navbar-brand" href="index.html">注销</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 	<div class="jumbotron jumbotron-margin-top"> -->
	<!-- 			<h1>Spring Quartz分布式定时任务</h1> -->
	<!-- 			<p>Spring整合Quartz基于数据库的分布式定时任务，可动态添加、删除、修改定时任务。</p> -->
	<!-- 		</div> -->
</div>