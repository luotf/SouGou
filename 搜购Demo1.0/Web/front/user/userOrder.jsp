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
    <title></title>
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
    <link rel="stylesheet" href="<%=path%>/css/user/modify-pwd.css"/>
</head>
<body>
<!--头部信息-->
<jsp:include page="../view/frontTop.jsp"></jsp:include>
<%
	UserBean user=(UserBean)request.getSession().getAttribute("user");
%>
<!--个人主页信息-->
<div class="main comwid" style="margin-top:75px;">
    <div class="menu left">
        <img src="${user.userImages}" alt="头像"/>
        <ul>
            <li><a href="front/user/userSafe.jsp" >安全设置</a></li>
            <li><a href="front/user/userInfo.jsp" >个人资料</a></li>
            <li><a href="front/user/modifyPwd.jsp">修改密码</a></li>
            <li><a href="front/user/userOrder.jsp" style="color:#fff;background:rgb(241, 207, 120);">我的预定</a></li>
            <li><a href="front/user/collection.jsp">我的收藏</a></li>
        </ul>
    </div>
    <div class="content left order">
        <p class="ways"><a href="">个人中心</a>>><a href="">我的预定</a></p>
        <table border="1px" width="950">
            <tr class="title">
                <td>预定商品</td>
                <td>型号</td>
                <td>数量</td>
                <td>预定店铺</td>
                <td>预定时间</td>
                <td>预定状态</td>
                <td>更多操作</td>
            </tr>
            <tr>
                <td>MARQUEE MOON</td>
                <td>M</td>
                <td>1</td>
                <td>成都市龙泉驿区十陵镇海澜之家</td>
                <td>2017-5-18</td>
                <td>预定中</td>
                <td><a href="">再次预定</a>&nbsp;&nbsp;<a href="">取消预定</a></td>
            </tr>
            <tr>
                <td>H&M春季款4H&M春季款4H&M春季款4</td>
                <td>L</td>
                <td>1</td>
                <td>成都市龙泉驿区十陵镇海澜之家</td>
                <td>2017-5-18</td>
                <td>预定中</td>
                <td><a href="">再次预定</a>&nbsp;&nbsp;<a href="">取消预定</a></td>
            </tr>
        </table>
    </div>
</div>





</body>
</html>