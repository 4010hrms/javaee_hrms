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
							<td align="center" style="font-size: 24px; color: #666">考勤管理</td>
						</tr>
						<tr>
							<td align="right">
							<a href="echeck_goAddEcheck.action">添加考勤记录</a>
							</td>
						</tr>
						<tr>
							<td align="right">
							<form action="echeck_search" method="post">
							<input type="text" name="echeckid" placeholder="请输入考勤编号" required maxLength="20">
							<input type="submit" class="button"value="查询"> 
							</form>
							</td>
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
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
			<s:iterator value="list" var="echeck">
				<tr>
					<td align="center"><s:property value="#echeck.echeckid" /></td>
					<td align="center"><s:property value="#echeck.eid" /></td>
					<td align="center"><s:date format="yyyy-MM-dd HH:mm:ss" name="#echeck.btime" /></td>
					<td align="center"><s:date format="yyyy-MM-dd HH:mm:ss" name="#echeck.etime"/></td>
					<td align="center"><s:property value="#echeck.state" /></td>
				
					<td align="center">
					    <a href="echeck_findByid.action?echeckid=<s:property value="#echeck.echeckid"/>">
					       <img src="${pageContext.request.contextPath }/images/mark.png" />
					    </a>
					</td>
					<td align="center">
					    <a href="echeck_delete.action?echeckid=<s:property value="#echeck.echeckid"/>">
					       <img src="${pageContext.request.contextPath }/images/trash.gif" />
					    </a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
					</table>
					<br />
					<table border="0" >
						<tr>
							<td align="right"><span> 第<s:property
										value="currPage" />/<s:property value="totalPage" />页
							</span> &nbsp;&nbsp; <span> 总记录数：<s:property value="totalCount" />&nbsp;&nbsp;
									每页显示:<s:property value="pageSize" /></span>&nbsp;&nbsp; <span>
									<s:if test="currPage != 1">
										<a href="echeck_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
                    <a
											href="echeck_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
               </s:if> <s:if test="currPage != totalPage">
										<a
											href="echeck_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
                    <a
											href="echeck_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
               </s:if>
							</span></td>
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
					<h2>管理菜单</h2>
					<ul>
						<li><a href="department_findAll.action">部门管理</a></li>
						<li><a href="employee_findAll.action">员工管理 </a></li>
						<li><a href="echeck_findAll.action">考勤管理</a></li>
						<li><a href="aleave_findAll.action">假条管理</a></li>
						<li><a href="salary_findAll.action">工薪管理</a></li>
						<li><a href="task_findAll.action">任务管理</a></li>
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
