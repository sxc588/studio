<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>jQueryStudy</title>
    <style>
     .int{ height: 30px; text-align: left; width: 600px; }
     label{ width: 200px; margin-left: 20px; }
     .high{ color: red; }
     .msg{ font-size: 13px; }
     .onError{ color: red; }
     .onSuccess{ color: green; }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="webapp/jqvalidate.js"></script>    

    </script>
</head>
<body>
    <form method="post" action="#">
        <div class="int">
            <label for="name">姓名：</label>
            <input type="text" id="name" class="required" />
        </div>
        <div class="int">
            <label for="email">邮箱：</label>
            <input type="text" id="email" class="required" />
        </div>
        <div class="int">
            <label for="address">住址：</label>
            <input type="text" id="address" />
        </div>
        <div class="int">
            <input type="submit" value="提交" id="send" style="margin-left: 70px;" />
            <input type="reset" value="重置" id="res" />
        </div>
    </form>    
</body>
</html>