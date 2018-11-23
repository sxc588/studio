<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="/springmvc/3rd/bootstrap/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<link rel="stylesheet"
	href="/springmvc/3rd/bootstrap/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/springmvc/3rd/bootstrap/assets/index.css">
<script src="/springmvc/3rd/bootstrap/assets/jquery.min.js"></script>
<script src="/springmvc/3rd/bootstrap/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/springmvc/3rd/bootstrap/assets/index.js"></script>
<script src="/springmvc/3rd/bootstrap/ga.js"></script>

<%
String contextPath = request.getContextPath();
%>


<style type="text/css">
body {
	padding: 20px;
}

.jumbotron-margin-top {
	margin-top: 95px;
}

.table-margin-top {
	margin-top: 15px;
}

.status-color {
	color: red;
	font-weight: bold;
}

#rightDiv {
	background-color: #FFCC00;
	height: 100%;
	width: 90%;
	float: left;
	/*  position: absolute; */
	/*  top: 60px; */
	/*  left: 200px; */
}

#leftDiv {
	background-color: #00CC00;
	height: 100%;
	width: 10%;
	float: left;
	/*  position: absolute; */
	/*  left: 0px; */
	/*  top: 60px; */
	
}

/* #parent{   */
/* width:300px;   */
/* height:300px;   */
/* background:gray;   */
/* position:relative;   */
/* }   */
#i_want_to_be_bottom {
	/* width:100px;   */
	height: 30px;
	background: red;
	position: absolute;
	bottom: 0px;
}
</style>