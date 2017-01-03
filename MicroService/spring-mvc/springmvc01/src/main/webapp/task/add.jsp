l 39o<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
    <th colspan=2>任务添加</th>
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