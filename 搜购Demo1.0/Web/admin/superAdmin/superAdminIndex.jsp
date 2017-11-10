<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
   <base href="<%=basePath%>">
    <title>搜购商家后台管理系统</title>
    <style>
        *{width: 100%;min-width: 1200px;}
    </style>
    <frameset rows="45,*" frameborder="no">
        <frame src="../admin/shop-admin-head.html" scrolling="no">
        <frameset cols="200,*" frameborder="no">
            <frame src="../admin/shop-admin-left-menu.html" scrolling="hidden">
            <frame name="right"src="../admin/shop-admin/shop-admin-index.html" >
        </frameset>
    </frameset>
    <noframes>你的浏览器不支持框架</noframes>
</head>
<body>
<div>

</div>
</body>
</html>