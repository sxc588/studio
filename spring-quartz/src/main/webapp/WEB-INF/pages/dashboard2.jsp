<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>基于Quartz的分布式定时任务</title>
<jsp:include page="top_header.jsp"></jsp:include>

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

 <div class="container">
 
 
	<!-- 	<div> -->
	<%-- 		<jsp:include page="top_navi.jsp"></jsp:include> --%>
	<!-- 		<br> -->
	<!-- 		<br> -->
	<!-- 	</div> -->

	<div class="container1">
		<div class="row">
			<div class="span8">
				<ul class="breadcrumb">
					<li><a href="#">Home</a> <span class="divider">></span></li>
					<li><a href="#">Tutorials</a> <span class="divider">></span></li>
					<li class="active">HTML5</li>
				</ul>
			</div>
		</div>

		<div id="leftDiv">
			<ul>
				<li><a href="options/boolean-options.html">Boolean options</a></li>
				<li><a href="options/from-html.html">From html</a></li>
				<li><a href="options/from-data.html">From data</a></li>
			</ul>
		</div>

		<div id="rightDiv">
			<a href="input-schedule-job" class="btn btn-success" role="button">添加任务</a>
			<a href="input-schedule-job" class="btn btn-success" role="button">批量暂停</a>
			<a href="input-schedule-job" class="btn btn-success" role="button">批量恢复</a>
			<a href="input-schedule-job" class="btn btn-success" role="button">批量执行一次</a>
			<a href="input-schedule-job" class="btn btn-success" role="button">批量删除</a>
			<table class="table table-bordered table-margin-top">
				<tr>
					<td>监控名称</td>
					<td>监控描述</td>
					<td>责任人</td>
					<td>触发器</td>
					<td>任务状态</td>
					<td>时间表达式</td>
					<td>是否异步</td>
					<td>任务执行url</td>
					<td>任务描述</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${scheduleJobVoList}" var="item" varStatus="id"
					begin="1">
					<tr>
						<td>${item.jobName}</td>
						<td>${item.aliasName}</td>
						<td>${item.jobGroup}</td>
<%-- 						<td><fmt:formatDate value="${item.trigger.nextFireTime}" --%>
<%-- 								pattern="yyyy-MM-dd HH:mm:ss SSS" /></td> --%>

						<c:choose>
							<c:when test="${item.status == 'PAUSED'}">
								<td class="status-color">${item.status}</td>
							</c:when>
							<c:otherwise>
								<td>${item.status}</td>
							</c:otherwise>
						</c:choose>

						<td>${item.cronExpression}</td>

						<td><c:choose>
								<c:when test="${item.isSync}">异步</c:when>
								<c:otherwise>同步</c:otherwise>
							</c:choose></td>
						<td>${item.url}</td>
						<td>${item.description}</td>
						<td>
							<!--<a href="input-schedule-job.shtml?scheduleJobId=$!{item.scheduleJobId}">修改</a>-->
							<a class="btn btn-danger" role="button"
							href="pause-schedule-job?scheduleJobId=${item.scheduleJobId}"><i
								class="fa fa-pause-circle-o" aria-hidden="true"></i>暂停</a> <a
							class="btn btn-danger" role="button"
							href="resume-schedule-job?scheduleJobId=${item.scheduleJobId}"><i
								class="fa fa-reply" aria-hidden="true"></i>恢复</a> <a
							class="btn btn-danger" role="button"
							href="run-once-schedule-job?scheduleJobId=${item.scheduleJobId}"><i
								class="fa fa-play" aria-hidden="true"></i>运行一次</a> <a
							class="btn btn-danger" role="button"
							href="input-schedule-job?scheduleJobId=${item.scheduleJobId}&keywords=delUpdate"><i
								class="fa fa-pencil" aria-hidden="true"></i>修改</a> <a
							class="btn btn-danger" role="button"
							href="delete-schedule-job?scheduleJobId=${item.scheduleJobId}"><i
								class="fa fa-trash" aria-hidden="true"></i>删除</a> <a
							class="btn btn-danger" role="button"
							href="delete-schedule-job?scheduleJobId=${item.scheduleJobId}"><i
								class="fa fa-trash" aria-hidden="true"></i>复制</a>

						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
	
	
	
	
	
	
	
	
	
	
	
	<script>  
    $("#fileUpload").fileinput({  
        language : "zh",//设置语言  
        uploadUrl: "${pageContext.request.contextPath}/fileUpload/UploadServlet",//上传地址  
        uploadAsync: true,//同步还是异步  
        showCaption:false,//是否显示标题  
        showUpload: true,//是否显示上传按钮  
        browseClass: "btn btn-primary", //按钮样式   
        allowedFileExtensions : ['jpg', 'png','gif','xls'],//接收的文件后缀  
        allowedFileTypes: ['image', 'video', 'flash','excel'],//接收的文件类型['image', 'html', 'text', 'video', 'audio', 'flash','object']  
        maxFileCount: 6,//最大上传文件数限制  
        overwriteInitial: false,  
        maxFileSize: 1000,   
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",  
        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',   
        enctype: 'multipart/form-data',  
        /* allowedPreviewTypes: null, */  
        previewFileIconSettings: {  
               'docx': '<i class="glyphicon glyphicon-file"></i>',  
               'xlsx': '<i class="glyphicon glyphicon-file"></i>',  
               'pptx': '<i class="glyphicon glyphicon-file"></i>',  
               'jpg': '<i class="glyphicon glyphicon-picture"></i>',  
               'pdf': '<i class="glyphicon glyphicon-file"></i>',  
               'zip': '<i class="glyphicon glyphicon-file"></i>'  
           });
    </script>

	<table id="jsGrid"></table>
	<div id="gridpager"></div>
	<script>  
      var clients = [  
          { "Name": "Otto Clay", "Age": 25, "Country": 1, "Address": "Ap #897-1459 Quam Avenue", "Married": false },  
          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
          { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },  
          { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },
          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
          { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },  
          { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },  
          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
          { "Name": "Ramona Benton", "Age": 32, "Country": 3, "Address": "Ap #614-689 Vehicula Street", "Married": false }  
      ];  
  
      var countries = [  
          { Name: "", Id: 0 },  
          { Name: "United States", Id: 1 },  
          { Name: "Canada", Id: 2 },  
          { Name: "United Kingdom", Id: 3 },  
          { Name: "China", Id: 4 }  
      ];  
  
      $("#jsGrid").jsGrid({
    	  
          width: "100%",  
          height: "400px",  
           inserting: true,  
           editing: true,  
           sorting: true,  
            paging: true,  
          data: clients,
          fields: [
        	  { name: "Name", type: "text", width: 150, validate: "required" },  
              { name: "Age", type: "number", width: 50 },  
              { name: "Address", type: "text", width: 200 },  
              { name: "Country", type: "select", items: countries, valueField: "Id", textField: "Name" },  
              { name: "Married", type: "checkbox", title: "Is Married", sorting: false },  
              { type: "control" }  
          ]  
      }).navButtonAdd('#gridpager',{
    	  caption:"Excel", 
    	  buttonicon:"ui-icon-excel", 
    	  onClickButton: function()
    	  {
    		  alert("导出excel"); 
    	 },
    	 position:"last" 
    	 });
      </script>
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
      });
      </script>
    
	
	

	<jsp:include page="foot.jsp"></jsp:include>
 
 </div>


</body>
</html>