
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
  <title>五角星评分案例</title> 
  <style> 
    * { 
      padding: 0; 
      margin: 0; 
    } 
    .comment { 
      font-size: 40px; 
      color: teal; 
    } 
    .comment li { 
      float: left; 
    } 
    ul { 
      list-style: none; 
    } 
  </style> 
</head> 
<body> 
<ul class="comment"> 
  <li>☆</li> 
  <li>☆</li> 
  <li>☆</li> 
  <li>☆</li> 
  <li>☆</li> 
</ul> 
  
</head>
<body>


  <div id="starAll">
            <ul class="stars">
                <li class="no" id="1">&nbsp;</li>
                <li class="no" id="2">&nbsp;</li>
                <li class="no" id="3">&nbsp;</li>
                <li class="no" id="4">&nbsp;</li>
                <li class="no" id="5">&nbsp;</li>
            </ul>
        </div>

</body>

<script> 
  $(function () { 
    var wjx_k = "☆"; 
    var wjx_s = "★"; 
    //prevAll获取元素前面的兄弟节点，nextAll获取元素后面的所有兄弟节点 
    //end 方法；返回上一层 
    //siblings 其它的兄弟节点 
    //绑定事件 
    $("li").on("mouseenter", function () { 
      $(this).html(wjx_s).prevAll().html(wjx_s).end().nextAll().html(wjx_k); 
    }).on("click", function () { 
      $(this).addClass("active").siblings().removeClass("active") 
    }); 
    
    $("ul").on("mouseleave", function () { 
      $("li").html(wjx_k); 
      
      $(".active").text(wjx_s).prevAll().text(wjx_s); 
    }) 
  }); 
</script> 
</html>