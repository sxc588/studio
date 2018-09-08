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

	<style>
li {
	list-style: none;
}
</style>

	<input type="checkbox" id="all">
	<input type="button" value="全选" class="btn" id="selectAll">
	<input type="button" value="全不选" class="btn" id="unSelect">
	<input type="button" value="反选" class="btn" id="reverse">
	<input type="button" value="获得选中的所有值" class="btn" id="getValue">
	<input type="button" value="批量导出" onclick="dao()" />
	<input type="button" value="批量删除" id="delete">

	<input type="button" id="test" value="test">
	<table id="jsGrid"></table>
	<div id="pager2"></div>
	<script type="text/javascript">
		$('#test').click(function() {

			//  var mydata={};

			$.ajax({
				url : '/springmvc/json',
				//            data:"[{'name':'1', 'result'':'60''}]",  
				type : 'get',
				cache : false,
				dataType : 'json',
				success : function(json) {
					var item;
					$.each(json, function(i, result) {

					//	console.log(result);

						// //                       item = "<tr><td>" + result['name'] + "</td><td>" + result['result'] + "</td></tr>";  
						// //                       $('.table').append(item);  
					});

					//  mydata  = json;
				}
			});
			
			
			   var clients = [  
			          { "Name": "Otto Clay", "Age": 25, "Country": 1, "Address": "Ap #897-1459 Quam Avenue", "Married": false },  
			          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
			          { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },  
			          { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },
			          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
			          { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },  
			          { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },  
			          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
			          { "Name": "Ramona Benton", "Age": 32, "Country": 3, "Address": "Ap #614-689 Vehicula Street", "Married": false },  
			          { "Name": "Otto Clay", "Age": 25, "Country": 1, "Address": "Ap #897-1459 Quam Avenue", "Married": false },  
			          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
			          { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },  
			          { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },
			          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
			          { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },  
			          { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },  
			          { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },  
			          { "Name": "Ramona Benton", "Age": 32, "Country": 3, "Address": "Ap #614-689 Vehicula Street", "Married": false },  
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
		});
	</script>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>