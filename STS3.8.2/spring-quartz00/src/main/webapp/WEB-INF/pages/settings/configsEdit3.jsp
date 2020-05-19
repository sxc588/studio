
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<title>测试</title>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>


<style>
.circle {
	width: 20px;
	height: 20px; <!--
	background: #7fee1d; -->
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
}

.red {
	background: red;
}

.yellow {
	background: yellow;
}

.green {
	background: green;
}
</style>
</head>
<body>
	<jsp:include page="../top.vm.jsp"></jsp:include>

	<input type="button" name="request" value="请求后台"
		style="width: 200px; height: 50px; background-color: red; margin-bottom: 20px;">
	<div name="rs"></div>
	<input type="checkbox" name="se" value="1">hafiz.zhang
	<br />
	<input type="checkbox" name="se" value="2">jack.chen
	<br />
	<input type="checkbox" name="se" value="3">lili.wang
	<br />
	<script type="text/javascript">
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
				url : "/springmvc/setting/config2/index",
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
	</script>


	<form action="/springmvc/upload/upload" enctype="multipart/form-data"
		method="post">
		<input type="file" name="file"><br> <br> <input
			type="submit" value="上传">
	</form>



	<form action="/springmvc/upload/uploads" enctype="multipart/form-data"
		method="post">
		<fieldset>
			<legend>主机信息</legend>
			<table>
				<tr>
					<td>机器名</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Ip</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>上联CI</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>下联CI</td>
					<td><input type="text" /></td>
				</tr>

			</table>
			<div class="circle red"></div>
		</fieldset>
		<fieldset>
			<legend>选择文件: </legend>
			<table>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="上传">
	</form>

	<form action="/springmvc/upload/uploads" enctype="multipart/form-data"
		method="post">

		<fieldset>
			<legend>健康信息</legend>
			<table>
				<tr>
					<td>身高:<input type="text" /></td>
				</tr>
				<tr>
					<td>体重：<input type="text" /></td>
				</tr>
			</table>
			<div class="circle red"></div>
		</fieldset>
		<fieldset>
			<legend>选择文件: </legend>
			<table>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
				<tr>
					<td><input type="file" name="files"></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="上传">
	</form>

	<tbody>
		<tr>

			<td><span><span
					class="c-index  c-index-hot1 c-gap-icon-right-small">1</span><a
					target="_blank" title="鲍毓明养女发声"
					href="/s?wd=%E9%B2%8D%E6%AF%93%E6%98%8E%E5%85%BB%E5%A5%B3%E5%8F%91%E5%A3%B0&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_1&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">鲍毓明养女发声</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">483万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span
					class="c-index  c-index-hot2 c-gap-icon-right-small">2</span><a
					target="_blank" title="世卫称新冠病亡率比流感高10倍"
					href="/s?wd=%E4%B8%96%E5%8D%AB%E7%A7%B0%E6%96%B0%E5%86%A0%E7%97%85%E4%BA%A1%E7%8E%87%E6%AF%94%E6%B5%81%E6%84%9F%E9%AB%9810%E5%80%8D&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_2&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">世卫称新冠病亡率比流感高10倍</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">466万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span
					class="c-index  c-index-hot3 c-gap-icon-right-small">3</span><a
					target="_blank" title="打工是不可能打工的当事人将出狱"
					href="/s?wd=%E6%89%93%E5%B7%A5%E6%98%AF%E4%B8%8D%E5%8F%AF%E8%83%BD%E6%89%93%E5%B7%A5%E7%9A%84%E5%BD%93%E4%BA%8B%E4%BA%BA%E5%B0%86%E5%87%BA%E7%8B%B1&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_3&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">打工是不可能打工的当事人将出狱</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">450万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">4</span><a
					target="_blank" title="绥芬河急缺防护服和N95口罩"
					href="/s?wd=%E7%BB%A5%E8%8A%AC%E6%B2%B3%E6%80%A5%E7%BC%BA%E9%98%B2%E6%8A%A4%E6%9C%8D%E5%92%8CN95%E5%8F%A3%E7%BD%A9&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_4&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">绥芬河急缺防护服和N95口罩</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">434万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">5</span><a
					target="_blank" title="江西回应2.5天弹性假不得居家"
					href="/s?wd=%E6%B1%9F%E8%A5%BF%E5%9B%9E%E5%BA%942.5%E5%A4%A9%E5%BC%B9%E6%80%A7%E5%81%87%E4%B8%8D%E5%BE%97%E5%B1%85%E5%AE%B6&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_5&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">江西回应2.5天弹性假不得居家</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">419万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">6</span><a
					target="_blank" title="钟南山称群体免疫行不通"
					href="/s?wd=%E9%92%9F%E5%8D%97%E5%B1%B1%E7%A7%B0%E7%BE%A4%E4%BD%93%E5%85%8D%E7%96%AB%E8%A1%8C%E4%B8%8D%E9%80%9A&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_6&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">钟南山称群体免疫行不通</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">404万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">7</span><a
					target="_blank" title="疫情已扩散至211个国家和地区"
					href="/s?wd=%E7%96%AB%E6%83%85%E5%B7%B2%E6%89%A9%E6%95%A3%E8%87%B3211%E4%B8%AA%E5%9B%BD%E5%AE%B6%E5%92%8C%E5%9C%B0%E5%8C%BA&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_7&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">疫情已扩散至211个国家和地区</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">390万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">8</span><a
					target="_blank" title="武汉正研究扩大核酸检测范围"
					href="/s?wd=%E6%AD%A6%E6%B1%89%E6%AD%A3%E7%A0%94%E7%A9%B6%E6%89%A9%E5%A4%A7%E6%A0%B8%E9%85%B8%E6%A3%80%E6%B5%8B%E8%8C%83%E5%9B%B4&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_8&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">武汉正研究扩大核酸检测范围</a></span><span
				class="c-text c-text-danger c-gap-icon-left-small opr-toplist1-new">新</span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">376万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">9</span><a
					target="_blank" title="五环飙车凯迪拉克车主被公诉"
					href="/s?wd=%E4%BA%94%E7%8E%AF%E9%A3%99%E8%BD%A6%E5%87%AF%E8%BF%AA%E6%8B%89%E5%85%8B%E8%BD%A6%E4%B8%BB%E8%A2%AB%E5%85%AC%E8%AF%89&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_9&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">五环飙车凯迪拉克车主被公诉</a></span><span
				class="c-text c-text-danger c-gap-icon-left-small opr-toplist1-new">新</span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">363万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">10</span><a
					target="_blank" title="高管涉性侵养女案还有多少疑点"
					href="/s?wd=%E9%AB%98%E7%AE%A1%E6%B6%89%E6%80%A7%E4%BE%B5%E5%85%BB%E5%A5%B3%E6%A1%88%E8%BF%98%E6%9C%89%E5%A4%9A%E5%B0%91%E7%96%91%E7%82%B9&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_10&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">高管涉性侵养女案还有多少疑点</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">351万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">11</span><a
					target="_blank" title="海底捞就涨价道歉"
					href="/s?wd=%E6%B5%B7%E5%BA%95%E6%8D%9E%E5%B0%B1%E6%B6%A8%E4%BB%B7%E9%81%93%E6%AD%89&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_11&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">海底捞就涨价道歉</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">338万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">12</span><a
					target="_blank" title="武汉武昌悬赏寻找无症状感染者"
					href="/s?wd=%E6%AD%A6%E6%B1%89%E6%AD%A6%E6%98%8C%E6%82%AC%E8%B5%8F%E5%AF%BB%E6%89%BE%E6%97%A0%E7%97%87%E7%8A%B6%E6%84%9F%E6%9F%93%E8%80%85&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_12&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">武汉武昌悬赏寻找无症状感染者</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">326万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">13</span><a
					target="_blank" title="祁连山千头野牦牛踏雪迁徙"
					href="/s?wd=%E7%A5%81%E8%BF%9E%E5%B1%B1%E5%8D%83%E5%A4%B4%E9%87%8E%E7%89%A6%E7%89%9B%E8%B8%8F%E9%9B%AA%E8%BF%81%E5%BE%99&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_13&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">祁连山千头野牦牛踏雪迁徙</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">315万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">14</span><a
					target="_blank" title="蕾哈娜父亲感染新冠"
					href="/s?wd=%E8%95%BE%E5%93%88%E5%A8%9C%E7%88%B6%E4%BA%B2%E6%84%9F%E6%9F%93%E6%96%B0%E5%86%A0&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_14&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">蕾哈娜父亲感染新冠</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">304万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
		<tr>

			<td><span><span class="c-index  c-gap-icon-right-small">15</span><a
					target="_blank" title="陶喆听淡黄的长裙"
					href="/s?wd=%E9%99%B6%E5%96%86%E5%90%AC%E6%B7%A1%E9%BB%84%E7%9A%84%E9%95%BF%E8%A3%99&amp;rsv_idx=2&amp;tn=baiduhome_pg&amp;ie=utf-8&amp;rsv_cq=form+%E5%88%86%E7%BB%84&amp;rsv_dl=0_right_fyb_pchot_20811_01&amp;rsf=36b6a3a60bb629b04d89fcdf003e8eba_1_15_15&amp;rqid=e28e58de0000fb12"
					class="opr-toplist1-cut">陶喆听淡黄的长裙</a></span></td>
			<td class="opr-toplist1-right opr-toplist1-right-hot">293万<i
				class="opr-toplist1-st c-icon "></i></td>
		</tr>
	</tbody>
	<jsp:include page="<%=request.getContextPath()%>/foot.vm.jsp"></jsp:include>
</body>
</html>