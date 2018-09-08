<head>
<title>第一个jqGrid!</title>

  <link id="uiThemes" rel="stylesheet" type="text/css" media="screen" href="styles/themes/redmond/jquery-ui-1.7.2.custom.css" />
  <link rel="stylesheet" type="text/css" media="screen" href="styles/themes/ui.jqgrid.css" />
  
  <!-- 引入jQuery -->
  <script type="text/javascript" src="scripts/jQuery/jquery-1.3.2.js"></script>
  <script src="scripts/jQuery/plugins/jquery-ui-1.7.2.custom.min.js" type="text/javascript"></script>
  <script src="scripts/jQuery/plugins/grid.locale-zh_CN.js" type="text/javascript"></script>
  <script src="scripts/jQuery/plugins/jquery.jqGrid.min.js" type="text/javascript"></script>

 <style>
html, body {   
    margin: 0;   
    padding: 0;   
    font-size: 75%;   
}   

 </style>
<script type="text/javascript">
jQuery(document).ready(
function() {
jQuery("#list1").jqGrid( { //jqGrid固定的写法:jQuery("#list").jqGrid({参数})
datatype : "json", //将这里改为使用JSON数据   
url : "DataServlet", //这是Action的请求地址   
mtype : "get", //提交类型
height : 250,//表格高度   
width : 1000, //表格宽度
//表格结构定义
colNames : [ "编号", "Date", "Client", "Amount",
"Tax", "Total", "Notes" ],
colModel : [ {
name : "id",
index : "id",
width : 60,
sorttype : "int"
}, {
name : "invdate",
index : "invdate",
width : 90,
sorttype : "date"
}, {
name : "name",
index : "name",
width : 100
}, {
name : "amount",
index : "amount",
width : 80,
align : "right",
sorttype : "float"
}, {
name : "tax",
index : "tax",
width : 80,
align : "right",
sorttype : "float"
}, {
name : "total",
index : "total",
width : 80,
align : "right",
sorttype : "float"
}, {
name : "note",
index : "note",
width : 150,
sortable : false
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
sortname : "id",//根据哪个字段排序   
caption : "jqGrid表格测试", //表格标题
recordtext : "记录 {0} - {1} 总记录数 {2}",//显示记录数的格式
emptyrecords : "无数据",//空记录时的提示信息
loadtext : "获取数据中...",//获得数据时的提示信息
pgtext : "第几页 {0} 总页数 {1}"//页数显示格式
});
//定义默认按键的显示 ,refresh刷新按钮是否显示、edit编辑按钮是否显示、add添加按钮是否显示、del删除按钮是否显示、refreshtitle刷新按钮提示信息
$('#list1').navGrid('#nav', {
refresh : true,
edit : true,
add : true,
del : true,
search : true,
refreshtitle : "刷新",
edittitle : "修改",
addtitle : "添加",
deltitle : "删除",
searchtitle : "搜索"
});
});
</script>
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

</body>
</html>
然后是后台java文件：
public class DataServlet extends HttpServlet {

/**
 * 
 */
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,
HttpServletResponse response) throws IOException, ServletException {

 String page="1";
         String rows="1";
         page=request.getParameter("page");
         rows=request.getParameter("rows");
         if(page==null){
        	 page="1";
         }
         if(rows==null){
        	 rows="2";
         }
System.out.println("page: "+page+" rows: "+rows);
int totalRecord = 12; // 总记录数(应根据数据库取得，在此只是模拟)
int totalPage = totalRecord % Integer.parseInt(rows) == 0 ? totalRecord
/ Integer.parseInt(rows) : totalRecord / Integer.parseInt(rows)
+ 1; // 计算总页数
try {
int index = (Integer.parseInt(page) - 1) * Integer.parseInt(rows); // 开始记录数0
int pageSize = Integer.parseInt(rows);//2
// 以下模拟构造JSON数据对象 ,该对象是jqgrid的默认返回对象
String json = "{total: " + totalPage + ", page: " + page
+ ", records: " + totalRecord + ", rows: [";
for (int i = index; i < pageSize + index && i < totalRecord; i++) {
json += "{'id':'" + i + "','invdate':'" + i + "','name':'" + i
+ "','amount':'" + i + "','tax':'" + i + "','total':'" + i
+ "','note':'" + i + "'}";
if (i != pageSize + index - 1 && i != totalRecord - 1) {
json += ",";
}
}
json += "]}";
System.out.println(json);
response.getWriter().write(json); // 将JSON数据返回页面
} catch (Exception ex) {
}
}