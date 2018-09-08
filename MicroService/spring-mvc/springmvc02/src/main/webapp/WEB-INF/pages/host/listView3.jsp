<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>第一个jqGrid!</title>
<script type="text/javascript"
	src="../3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="../3rd/jsgrid-1.5.3/dist/jsgrid.min.css" />
<link type="text/css" rel="stylesheet"
	href="../3rd/jsgrid-1.5.3/dist/jsgrid-theme.min.css" />
<script type="text/javascript"
	src="../3rd/jsgrid-1.5.3/dist/jsgrid.min.js"></script>
</head>
<body>
<!-- https://blog.csdn.net/meng564764406/article/details/52426634 -->
	<div class="htmleaf-container">
		<div class="container kv-main">
			<!-- <div class="page-header">  
           <h2>单张上传 <small></h2>  
           </div> -->
			<form enctype="multipart/form-data" action="upload"  method = "post">
			<input id="fileUpload"  id="file" type="file" name="file"
				multiple data-show-preview="true" />
				
				<input type="submit" value="dddddddddddd " /> 
			</form>
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
           }  
);  
    
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
//            paging: true,  
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
</body>
</html>