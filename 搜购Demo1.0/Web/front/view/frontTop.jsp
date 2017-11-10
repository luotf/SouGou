<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>


<head lang="en">
 <base href="<%=basePath%>">
    <title></title>
    <script src="<%=path%>/js/jquery-1.7.1.min.js"></script>
    <script src="<%=path%>/js/index.js"></script>
    
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
   
</head>
<body>
<!--头部信息-->
	<header>
    <!--左侧logo-->
    <div class="logo left">
        <h2>搜购</h2>
        <img src="images/logo.png" alt="LOGO"/>
        <c:choose>
         <c:when test="${ empty sessionScope.user }">
         <span style="color:#000;font-weight:bold">未登录</span>
         </c:when>
         <c:otherwise>
           <span>欢迎"<a href="front/user/userInfo.jsp"><strong style="color:#7974ff">${ sessionScope.user.userNickName }</strong></a>"登录</span>
         </c:otherwise>
         </c:choose>
      
       
    </div>
    <!--右侧导航-->
    <div class="nav right">
        <ul>
            <li><a href="index.jsp">首页</a></li>
            
		<c:choose>
         <c:when test="${ empty sessionScope.user }">
            <li><a href="front/user/login.jsp" class="sign_in">登录</a></li>
			<li><span class="line">|</span></li>
            <li><a href="front/user/register-1.jsp" class="sign_up">注册</a></li>
           </c:when>
           <c:otherwise>
           
           </c:otherwise>
        </c:choose>
            <li><a href="" class="add_arrow add_arrow1">我的搜购</a>
                <ul class="sec_ul sec_ul1">
                    <li><a href="">我的预约</a></li>
                    <li><a href="">个人中心</a></li>
                </ul>
            </li>
            <li>
                <a href="front/shop/addShop.jsp" class="add_arrow add_arrow2">我要开店</a>
                
            </li>
            <li><a href="admin/adminLogin.jsp">后台管理</a></li>
            <c:choose>
         <c:when test="${ empty sessionScope.user }">
           
            </c:when>
            <c:otherwise>
             <li><a href="UserServlet?action=loginOut" >退出</a></li>
             </c:otherwise>
            </c:choose>
            
        </ul>
    </div>
</header>
</body>
</html>