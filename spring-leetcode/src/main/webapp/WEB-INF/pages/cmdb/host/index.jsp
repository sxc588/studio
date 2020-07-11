<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery实现全选、全不选和反选功能</title>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery点击弹出登陆窗口</title>
<link rel="stylesheet" href="springmvc/pages/cmdb/host/jiaobenzhijia.css" media="all">
<script type="text/javascript">
function show(){  
    document.getElementById("overDiv").style.display = "block" ;  
    document.getElementById("hsDiv").style.display = "block" ;  
}  
function closeDiv(){  
    document.getElementById("overDiv").style.display = "none" ;  
    document.getElementById("hsDiv").style.display = "none" ;  
}  
</script>
</head>
<body>
  <!-- 登陆连接 -->
    <div><a href="javascript:void(0);" onclick="show()">登陆</a></div>
     <!-- 弹出登录表单开始 -->
    <div id="hsDiv" style="display:none;">
        <!-- 右上角关闭按钮 -->
		<div id="closediv">
			<a href="javascript:void(0);" onclick="closeDiv()"><img src="images/logingb.png">
			</a>
		</div>
		<!-- 登陆标题 -->
		<div id="dlTitle">登陆</div>
		<!-- 登陆div -->
		<div id="tbdiv">
			<table id="logintb">
				<tr>
					<td class="logintd1">用户名/Email：</td>
				</tr>
				<tr>
					<td class="logintd2"><input type="text" name="" value="">
					</td>
				</tr>
				<tr>
					<td class="logintd1">密码：</td>
				</tr>
				<tr>
					<td class="logintd2"><input type="password" name="" value="">
					</td>
				</tr>
				<tr>
					<td class="logintd3"><input type="checkbox"> Remember
						Me 记住我 <a href="">忘记密码？</a>
					</td>
				</tr>
				<tr>
					<td class="logintd4"><input type="submit" value="登 陆">
					</td>
				</tr>
			</table>

		</div>
	</div>
	<div id="overDiv" style="display:none;"></div>
  </body>
</html>