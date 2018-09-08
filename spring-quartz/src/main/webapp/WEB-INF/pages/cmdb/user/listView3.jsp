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
	      $(document).ready(function(){  
				$("#jsGrid").jsGrid({
					url : "/springmvc/cmdb/user/json",
					mtype : 'GET',
					dataType : 'json',
					width : "100%",
					height : "auto",
					inserting : true,
			        pager:"#gridpager",
					editing : true,
					sorting : true,
					paging : true,
					multiselect:true,
					rowNum:true,
					colModel : [ {name : "address",index : "address", width : 60}, 
						{name : "name",index : "name", width : 90},
						{name : "married", index : "married", width : 100},
						{name : "lastUpdateTimeFmt", index : "lastUpdateTimeFmt",width : 80,align : "right"}
					],
					rowNum:30,
					rowList:[30,50,100,500,2000],
					prmNames:{
						page:"pageNum",
						rows:"rowsPerPage"
					},
					jsonReader : {   
						root: function(data)
						{
							return data.rows;
						},
						page: "page",   
						total: "total",   
						records: "records",   
						repeatitems: true
					},
					loadtext:"loading....",
				});
				
	      });
	</script>
</body>
</html>