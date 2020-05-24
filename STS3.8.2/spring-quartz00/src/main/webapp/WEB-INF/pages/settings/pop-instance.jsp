<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<style type="text/css">
.dialog {
	top: 0;
	width: 360px;
	border: 1px #666 solid;
	position: absolute;
	display: block;
	z-index: 101;
	width: 360px;
}

.dialog .title {
	background: #333;
	padding: 10px;
	color: #fff;
	font-weight: bold;
}

.dialog .title img {
	float: right;
}

.dialog .content {
	background: #fff;
	padding: 25px;
	height: 60px;
}

.dialog .content img {
	float: left;
}

.dialog .content span {
	float: left;
	padding: 10px;
}

.dialog .bottom {
	text-align: right;
	padding: 10px 10px 10px 0px;
	background: #eee;
}

.dialog .btn {
	border: #666 1px solid;
	width: 65px;
}
</style>

<div class="dialog" id="delallpartdialog">
	<div class="title">
		<img alt="点击可以关闭" src="/static/images/disk.png" width="30px"
			height="30px;"> 删除时提示
	</div>
	<div class="box">
		<dl>
			<dt>作业要求：</dt>
			<dd>
				<ol>
					<li>点击中间按钮，实现左右列表框中元素的左右移动</li>
				</ol>
			</dd>
		</dl>
	</div>
	<div class="box">
		<table style="width: 600px;">
			<tr>
				<td style="width: 250px;"><select id="Select1" name="D1"
					size="4" style="height: 200px; width: 80px;" multiple="multiple">
						<option>选项1</option>
						<option>选项2</option>
						<option>选项3</option>
						<option>选项4</option>
						<option>选项5</option>
						<option>选项6</option>
				</select></td>
				<td style="width: 100px;"><input id="Button1" type="button"
					value=">" /><br /> <input id="Button2" type="button" value=">>" /><br />
					<input id="Button3" type="button" value='left' /><br /> <input
					id="Button4" type="button" value='ll' /></td>
				<td style="width: 250px;"><select id="Select2" name="D2"
					size="4" style="height: 200px; width: 80px;" multiple="multiple">
				</select></td>
			</tr>
		</table>
	</div>
	<div class="bottom">
		<input type="button" value="确定" class="btnok"> <input
			type="button" value="取消" class="btnnoOk">
	</div>
</div>



<script>
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

	$(".delallpart").on("click", function() {
		$.ajax({
			url : "/osd/opt/delallpart",
			type : "POST",
			datatype : 'json',
			data : {
				"action" : "del_all",
				"del_mount" : "2"
			},
			beforeSend : function(xhr, settings) {
				xhr.setRequestHeader("X-CSRFToken", getCookie2('csrftoken'));
			},
			success : function(arg) {
				var div = $("#delallpartdialog");
				div.css("display", "block");
				div.css("left", 500).css("top", 500);
			}
		});
	});
	$(".dialog").on("click", ".btnnoOk", function() {
		alert("not ok");
		$(this).parents(".dialog").css("display", "none");
	});

	$("#delallpartdialog").on("click", ".btnok", function() {
		alert("ok!");
	});
</script>