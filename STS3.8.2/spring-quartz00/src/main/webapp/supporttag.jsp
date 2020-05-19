<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="util" uri="custmTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>SupportTag demo(i18n,cfig,meta)</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];
		$("#tags").autocomplete({
			source : availableTags
		});
	});
</script>

<style>
.app {
	font-size: 20px;
	font-family: "微软雅黑";
	font-style: oblique;
	color: red;
	border: #909090 1px solid;
}

.trigger {
	display: inline-block;
	width: 24px;
	height: 24px;
	line-height: 24px;
	border-radius: 50%;
	background: #e83e00;
	margin: 8px 8px 5px;
	text-align: center;
	font-size: 12px;
	color: #b5b4b4;
	background: #e5e5e5;
}
</style>

</head>
<body>
	<div class="ui-widget">
		<label for="tags">Tags: </label> <input id="tags">
	</div>

	<div class="app">
		<util:i18n key="ddd" />
	</div>

	<div class="app">
		<util:config key="ddd" />
	</div>

	<div class="triggers">
		<a class="trigger j-trigger"
			href="https://srd.simba.taobao.com/rd?w=mmp4ptest&amp;f=https%3A%2F%2Fre.taobao.com%2Fauction%3Fkeyword%3D%25BC%25D0%25BF%25CB%26catid%3D50010158%26refpid%3Dmm_15890324_2192376_51598951%26crtid%3D1679720521%26itemid%3D600165476317%26adgrid%3D1977327728%26elemtid%3D1%26clk1info%3D1347675136%2C56%2CGJS%252FfrPmuZN5We%252B4dLbHzL2dcPTCN9olDF22cVbhz66AoVMt63TMbA%253D%253D%26sbid%3D%3B%3B%2C%3B31234%2C2967186%26qtype%3D7%26tagvalue%3D57303596_0_100%26isf%3D0%26templateid%3D100%26spm%3Da2e01.7920152.0.0.IIRqaF&amp;k=eb305a7ca09eeebf&amp;pvid=afd60d0baf7e67005e4003c710a02e1c&amp;p=mm_15890324_2192376_51598951"
			target="_blank" data-index="0">1</a><a class="trigger j-trigger"
			href="https://srd.simba.taobao.com/rd?w=mmp4ptest&amp;f=https%3A%2F%2Fre.taobao.com%2Fauction%3Fkeyword%3D%25BC%25D0%25BF%25CB%26catid%3D50010158%26refpid%3Dmm_15890324_2192376_51598951%26crtid%3D1679720521%26itemid%3D600165476317%26adgrid%3D1977327728%26elemtid%3D1%26clk1info%3D1347675136%2C56%2CGJS%252FfrPmuZN5We%252B4dLbHzL2dcPTCN9olDF22cVbhz66AoVMt63TMbA%253D%253D%26sbid%3D%3B%3B%2C%3B31234%2C2967186%26qtype%3D7%26tagvalue%3D57303596_0_100%26isf%3D0%26templateid%3D100%26spm%3Da2e01.7920152.0.0.IIRqaF&amp;k=eb305a7ca09eeebf&amp;pvid=afd60d0baf7e67005e4003c710a02e1c&amp;p=mm_15890324_2192376_51598951"
			target="_blank" data-index="1">2</a><a class="trigger j-trigger"
			href="https://srd.simba.taobao.com/rd?w=mmp4ptest&amp;f=https%3A%2F%2Fre.taobao.com%2Fauction%3Fkeyword%3D%25BC%25D0%25BF%25CB%26catid%3D50010158%26refpid%3Dmm_15890324_2192376_51598951%26crtid%3D1679720521%26itemid%3D600165476317%26adgrid%3D1977327728%26elemtid%3D1%26clk1info%3D1347675136%2C56%2CGJS%252FfrPmuZN5We%252B4dLbHzL2dcPTCN9olDF22cVbhz66AoVMt63TMbA%253D%253D%26sbid%3D%3B%3B%2C%3B31234%2C2967186%26qtype%3D7%26tagvalue%3D57303596_0_100%26isf%3D0%26templateid%3D100%26spm%3Da2e01.7920152.0.0.IIRqaF&amp;k=eb305a7ca09eeebf&amp;pvid=afd60d0baf7e67005e4003c710a02e1c&amp;p=mm_15890324_2192376_51598951"
			target="_blank" data-index="2">3</a><a class="trigger j-trigger"
			href="https://srd.simba.taobao.com/rd?w=mmp4ptest&amp;f=https%3A%2F%2Fre.taobao.com%2Fauction%3Fkeyword%3D%25BC%25D0%25BF%25CB%26catid%3D50010158%26refpid%3Dmm_15890324_2192376_51598951%26crtid%3D1679720521%26itemid%3D600165476317%26adgrid%3D1977327728%26elemtid%3D1%26clk1info%3D1347675136%2C56%2CGJS%252FfrPmuZN5We%252B4dLbHzL2dcPTCN9olDF22cVbhz66AoVMt63TMbA%253D%253D%26sbid%3D%3B%3B%2C%3B31234%2C2967186%26qtype%3D7%26tagvalue%3D57303596_0_100%26isf%3D0%26templateid%3D100%26spm%3Da2e01.7920152.0.0.IIRqaF&amp;k=eb305a7ca09eeebf&amp;pvid=afd60d0baf7e67005e4003c710a02e1c&amp;p=mm_15890324_2192376_51598951"
			target="_blank" data-index="3">4</a><a
			class="trigger j-trigger current"
			href="https://srd.simba.taobao.com/rd?w=mmp4ptest&amp;f=https%3A%2F%2Fre.taobao.com%2Fauction%3Fkeyword%3D%25BC%25D0%25BF%25CB%26catid%3D50010158%26refpid%3Dmm_15890324_2192376_51598951%26crtid%3D1679720521%26itemid%3D600165476317%26adgrid%3D1977327728%26elemtid%3D1%26clk1info%3D1347675136%2C56%2CGJS%252FfrPmuZN5We%252B4dLbHzL2dcPTCN9olDF22cVbhz66AoVMt63TMbA%253D%253D%26sbid%3D%3B%3B%2C%3B31234%2C2967186%26qtype%3D7%26tagvalue%3D57303596_0_100%26isf%3D0%26templateid%3D100%26spm%3Da2e01.7920152.0.0.IIRqaF&amp;k=eb305a7ca09eeebf&amp;pvid=afd60d0baf7e67005e4003c710a02e1c&amp;p=mm_15890324_2192376_51598951"
			target="_blank" data-index="4">5</a>
	</div>
</body>
</html>