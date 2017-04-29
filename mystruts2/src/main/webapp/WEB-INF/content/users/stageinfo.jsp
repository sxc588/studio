<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="st"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出所有的用户！</title>
<link rel="stylesheet" href="/struts2/3rd/bootstrap/css/bootstrap.css">
    <script src="//code.jquery.com/jquery-1.11.3.js" type="text/javascript"></script>
<script src="/struts2/3rd/bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="/struts2/3rd/bootstrap/buttons/css/buttons.css">

<script type="text/javascript"
	src="/struts2/3rd/bootstrap/buttons/js/buttons.js"></script>

    <script type="text/javascript">
	$(function() {

	
	       $("#btn5").click(function () {
	    	   var aa = "";
	    	  
	           $("input[name='checkbox']:checkbox:checked").each(function () {
	               aa += $(this).val()
	           })
	           alert(aa);
	       })
		
		$("#edit").click(function() {
			$('input').attr("disabled", false)//将input元素设置为readonly 
		});
		$("#save").click(function() {
			$('input').attr("disabled", true)//将input元素设置为readonly 
		});
		$("input:radio[name='stage']").click(
				function() {
					//alert("您是..." + $(this).val());
					var Days = 30;
					var exp = new Date();
					exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
					document.cookie = "stage" + "=" + escape($(this).val())
							+ ";expires=" + exp.toGMTString();
					window.location.reload();//刷新当前页面.
					$(this).attr("disabled", true)//将input元素设置为readonly 
				});
		


	});


</script>
</head>
<body>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> 点击我进行展开，再次点击我进行折叠。第 1 部分：基本信息 </a>
				</h4>
			</div>

			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<h2>当前为${stage}环境信息页</h2>
					<button id="edit">编辑当前页</button>
					<button id="save">保存当前页</button>
					<button id="btn5">保存当前页</button>
					<button id="btn5">保存当前页</button>
<!-- 					<s:property value="stage" /> -->
												
					<input type="radio" name="stage" value="Alpha" checked>Alpha</input>
					<input type="radio" name="stage" value="Beta">Beta</input>
					<input type="radio" name="stage" value="Prod">Prod </input>
					<%--     <st:radio list="{'id':'Alpha','id':'Beta',''id'':Prod'}" name="id" /> --%>
					

					<div class="" data-tag="bdshare" data-bd-bind="1491697790898">
						<a class="bds_qzone bds" data-cmd="qzone" href="#" title="分享到QQ空间">反反復復</a>
						<a class="bds_tsina bds" data-cmd="tsina" title="分享到新浪微博">水水水水</a>
						<a class="bds_weixin bds" data-cmd="weixin" title="分享到微信">發發發</a>
					</div>

					<div class="table-responsive">
						<table class="table table-condensed table-hover">
							<thead>
								<tr class="active">
									<th calss="col-md-8">环境信息名称</th>
									<th>信息值</th>
								</tr>
							</thead>
							<tbody>
								<st:iterator value="envInfos" var="env">
									<tr class="alert-success">
										<td><input class=type= "text" value=${env.name}></td>
										<td><input class=type= "text" value=${env.value}></td>
									</tr>
								</st:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo"> 点击我进行展开，再次点击我进行折叠。第 2 部分：服務信息 </a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse">
				<div class="panel-body">Nihil anim keffiyeh helvetica, craft
					beer labore wes anderson cred nesciunt sapiente ea proident. Ad
					vegan excepteur butcher vice lomo.</div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseThree"> 点击我进行展开，再次点击我进行折叠。第 3 部分：數據庫信息 </a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse  in">
				<div class="panel-body">Nihil anim keffiyeh helvetica, craft
					beer labore wes anderson cred nesciunt sapiente ea proident. Ad
					vegan excepteur butcher vice lomo.</div>
			</div>
		</div>

	
	</div>

	<jsp:include page="dialog/addone.jsp"></jsp:include>
	<jsp:include page="dialog/import.html"></jsp:include>
	<jsp:include page="dialog/export.html"></jsp:include>

	<input type="button" value="全选" class="btn" id="selectAll">
	<input type="button" value="全不选" class="btn" id="unSelect">
	<input type="button" value="反选" class="btn" id="reverse">
	<input type="button" value="获得选中的所有值" class="btn" id="getValue">

	<h2>当前的用户列表</h2>
	<input type="button" value="批量删除" class="btn" id="selectAll">
	<input type="button" value="批量检查" class="btn" id="unSelect">
	<input type="button" value="导出..." class="btn" id="reverse">
	<input type="button" value="导入..." class="btn" id="getValue">


	<table width="800" border="1">
		<tr>
			<th><input type="checkbox" id="all"></th>
			<th>名称</th>
			<th>Stage</th>
			<th>端口</th>
			<th>dubbo端口</th>
			<th>url</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<st:iterator value="vminfos" var="user" >
			<tr>
				<td><input type="checkbox" name="checkbox"  value=${user.url}/></td>
				<td>${user.name}</td>
				<td>${user.stage}</td>
				<td>${user.port}</td>
				<td>${user.dubboPort}</td>
				<td>${user.url}</td>
				<td>200 OK</td>
				<td><input type="button" value="删除" class="btn" id="unSelect">
					<input type="button" value="编辑" class="btn" id="reverse"> <input
					type="button" value="检查" class="btn" id="getValue"></td>
			</tr>
		</st:iterator>
	</table>

<ul class="pagination pagination-sm">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>

</body>
</html>