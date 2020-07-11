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
     
     
	<table id="jsGrid"></table>
	<div id="gridpager"></div>
	
	<script type="text/javascript">
	      var countries = [  
	          { Name: "", Id: 0 },  
	          { Name: "United States", Id: 1 },  
	          { Name: "Canada", Id: 2 },  
	          { Name: "United Kingdom", Id: 3 },  
	          { Name: "China", Id: 4 }  
	      ]; 

		$.ajax({
			type : 'get',
			dataType : 'json',
			data : {},
			pager:"#gridpager",  
			url : "json",
			success : function(clients) {
				$("#jsGrid").jsGrid({
					width : "100%",
					height : "auto",
					inserting : false,
					editing : false,
					sorting : false,
					paging : true,
					data : clients.rows,
					pager : "#gridpager", //分页工具栏   
					imgpath : "themes/redmond/images", //图片路径   
					rowNum : 5, //每页显示记录数   
					viewrecords : true, //是否显示行数   
					rowList : [ 10, 20, 30 ], //可调整每页显示的记录数   
					multiselect : true, //是否支持多选   
					sortname : "id",//根据哪个字段排序   
					caption : "jqGrid表格测试", //表格标题
					recordtext : "记录 {0} - {1} 总记录数 {2}",//显示记录数的格式
					emptyrecords : "无数据",//空记录时的提示信息
					loadtext: "获取数据中...",//获得数据时的提示信息
					pgtext: "第几页 {0} 总页数 {1}",//页数显示格式
					rownumbers: true,
			        fields: [
			        	  { name: "name", type: "text", width: 150, validate: "required" },  
			              { name: "age", type: "number", width: 50 },  
			              { name: "address", type: "text", width: 200 },  
			              { name: "country", type: "select", items: countries, valueField: "Id", textField: "Name" },  
			              { name: "married", type: "checkbox", title: "Is Married", sorting: false }, 		
			              { name: 'lastUpdateTimeFmt', index:'lastUpdateTimeFmt',title:"最后更新时间", editable:false,sorting: true },
			              { value:'lastUpdateTimeFmt',title:"最后更新人",  editable:false,sorting: true }
// 			              { type: "control" } 
				]
 				});
			}
			
		
		});
	</script>
</body>
</html>