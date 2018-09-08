<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="application/javascript">
    function download(){
        var url="http://localhost:8080/wdxend/excelexport/testDownload";
        window.open(url);
    }
</script>

<body>

<input type="button" value="导出数据" onclick="download()"/>
</body>
</html>