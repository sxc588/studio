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
					��ǰλ��:
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
								��ǰʱ�䣺<span id="myclock"></span>
							</TD>
						</TR>
						<TR>
							<TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">
								${user.nic}
							</TD>
						</TR>
						<TR>
							<TD>
								��ӭ�����û��������ģ�
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
					${userinfo.nic}--�����Ϣ
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
				<s:textfield name="userinfo.username" label="��¼�˺�" />
				<s:textfield name="userinfo.password" label="��¼����" />
				<s:textfield name="userinfo.name" label="��ʵ����" />
				<s:textfield name="userinfo.nic" />
				<s:radio list="#{1:'��',0:'Ů'}" name="userinfo.sex"
					value="userinfo.sex" label="�Ա�" />
				<s:textfield name="userinfo.age" label="����" />
				<s:textfield name="userinfo.email" label="�����ַ" />
				<s:textfield name="userinfo.phone" label="��ϵ�绰" />
				<s:textfield name="userinfo.selfshow" label="����˵��" />
				<s:submit value="�޸�" />

			</s:form>
		</center>
	</BODY>
</HTML>