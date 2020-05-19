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
		var clients = [ {
			"Name" : "Otto Clay",
			"Age" : 25,
			"Country" : 1,
			"Address" : "Ap #897-1459 Quam Avenue",
			"Married" : false
		}, {
			"Name" : "Connor Johnston",
			"Age" : 45,
			"Country" : 2,
			"Address" : "Ap #370-4647 Dis Av.",
			"Married" : true
		}, {
			"Name" : "Lacey Hess",
			"Age" : 29,
			"Country" : 3,
			"Address" : "Ap #365-8835 Integer St.",
			"Married" : false
		}, {
			"Name" : "Timothy Henson",
			"Age" : 56,
			"Country" : 1,
			"Address" : "911-5143 Luctus Ave",
			"Married" : true
		}, {
			"Name" : "Connor Johnston",
			"Age" : 45,
			"Country" : 2,
			"Address" : "Ap #370-4647 Dis Av.",
			"Married" : true
		}, {
			"Name" : "Lacey Hess",
			"Age" : 29,
			"Country" : 3,
			"Address" : "Ap #365-8835 Integer St.",
			"Married" : false
		}, {
			"Name" : "Timothy Henson",
			"Age" : 56,
			"Country" : 1,
			"Address" : "911-5143 Luctus Ave",
			"Married" : true
		}, {
			"Name" : "Connor Johnston",
			"Age" : 45,
			"Country" : 2,
			"Address" : "Ap #370-4647 Dis Av.",
			"Married" : true
		}, {
			"Name" : "Ramona Benton",
			"Age" : 32,
			"Country" : 3,
			"Address" : "Ap #614-689 Vehicula Street",
			"Married" : false
		} ];
		
		

		$.ajax({
			type : 'get',
			dataType : 'json',
			data : {},
			url : "/springmvc/cmdb/user/json",
			success : function(data) {
				$("#jsGrid").jsGrid({
					width : "100%",
					height : "400px",
					inserting : true,
					editing : true,
					sorting : true,
					paging : true,
					data : clients,
					fields : [ {
						name : "Name",
						type : "text",
						width : 150,
						validate : "required"
					}, {
						name : "Age",
						type : "number",
						width : 50
					}, {
						name : "Address",
						type : "text",
						width : 200
					}, {
						name : "Country",
						type : "select",
						items : countries,
						valueField : "Id",
						textField : "Name"
					}, {
						name : "Married",
						type : "checkbox",
						title : "Is Married",
						sorting : false
					}, {
						type : "control"
					} ]
				}).navButtonAdd('#gridpager', {
					caption : "Excel",
					buttonicon : "ui-icon-excel",
					onClickButton : function() {
						alert("导出excel");
					},
					position : "last"
				});
			}
		});

		
	</script>
</body>
</html>