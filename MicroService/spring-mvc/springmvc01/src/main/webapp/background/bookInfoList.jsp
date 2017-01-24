<%@page import="com.wangwang.entity.BookInfo"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>


<html>
  <head>
    <title>图书信息列表-云工厂网上商城</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
    
  </head>
  
  <body onload="init()">
    	<%
    		//共pageCount页
    		int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
    		//第nowPage页
    		int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    		//pageSize每页显示多少条
    		int pageSize = Integer.parseInt(request.getAttribute("pageSize").toString());
    		//具体数据
    		List<BookInfo> books = (List<BookInfo>)request.getAttribute("books");
    	
    	%>
    	<table>
    		<caption>图书信息列表</caption>
    		<tr>
    			<th>bookId</th>
    			<th>bookName</th>
    			<th>author</th>
    			<th>bookTypeId</th>
    			<th>pbName</th>
    			<th>price</th>
    			<th>ygcPrice</th>
    			<th>pbDate</th>
    			<th>状态</th>
    			<th>修改</th>
    			<th>不可用</th>
    		</tr>
    		<%
    		for (BookInfo book: books) {%>
    			<tr onmouseover="this.bgColor='#E6EB00'" onmouseout="this.bgColor='white'">
    				<td><%=book.getBookId()%></td>
    				<td><%=book.getBookName()%></td>
    				<td><%=book.getAuthor()%></td>
    				<td><%=book.getBookTypeId()%></td>
    				<td><%=book.getPbName()%></td>
    				<td><%=book.getPrice()%></td>
    				<td><%=book.getYgcPrice()%></td>
    				<td><%=book.getPbDate()%></td>
    				<td><%=book.getBookStates()%></td>
    				<td><a href="FindBookInfoByIdServlet?bookId=<%=book.getBookId()%>">修改</a></td>
    				<td><a href="DeleteBookInfoServlet?bookId=<%=book.getBookId()%>"
    				title="删除信息"
    				onclick="return isDelete('<%=book.getBookName()%>');"
    				>不可用</a></td>
    			</tr>
    		<%}%>
    		<tr>
    			<td colspan="1" >
    				<a href="InitBookTypeServlet">新增</a>
    			</td>
    			<td colspan="2" >
    				<a id="weishangjia" href="#" onclick="changeStates(1)" style=": ">未上架 </a> &nbsp;
    				<a id="yishangjia" href="#" onclick="changeStates(2)">已上架</a> &nbsp;
    				<a id="bukeyong" href="#" onclick="changeStates(3)">不可用</a> &nbsp;
    				<a id="quanbu" href="#" onclick="changeStates(5)">所有</a> &nbsp;
    			</td>
    			<td colspan="8" >
    				共<%=pageCount%>页 &nbsp;
    				第<%=nowPage%>页 &nbsp;
    				<%if(nowPage == 1) {%>
    					第一页 &nbsp;上一页 &nbsp;
    				<%} else {%>
    					<a href="#" onclick="gotoNowPage(1, 5)">第一页 </a> &nbsp;
    					<a href="#" onclick="gotoNowPage(<%=nowPage-1%>, 5)">上一页 </a> &nbsp;	
    				<%}%>
    				<%if(nowPage == pageCount) {%>
    					下一页 &nbsp;最后页 &nbsp;
    				<%} else {%>
    					<a href="#" onclick="gotoNowPage(<%=nowPage+1%>, 5)">下一页 </a> &nbsp;
    					<a href="#" onclick="gotoNowPage(<%=pageCount %>, 5)">最后页 </a> &nbsp;
    				<%}%>
    				<select id="selectNowPage" onchange="gotoNowPage(this.value)">
    					<%
    						for(int i = 1; i <= pageCount; i++) {%>
    							<option value="<%=i%>"
    							<%if(i==nowPage){%>
    								selected
    								<%} %>
    							>第<%=i%>页</option>
    					<%	} 
    					%>
    					
    				</select>	
    			</td>
    		</tr>
    	</table>
  </body>
 <script type="text/javascript">
 	var states = '<%=request.getAttribute("states")%>';
 	function isDelete(bookName) {
 		return confirm("您确定要删除[" + bookName + "]吗？");
 	}
 	function gotoNowPage(nowPage) {
 		var url = "<%=request.getContextPath()%>/FindAllBookInfoServlet?nowPage="+nowPage+"&states="+states;
 		
 		window.location = url; 	
 	}
 	function changeStates(mystates) {
 		states = mystates;
 		
 		gotoNowPage(1);
 		
 	}
 	function init() {
 		var tag = "quanbu";
 		if(states == '1') {
 			tag = "weishangjia";
 		} else if(states == '2') {
 			tag = "yishangjia";
 		} else if(states == '3') {
 			tag = "bukeyong";
 		}
 		document.getElementById(tag).style.backgroundColor = 'red';
 		document.getElementById("selectNowPage").value = "<%=nowPage%>";
 		
 	}
</script>
</html>
