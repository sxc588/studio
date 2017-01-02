<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>list task</title>
</head>

<body>
<table>
  <tr>
    <th colspan=2>更新任务</th>
    "src/main/webapp/task/add.jsp" </tr>
  <tr>
    <td>任务ID</td>
    <td><input type="text" name="id" value="${task.taskId}"/></td>
  </tr>
  <tr>
    <td>任务名</td>
    <td><input type="text" name="name" value="${task.taskName}"/></td>
  </tr>
  <tr>
    <td>最后执行时间</td>
    <td><input type="text" name="lastExecuteTime" value="${task.lastExcuteTime}" /></td>
  </tr>
  <tr>
    <td><input type="hidden" name="id" value="${task.taskId}"></td>
    <td><input type="submit" value="提交" /></td>
  </tr>
</table>
</body>
</html>