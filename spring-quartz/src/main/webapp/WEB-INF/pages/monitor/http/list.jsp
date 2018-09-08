<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>第一个jqGrid!</title>
<meta http-equiv="refresh" content="50">
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
	<jsp:include page='../../top.vm.jsp'></jsp:include>

	<table id="jsGrid"></table>
	<div id="gridpager"></div>

	<script type="text/javascript">
		$("#jsGrid").jqGrid(
				{
					url : 'search',
					datatype : "json",
					colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
							'Total', 'Notes' ],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55
					}, {
						name : 'invdate',
						index : 'invdate',
						width : 90
					}, {
						name : 'name',
						index : 'name asc, invdate',
						width : 100
					}, {
						name : 'amount',
						index : 'amount',
						width : 80,
						align : "right"
					}, {
						name : 'tax',
						index : 'tax',
						width : 80,
						align : "right"
					}, {
						name : 'total',
						index : 'total',
						width : 80,
						align : "right"
					}, {
						name : 'note',
						index : 'note',
						width : 150,
						sortable : false
					} ],

					jsonReader : {
						root : "rows", // json中代表实际模型数据的入口
						page : "pgSize", // json中代表当前页码的数据
						total : "pgIdex", // json中代表页码总数的数据
						records : "records", // json中代表数据行总数的数据
						repeatitems : true, // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
						cell : "cell",
						id : "id",
						userdata : "data",
						subgrid : {
							root : "rows",
							repeatitems : true,
							cell : "cell"
						}
					},
					rowNum : 10,
					rowList : [ 10, 20, 30 ],
					pager : '#gridpager',
					sortname : 'id',
					viewrecords : true,
					sortorder : "desc",
					caption : "JSON Example"
				});
		jQuery("#jsGrid").jqGrid('navGrid', '#gridpager', {
			edit : false,
			add : false,
			del : false
		});

		// 		jQuery("#jsGrid").jqGrid('navGrid','#gridpager',{edit:false,add:false,del:false
	</script>
</body>
</html>