<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="utf-8" %>
<%@ tablib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>list task</title>
</head>

<body>
<a href="${pageContext.request.contextPath}/task/preSave">添加</a>
<table>
  <tr>
    <th scope="col">任务ID</th>
    <th scope="col">任务名</th>
    <th scope="col">最后执行时间</th>
    <th scope="col">是否启用</th>
    <th scope="col">启用删除</th>
    <th scope="col">最后更新时间</th>
    <th scope="col">最后更新人</th>
    <th scope="col">操作</th>
  </tr>
  <c:forEach var="task" items="${taskList}">
    <tr>
      <th scope="row">${task.taskId}</th>
      <td>${task.taskName}</td>
      <td>${task.taskName}</td>
      <td>${task.isEnable}</td>
      <td>${task.isEnableDelete}</td>
      <td>${task.processing}</td>
      <td>${task.lastExcuteTime}</td>
      <td>${task.ext01}</td>
      <td>${task.ext02}</td>
      <td><a href="${pageContext.request.contextPath}/task/preSave.do?id=${task.taskId}">编辑</a></td>
      <td><a href="${pageContext.request.contextPath}/task/delete.do?id=${task.taskId}">删除</a></td>
    </tr>
  </c:forEach>
</table>
</body>
