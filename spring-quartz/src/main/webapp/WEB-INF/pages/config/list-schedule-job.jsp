<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../top.vm.jsp"></jsp:include>
<meta http-equiv="refresh" content="5">
<a href="input2" class="btn btn-success" role="button">添加任务</a>
<a href="export" class="btn btn-success" role="button">导出</a>

<p class="lead">数据库中的任务</p>
<table class="table table-bordered table-margin-top">
    <tr>
        <td>任务分组${scheduleJobVoList.size()}</td>
        <td>任务名称</td>
        <td>任务别名</td>
        <td>触发器</td>
        <td>nextFireTime</td>
        
        <td>previousFireTime</td>
        <td>任务状态</td>
        <td>时间表达式</td>
        <td>是否异步</td>
        <td>任务执行url</td>
        <td>任务描述</td>
        <td>操作</td>
    </tr>
    
    <c:forEach items="${scheduleJobVoList}" var="item" varStatus="id"
				begin="0">
				<tr>
					<td>${item.jobGroup}</td>
					<td>${item.jobName}</td>
					<td>${item.aliasName}</td>
					<td>${item.jobTrigger}</td>
					<td><fmt:formatDate value="${item.nextFireTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
					<td><fmt:formatDate value="${item.previousFireTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
					<td class="status-color">${item.status}</td>
					<td>${item.cronExpression}</td>
					<td>异步</td>
					<td>${item.url}</td>
					<td>${item.description}</td>
					<td>
						<!--<a href="input-schedule-job.shtml?scheduleJobId=${item.scheduleJobId}">修改</a>-->
						<a class="btn btn-danger" role="button"
						href="pause?scheduleJobId=${item.scheduleJobId}"><i
							class="fa fa-pause-circle-o" aria-hidden="true"></i>暂停</a> <a
						class="btn btn-danger" role="button"
						href="resume?scheduleJobId=${item.scheduleJobId}"><i
							class="fa fa-reply" aria-hidden="true"></i>恢复</a> <a
						class="btn btn-danger" role="button"
						href="runonce?scheduleJobId=${item.scheduleJobId}"><i
							class="fa fa-play" aria-hidden="true"></i>运行一次</a> <a
						class="btn btn-danger" role="button"
						href="input?scheduleJobId=${item.scheduleJobId}&keywords=delUpdate"><i
							class="fa fa-pencil" aria-hidden="true"></i>修改</a> <a
						class="btn btn-danger" role="button"
						href="delete?scheduleJobId=${item.scheduleJobId}"><i
							class="fa fa-trash" aria-hidden="true"></i>删除</a>
					</td>
				</tr>
			</c:forEach>
    </table>


<p class="lead">运行中的任务+++</p>
<table class="table table-bordered">
    <tr>
        <td>任务名称</td>
        <td>任务别名</td>
        <td>任务分组</td>
        <td>触发器</td>
        <td>任务状态</td>
        <td>时间表达式</td>
        <td>是否异步</td>
        <td>任务执行url</td>
        <td>任务描述</td>
    </tr>
    
     <c:forEach items="${executingJobList}" var="item" varStatus="id" begin="0">
        <tr>
            <td>${item.jobName}</td>
            <td>${item.aliasName}</td>
            <td>${item.jobGroup}</td>
            <td>${item.jobTrigger}</td>
            <td>${item.status}</td>
            <td>${item.cronExpression}</td>
            <td>${item.isSync}</td>
            <td>${item.url}</td>
            <td>${item.description}</td>
        </tr>
 	</c:forEach>
</table>
<jsp:include page="../foot.vm.jsp"></jsp:include>