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
    <script src="<%=path %>/js/admin-admin.js"></script>
</head>
<body>
  <div class="menu">
  			<div class="first-menu" id="first-menu1">个人管理</div>
            <ul class="admin">
                <li><a href="admin/admin/adminInfo.jsp" target="right" >查看信息</a></li>
                <li><a href="admin/admin/modifyAdmin.jsp" target="right">编辑信息</a></li>
                <li><a href="admin/admin/modifyPassword.jsp" target="right">修改密码</a></li>
            </ul>
            <div class="first-menu" id="first-menu2">用户管理</div>
            <ul class="user">
                <li><a href="UserServlet?action=showAllUser" target="right" >查询用户</a></li>
                <li><a href="admin/admin/modifyUser.jsp" target="right">编辑信息</a></li>
            </ul>
          <div class="first-menu" id="first-menu3">店铺管理 </div>
            <ul class="shop">
                <li><a href="ShopServlet?action=showAllShop" target="right" >查询店铺</a></li>
                <li><a href="ShopServlet?action=showNoCheckShop" target="right">审核店铺</a></li>
            </ul>
          <div class="first-menu" id="first-menu4">商品管理</div>
              <ul class="goods">
                  <li><a href="GoodsServlet?action=showAllGoods&goodsTypeId=0&isNew_Vip_KillGoods=-1&type=1" target="right">查询商品</a></li>
                  <li><a href="GoodsServlet?action=showAllNoCheckGoods" target="right">审核商品</a></li>
                  <li><a href="GoodsServlet?action=showAdminSingleShopGoods" target="right">增加类别</a></li>
              </ul>
        
          <div class="first-menu" id="first-menu5">交易管理</div>
                <ul class="trader">
                    <li><a href="">评价管理</a></li>
                    <li><a href="">预约管理</a></li>
                </ul>
          <div class="first-menu" id="first-menu6">营销中心</div>
                <ul class="promote">
                    <li><a href="">橱窗操作</a></li>
                    <li><a href="">推广操作</a></li>
                </ul>
  </div>
<div class="blank"></div>
</body>
</html>