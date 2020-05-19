<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>第一个jqGrid!</title>
<script type="text/javascript"
	src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="/springmvc/3rd/jsgrid-1.5.3/dist/jsgrid.min.css" />
<link type="text/css" rel="stylesheet"
	href="/springmvc/3rd/jsgrid-1.5.3/dist/jsgrid-theme.min.css" />
<script type="text/javascript"
	src="/springmvc/3rd/jsgrid-1.5.3/dist/jsgrid.min.js"></script>
</head>
<body>


   <script type="text/javascript">
    $(function() {
        $("#daochu").click(function() {

            array = new Array();
            $("input[type='checkbox']:gt(0):checked").each(
            function() {array.push($(this).parent().next().text());});
                    if (array == 0) {
                        alert("请勾选!!");
            } else {
                    location.href = "daochu.action?ids="+ array;
                }
          });
        
        $("#delete").click(function() {

            array = new Array();
            $("input[type='checkbox']:gt(0):checked").each(
            function() {array.push($(this).parent().next().text());});
                    if (array == 0) {
                        alert("请勾选!!");
            } else {
                    location.href = "userAction/deletes.action?ids="+ array;
                }
          });
        
  
            <!-- 让当前表单调用validate方法，实现表单验证功能 -->
            $("#from").validate({
                rules:{
                    username:{
                        required:true, 
                        rangelength:[2,5]
                    },
                    password:{
                        required:true,
                        rangelength:[6,12]
                    }
                },
                messages:{
                    username:{
                        required:"请输入用户名",
                        rangelength:$.validator.format("用户名长度在必须为：{0}-{1}之间"),
                    },
                    password:{
                        required:"请输入密码",
                        rangelength:$.validator.format("字段长度必须为：{0}-{1}之间")
                    }
                }
            });
        });
        
    });
</script>




   <input type="button" value="点击导出" id="daochu">
   <input type="button" value="点击删除" id="deletes">
    <table align="center" border="1">
        <tr>
            <td>请选择</td>
            <td>用户ID</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>生日</td>
            <td>密码</td>
            <td>操作</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${userlist}" var="userlist">
            <tr>
            <td><input type="checkbox"></td>
                <td>${userlist.uid}</td>
                <td>${userlist.username}</td>
                <td>${userlist.age}</td>
                <td>${userlist.sex}</td>
                <td><fmt:formatDate value="${userlist.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${userlist.password}</td>
                <td><a href="./deletebyId.action?uid=${userlist.uid}">删除</a></td>
                <td><a href="selectOneUser.action?uid=${userlist.uid}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>