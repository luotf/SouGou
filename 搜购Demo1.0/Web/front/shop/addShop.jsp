<%@ page language="java" import="java.util.*,com.ltf.vo.*,com.ltf.tools.*"
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
 <title>搜购商家注册</title>
    <link href="images/icon/favicon.ico" rel="shortcut icon">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path %>/js/index.js" type="text/javascript"></script>
    <script src="<%=path %>/js/Myjs.js" type="text/javascript" ></script>
    <link rel="stylesheet" href="<%=path %>/css/common.css"/>
    <link rel="stylesheet" href="<%=path %>/css/shop/shop-register.css"/>
</head>
<body>
<!--头部信息-->
	<jsp:include page="../view/frontTop.jsp"></jsp:include>
<!--头部信息-->
<div class="head">
    <img src="images/logo.png" alt="logo"/>
    <h2>搜购注册</h2>
</div>
<!--注册-->
<div class="main comwid">
        <div class="title">
            <p>店铺注册</p>
        </div>
    	<form action="ShopServlet?action=addShop" method="post" enctype="multipart/form-data">
        <!--注册信息-->
        <div class="register">
            <P><span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span><input type="text" id="shopName" name="shopName"/></P>
            <P><span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</span><input type="password" id="shopPassword" name="shopPassword"/></P>
            <P><span>确认密码:</span><input type="password" id="rshopPassword" name="rshopPassword" placeholder=""/></P>
            <P><span>店铺名称:</span><input type="text" name="shopNickName" id="shopNickName" placeholder="必须与实体店铺一致"/></P>
            <P><span>店铺店长:</span><input type="text" name="shopManager" id="shopManager" placeholder=""/></P>
            <P><span>联系电话:</span><input type="tel" name="shopPhone" id="shopPhone" placeholder=""/></P>
            <P><span>店铺地址:</span><input type="text" name="shopAddress" id="shopAddress"  placeholder="请输入详细地址"/></P>
            <p><span>店铺简介:</span></p>
            <P><textarea cols="43" rows="4" name="shopIntroduce" id="shopIntroduce"></textarea></P>
            <P><span>店铺实图:</span> <input type="file" id="file1" name="shopMainImages" onchange="uploading1(this)"/>
                <label for="file1" >点击上传</label>
            </P>
            <div class="add-img" id="add-img1"><img id="add1"></div>
            <input type="submit" value="注册" class="submit"/>
            
        </div>
        </form>
</div>

<jsp:include page="../view/frontEnd.jsp"></jsp:include>

<script>
    function uploading1(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("add1");
            img.src = e.target.result;
            //或者 img.src = this.result;  //e.target == this
        }
        reader.readAsDataURL(file);
    }
</script>
</body>

</html>