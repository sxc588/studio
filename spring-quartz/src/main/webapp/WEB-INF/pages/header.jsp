<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>基于Quartz的分布式定时任务</title>
    <!-- Bootstrap -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="/springmvc/3rd/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <link rel="stylesheet" href="/springmvc/3rd/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/springmvc/3rd/assets/index.css">
    <script src="/springmvc/3rd/assets/jquery.min.js"></script>
    <script src="/springmvc/3rd/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/springmvc/3rd/assets/index.js"></script>
    <script src="/springmvc/3rd/ga.js"></script>
    
    <style type="text/css">
        .jumbotron-margin-top {
            margin-top: 95px;
        }
        .table-margin-top {
            margin-top: 15px;
        }
        .status-color{
            color: red;
            font-weight:bold;
        }
    </style>
</head>
<body>
ffff
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">应用监控</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="https://github.com/wenzhixin/bootstrap-table" target="_blank"></a></li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Options <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="options/boolean-options.html">Boolean options</a></li>
                        <li><a href="options/from-html.html">From html</a></li>
                        <li><a href="options/from-data.html">From data</a></li>
                        <li><a href="options/modal-table.html">Modal Table</a></li>
                        <li><a href="options/table-style.html">Table Style</a></li>
                        <li><a href="options/no-bordered.html">No bordered</a></li>

                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">基础组件监控<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="extensions/editable.html">Editable</a></li>
                        <li><a href="extensions/export.html">Export</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">问题管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="extensions/editable.html">Editable</a></li>
                        <li><a href="extensions/export.html">Export</a></li>
                    </ul>
                </li>
                
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">运维报表<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="extensions/editable.html">Editable</a></li>
                        <li><a href="extensions/export.html">Export</a></li>
                    </ul>
                </li>
                 <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">CMDB<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="extensions/editable.html">Editable</a></li>
                        <li><a href="extensions/export.html">Export</a></li>
                    </ul>
                </li>
                
                
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">权限管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="integrate/angular">用户管理</a></li>
                        <li><a href="integrate/angular">用户组管理</a></li>
                    </ul>
                </li>
                
                 <li>
                    <a class="navbar-brand" href="#">s00318828</a>
                    <a class="navbar-brand" href="index.html">注销</a>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
