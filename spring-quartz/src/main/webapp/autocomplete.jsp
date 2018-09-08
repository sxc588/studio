<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/3rd/autocomplete/0.3.0/autocomplete-0.3.0.min.css"/>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/3rd/autocomplete/0.3.0/autocomplete-0.3.0.js"></script>

    <script type="text/javascript">
    $(function(){
        var data = "the People's Republic of China".split(" ");
        
        $("#autocomplete").autocomplete(data,{minChars:0}).result(function(event,data,formatted){
            alert(data);
        });
    });

    </script>
  </head>
  <body>
    <input type="text" id="autocomplete"/>
  </body>
</html>