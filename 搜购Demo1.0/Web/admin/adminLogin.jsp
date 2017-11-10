<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
<base href="<%=basePath%>">

<title>搜购后台管理系统登录</title>
<link rel="stylesheet" href="<%=path %>/css/admin/bootstrap.min.css" />
<link rel="stylesheet" href="<%=path %>/css/admin/sign_admin.css" />
<link rel="stylesheet" href="<%=path %>/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/css/admin/htmleaf-demo.css">
<script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path %>/js/sign-in.js"></script>
<style type="text/css">
.tip {
	width: 130px;
	height: 90px;
	background-color: rgba(244, 67, 54, 0.6);
	color: white;
	font-size: 17px;
	line-height: 88px;
	text-align: center;
	position: absolute;
	top: 39%;
	left: 45%;
	opacity: 0;
	z-index: 15;
	border-radius: 5px;
	display: none;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#_button").mousedown(function(){ 
			var obj = document.getElementsByName("admin");
			var url;
			    for(var i=0; i<obj.length; i ++){
			        if(obj[i].checked){
			        	if(obj[i].value==0)
			        		url="ShopServlet?action=shopLogin";
			        	if(obj[i].value==1)
			        		url="AdminServlet?action=adminLogin";
			        	if(obj[i].value==2)
			        		url="SuperAdminServlet?action=superAdminLogin";
			        }
			    }	
		login(url); 
		setTimeout(function(){
			$("#validateImg").click();
		},1000);
		}); 
		}); 
		function login(url){
		var username = $("#inputEmail3").val();//取框中的用户名 
		var password = $("#inputPassword3").val();//取框中的密码 
		var validate = $("#validate").val();//取框中的密码 
		$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : url, 
		dataType:'text',
		data: 'userName='+username+'&password='+password+'&validate='+validate, 
		success: function(msg){
			if(msg=="validate"){
				show();
				$(".tip").show();
				$(".tip").text("验证码错误");
				setTimeout(function(){
					$(".tip").css("display","none");
					$(".tip").css("top","39%");
				},1000);
		}
			
			if(msg=="error"){
				show();
				$(".tip").show();
				$(".tip").text("密码错误");
				setTimeout(function(){
					$(".tip").css("display","none");
					$(".tip").css("top","39%");
				},1000);
		}
		if(msg=="success"){
			show();
			$(".tip").show();
			$(".tip").text("登录成功");
			$(".tip").css("background-color","#00b4ef");
			setTimeout(function(){
				if(url=="ShopServlet?action=shopLogin")
				location.href="admin/shop/shopFrame.jsp";
				if(url=="AdminServlet?action=adminLogin")
				location.href="admin/admin/adminFrame.jsp";
				if(url=="SuperAdminServlet?action=superAdminLogin")
				location.href="admin/superAdmin/shopFrame.jsp";
			},1000);	
		}
		}
		});
	}
		function show(){
			var box=$('.tip');
	        box.animate({
	            opacity:'1',
	            width:'130px',
	            height:'90px',
	            top:'36%'
	        },900);
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
	<jsp:include page="../front/view/frontTop.jsp"></jsp:include>
	<div id="tip" class="tip"></div>
	<div class="htmleaf-container">
		<div class="comwid demo form-bg" style="width:100%">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">

						<form class="form-horizontal" id="adminLogin" method="post">
							<span class="heading">搜购后台管理系统登录</span>

							<div class="form-group">
								<input type="text" name="userName" class="form-control"
									id="inputEmail3" placeholder="用户名或电子邮件"> <i
									class="fa fa-user"></i>
							</div>
							<div class="form-group help">
								<input type="password" name="password" class="form-control"
									id="inputPassword3" placeholder="密　码"> <i
									class="fa fa-lock"></i> <a href="#"
									class="fa fa-question-circle"></a>
							</div>
							<div class="form-group help">
								<input type="text" name="validate" class="form-control"
									id="validate" placeholder="验证码" style="float:left;width:199px"> <i
									class="fa fa-lock"></i> <a href="#"
									class="fa fa-question-circle"></a>
								 <img alt="" src="randomcode.jpg" id="validateImg" onclick="changeR(this)" style="cursor: pointer;
            margin-right:131px;float:right;height:40px;">
							</div>
							<div class="form-group" id="form-radio">
								<input type="radio" name="admin" value="0" checked />商家 <input
									type="radio" name="admin" value="1" />管理员 <input type="radio"
									name="admin" value="2" />超级管理员

							</div>
							<input type="button" class="btn btn-default" value="登录"
								id="_button">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>

</html>