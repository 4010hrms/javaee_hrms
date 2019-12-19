<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人事考勤管理平台简介</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="../css/style3.css">
<link type="text/css" href="../css/login.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<link type="text/css" href="${pageContext.request.contextPath}/css/css_for_info.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/intro.css" rel="stylesheet" />

</head>
<body>
	<div class="ha">
		<ul>
			<li><a href="${pageContext.request.contextPath}/index.jsp">主页</a></li>
			<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/introduce.jsp">关于</a></li>
		</ul>
	</div>
	<div class="box2">
	<h2>简介</h2><br><br>
		<p>应用SSH框架基于JSP的人事考勤管理平台<br><br>
		<p>本平台面向两种种用户:员工和管理员<br><br>
		<p>员工可以维护自己的信息,进行考勤打、和查询工作任务和请假<br><br>
		<p>管理员可以对员工进行登录，信息,考勤,请假,工资,任务进行管理<br><br>
		<p>主要应用技术:Spring,Struts,Hibernate<br><br>
	</div>
	<div class="box" id="box">
		<div class="inner">
			<!--轮播图-->
			<ul>
				<li><a href="#"><img src="../images/1.jpg" alt=""></a></li>
				<li><a href="#"><img src="../images/1.jpg" alt=""></a></li>
				<li><a href="#"><img src="../images/1.jpg" alt=""></a></li>
				<li><a href="#"><img src="../images/1.jpg" alt=""></a></li>
				<li><a href="#"><img src="../images/1.jpg" alt=""></a></li>

			</ul>
			<ol class="bar">
			</ol>
			<!--左右焦点-->
			<div id="arr">
				<span id="left"> < </span> <span id="right"> > </span>
			</div>
		</div>
	</div>

	<script>
    /**
     *
     * @param id  传入元素的id
     * @returns {HTMLElement | null}  返回标签对象，方便获取元素
     */
    function my$(id) {
        return document.getElementById(id);
    }
 
    //获取各元素，方便操作
    var box=my$("box");
    var inner=box.children[0];
    var ulObj=inner.children[0];
    var list=ulObj.children;
    var olObj=inner.children[1];
    var arr=my$("arr");
    var imgWidth=inner.offsetWidth;
    var right=my$("right");
    var pic=0;
    //根据li个数，创建小按钮
    for(var i=0;i<list.length;i++){
        var liObj=document.createElement("li");
 
        olObj.appendChild(liObj);
        liObj.innerText=(i+1);
        liObj.setAttribute("index",i);
 
        //为按钮注册mouseover事件
        liObj.onmouseover=function () {
            //先清除所有按钮的样式
 
            for (var j=0;j<olObj.children.length;j++){
                olObj.children[j].removeAttribute("class");
            }
            this.className="current";
            pic=this.getAttribute("index");
            animate(ulObj,-pic*imgWidth);
        }
 
    }
 
 
    //设置ol中第一个li有背景颜色
    olObj.children[0].className = "current";
    //克隆一个ul中第一个li,加入到ul中的最后=====克隆
    ulObj.appendChild(ulObj.children[0].cloneNode(true));
 
    var timeId=setInterval(onmouseclickHandle,2000);
    //左右焦点实现点击切换图片功能
    box.onmouseover=function () {
        arr.style.display="block";
        clearInterval(timeId);
    };
    box.onmouseout=function () {
        arr.style.display="none";
        timeId=setInterval(onmouseclickHandle,2000);
    };
 
    right.onclick=onmouseclickHandle;
    function onmouseclickHandle() {
        //如果pic的值是5,恰巧是ul中li的个数-1的值,此时页面显示第六个图片,而用户会认为这是第一个图,
        //所以,如果用户再次点击按钮,用户应该看到第二个图片
        if (pic == list.length - 1) {
            //如何从第6个图,跳转到第一个图
            pic = 0;//先设置pic=0
            ulObj.style.left = 0 + "px";//把ul的位置还原成开始的默认位置
        }
        pic++;//立刻设置pic加1,那么此时用户就会看到第二个图片了
        animate(ulObj, -pic * imgWidth);//pic从0的值加1之后,pic的值是1,然后ul移动出去一个图片
        //如果pic==5说明,此时显示第6个图(内容是第一张图片),第一个小按钮有颜色,
        if (pic == list.length - 1) {
            //第五个按钮颜色干掉
            olObj.children[olObj.children.length - 1].className = "";
            //第一个按钮颜色设置上
            olObj.children[0].className = "current";
        } else {
            //干掉所有的小按钮的背景颜色
            for (var i = 0; i < olObj.children.length; i++) {
                olObj.children[i].removeAttribute("class");
            }
            olObj.children[pic].className = "current";
        }
    }
    left.onclick=function () {
        if (pic==0){
            pic=list.length-1;
            ulObj.style.left=-pic*imgWidth+"px";
        }
        pic--;
        animate(ulObj,-pic*imgWidth);
        for (var i = 0; i < olObj.children.length; i++) {
            olObj.children[i].removeAttribute("class");
        }
        //当前的pic索引对应的按钮设置颜色
        olObj.children[pic].className = "current";
    };
 
    //设置任意的一个元素,移动到指定的目标位置
    function animate(element, target) {
        clearInterval(element.timeId);
        //定时器的id值存储到对象的一个属性中
        element.timeId = setInterval(function () {
            //获取元素的当前的位置,数字类型
            var current = element.offsetLeft;
            //每次移动的距离
            var step = 10;
            step = current < target ? step : -step;
            //当前移动到位置
            current += step;
            if (Math.abs(current - target) > Math.abs(step)) {
                element.style.left = current + "px";
            } else {
                //清理定时器
                clearInterval(element.timeId);
                //直接到达目标
                element.style.left = target + "px";
            }
        }, 10);
    }
</script>

</body>

</html>