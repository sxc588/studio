<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

    <head>
        <title>用户注册</title>
    </head>

    <body style="text-align: center;">
    https://www.cnblogs.com/xdp-gacl/p/3902537.html
        <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
            <table width="60%" border="1">
                <tr>
                    <td>用户名</td>
                    <td>
                        
                        <input type="text" name="userName">
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" name="userPwd">
                    </td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td>
                        <input type="password" name="confirmPwd">
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                        <input type="text" name="email">
                    </td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td>
                        <input type="text" name="birthday">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" value="清空">
                    </td>
                    <td>
                        <input type="submit" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>