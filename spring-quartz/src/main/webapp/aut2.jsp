<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>jQuery UI Autocomplete - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
    
    
    
    $("#language").autocomplete({
  	    source: [
  	        "Chinese",
  	        "English",
  	        "Spanish",
  	        "Russian",
  	        "French",
  	        "Japanese",
  	        "Korean",
  	        "German"
  	    ]
  	});
    
    $("#language2").autocomplete({
        // 静态的数据源，根据label属性进行显示或模糊匹配，当给输入框设置value属性值
        source: [
            { label: "Chinese", value: 1 },
            { label: "English", value: 2 },
            { label: "Spanish", value: 3 },
            { label: "Russian", value: 4 },
            { label: "French", value: 5 },
            { label: "Japanese", value: 6 },    
        ]
    });
    
    
    
    $("#language3").autocomplete({
        // 静态的数据源
        source: [
            { label: "Chinese", value: 1, sayHi: "你好" },
            { label: "English", value: 2, sayHi: "Hello" },
            { label: "Spanish", value: 3, sayHi: "Hola" },
            { label: "Russian", value: 4, sayHi: "Привет" },
            { label: "French", value: 5, sayHi: "Bonjour" },
            { label: "Japanese", value: 6, sayHi: "こんにちは" },    
        ],
        select: function(event, ui){
            // 这里的this指向当前输入框的DOM元素
            // event参数是事件对象
            // ui对象只有一个item属性，对应数据源中被选中的对象
            $(this).value = ui.item.label;
            $("#lang_id").val( ui.item.value );
            $("#sayHi").html( ui.item.sayHi );
            
            // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
            event.preventDefault();     
        }
    });
 
  });
  


  
  
  
  </script>
</head>
<body>
<%
String language= request.getParameter("language");
String language2= request.getParameter("language2");


%>
	<form method="post" action="aut2.jsp">
		<div class="ui-widget">
			<label for="tags">Tags: </label> <input id="tags">
		</div>
		<div class="ui-widget">
			<label for="language">请输入指定的语言：</lable> <input id="language"
				name="language" type="text"  value="<%=language%>">
		</div>
				<div class="ui-widget">
			<label for="language2">请输入指定的语言：</lable> <input id="language2"
				name="language2" type="text"  value="<%=language2%>">
		</div>
		<div class="ui-widget">
			<label for="language3">请输入指定的语言：</lable> <input id="language3"
				name="language3" type="text">
		</div>
		<div class="ui-widget">
			<input type="submit" value="提交" id="send" style="margin-left: 70px;" />
			<input type="reset" value="重置" id="res" />
		</div>
	</form>
</body>
</html>