<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="sf"
uri="http://www.springframework.org/tags/form"%> <%
request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>注册表编辑</title>
<script
	src="<%=request.getContextPath()%>/3rd/My97DatePicker/WdatePicker.js"></script>
<style>
.hse1 {
	color: red
}

.hse2 {
	color: #F00
}

.hse3 {
	color: #FF0000
}
</style>
<body>
	<jsp:include page="../top.header.jsp"></jsp:include>

	<div class="container" role="main">

		<div>
			<jsp:include page="settingsLeft.jsp"></jsp:include>
		</div>
		<div class="container" role="main">

			<div>
				<nobr>
					<div>
						<form method="POST" action="/setting/commonquery2">
							<div class="row">
								<div class="col-md-10">
									<textarea name="sql" STYLE="width: 1000px; height: 100px"
										id="sql" onfocus="ClearDefault(this)" placeholder="输入查询语句"
										onblur="AddDefault(this)">${sql}</textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									<button type='submit' class="btn btn-primary btn-block"
										id="sure">确定</button>
								</div>
								<div class="col-md-2">
									<button id="back" type="reset"
										class="btn btn-primary btn-block">重置</button>
								</div>
								<div class="col-md-2">
									<p id="message" style="height: 28px" align="center"></p>
								</div>
							</div>
						</form>
					</div>
				</nobr>
				<hr style="background-color: #0c0c0c; height: 1px; width: 2000px;">
				<%--引入jqGerid--%>
				<div>
					<table id="jqGrid"></table>
					<div id="jqGridPager"></div>
				</div>

				<content tag="customJavascript"> 
				<script type="text/ecmascript" src="/plugins/jqGrid-master/js/i18n/grid.locale-cn.js"></script>
				<script type="text/ecmascript" src="/plugins/jqGrid-master/js/jquery.jqGrid.js"></script>
				<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
				<script src="/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>

				<script type="text/javascript">

            //加载的主表（对表格进行遍历
            $(document).ready(function () {
               // var applicationId = $('#applicationId option:selected').val();
                $("#jqGrid").jqGrid({
                    url:"/setting/commonquery",
                    mtype: "POST",
                    datatype: "json",
                    postData: {
                        'sql': function () {
                            return $('#sql').val().trim();}
                        },
                    styleUI: 'Bootstrap',
                    colModel: [
                        <c:forEach items="${list3}" var="user" varStatus="status">
                        {label: '${user}', name: '${user}', autowidth: true, sortable: false},
                        </c:forEach>
                    ],
                    viewrecords: true,
                    height: 400,
                    shrinkToFit: false,
                    rowNum: 10,
                    autowidth: true,
                    pager: "#jqGridPager",
                    page: 1
                }).trigger("reloadGrid");
                return false;
                var len = $("#jqGrid").getGridParam("width");
//                $("#jqGrid").setGridParam().hideCol("id");
                $("#jqGrid").setGridWidth(len);
            });
            //点击重置按钮
            $("#back").click(function () {
                $("#sql").empty();
            });
        </script> </content>
			</div>
		</div>
	</div>
	<jsp:include page="<%=request.getContextPath()%>/foot.vm.jsp"></jsp:include>
</body>
</html>