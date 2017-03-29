<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制标签</title>
</head>
<body>
	<h2>控制标签 - s:iterator</h2>
	<s:debug />

	<p>有序列表：</p>
	<ol>
		<s:iterator value="{'孙悟空','白骨精','唐僧','猪八戒','牛魔王'}" var="name">
			<li>${name}</li>
		</s:iterator>
	</ol>

	<ul>
		<s:iterator value="{'孙悟空','白骨精','唐僧','猪八戒','牛魔王'}" var="name"
			begin='2' end='3'>
			<li>${name}</li>
		</s:iterator>
	</ul>
	<p>无序列表：</p>
	<ul>
		<s:iterator value="{'孙悟空','白骨精','唐僧','猪八戒','牛魔王','孙艺欣','孙艺凡'}"
			var="name" status="st">
			<li <s:if test="#st.odd"> style="background-color:red"</s:if>>
				${name}</li>
		</s:iterator>
	</ul>

	<p>map 迭代：</p>
	<table width="600" border="1"
		<s:iterator value="#{'孙悟空':100,'白骨精':95,'唐僧':99,'猪八戒':36,'牛魔王':66,'孙艺欣':99,'孙艺凡':26}" var="entity" status="st">
		<tr>
		<td <s:if test="#st.odd"> style="background-color:red"</s:if>>${entity.key}</td>
		<td <s:if test="#st.odd"> style="background-color:red"</s:if>>${entity.value}</td>
		</s:iterator>
	</table>

</body>
</html>