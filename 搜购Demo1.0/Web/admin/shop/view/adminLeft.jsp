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
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/shop-admin/shop-admin-left-menu.css"/>
    <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path %>/js/shop-admin.js"></script>
</head>
<body>
  <div class="menu">
          <div class="first-menu" id="first-menu1">店铺管理 </div>
            <ul class="shop">
                <li><a href="ShopServlet?action=showSingleShop&shopId=${sessionScope.shop.shopId}&showType=all" target="_blank" >查看店铺</a></li>
                <li><a href="ShopServlet?action=showSingleShop&shopId=${sessionScope.shop.shopId}" target="right">装修店铺</a></li>
            </ul>
          <div class="first-menu" id="first-menu2">商品列表</div>
              <ul class="goods">
                  <li><a href="GoodsServlet?action=showSingleShopGoods&shopId=${sessionScope.shop.shopId}" target="right">所有商品</a></li>
                  <li><a href="GoodsServlet?action=showAdminSingleShopGoods&shopId=${sessionScope.shop.shopId}&isType=1" target="right">上新商品</a></li>
                  <li><a href="GoodsServlet?action=showAdminSingleShopGoods&shopId=${sessionScope.shop.shopId}&isType=3" target="right">秒杀商品</a></li>
                  <li><a href="GoodsServlet?action=showAdminSingleShopGoods&shopId=${sessionScope.shop.shopId}&isType=2" target="right">折扣商品</a></li>
              </ul>
          <div class="first-menu" id="first-menu3">商品管理</div>
                <ul class="manner">
                    <li><a href="<%=path %>/admin/shop/addGoods.jsp" target="right">添加商品</a></li>
                    <li><a href="GoodsServlet?action=showShopNoCheckGoods&shopId=${sessionScope.shop.shopId}" target="right">未审核商品</a></li>
                     <li><a href="GoodsServlet?action=showSingleShopSoldOut&shopId=${sessionScope.shop.shopId}" target="right">下架商品</a></li>
                </ul>
          <div class="first-menu" id="first-menu4">交易管理</div>
                <ul class="trader">
                    <li><a href="">评价管理</a></li>
                    <li><a href="">预约管理</a></li>
                </ul>
          <div class="first-menu" id="first-menu5">营销中心</div>
                <ul class="promote">
                    <li><a href="">我要推广</a></li>
                    <li><a href="">购买橱窗</a></li>
                </ul>
  </div>
<div class="blank"></div>
</body>
</html>