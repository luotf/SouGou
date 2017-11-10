<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head lang="en">
<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
    
</head>
<body>
<div class="footer" >
    <div class="blank"></div>
     <div class="blank"></div>
    <span><a href="#">关于我们</a></sapn>
    <span><a href="#">联系我们</a></span>
    <span><a href="#">搜购合作</a></span>
    <span><a href="#">加盟合作</a></span>
    <span>© 2017-2018 搜购 版权所有</span>
    <p>互联网违法和不良信息举报电话：0571-81683755 blxxjb@alibaba-inc.com</p>
</div>
</body>
</html>