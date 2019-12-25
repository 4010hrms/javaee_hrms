<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang=en>
<head>
<meta charset=UTF-8>
<title>人事考勤</title>
<link href="${pageContext.request.contextPath }/css/style.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath }/css/main.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<div id="page">
		<header> <img
			src="${pageContext.request.contextPath }/images/logo.png" width="303"
			height="82" alt="logo" /> <br />
		<img
			src="${pageContext.request.contextPath }/images/bg_banner_grey.gif"
			width="980" height="5" alt="logo_banner" /> </header>

		<div id="content">
			<div class="post">
				<B>关于人事考勤系统</B>
				<p>应用SSH框架基于JSP的人事考勤管理平台，本平台面向两种用户:员工和管理员</p>
				<p>
					员工可以维护自己的信息,进行考勤打卡和查询工作任务和请假 <br />
				</p>
				<p>
					管理员可以对员工进行登录，信息,考勤,请假,工资,任务进行管理 <br />
				</p>
				<p>主要应用技术:Spring+Struts+Hibernate.</p>
				<hr />
			</div>
			<div id="left">
				<table border="0" width="900px">
						<tr>
							<td align="center" style="font-size: 24px; color: #666">修改密码<span style="color: red"><s:actionerror /></span></td>
						</tr>
					</table>
					<br /> <br />
				<div align="center">
					<!-- action对应一个action标签，id对应提交时的对应关系 -->
					<s:form id="saveForm" action="employee_editpassword" method="post"
						namespace="/" theme="simple">
						<s:hidden name="eid" value="%{#session.theperson.eid}"></s:hidden>
						<s:hidden name="ename" value="%{#session.theperson.ename}"></s:hidden>
						<s:hidden name="sex" value="%{#session.theperson.sex}"></s:hidden>
						<s:hidden name="birthday" value="%{#session.theperson.birthday}"></s:hidden>
						<s:hidden name="joinDate" value="%{#session.theperson.joinDate}"></s:hidden>
						<s:hidden name="username" value="%{#session.theperson.username}"></s:hidden>
						<s:hidden name="department.did" value="%{#session.theperson.department.did}"></s:hidden>

						<table style="font-size: :16px">
							<tr>
								<td align="right">用户名：</td>
								<td><s:property value="%{#session.theperson.username}" /></td>
							</tr>
							<tr>
								<td align="right">密码：</td>
								<td><s:password value="%{#session.theperson.password}" name="password" showPassword="true" /></td>
							</tr>
						</table>
					</s:form>
					<table border="0" width="900px">
						<tr>
							<td align="right"><a
								href="javascript:document.getElementById('saveForm').submit()">保存</a>
								&nbsp;&nbsp; <a href="javascript:history.go(-1)">退回 </a></td>
						</tr>
					</table>
				</div>
				<s:if test="#session.existEmployee==null">
					<form action="employee_outlog" method="get" name="myform"></form>
					<script type="text/javascript">
						document.myform.submit();
					</script>
				</s:if>

			</div>



		</div>
		<div id="sidebar">
			<ul>
				<li>
					<h2>个人菜单</h2>
					<ul>
						<li><a href="employee_personinfo.action">个人信息</a></li>
						<li><a href="echeck_personecheck.action">考勤信息 </a></li>
						<li><a href="task_persontask.action">任务查看</a></li>
						<li><a href="aleave_personaleave.action">假条申请</a></li>
						<li><a href="employee_personpassword.action">密码修改</a></li>
						<li><a href="employee_outlog.action">退出登录</a></li>				
					</ul>
				</li>
			</ul>
			<br />
		</div>
		<div style="clear: both;">&nbsp;</div>
		<img
			src="${pageContext.request.contextPath }/images/bg_banner_grey.gif"
			width="980" height="5" alt="logo_banner" />
		<footer> 软工174-4010小组 © 2019 | JAVAEE作品 <a href="#"
			title="人事考勤系统" target="_blank">人事考勤系统</a> </footer>
	</div>
</body>
</html>
