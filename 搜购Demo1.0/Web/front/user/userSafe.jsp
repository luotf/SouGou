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
    <script>
        $(".main .content #citySelect").citySelect({
            nodata: "none",
            required: false,
        });
    </script>
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
            <li><a href="front/user/userSafe.jsp" style="color:#fff;background:rgb(241, 207, 120);">安全设置</a></li>
            <li><a href="front/user/userInfo.jsp" >个人资料</a></li>
            <li><a href="front/user/modifyPwd.jsp">修改密码</a></li>
            <li><a href="front/user/userOrder.jsp">我的预定</a></li>
            <li><a href="front/user/collection.jsp">我的收藏</a></li>
        </ul>
    </div>
    <div class="content left">
       <h2>您的安全设置</h2>
        <div class="pwd">
            <p class="status">
                <span class="status-img left"></span>
                <span>已完成</span>
            </p>
            <p class="name">登录密码</p>
            <p class="des">安全性高的密码可以使账号更安全。建议您定期更换密码，且设置一个包含数字和字母，并长度超过6位以上的密码。</p>
            <p class="pa"><a href="">修改</a></p>
        </div>
        <div class="pwd">
            <p class="status">
                <span class="status-img left"></span>
                <span>已完成</span>
            </p>
            <p class="name">绑定手机</p>
            <p class="des">绑定手机后，您即可享受淘宝丰富的手机服务，如手机找回密码等。</p>
            <p class="pa"><a href="">修改</a></p>
        </div>
        <div class="pwd">
            <p class="status">
                <span class="status-img left" id="email"></span>
                <span>未设置</span>
            </p>
            <p class="name">绑定邮箱</p>
            <p class="des">绑定邮箱后，可以将邮箱作为登录账号，也可以找回登录密码等。</p>
            <p class="pa"><a href="">绑定</a></p>
        </div>
    </div>
</div>

</body>
</html>