<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="css/admin.css" type="text/css" rel="stylesheet">
		<base href="<%=basePath%>">
		<style type="text/css">
			.label{
				font-size:14px;
			}
			.tdLabel{
				width:150px;
			}
		</style>
		<script src="js/clock.js" type="text/javascript"></script>
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TR height=28>
				<TD background=images/title_bg1.jpg>
					当前位置:
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background=images/shadow_bg.jpg></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
			<TR height=100>
				<TD align=middle width=100>
					<IMG height=100 src="images/admin_p.gif" width=90>
				</TD>
				<TD width=60>
					&nbsp;
				</TD>
				<TD>
					<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>

						<TR>
							<TD>
								当前时间：<span id="myclock"></span>
							</TD>
						</TR>
						<TR>
							<TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">
								${user.nic}
							</TD>
						</TR>
						<TR>
							<TD>
								欢迎进入用户管理中心！
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
			<TR>
				<TD colSpan=3 height=10></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align=middle background=images/title_bg2.jpg>
					${userinfo.nic}--相关信息
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<center>
			<s:form action="common/modifyuser" method="post">
				<s:textfield name="userinfo.username" label="登录账号" />
				<s:textfield name="userinfo.password" label="登录密码" />
				<s:textfield name="userinfo.name" label="真实姓名" />
				<s:textfield name="userinfo.nic" />
				<s:radio list="#{1:'男',0:'女'}" name="userinfo.sex"
					value="userinfo.sex" label="性别" />
				<s:textfield name="userinfo.age" label="年龄" />
				<s:textfield name="userinfo.email" label="邮箱地址" />
				<s:textfield name="userinfo.phone" label="联系电话" />
				<s:textfield name="userinfo.selfshow" label="个人说明" />
				<s:submit value="修改" />

			</s:form>
		</center>
	</BODY>
</HTML>