<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>注册表编辑</title>
<style type="text/css">
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

/* .container input { */
/* 	width: 100% */
/* } */
.display-flex {
	display: flex;
}

.div-inline {
	display: inline
}

.div-size {
	border: 1px solid red;
	width: 200px;
	height: 120px;
	margin: 10px;
}
</style>
<body>
	<jsp:include page="../top.header.jsp"></jsp:include>

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
					<label for="name">名称</label> <input type="text"
						class="form-control" id="name" placeholder="请输入名称">
				</div>
				<div class="form-group">
					<label for="inputfile">文件输入</label> <input type="file"
						id="inputfile">
					<p class="help-block">这里是块级帮助文本的实例。</p>
				</div>





				<div class="display-flex">
					<label> <input type="checkbox" id="all">全选
					</label> <label> <input type="checkbox" id="all">
					</label>


					<div class="div-size">
						<input type="checkbox" name="category" value="今日话题" />今日话题
					</div>
					<div class="div-size">
						<input type="checkbox" name="category" value="视觉焦点" />视觉焦点
					</div>
					<div class="div-size">
						<input type="checkbox" name="category" value="财经" />财经
					</div>
					<div class="div-inline div-size">
						<input type="checkbox" name="category" value="汽车" />汽车
					</div>
					<div class="div-size">
						<input type="checkbox" name="category" value="科技" />科技
					</div>
					<div class="div-size">
						<input type="checkbox" name="category" value="房产" />房产
					</div>
					<div class="div-size">
						<input type="checkbox" name="category" value="旅游" />旅游
					</div>
				</div>

				<p>
					<input id="btnOperate" type="button" value="选择"
						onclick="static_num()" />
				</p>

				<button type="submit" class="btn btn-default">提交</button>
			</form>

		</div>
	</div>



<input type="checkbox" id="checkall">全选<input type="checkbox" id="checkrev">反选
<input type="checkbox" name="check1">1
<input type="checkbox" name="check1">2


<input type="checkbox" name="fruit[]"/>苹果<br/>
<input type="checkbox" name="fruit[]"/>菠萝<br/>
<input type="checkbox" name="fruit[]"/>芒果<br/>
<br/>
<input type="checkbox" id="all_ck"/>全选

	您最喜欢水果？
	<br />
	<br />
	<label><input name="Fruit" type="radio" value="" />get </label>
	<label><input name="Fruit" type="radio" value="" />post-body</label>
	<label><input name="Fruit" type="radio" value="" />post-form</label>
	<label><input name="Fruit" type="radio" value="" />head </label>
	<label><input name="Fruit" type="radio" value="" />put </label>
	<label><input name="Fruit" type="radio" value="" />delete </label>

	<select>
		<option value="值">选项内容</option>
		<option value="值">选项内容</option>
	</select>
	<jsp:include page="../foot.vm.jsp"></jsp:include>
	<script>
		function static_num() {
			document.getElementById("btnOperate").onclick = function() {
				var arr = new Array();
				var items = document.getElementsByName("category");
				for (i = 0; i < items.length; i++) {
					if (items[i].checked) {
						arr.push(items[i].value);
					}
				}
				alert("选择的个数为：" + arr.length);
			};
		};

		$(function() {

			$("#all").change(function() {//判断全选框的改变
				var flage = $(this).is(":checked");//全选选中为true，否则为false
				$("input[type=checkbox]").each(function() {
					$(this).prop("checked", flage);
				})
			})
		})

		$(function() {
			$("#checkall").click(function() {
				$('[name=check1]:checkbox').attr('checked', this.checked); //checked为true时为默认显示的状态  
			});
			
			$("#checkrev").click(function() {
				//实现反选功能 
				$('[name=check1]:checkbox').each(function() {
					this.checked = !this.checked;
				});
			});
		});
		
		
		
		//全选 与 每一项 的联动   方法一：
		$('[name="fruit[]"]:checkbox').click(function(){
		    var biaozhi=true;
		    $('[name="fruit[]"]:checkbox').each(function(){
		        if(!this.checked){
		            biaozhi=false;
		        }
		    })
		    $('#all_ck').prop('checked',biaozhi);
		})
		
		//全选 与 每一项 的联动   方法二：【更简洁！】
		$('[name="fruit[]"]:checkbox').click(function(){
		    var biaozhi=$('[name="fruit[]"]:checkbox');
		    $('#all_ck').prop('checked',biaozhi.length==biaozhi.filter(':checked').length);
		})
		
		//全选与反选（通过单一复选框实现）
		$('#all_ck').click(function(){
		    if(this.checked){
		        $('[name="fruit[]"]:checkbox').prop('checked',true);
		    }else{
		        $('[name="fruit[]"]:checkbox').prop('checked',false);
		    }
		})
	</script>
</body>
</html>