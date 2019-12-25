<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>人事考勤平台</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/set.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style3.css">
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
	<div style="padding-top: 8%;">
		<div id="works" class=" clearfix grid">
		
			<figure class="effect-oscar  wowload fadeIn">
				<img src="${pageContext.request.contextPath}/images/BGD.jpg" alt="img01"/>
				<figcaption>
					<h2>员工登录</h2>
					<p>
						员工登录窗口<br> <a href="${pageContext.request.contextPath}/jsp/plogin.jsp" title="1" data-gallery>点击进入</a>
					</p>
				</figcaption>
			</figure>
			<figure class="effect-oscar  wowload fadeInUp">
					<img src="${pageContext.request.contextPath}/images/BGD.jpg" alt="img02"/>
				<figcaption>
					<h2>人事管理</h2>
					<p>
						管理登录窗口<br> <a href="${pageContext.request.contextPath}/login.jsp" title="1" data-gallery>点击进入</a>
					</p>
				</figcaption>
			</figure>
			<figure class="effect-oscar  wowload fadeInUp">
					<img src="${pageContext.request.contextPath}/images/BGD.jpg" alt="img03"/>
				<figcaption>
					<h2>系统简介</h2>
					<p>
						HRMS管理平台简介窗口<br> <a href="${pageContext.request.contextPath}/jsp/introduce.jsp" title="1" data-gallery>点击进入</a>
					</p>
				</figcaption>
			</figure>
		</div>
	</div>
</body>
</html>