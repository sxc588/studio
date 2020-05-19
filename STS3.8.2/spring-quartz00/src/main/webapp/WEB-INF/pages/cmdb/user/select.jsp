<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery实现全选、全不选和反选功能</title>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script type="text/javascript">  
              $(function() {  
                  $("#selectAll").click(function(){  
                      $("#checkBoxList :checkbox").attr("checked", true);  
                  });  
                  $("#unSelect").click(function(){  
                      $("#checkBoxList :checkbox").attr("checked", false);  
                  });  
                  $("#reverseSelect").click(function(){  
                      $("#checkBoxList :checkbox").each(function(){  
                          $(this).attr("checked", !$(this).attr("checked"));  
                      });  
                  });  
              });  
</script>
</head>
<body>
<h1>JQuery实现全选、全不选和反选功能</h1>
	<div id="checkBoxList">
		<input type="checkbox" value="项羽" />项羽<br> <input type="checkbox"
			value="范增" />范增<br> <input type="checkbox" value="龙且" />龙且<br>
		<input type="checkbox" value="刘邦" />刘邦<br> <input type="checkbox"
			value="萧何" />萧何<br> <input type="checkbox" value="韩信" />韩信<br>
	</div>
	<input type="checkbox" value="全选" id="selectAll" />全选
	<input type="checkbox" value="全不选" id="unSelect" />全不选
	<input type="checkbox" value="反选" id="reverseSelect" />反选
</body>
</html>
