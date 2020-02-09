<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="util" uri="custmTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>jQuery UI Autocomplete - Default functionality</title>
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
	border:#909090 1px solid;
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
</body>
</html>