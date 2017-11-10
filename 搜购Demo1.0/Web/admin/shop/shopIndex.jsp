<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
   <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/common.css"/>
    <link rel="stylesheet" href="<%=path %>/css/shop-admin/shop-admin-index.css"/>
    <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path %>/js/shop-admin.js"></script>
    <script src="<%=path %>/js/echarts.min.js"></script>
    <script src="<%=path %>/js/charts.js"></script>
    <script src="<%=path %>/js/shop-admin.js"></script>
</head>
<body>
<div class="shop-introduce">
    <img src="images/touxiang.png" alt="店铺头像"/>
    <div class="text">
        <h2>UNDEROVER</h2>
        <p>店铺号：9987654</p>
        <p><a href="#">我的店铺</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">装修店铺</a></p>
        <p>店铺地址:金牛区万达广场1楼 UNDEROVER</p>
    </div>

    <div class="dynamic">
        <h2>店铺动态</h2>
        <ul>
            <li><a href="#">上架一件名为【时尚风衣】的打折商品</a></li>
            <li><a href="#">发布了一则秒杀活动消息</a></li>
            <li><a href="#">修改名为【时尚上衣】的商品信息</a></li>
        </ul>
    </div>
</div>


<!--店铺概况-->
<div class="situation">
    <div class="shop-data">
        <h2>店铺概况</h2>
        <p>
            <a href="#" class="left">上新商品</a>
            <a href="#" class="right">4</a>
        </p>
        <p>
            <a href="#" class="left">秒杀商品</a>
            <a href="#" class="right">2</a>
        </p>
        <p>
            <a href="#" class="left">折扣商品</a>
            <a href="#" class="right">6</a>
        </p>
        <p>
            <a href="#" class="left">上架商品</a>
            <a href="#" class="right">18</a>
        </p>
        <p>
            <a href="#" class="left">下架商品</a>
            <a href="#" class="right">3</a>
        </p>
        <p>
            <a href="#" class="left">已用橱窗</a>
            <a href="#" class="right">18</a>
        </p>
        <p>
            <a href="#" class="left">剩余橱窗</a>
            <a href="#" class="right">2</a>
        </p>
        <p>
            <a href="#" class="left">今日浏览量</a>
            <a href="#" class="right">12</a>
        </p>
    </div>
    <div class="near-shop">
        <h2>附近商家</h2>
        <div class="near-shop-show">
            <img src="images/img-admin/shop-touxiang.jpg" alt=""/>
            <p><a href="">新鲜水果店</a></p>
        </div>
        <div class="near-shop-show">
            <img src="images/touxiang.png" alt=""/>
            <p><a href="">NIKE专卖店</a></p>
        </div>
        <div class="near-shop-show">
            <img src="images/like1.png" alt=""/>
            <p><a href="">红旗超市</a></p>
        </div>
        <div class="near-shop-show">
            <img src="images/like3.png" alt=""/>
            <p><a href="">美你服饰</a></p>
        </div>
        
        <div class="near-shop-show">
            <img src="images/like1.png" alt=""/>
            <p><a href="">红旗超市</a></p>
        </div>
        <div class="near-shop-show">
            <img src="images/like3.png" alt=""/>
            <p><a href="">美你服饰</a></p>
        </div>
        
        <div class="near-shop-show">
            <img src="images/like1.png" alt=""/>
            <p><a href="">红旗超市</a></p>
        </div>
        
        <div class="near-shop-show">
            <img src="images/like3.png" alt=""/>
            <p><a href="">美你服饰</a></p>
        </div>
        
        
        
    </div>
    <!--商品统计图-->
    <div class="charts">
        <div class="blank"></div>
        <div class="goods-charts left" id="main"></div>
        <div class="goods-charts left" id="main2"></div>

    </div>
</div>
</body>
</html>