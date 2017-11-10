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
<link rel="stylesheet"
	href="<%=path %>/css/shop-admin/shop-admin-head.css" />
<title></title>
</head>
<body>
<head>
<div class="logo">
	<img src="images/logo.png" style="width:43px;height:40px;" alt="" />
	<h3>后台管理系统——管理员</h3>
</div>
<a href="" style="border: none;text-align: center;line-height: 45px;font-size: 20px;
    text-decoration: none;color: #ffffff;padding: 10px 40px; background: rgba(0, 188, 212, 0.64);
    margin-left: 23%;">${sessionScope.admin.adminNickName}</a>
<div class="menu">
	<ul>

		<li><a href="index.jsp" class="menu-a1" target="_parent">搜购首页</a></li>
		<li><a href="admin/admin/shopFrame.jsp" class="menu-a2" target="_parent">系统首页</a></li>
		<li><a href="#" class="menu-a3" target="_parent">个人中心</a></li>
		<li><a href="AdminServlet?action=loginOut" class="menu-a4" target="_parent">退出</a></li>
	</ul>
</div>
</head>
</
</body>
</
</html>