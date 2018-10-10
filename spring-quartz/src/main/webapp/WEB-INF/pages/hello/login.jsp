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
<title>用户登录</title>
<script src="<%=request.getContextPath()%>/3rd/My97DatePicker/WdatePicker.js"></script>
<body>
	<sf:form modelAttribute="user" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><sf:input path="username" /></td>
				<td><sf:errors path="username" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><sf:input path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>
			<tr>
				<td>昵称:</td>
				<td><sf:input path="nickname" /></td>
				<td><sf:errors path="nickname" /></td>
			</tr>
			<tr>
				<td>产品:</td>
				<td><select>
						<option value="volvo">Volvo</option>
						<option value="saab">Saab</option>
						<option value="opel">Opel</option>
						<option value="audi">Audi</option>
				</select></td>
			<tr>


				<td>昵称:</td>
				<td>
					<p>
						<input type="checkbox" name="vehicle" value="Bike" /> I have a
						bike
					</p>
				</td>
				<td><p>
						<input type="checkbox" name="vehicle" value="Car"
							checked="checked" /> I have a car
					</p></td>
			</tr>



			<td><sf:errors path="password" /></td>
			</tr>


			<tr>
				<td colspan=3><input type="submit" value="提交"></td>
			</tr>
		</table>
	</sf:form>


	<script type="text/javascript"
		src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//实现全选与反选
			$("#allAndNotAll").click(function() {
				if (this.checked) {
					$("input[name='items']:checkbox").each(function() {
						$(this).attr("checked", true);
					});
				} else {
					$("input[name='items']:checkbox").each(function() {
						$(this).attr("checked", false);
					});
				}
			});

			//获取被选中的id
			var ids = [];
			$('#getAllSelectedId').click(function() {
				ids.length = 0;
				$("input[name='items']:checked").each(function() {
					ids.push($(this).attr("id"));
				});

				var delIds = ids.join(",");
				console.log(delIds);

				alert(ids);

				//可以将delIds通过jquery ajax传到后台了,在后台采用String接收这个delIds参数,然后采用split(",")分隔得到一个
				//String[]的id数组。可以参考我的博客：http://blog.csdn.net/u013871100/article/details/52740061

			});
		});
	</script>


	<input type="checkbox" id="allAndNotAll" />全选/反选
	<input type="button" id="getAllSelectedId" value="获取被选中的id" />
	<br>
	<fieldset style="width: 230px">
		<legend>员工列表:</legend>
		<input type="checkbox" name=items id="001" />刘德华 <br> <input
			type="checkbox" name=items id="002" />张学友 <br> <input
			type="checkbox" name=items id="003" />黎明 <br> <input
			type="checkbox" name=items id="004" />郭富城 <br>
	</fieldset>

	<div>

		<div style="float: left">
			<fieldset style="width: 230px">
				<legend>产品：</legend>
				<input type="radio" name=feature id="001" />Support v8 <br> <input
					type="radio" name=feature id="002" />Supppor-E v2 <br> <input
					type="radio" name=feature id="003" />DFX <br> <input
					type="radio" name=feature id="004" />PlatForm <br>
			</fieldset>
		</div>
		<div style="float: left">
			<fieldset style="width: 230px">
				<legend>特性:</legend>
				<input type="radio" name=feature id="001" />Support v8 <br> <input
					type="radio" name=feature id="002" />Supppor-E v2 <br> <input
					type="radio" name=feature id="003" />DFX <br> <input
					type="radio" name=feature id="004" />PlatForm <br>
			</fieldset>
		</div>
		<div style="float: left">
			<fieldset style="width: 230px">
				<legend>应用:</legend>
				<input type="radio" name=feature id="001" />应用一 <br> <input
					type="radio" name=feature id="002" />应用二<br> <input
					type="radio" name=feature id="003" />引用三 <br> <input
					type="radio" name=feature id="004" />应用四<br>
			</fieldset>

		</div>
		<div></div>

		<div>
			<fieldset style="width: 230px">
				<legend>告警通知群组:</legend>
				<input type="checkbox" name=items id="001" />刘德华 <br> <input
					type="checkbox" name=items id="002" />张学友 <br> <input
					type="checkbox" name=items id="003" />黎明 <br> <input
					type="checkbox" name=items id="004" />郭富城 <br>
			</fieldset>
		</div>



		<div id=win
			style="display: none; POSITION: absolute; left: 50%; top: 50%; width: 600px; height: 400px; margin-left: -300px; margin-top: -200px; border: 1px solid #888; background-color: #edf; text-align: center">
			这是DIV登录框示例<br> <a href="javascript:closeLogin();">关闭登录框</a>
		</div>
		<script>
			function openLogin() {
				document.getElementById("win").style.display = "";
			}
			function closeLogin() {
				document.getElementById("win").style.display = "none";
			}
		</script>


		<a href="javascript:openLogin();">打开登录框</a>


		</script>


		<input type="date" value="2015-09-24" />



<!-- 		<span id="demospan ">2008-01-01</span> <img -->
<!-- 			onClick="WdatePicker({el: 'demospan' })" -->
<%-- 			src="<%=request.getContextPath()%>/3rd/My97DatePicker/skin/datePicker.gif" --%>
<!-- 			width="16" height="22" align="absmiddle" style="cursor: pointer" /> -->
</body>
</html>