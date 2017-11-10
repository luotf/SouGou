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
    <title>搜购 用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
    <link rel="stylesheet" href="<%=path%>/css/sign_up.css"/>
    <style>
        .main .step .complete{border-bottom: 3px solid red;}
    </style>
</head>
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
        <p class="complete">注册成功</p>
    </div>
    <div class="success">
        <h2>恭喜你，注册成功</h2>
        <p style="margin-top:35px"><a href="front/user/login.jsp">马上登录</a></p>
    </div>
</div>
<jsp:include page="../view/frontEnd.jsp"></jsp:include>
<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/js/index.js"></script>
<script src="<%=path%>/js/Myjs.js" language="JavaScript"></script>
</body>
</html>