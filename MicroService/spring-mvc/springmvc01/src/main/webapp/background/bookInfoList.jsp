<%@page import="com.wangwang.entity.BookInfo"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>


<html>
  <head>
    <title>ͼ����Ϣ�б�-�ƹ��������̳�</title>
    <link rel="styleSheet" href="<%=request.getContextPath()%>/background/css/body.css" type="text/css" media="all" />
    
  </head>
  
  <body onload="init()">
    	<%
    		//��pageCountҳ
    		int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
    		//��nowPageҳ
    		int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    		//pageSizeÿҳ��ʾ������
    		int pageSize = Integer.parseInt(request.getAttribute("pageSize").toString());
    		//��������
    		List<BookInfo> books = (List<BookInfo>)request.getAttribute("books");
    	
    	%>
    	<table>
    		<caption>ͼ����Ϣ�б�</caption>
    		<tr>
    			<th>bookId</th>
    			<th>bookName</th>
    			<th>author</th>
    			<th>bookTypeId</th>
    			<th>pbName</th>
    			<th>price</th>
    			<th>ygcPrice</th>
    			<th>pbDate</th>
    			<th>״̬</th>
    			<th>�޸�</th>
    			<th>������</th>
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
    				<td><a href="FindBookInfoByIdServlet?bookId=<%=book.getBookId()%>">�޸�</a></td>
    				<td><a href="DeleteBookInfoServlet?bookId=<%=book.getBookId()%>"
    				title="ɾ����Ϣ"
    				onclick="return isDelete('<%=book.getBookName()%>');"
    				>������</a></td>
    			</tr>
    		<%}%>
    		<tr>
    			<td colspan="1" >
    				<a href="InitBookTypeServlet">����</a>
    			</td>
    			<td colspan="2" >
    				<a id="weishangjia" href="#" onclick="changeStates(1)" style=": ">δ�ϼ� </a> &nbsp;
    				<a id="yishangjia" href="#" onclick="changeStates(2)">���ϼ�</a> &nbsp;
    				<a id="bukeyong" href="#" onclick="changeStates(3)">������</a> &nbsp;
    				<a id="quanbu" href="#" onclick="changeStates(5)">����</a> &nbsp;
    			</td>
    			<td colspan="8" >
    				��<%=pageCount%>ҳ &nbsp;
    				��<%=nowPage%>ҳ &nbsp;
    				<%if(nowPage == 1) {%>
    					��һҳ &nbsp;��һҳ &nbsp;
    				<%} else {%>
    					<a href="#" onclick="gotoNowPage(1, 5)">��һҳ </a> &nbsp;
    					<a href="#" onclick="gotoNowPage(<%=nowPage-1%>, 5)">��һҳ </a> &nbsp;	
    				<%}%>
    				<%if(nowPage == pageCount) {%>
    					��һҳ &nbsp;���ҳ &nbsp;
    				<%} else {%>
    					<a href="#" onclick="gotoNowPage(<%=nowPage+1%>, 5)">��һҳ </a> &nbsp;
    					<a href="#" onclick="gotoNowPage(<%=pageCount %>, 5)">���ҳ </a> &nbsp;
    				<%}%>
    				<select id="selectNowPage" onchange="gotoNowPage(this.value)">
    					<%
    						for(int i = 1; i <= pageCount; i++) {%>
    							<option value="<%=i%>"
    							<%if(i==nowPage){%>
    								selected
    								<%} %>
    							>��<%=i%>ҳ</option>
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
 		return confirm("��ȷ��Ҫɾ��[" + bookName + "]��");
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
