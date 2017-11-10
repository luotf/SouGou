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
            <li><a href="front/user/userOrder.jsp" >我的预定</a></li>
            <li><a href="front/user/collection.jsp" style="color:#fff;background:rgb(241, 207, 120);">我的收藏</a></li>
        </ul>
    </div>
    <div class="content left order collection">
        <p class="ways"><a href="">个人中心</a>>><a href="">我的收藏</a></p>
        <div class="coll-goods">
            <a href="../../html/sale-mixian.html"><img src="images/mi.jpg" alt="图片"/></a>
            <a href="../../html/sale-mixian.html"><p>云南米线</p></a>
            <p class="btn">
                <a href="">进入店铺</a>
                <a href="">删除商品</a>
            </p>
        </div>

        <div class="coll-goods">
            <a href="../../html/sale-mixian.html"><img src="images/mi1.jpg" alt="图片"/></a>
            <a href="../../html/sale-mixian.html"><p>云南米线</p></a>
            <p class="btn">
                <a href="">进入店铺</a>
                <a href="">删除商品</a>
            </p>
        </div>

        <div class="coll-goods">
            <a href="../../html/sale-mixian.html"><img src="images/mi2.jpg" alt="图片"/></a>
            <a href="../../html/sale-mixian.html"><p>云南米线</p></a>
            <p class="btn">
                <a href="">进入店铺</a>
                <a href="">删除商品</a>
            </p>
        </div>
        <div class="coll-goods">
            <a href="../../html/sale-mixian.html"><img src="images/mi3.jpg" alt="图片"/></a>
            <a href="../../html/sale-mixian.html"><p>云南米线</p></a>
            <p class="btn">
                <a href="">进入店铺</a>
                <a href="">删除商品</a>
            </p>
        </div>
    </div>
</div>

</body>
</html>