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
	vertical-align: middle;
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

/* 
弹框样式： */
.tanchuang {
	width: 50%;
	height: 50%;
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, .5);
	z-index: 9999;
}

.tanchuang img {
	width: 380px;
	/* 	//如果想要让图片与本身的比例自适应放大或者缩小，只指定一个宽或者高属性即可，另一个属性会自适应 //height: 380px; */
	position: absolute;
	top: 22%;
	left: 65%;
	margin-left: -100px;
	margin-top: -100px;
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



	<div class="display-flex ">
		<div>
			<select id="Select1" name="D1" size="4"
				style="height: 200px; width: 80px;" multiple="multiple">
				<option>选项1</option>
				<option>选项2</option>
				<option>选项3</option>
				<option>选项4</option>
				<option>选项5</option>
				<option>选项6</option>
			</select>
		</div>
		<div>
			<div>
				<input id="Button1" type="button" value="==>" />
			</div>
			<div>
				<input id="Button2" type="button" value="=>>" />
			</div>
			<div>
				<input id="Button3" type="button" value="<<=" />
			</div>
			<div>
				<input id="Button4" type="button" value="<==" />
			</div>
		</div>
		<div>
			<select id="Select2" name="D2" size="4"
				style="height: 200px; width: 80px;" multiple="multiple">
			</select>
		</div>
	</div>


	<input type="checkbox" id="checkall">全选
	<input type="checkbox" id="checkrev">反选
	<input type="checkbox" name="check1">1
	<input type="checkbox" name="check1">2


	<input type="checkbox" name="fruit[]" />苹果
	<br />
	<input type="checkbox" name="fruit[]" />菠萝
	<br />
	<input type="checkbox" name="fruit[]" />芒果
	<br />
	<br />
	<input type="checkbox" id="all_ck" />全选 您最喜欢水果？
	<br />
	<br />
	<label><input name="Fruit" type="radio" value="" />get </label>
	<label><input name="Fruit" type="radio" value="" />post-body</label>
	<label><input name="Fruit" type="radio" value="" />post-form</label>
	<label><input name="Fruit" type="radio" value="" />head </label>
	<label><input name="Fruit" type="radio" value="" />put </label>
	<label><input name="Fruit" type="radio" value="" />delete </label>


	<button type="button" id="ddddd">切换</button>
	<select>
		<option value="值">选项内容</option>
		<option value="值">选项内容</option>
	</select>
	<div class="tanchuang">
		<img id="picture" src="" alt="">
	</div>
	form表单
	<form id="newUserPageAddForm" method="post"
		enctype="multipart/form-data">
		<div id="divSelect" class="searchCenter" width="100%">
			<input name="nuConfId" id="nuConfId" type="hidden"
				value="${newUserPageInfo.nuConfId}" />
			<table class="searTabBg" width="100%">
				<tr>
					<td width="120" align="right"><font color="#FF0000">* </font>新人入户页图片：</td>
					<td><input name="nuFirstImage1" id="nuFirstImage1" type="file"
						style="width: 200px;" /> <font color="#999999">大小限制（380*380）</font>
						<input type="button" value="上传" id="button1"
						class="nuFirstImageButton" /> <input name="nuFirstImage"
						id="nuFirstImage" type="hidden"
						value="${newUserPageInfo.nuFirstPic}" /> <input type="button"
						value="预览" class="preViewBtn" id="preViewImgBtn" /></td>
				</tr>
			</table>
		</div>
	</form>











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
		$('[name="fruit[]"]:checkbox').click(function() {
			var biaozhi = true;
			$('[name="fruit[]"]:checkbox').each(function() {
				if (!this.checked) {
					biaozhi = false;
				}
			})
			$('#all_ck').prop('checked', biaozhi);
		})

		//全选 与 每一项 的联动   方法二：【更简洁！】
		$('[name="fruit[]"]:checkbox').click(
				function() {
					var biaozhi = $('[name="fruit[]"]:checkbox');
					$('#all_ck')
							.prop(
									'checked',
									biaozhi.length == biaozhi
											.filter(':checked').length);
				})

		//全选与反选（通过单一复选框实现）
		$('#all_ck').click(function() {
			if (this.checked) {
				$('[name="fruit[]"]:checkbox').prop('checked', true);
			} else {
				$('[name="fruit[]"]:checkbox').prop('checked', false);
			}
		})

		// 点击预览弹出图片div
		$("#preViewImgBtn").click(function() {
			var imgUrl = $("#nuFirstImage").val();
			$("#picture").attr("src", imgUrl);
			$(".tanchuang").toggle();
			return false;
		});
		// 点击页面上任何一处隐藏div
		$("body").click(function() {
			$(".tanchuang").hide();
		});

		$(function() {
			$("#Button1").click(function() {
				$("#Select1 option:selected").clone().appendTo("#Select2");
				$("#Select1 option:selected").remove();
			})
			$("#Button2").click(function() {
				$("#Select1 option").clone().appendTo("#Select2");
				$("#Select1 option").hide();
			})
			$("#Button3").click(function() {
				$("#Select2 option:selected").clone().appendTo("#Select1");
				$("#Select2 option:selected").remove();
			})
			$("#Button4").click(function() {
				$("#Select2 option").clone().appendTo("#Select1");
				$("#Select2 option").hide();
			})
		})
	</script>
</body>
</html>