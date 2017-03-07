<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'welcome.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="http://www.huawei.com/favicon.ico" type="image/x-icon" rel="icon" />
<link href="http://www.huawei.com/favicon.ico" type="image/x-icon" rel="shortcut icon" />
<link href="http://www.huawei.com/favicon.ico" type="image/x-icon" rel="Bookmark" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="http://e.huawei.com/Assets/EBG/js/vendor/jquery-1.11.1.min.js?ver=20160226"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('#top').click(function(){
			 $('html,body').animate({scrollTop: 0}, 200);
			 $('#top').css("display", "none");
		  return false;
	    });
	     $(window).scroll(function(){ 
	 		if($(document).scrollTop() != 0){
	 			$('#top').css("display", "block");
	 		} else {
	 			$('#top').css("display", "none");
	 		}
	 	});
	});
</script>

</head>

<body>
	<h1>3.1.1 下拉菜单</h1>

	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div><div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>v<div class="container">
		<div class="btn-group">
			<button class="btn btn-default" type="button">Left</button>
			<button class="btn btn-default" type="button">Middle</button>
			<button class="btn btn-default" type="button">Right</button>
		</div>


		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
				<button class="btn btn-default" type="button">
					<span class="glyphicon-align-left"></span>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn btn-default" type="button">Left</button>
			</div>
		</div>
	</div>
	<div id="product_left_nav" class="product_left_nav pc-show-important hide-not-important" style="">
		<div class="nav_header"></div>
		<ul id="sectionCollection">
			<li class="selectLi current"><a href="#" id="js_section_1" data-section-selector=".js_section_1" class="active"><span
					class="left_nav_icon"></span><span class="center_nav_icon">产品分类</span></a></li>
			<li class="selectLi"><a href="#" id="js_section_2" data-section-selector=".js_section_2" class=""><span
					class="left_nav_icon"></span><span class="center_nav_icon">解决方案</span></a></li>
			<li class="selectLi"><a href="#" id="js_section_3" data-section-selector=".js_section_3" class=""><span
					class="left_nav_icon"></span><span class="center_nav_icon">服务专区</span></a></li>
			<li class="selectLi"><a href="#" id="js_section_4" data-section-selector=".js_section_4" class=""><span
					class="left_nav_icon"></span><span class="center_nav_icon">工具</span></a></li>
			<li class="selectLi"><a href="#" id="js_section_5" data-section-selector=".js_section_5" class=""><span
					class="left_nav_icon"></span><span class="center_nav_icon">联系支持</span></a></li>


		</ul>
		<div class="navfooter"></div>
	</div>
	<div id="top">
		<img src="http://support.huawei.com/enterprise/pages/main/images/transparent.gif"
			style="background: url(http://support.huawei.com/enterprise/pages/doc/images/icon-offering.png);background-position: 0 -260px; width: 60px;height: 60px;z-index: 999;">
	</div>

</body>
</html>
