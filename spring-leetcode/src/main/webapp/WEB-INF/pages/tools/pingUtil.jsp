<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<title>测试</title>

<jsp:include page="../top.header.jsp"></jsp:include>
</head>
<body onload="myFunction">
	<jsp:include page="../top.body.jsp"></jsp:include>
	<div class="icon_favApp">
		<img class="appImg img-responsive"
			src="//support.huawei.com/enterpriseindex/images/icon_app.png"></img>
	</div>
	
<div class="mt10"> <img id="headimg5" alt="" loading="lazy"  height="200" width="200"  class="img-responsive center-block" src="/springmvc/group_nav_support.jpg">
	                <p>在线技术支持、软件下载、文档共享，无论您遇到任何问题，我们都将随时为您提供服务。</p>
	              </div>
	
	
	
	
	<div class="container">
		<table id="thisTable" border=1 width=100%>
			<caption>
				<input type="button" name="request2"
					value="册表列表(${hostList.size()})"
					style="width: 200px; height: 50px; background-color: red; margin-bottom: 20px; fontsize: 10; color: yellow; border-radius: 25px;">
			</caption>
			<thead>
				<tr>
					<th width=8%>序号</th>
					<th width=15%>主机名称</th>
					<th width=10%>IP地址</th>
					<th width=10%>联通状态</th>
					<th>最后更新人</th>
					<th>最后更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${hostList}" var="item" varStatus="id">
					<tr>
						<td><input id=${item.hostName } type="checkbox" name='se'
							value=${item.hostName } />${id.index+1}</td>
						<td>${item.hostName}</td>
						<td>${item.ipAddress}</td>
						<td align="center" title=${item.status}><div
								class="circle green"></div></td>
						<td>${item.lastUpdateBy}</td>
						<td><fmt:formatDate value="${item.lastUpdateTime}"
								pattern="yyyy-MM-dd HH:mm:ss.SSS" /></td>
						<td><a class="btn-sm btn-danger" role="button"
							href="edit?copy=${item.hostName}"><i
								class="fa fa-pause-circle-o" aria-hidden="true"></i>复制</a> <a
							class="btn-sm btn-danger" role="button"
							href="edit?modify=${item.hostName}"><i class="fa fa-reply"
								aria-hidden="true"></i>编辑</a> <a class="btn-sm btn-danger"
							role="button" href="remove?config=${item.hostName}"><i
								class="fa fa-reply" aria-hidden="true"></i>删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>序号</th>
					<th>主机名称</th>
					<th>IP地址</th>
					<th>联通状态</th>
					<th>最后更新人</th>
					<th>最后更新时间</th>
					<th>操作</th>
				</tr>
			</tfoot>
		</table>

		<div>
			<input type="checkbox" name="checkboxAll" onclick="SelectAll(this)">
			<button onclick="BatchAddToBasket()">加入试题篮</button>
		</div>


		<input type="button" name="request" value="请求后台"
			style="width: 200px; height: 50px; background-color: red; margin-bottom: 20px;">


  <img src="<c:url value='/download/img'/>"  border="1"/><br/>


		<div name="rs"></div>
	</div>
	<span>热点话题</span>
	<em class="iconfont icon-right"></em>
	<dl>
		<dd>计算机</dd>
		<dd>用来计算的仪器 ... ...</dd>
		<dt>显示器</dt>
		<dd>以视觉方式显示信息的装置 ... ...</dd>
	</dl>

	<ol type="C">
		<li>计算机</li>
		<li>用来计算的仪器 ... ...</li>
		<li>显示器</li>
		<li>以视觉方式显示信息的装置 ... ...</li>
	</ol>





	<script type="text/javascript">
		function addAsyncJs(url) {
			var gt = document.createElement('script')
			gt.type = 'text/javascript';
			gt.async = true;
			gt.src = url;
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(gt, s);
			return gt;
		}

		function myFunction() {
			addAsyncJs('/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js');

			$("input[name='request2' ]").click(function() {
				var thisTable = $("#thisTable");
				var tr = $("#thisTable tr");
				var td_1 = tr.find("td:eq(1)");
				td_1.each(function() {
					console.log($(this).text());
					if ($(this).text() != "127.0.0.1") {
						$(this).text("127.0.0.1");
					} else {
						$(this).text("192.168.1.1");
					}

				});
			});

			$("input[name='request']").click(function() {
				var data = [];
				$("input[name='se']").each(function() {
					if ($(this).prop("checked")) {
						data.push($(this).val());
					}
				});
				var json_data = JSON.stringify(data);

				$.ajax({
					type : "post",
					url : "/springmvc/tools/net/ping",
					contentType : "application/json",
					data : json_data,
					dataType : "json",
					success : function(data) {
						var str = "";
						for (var i = 0; i < data.length; i++) {
							str += ";name=" + data[i];
						}
						$("div[name='rs']").html(str);
					},
					error : function() {
						alert("出错啦");
					}
				});
			});

		};

		function BatchAddToBasket() {
			var questionNums = '';
			var checkboxs = document.getElementsByName('se');
			for (var i = 0; i < checkboxs.length; i++) {
				var isChecked = false;
				if (checkboxs[i].checked) {
					isChecked = true;
					break;
				}
			}
			if (!isChecked) {
				alert('请至少选择一个选项');
				return;
			}

			for (var i = 0; i < checkboxs.length; i++) {
				if (checkboxs[i].checked) {
					questionNums += checkboxs[i].id;
					if (i < checkboxs.length - 1)
						questionNums += ',';
				}
			}
			//         alert('选项id：' + questionNums);

			$("div[name='rs']").html('选项id：' + questionNums);
		}

		function SelectAll(obj) {
			if (obj.checked) {
				var checkboxs = document.getElementsByName('se');
				for (var i = 0; i < checkboxs.length; i++) {
					checkboxs[i].checked = true;
				}
			} else {
				var checkboxs = document.getElementsByName('se');
				for (var i = 0; i < checkboxs.length; i++) {
					checkboxs[i].checked = false;
				}
			}
		}
	</script>
	
	
	<script type="text/javascript">
    function ScriptLoader() {
        function b(d) {
            return function (f, g) {
                var e = c(d, f, g);
                window.addEventListener("load", function () {
                    document.getElementsByTagName("head")[0].appendChild(e)
                })
            }
        }

        function a(d) {
            return function (f, g) {
                var e = c(d, f, g);
                document.getElementsByTagName("head")[0].appendChild(e)
            }
        }

        function c(e, f, g) {
            var d = document.createElement("script");
            d.type = "text/javascript";
            d.async = e;
            d.src = f;
            if (typeof g == "function") {
                d.addEventListener("load", g)
            }
            return d
        }

        this.later = {async: b(true), sync: b(false)};
        this.now = {async: a(true), sync: a(false)}
    }

    var scriptLoader = new ScriptLoader();

    scriptLoader.later.sync("//support.huawei.com/carrierindex/common/js/utils/pubUtils.js?v=V900R002C00-202004182103");
    scriptLoader.later.sync("//support.huawei.com/carrierindex/pages/index/js/jquery.fly.min.js?v=V900R002C00-202004182103");
    scriptLoader.later.sync("//support.huawei.com/resource/3rdparty/bootstrap/3.4.1/js/bootstrap.min.js");
    scriptLoader.later.sync("//support.huawei.com/carrierindex/3rdParty/opensource/jquery-ui/1.12.1/jquery-ui.js");
    scriptLoader.later.sync("//support.huawei.com/resource/3rdparty/jquery-blockui/2.70/jquery.blockUI.js");
    scriptLoader.later.sync("//support.huawei.com/resource/3rdparty/jquery-bbq/1.3pre/jquery.ba-bbq.min.js");
    scriptLoader.later.sync("//support.huawei.com/carrierindex/3rdParty/opensource/autocomplete/jquery.autocomplete.js?v=V900R002C00-202004182103");
    scriptLoader.later.sync("//support.huawei.com/carrierindex/pages/layout/js/layoutRight_new.js?v=V900R002C00-202004182103");
    scriptLoader.later.sync("//support.huawei.com/carrierindex/common/js/socialShare.js?v=V900R002C00-202004182103");
    scriptLoader.later.sync("//support.huawei.com/carrierindex/pages/navigation/js/navi_search.js?v=V900R002C00-202004182103");
//     scriptLoader.later.sync("//support.huawei.com/carrierindex/pages/index/js/index.js?v=V900R002C00-202004182103");
//     scriptLoader.later.sync("//support.huawei.com/carrierindex/pages/index/js/header.js?v=V900R002C00-202004182103");
//     scriptLoader.later.sync("//support.huawei.com/carriermysupport/pages/customizenav/js/customizenav.js?v=V900R002C00-202004182103");
</script>
	
	<jsp:include page="../foot.vm.jsp"></jsp:include>
</body>
</html>