<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
    <title>登录</title>
    <script src="<%=path%>/js/jquery-1.7.1.min.js"></script>
    <script src="<%=path%>/js/sign-in.js" type="text/javascript" language="JavaScript"></script>
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
    <link rel="stylesheet" href="<%=path%>/css/sign_in.css"/>
    <style type="text/css">
.tip {
	width: 100px;
	height: 90px;
	background-color: rgba(244, 67, 54, 0.6);
	color: white;
	font-size: 17px;
	line-height: 88px;
	text-align: center;
	position: absolute;
	top: 49%;
	left: 64%;
	opacity: 0;
	z-index: 15;
	border-radius: 5px;
	display: none;
}
</style>
<script type="text/javascript">
function checkUser(){
	if($("#userName").val()==""){		
		alert("用户名为空");
		$("#userName").focus();
		return;
	}else if($("#validate").val()==""){
		alert("验证码为空");
		$("#validate").focus();
	}else{
		login();
		setTimeout(function(){
			$("#validateImg").click();
		},1000);
	}
}
function login(){ 
	var username = $("#userName").val();//取框中的用户名 
	var password = $("#userPassword").val();//取框中的密码 
	var validate = $("#validate").val();//取框中的密码 
	$.ajax({ //一个Ajax过程 
	type: "post", //以post方式与后台沟通 
	url : "UserServlet?action=UserLogin", 
	dataType:'text',
	data: 'userName='+username+'&userPassword='+password+'&validate='+validate, 
	success: function(msg){
		if(msg=="validate"){
			show();
			$(".tip").show();
			$(".tip").text("验证码错误");
			setTimeout(function(){
				$(".tip").css("display","none");
				$(".tip").css("top","49%");
			},1000);
	}
		
		if(msg=="error"){
			show();
			$(".tip").show();
			$(".tip").text("密码错误");
			setTimeout(function(){
				$(".tip").css("display","none");
				$(".tip").css("top","49%");
			},1000);
	}
	if(msg=="success"){
		show();
		$(".tip").show();
		$(".tip").text("登录成功");
		$(".tip").css("background-color","#00b4ef");
		setTimeout(function(){
			location.href="index.jsp";
		},1000);	
	}
	}
	});
}
	function show(){
		var box=$('.tip');
        box.animate({
            opacity:'1',
            width:'100px',
            height:'90px',
            top:'47%'
        },1000);
        setTimeout(function(){
        	 box.animate({
	 	            opacity:'0'
	 	        },1000);
			},1000);
    }
	
	function changeR(node){
		// 用于点击时产生不同的验证码
		node.src = "randomcode.jpg?time="+new Date().getTime();	
	}
</script>

</head>
<body>
<jsp:include page="../view/frontTop.jsp"></jsp:include>
<div>
<!--头部信息-->
<div class="head"></div>
<div id="tip" class="tip"></div>
<!--登录模块-->
<div class="main comwid">
    <div class="sign_box">
        <h2>欢迎登录</h2>
        <form action="" id="loginForm" method="post">
            <input type="text" class="account" id="userName" name="userName" placeholder="账号/手机号"/>
            <input type="password" class="psw" id="userPassword" name="userPassword"/>
            <input type="text" style="width:131px" id="validate" name="validate"/>
            <img alt="" src="randomcode.jpg" id="validateImg" onclick="changeR(this)" style="cursor: pointer;
            margin-top:30px;margin-right:31px;float:right;height:32px;">
            <a href="javaScript:void(0)" class="sign" onclick="checkUser();">登录</a>
            <a href="#" class="wechat left">微信登录</a>
            <a href="#" class="qq right">QQ登录</a>
            <a href="front/user/register-1.jsp" class="sign-up">免费注册</a>
            <a href="#" class="forget-password">忘记密码</a>
        </form>
    </div>
</div>
<jsp:include page="../view/frontEnd.jsp"></jsp:include>
</body>
</html>