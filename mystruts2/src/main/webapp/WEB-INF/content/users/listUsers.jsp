<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="st"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出所有的用户！</title>

<script>
	$(".saveAssPersonnelUser")
			.click(
					function() {
						var org3_ids = $("#org3_ids").val();
						var user_id = $("#user_id").val();
						jQuery
								.ajax({
									type : 'POST',
									dataType : 'json', //设置为json 类型后返回数据不需要 再次转换;
									contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
									url : '${contextPath}/wzoa/associatedpersonnel/save?org3_ids='
											+ org3_ids + '&user_id=' + user_id,
									error : function() {
										alertMsg.error('联系人添加失败！');
									},
									success : function(data) {
										$("#tbody_index_html").html("");
										var tbody_index_html = "";
										for ( var p in data) { //for循环直接遍历数据
											tbody_index_html += "<tr id='personRoleRow_"+data[p].id+"'>";
											tbody_index_html += "<td>"
													+ (parseInt(p) + 1)
													+ "</td>";
											tbody_index_html += "<td>"
													+ data[p].recipient_name
													+ "</td>";
											tbody_index_html += "<td>"
													+ data[p].organization_name
													+ "</td>";
											tbody_index_html += "<td>"
													+ data[p].recipient_dept_name
													+ "</td>";
											tbody_index_html += "<td>"
													+ data[p].post + "</td>";
											tbody_index_html += "<td>"
													+ data[p].posttype
													+ "</td>";
											tbody_index_html += "<td>"
													+ data[p].direct_leadership == '00' ? '否'
													: '是' + "</td>";
											tbody_index_html += "<td>";
											tbody_index_html += "<div class='button'><div class='buttonContent'><button id='submit_"+data[p].id+"' class='assPersonnelUser'>移除</button></div></div>";
											tbody_index_html += "<div class='button' style='margin-left: 10px;'><div class='buttonContent'><button id='update_"+data[p].id+"' class='updateAssPersonnelUser'>设置/取消(直接领导)</button></div></div>";
											tbody_index_html += "</td>";
											tbody_index_html += "</tr>";
										}
										$("#tbody_index_html").html(
												tbody_index_html);
									}
								});
					});
</script>
</head>
<body>






	<h2>当前的用户列表</h2>
	<h2><a href="${pageContent.requert.contextPath}/mystruts2/login/registForm.jsp">注册一个用户</a></h2>
	<table width="600" border="1">
		<tr>
			<th>工号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>体重</th>
			<th>生日</th>
		</tr>
		<st:iterator value="users" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.pass}</td>
				<td>${user.weight}</td>
				<td>${user.birthDay}</td>
			</tr>
		</st:iterator>
	</table>
	
	

	<span id="spanFirst">首页</span>
	<span id="spanPre">上一页</span>
	<span id="spanNext">下一页</span>
	<span id="spanLast">尾页</span> 第
	<span id="spanPageNum"></span>页/共
	<span id="spanTotalPage"></span>页


	<div class="button">
		<div class="buttonContent">
			<button class="saveAssPersonnelUser">保存联系人</button>
		</div>
	</div>
</body>
</html>