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
	src="/springmvc/3rd/jquery-ui-1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="/springmvc/3rd/jsgrid-1.5.3/dist/jsgrid.js"></script>
	

</head>
<body>

	<!-- 调用表格并分页 -->
	<table width="600" height="500" border="0" cellpadding="0"
		cellspacing="0" align="center">
		<tr>
			<td>
				<table id="list1"></table>
				<div id="pager"></div>
			</td>
		</tr>
	</table>

	<script type="text/javascript">
	  $(document).ready(
			  
		       function () {
// 		    		alert("DDD");
		       
	$("#list1").jsGrid(
						{ //jqGrid固定的写法:jQuery("#list").jqGrid({参数})
							datatype : "json", //将这里改为使用JSON数据   
							url : "/springmvc/cmdb/user/json2", //这是Action的请求地址   
							mtype : "GET", //提交类型
							height : 250,//表格高度   
							width : 1000, //表格宽度
							//表格结构定义
							colNames : [ "issueID", "title", "description", "progress",
									"createTime", "locked" ],
						colModel : [ {
							name : 'issueID',
							width : 100,
							index : 'issueID'
						}, {
							name : 'title',
							width : 100,
							index : 'title'
						}, {
							name : 'description',
							width : 300,
							index : 'description'
						}, {
							name : 'progress',
							width : 150,
							index : 'progress'
						}, {
							name : 'createTime',
							width : 100,
							index : 'createTime',
							formatter : 'date',
							sorttype : 'datetime',
							datefmt : 'M d h:i'
						}, {
							name : 'locked',
							width : 100,
							index : 'locked'
						} ],

							jsonReader : {
								root : "rows",
								page : "page",
								total : "total",
								records : "records",
								repeatitems : false
							},
							pager : "#pager", //分页工具栏   
							imgpath : "themes/redmond/images", //图片路径   
							rowNum : 10, //每页显示记录数   
							viewrecords : true, //是否显示行数   
							rowList : [ 10, 20, 30 ], //可调整每页显示的记录数   
							multiselect : false, //是否支持多选   
							sortname : "issueID",//根据哪个字段排序   
							caption : "jqGrid表格测试", //表格标题
							recordtext : "记录 {0} - {1} 总记录数 {2}",//显示记录数的格式
							emptyrecords : "无数据",//空记录时的提示信息
							loadtext : "获取数据中...",//获得数据时的提示信息
							pgtext : "第几页 {0} 总页数 {1}"//页数显示格式
						});
				//定义默认按键的显示 ,refresh刷新按钮是否显示、edit编辑按钮是否显示、add添加按钮是否显示、del删除按钮是否显示、refreshtitle刷新按钮提示信息
// 				$('#list1').navGrid('#nav', {
// 					refresh : true,
// 					edit : true,
// 					add : true,
// 					del : true,
// 					search : true,
// 					refreshtitle : "刷新",
// 					edittitle : "修改",
// 					addtitle : "添加",
// 					deltitle : "删除",
// 					searchtitle : "搜索"
 				});
</script>



</body>
</html>