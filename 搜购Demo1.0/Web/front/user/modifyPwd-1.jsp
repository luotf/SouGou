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
    <meta charset="UTF-8">
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
            <li><a href="front/user/userSafe.jsp" >安全设置</a></li>
            <li><a href="front/user/userInfo.jsp" >个人资料</a></li>
            <li><a href="front/user/modifyPwd.jsp" style="color:#fff;background:rgb(241, 207, 120);">修改密码</a></li>
            <li><a href="front/user/userOrder.jsp" >我的预定</a></li>
            <li><a href="front/user/collection.jsp">我的收藏</a></li>
        </ul>
    </div>
    <div class="content left">
        <div class="box">
            <p>
                <span>原&nbsp;&nbsp;密&nbsp;&nbsp;码：</span>
                <input type="password" size="30"/>
            </p>
            <p>
                <span>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</span>
                <input type="password" size="30"/>
            </p>
            <p>
                <span>确认密码&nbsp;：</span>
                <input type="password" size="30"/>
            </p>
            <p>
                <a href="">保存</a>
            </p>
        </div>
    </div>
</div>





</body>
</html>