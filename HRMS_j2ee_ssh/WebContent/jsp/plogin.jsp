<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>
<title>登录页面</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="../css/style2.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="ha">
		<ul>
			<li><a href="${pageContext.request.contextPath}/index.jsp">主页</a></li>
			<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/introduce.jsp">关于</a></li>
			<li style="float: right;"><script charset="Shift_JIS" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_wh.js"></script></li>
		</ul>
	</div>
 <div class="login">
    <h1>员工登录</h1>
    <form action="employee_plogin" method="post">
     <input type="text" name="username" value="" placeholder="请输入用户名" required autofocus />
     <input type="password" name="password" value="" placeholder="请输入密码" required maxLength="16" /> 
      <button type="submit" class="btn btn-primary btn-block btn-large">登录</button>
    </form>
  </div>
</body>

</html>