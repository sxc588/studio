<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
 <base href="<%=basePath%>">
 <script src="js/clock.js" type="text/javascript"></script>
</HEAD>
<style type="text/css">
.errorMessage{
	font-size:12px;
	color:red;
}
.label{
	font-size:12px;
}
.errorLabel{
	font-size:14px;
	color:red;
}
</style>
<BODY>

<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD background=images/title_bg1.jpg>当前位置:${tip} </TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
  <TR height=100>
    <TD align=middle width=100><IMG height=100 src="images/admin_p.gif" 
      width=90></TD>
    <TD width=60>&nbsp;</TD>
    <TD>
      <TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>
        
        <TR>
          <TD>当前时间：<span id="myclock"></span></TD></TR>
        <TR>
          <TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${user.nic}</TD></TR>
        <TR>
          <TD>欢迎进入用户管理中心！</TD></TR></TABLE></TD></TR>
  <TR>
    <TD colSpan=3 height=10></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
  <TR height=20>
    <TD></TD></TR>
  <TR height=22>
    <TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff" 
    align=middle background=images/title_bg2.jpg>添加管理员</TD></TR>
  <TR bgColor=#ecf4fc height=12>
    <TD></TD></TR>
  <TR height=20>
    <TD></TD></TR></TABLE>
    <center>
    <font color='red'><s:property value="errors.addadminerr[0]"/> </font>
<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0 class="table">
<s:form action="admin/addadmin" method="post"><!--用户注册表单 -->
        <s:textfield name="admin.username" label="用户名"/>
        <s:textfield name="admin.password" label="密码"/>
        <s:textfield name="admin.name" label="真实姓名"/>
        <s:textfield name="admin.nic" label="用户昵称"/>
        <s:radio list="#{1:'男',0:'女'}" label="性别" name="admin.sex" value="1"/>
        <s:textfield name="admin.age" label="年龄"/>
        <s:textfield name="admin.email" label="电子邮箱"/>
        <s:textfield name="admin.phone" label="联系电话"/>
        <s:select list="#{0:'管理员'}" label="角色" name="admin.roleId" listKey="key" listValue="value" value="1"/>
        <s:textarea  name="admin.selfshow" label="个人说明"/>
        <s:submit value="添加"></s:submit>
    </s:form>
    </TABLE>
    </center>
    </BODY>
    </HTML>