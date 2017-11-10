<%@ page language="java" import="java.util.*,com.ltf.vo.*" pageEncoding="UTF-8"%>
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
    <title>用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path%>/js/index.js" type="text/javascript" ></script>
    <script src="<%=path%>/js/Myjs.js" type="text/javascript" ></script>
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
    <link rel="stylesheet" href="<%=path%>/css/sign_up.css"/>
</head>

<script type="text/javascript">
	function createRequest(url) {
		
		http_request = false;
		if (window.XMLHttpRequest) { // 非IE浏览器
		http_request = new XMLHttpRequest(); //创建XMLHttpRequest对象
		} else if (window.ActiveXObject) { // IE浏览器
			try {
		http_request = new ActiveXObject("Msxml2.XMLHTTP"); //创建XMLHttpRequest对象
			} catch (e) {
				try {
	http_request = new ActiveXObject("Microsoft.XMLHTTP"); //创建XMLHttpRequest对象
				} catch (e) {
				}
			}
		}
		if (!http_request) {
			alert("不能创建XMLHttpRequest对象实例！");
			return false;
		}
	http_request.onreadystatechange = getResult; //调用返回结果处理函数
		http_request.open('POST', url, true); //创建与服务器的连接
		http_request.send(null); //向服务器发送请求
	}
	function getResult() {
		if (http_request.readyState == 4) { // 判断请求状态
			if (http_request.status == 200) { // 请求成功，开始处理返回结果
				document.getElementById("tip").innerHTML = http_request.responseText; //设置提示内容
//document.getElementById("toolTip").style.display = "block"; //显示提示框
			} else { // 请求页面有错误
				alert("您所请求的页面有错误！");
			}
		}
	}
	function checkUser(userName) {
		if (userName.value == "") {
			//alert("请输入用户名！");
			//this.focus();
			return 0;
		} else {
			createRequest('UserServlet?action=checkUserExist&userName='
					+ encodeURIComponent(userName.value));
		}
	}
	
	 
</script>
<body>
<!--头部信息-->
<jsp:include page="../view/frontTop.jsp"></jsp:include>
<!--头部信息-->
<div class="head">
    <h2 style="margin-left:5%">用户注册</h2>
</div>
<!--注册-->
<div class="main comwid">
    <div class="step">
        <p>填写资料</p>
        <p>注册成功</p>
    </div>
    <div class="sign_up_message">
        <form action="UserServlet?action=addUser" id="addUser" method="post" name="addUser">
            <p><input class="username"  id="userName" type="text" name="userName" placeholder="请输入账号" onblur="checkUser(addUser.userName)"/></p>
                <span id="tip"></span>
                <span id="un_bg"></span>
                <span class="un">(必填)</span>
            <div class="blank"></div>
            <p><input class="phone" type="text" name="userPhone" placeholder="请输入手机号码"/></p>
                <span class="ph_bg"></span>
                <span class="ph">(必填)</span><br><br><br>
            <p><input class="pwd" type="password" name="userPassword" placeholder="请输入密码"/></p>
                <span class="pw"></span>
                <span class="pw_bg"></span><br><br><br>
            <p><input class="repwd" type="password" name="userPassword" placeholder="请确认密码"/></p>
                <span class="rep"></span>
                <span class="rep_bg"></span>
            <div class="blank"></div>
            <button class="next_btn" ><a href="javascript:void(0)" onclick="document.getElementById('addUser').submit();">注册</a></button>
        </form>
    </div>
</div>


<jsp:include page="../view/frontEnd.jsp"></jsp:include>
</body>

</html>