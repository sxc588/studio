<%@page import="com.github.support.utils.PtResoult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.github.support.utils.*"%>
<!doctype html>
<html>
<head>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<title>java jsp struts2 用户满意度评价模块</title>
<style>
</style>
</head>
<body>
		<script type="text/javascript">
			function changColor(num) {
				var obj = document.getElementByIdx_x(num);
				$("#" + num).css("color", "red");
				for (var i = 5; i > -1; i--) {
					if (i == num)
						continue;
					else {
						$("#" + i).css("color", "#666");
					}
				}
			}
		</script>
		<form method="post" action="consult_upSatisfaction.action">
				<input type="hidden" value="${title}" name="title">
				<div align="left" style="margin-top: 20px;">
						<h5>请您选择满意度:</h5>
						<table>
								<tr>
										<td><span style="font-weight: bold; color: #666;"><input type="radio" name="radio" value="5" onClick="changColor(5)" />非常满意:</span>
										</td>
										<td><span id="5" style="font-size: 15px; font-weight: bold; color: #666;"> ☆&nbsp; ☆&nbsp; ☆ &nbsp;☆ &nbsp;☆</span>
												<div id="divcontent" style="display: inline"></div></td>
										<td><span style="font-weight: bold; color: #666;"><input type="radio" name="radio" value="4" onClick="changColor(4)" />很满意:</span>
										</td>
										<td><span id="4" style="font-size: 15px; font-weight: bold; color: #666;"> ☆ &nbsp;☆&nbsp; ☆&nbsp; ☆ </span>
												<div id="divcontent" style="display: inline"></div></td>
										<td><span style="font-weight: bold; color: #666;"><input type="radio" name="radio" value="3" onClick="changColor(3)" />满意:</span>
										</td>
										<td><span id="3" style="font-size: 15px; font-weight: bold; color: #666;"> ☆&nbsp; ☆&nbsp; ☆ </span>
												<div id="divcontent" style="display: inline"></div></td>
										<td><span style="font-weight: bold; color: #666;"><input type="radio" name="radio" value="2" onClick="changColor(2)" />不满意:</span>
										</td>
										<td><span id="2" style="font-size: 15px; font-weight: bold; color: #666;"> ☆ &nbsp;☆ </span>
												<div id="divcontent" style="display: inline"></div></td>
										<td><span style="font-weight: bold; color: #666;"><input type="radio" name="radio" value="1" onClick="changColor(1)" />很不满意:</span>
										</td>
										<td><span id="1" style="font-size: 15px; font-weight: bold; color: #666;"> ☆ </span>
												<div id="divcontent" style="display: inline"></div></td>
										<td><span style="font-weight: bold; color: #666;"> <input type="radio" name="radio" value="0" onClick="changColor(0)" />非常不满意:
										</span></td>
										<td><span id="0" style="font-size: 15px; font-weight: bold; color: #666;">〇</span>
												<div id="divcontent" style="display: inline"></div></td>
								</tr>
								<tr>
										<td style="height: 0px;"></td>
								</tr>
								<tr style="" align="center">
										<td><input type="hidden" name="cid" value="${currUser.cid}"
												style="border-left: 1px dashed #CCC; border-right: 1px dashed #CCC; border-top: 0px dashed #CCC; border-bottom: 0px dashed #CCC;"
										/> <input type="image" onClick="提交" src="/images/tijiao.png" /></td>
										<td><img src="/images/quxiao.png" onclick="window.close()" /></td>
								</tr>
						</table>
				</div>
		</form>
</body>
</html>