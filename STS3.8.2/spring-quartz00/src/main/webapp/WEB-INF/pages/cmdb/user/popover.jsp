<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">  
  <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />  
    
    <title>Query MultiSelect（左右选择框）</title> 
    <link href="/springmvc/3rd//bootstrap/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
    
    
    <script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
     <script src="/springmvc/3rd/bootstrap/assets/bootstrap/js/bootstrap.min.js"></script>
    <script>  
    $(function(){  
    	$("[data-toggle='popover']").popover(); 
    });
    </script>  
  </head>  
<body>  
<a href="#" data-toggle="popover" title="Example popover">
    请悬停在我的上面
</a>



<div class="container" style="padding: 100px 50px 10px;" >
    <button type="button" class="btn btn-default" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="left"
            data-content="左侧的 Popover 中的一些内容">
        左侧的 Popover
    </button>
    <button type="button" class="btn btn-primary" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="top"
            data-content="顶部的 Popover 中的一些内容">
        顶部的 Popover
    </button>
    <button type="button" class="btn btn-success" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="bottom"
            data-content="底部的 Popover 中的一些内容">
        底部的 Popover
    </button>
    <button type="button" class="btn btn-warning" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="right"
            data-content="右侧的 Popover 中的一些内容">
        右侧的 Popover
    </button>
</div>

</div>
</body>  
</html>  