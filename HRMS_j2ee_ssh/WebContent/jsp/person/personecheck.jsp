<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	java.util.HashMap map = new java.util.LinkedHashMap();
	request.setAttribute("default", 1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang=en>
<head>
<meta charset=UTF-8>
<title>人事考勤</title>
<link href="${pageContext.request.contextPath }/css/style.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css">
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
				<p>应用SSH框架基于JSP的人事考勤管理平台，本平台面向两种种用户:员工和管理员</p>
				<p>
					员工可以维护自己的信息,进行考勤打、和查询工作任务和请假 <br />
				</p>
				<p>
					管理员可以对员工进行登录，信息,考勤,请假,工资,任务进行管理 <br />
				</p>
				<p>主要应用技术:Spring+Struts+Hibernate.</p>
				<hr />
			</div>
			<div id="left">
				<h2>管理面板</h2>
				<div align="center">
					<table border="0" width="900px">
						<tr>
							<td align="center" style="font-size: 24px; color: #666">考勤查看</td>
						</tr>

					</table>
					<br />
					<table border="0" width="900px">
						<thead>
							<tr>
								<th>考勤编号</th>
								<th>员工编号</th>
								<th>上班时间</th>
								<th>下班时间</th>
								<th>状态</th>
						
							</tr>
						</thead>
						<tbody>
			<s:iterator value="#session.personlist" var="echeck">
				<tr>
					<td align="center"><s:property value="#echeck.echeckid" /></td>
					<td align="center"><s:property value="#echeck.eid" /></td>
					<td align="center"><s:date format="yyyy-MM-dd hh:mm:ss" name="#echeck.btime" /></td>
					<td align="center"><s:date format="yyyy-MM-dd hh:mm:ss" name="#echeck.etime"/></td>
					<td align="center"><s:property value="#echeck.state" /></td>
				
					
				</tr>
			</s:iterator>
		</tbody>
					</table>
					<br />	
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
					<h2>管理菜单</h2>
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
