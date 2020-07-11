<%@page import="com.github.support.utils.PtResoult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.github.support.utils.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>评论回复页面</title>
    <meta charset="utf-8" />
    <style>
     .cd-user-modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(52, 54, 66, 0.9);
  z-index: 3;
  overflow-y: auto;
  cursor: pointer;
  visibility: hidden;
  opacity: 0;
  -webkit-transition: opacity 0.3s 0, visibility 0 0.3s;
  -moz-transition: opacity 0.3s 0, visibility 0 0.3s;
  transition: opacity 0.3s 0, visibility 0 0.3s;
}
.cd-user-modal.is-visible {
  visibility: visible;
  opacity: 1;
  -webkit-transition: opacity 0.3s 0, visibility 0 0;
  -moz-transition: opacity 0.3s 0, visibility 0 0;
  transition: opacity 0.3s 0, visibility 0 0;
}
.cd-user-modal.is-visible .cd-user-modal-container {
  -webkit-transform: translateY(0);
  -moz-transform: translateY(0);
  -ms-transform: translateY(0);
  -o-transform: translateY(0);
  transform: translateY(0);
}

.cd-user-modal-container {
  position: relative;
  width: 90%;
  max-width: 600px;
  background: #FFF;
  margin: 3em auto 4em;
  cursor: auto;
  border-radius: 0.25em;
  -webkit-transform: translateY(-30px);
  -moz-transform: translateY(-30px);
  -ms-transform: translateY(-30px);
  -o-transform: translateY(-30px);
  transform: translateY(-30px);
  -webkit-transition-property: -webkit-transform;
  -moz-transition-property: -moz-transform;
  transition-property: transform;
  -webkit-transition-duration: 0.3s;
  -moz-transition-duration: 0.3s;
  transition-duration: 0.3s;
}
.cd-user-modal-container .cd-switcher:after {
  content: "";
  display: table;
  clear: both;
}
.cd-user-modal-container .cd-switcher li {
  width: 50%;
  float: left;
  text-align: center;
}
.cd-user-modal-container .cd-switcher li:first-child a {
  border-radius: .25em 0 0 0;
}
.cd-user-modal-container .cd-switcher li:last-child a {
  border-radius: 0 .25em 0 0;
}
.cd-user-modal-container .cd-switcher a {
  display: block;
  width: 100%;
  height: 50px;
  line-height: 50px;
  background: #d2d8d8;
  color: #809191;
}
.cd-user-modal-container .cd-switcher a.selected {
  background: #FFF;
  color: #505260;
}

#cd-login, #cd-signup {
  display: none;
}

#cd-login.is-selected, #cd-signup.is-selected{
  display: block;
}
    </style>

    <script>
    jQuery(document).ready(function($){
        var form_modal = $('.cd-user-modal'),
            form_login = $form_modal.find('#cd-login'),
            form_signup = $form_modal.find('#cd-signup'),
            form_modal_tab = $('.cd-switcher'),
            tab_login = $form_modal_tab.children('li').eq(0).children('a'),
            tab_signup = $form_modal_tab.children('li').eq(1).children('a'),
            main_nav = $('.main_nav');

        //弹出窗口
        $main_nav.on('click', function(event){

            if( $(event.target).is($main_nav) ) {
                // on mobile open the submenu
                $(this).children('ul').toggleClass('is-visible');
            } else {
                // on mobile close submenu
                $main_nav.children('ul').removeClass('is-visible');
                //show modal layer
                $form_modal.addClass('is-visible'); 
                //show the selected form
                ( $(event.target).is('.cd-signup') ) ? signup_selected() : login_selected();
            }

        });

        //关闭弹出窗口
        $('.cd-user-modal').on('click', function(event){
            if( $(event.target).is($form_modal) || $(event.target).is('.cd-close-form') ) {
                $form_modal.removeClass('is-visible');
            }   
        });
        //使用Esc键关闭弹出窗口
        $(document).keyup(function(event){
            if(event.which=='27'){
                $form_modal.removeClass('is-visible');
            }
        });

        //切换表单
        $form_modal_tab.on('click', function(event) {
            event.preventDefault();
            ( $(event.target).is( $tab_login ) ) ? login_selected() : signup_selected();
        });

        function login_selected(){
            form_login.addClass('is-selected');
            form_signup.removeClass('is-selected');
            form_forgot_password.removeClass('is-selected');
            tab_login.addClass('selected');
            tab_signup.removeClass('selected');
        }

        function signup_selected(){
            form_login.removeClass('is-selected');
            form_signup.addClass('is-selected');
            form_forgot_password.removeClass('is-selected');
            tab_login.removeClass('selected');
            tab_signup.addClass('selected');
        }

    });
    </script>
</head>
<body>
   <nav class="main_nav">
    <ul>
        <li><a class="cd-signin" href="#0">登录</a></li>
        <li><a class="cd-signup" href="#0">注册</a></li>
    </ul>
</nav>


<div class="cd-user-modal"> 
    <div class="cd-user-modal-container">
        <ul class="cd-switcher">
            <li><a href="#0">用户登录</a></li>
            <li><a href="#0">注册新用户</a></li>
        </ul>

        <div id="cd-login"> 
            <form class="cd-form">
                <!-- 登录表单 -->
            </form>
        </div>

        <div id="cd-signup"> 
            <form class="cd-form">
                <!-- 注册表单 -->
            </form>
        </div>      
    </div>
</div> 
</body>
</html>