<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang=en>
<head>
<s:head theme="xhtml" />
<sx:head parseContent="true" />
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
				<div align="center">
					<br /> <br />

					<ul>
						<li>员工编号：<s:property value="%{#session.theperson.eno}" />--<s:property
								value="%{#session.theperson.ename}" />--<s:property
								value="%{#session.theperson.sex}" /></li>
						<li>所在部门：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:select name="department.did"
								value="%{#session.theperson.department.did}" list="list"
								listKey="did" listValue="dname" disabled="true" /></li>
						<li>出生日期：<sx:datetimepicker name="joinDate"
								displayFormat="yyyy-MM-dd"
								value="%{#session.theperson.joinDate}" disabled="true" /></li>
						<li>入职时间：<sx:datetimepicker name="birthday"
								displayFormat="yyyy-MM-dd"
								value="%{#session.theperson.birthday}" disabled="true" /></li>
						<li>员工月薪：<s:property value="#session.theperson.esalary"/></li>
					
					</ul>													

				</div>
			</div>
			<s:if test="#session.existEmployee==null">
				<form action="employee_outlog" method="get" name="myform"></form>
				<script type="text/javascript">
					document.myform.submit();
				</script>
			</s:if>

		</div>
		<div id="sidebar">
			<ul>
				<li>
					<h2>个人菜单</h2>
					<ul>
						<li><a href="employee_personinfo.action">个人信息</a></li>
						<li><a href="employee_findAll.action">考勤信息 </a></li>
						<li><a href="echeck_findAll.action">任务查看</a></li>
						<li><a href="aleave_findAll.action">工薪查看</a></li>
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
