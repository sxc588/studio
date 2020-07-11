<%@page import="com.github.support.utils.PtResoult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.github.support.utils.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评论回复页面</title>
<meta charset="utf-8" />
<style>
#tb {
	width: 200px;
	border: 2px solid black;
}


.comments {  
 width:90%;/*自动适应父布局宽度*/
 height:500px;
 overflow:auto;  
 word-break:break-all;  
/*在ie中解决断行问题(防止自动变为在一行显示，主要解决ie兼容问题，ie8中当设宽度为100%时，文本域类容超过一行时，  
当我们双击文本内容就会自动变为一行显示，所以只能用ie的专有断行属性“word-break或word-wrap”控制其断行)*/  
} 
</style>
<script>
	//文档就绪函数
	$(function() {
		//按钮点击事件
		$("#btn1").click(
				function() {
					var message = $("<tr><td>" + $("#name").val() + "</td><td>"
							+ $("#txt").val() + "</td></tr>");
					$("#tb").append(message);
				});
	});
</script>
</head>
<body>
		<!--评论表格-->
		<table id="tb" rules="all">
				<tr>
						<td>姓名：</td>
						<td>评论：</td>
				</tr>
		</table>
		<!--写回复区-->
		<div>
				<div>
						<div>用户名：</div>
						<div>
								<input id="name" type="text" />
						</div>
				</div>
				<div>
						<div>评论：</div>
						<div>
								<textarea  class="comments" id="txt" cols="20" rows="2" placeholder="你忍心看到人家排到队尾吗，求你啦"
  minlength="10" maxlength="200"></textarea>
						</div>
				</div>
		</div>
		<!--提交按钮-->
		<input id="btn1" type="button" value="提交" />
</body>
</html>