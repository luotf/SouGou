<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
   <base href="<%=basePath%>">
    <title>搜购商家后台管理系统</title>
    <style>
        *{width: 100%;min-width: 1200px;}
    </style>
</head>
<frameset rows="45,*" frameborder="no">
        <frame src="admin/shop/view/adminTop.jsp" scrolling="no">
        <frameset cols="200,*" frameborder="no">
            <frame src="admin/shop/view/adminLeft.jsp" scrolling="hidden">
            <frame name="right"src="admin/shop/shopIndex.jsp" >
        </frameset>
    </frameset>
    <noframes>你的浏览器不支持框架</noframes>
<body>
</body>
</html>