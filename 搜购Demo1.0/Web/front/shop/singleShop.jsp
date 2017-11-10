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
<title>店铺商品</title>
<link rel="stylesheet" href="<%=path%>/css/shop/shop-index.css" />
<script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path %>/js/login.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
<link rel="stylesheet" href="<%=path %>/css/common.css" />
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=9lKrnYhjbCexpqGIAoNUmiePIMWiu3WS"></script>

</head>
<body>
	<!--头部信息-->
	<jsp:include page="../view/frontTop.jsp"></jsp:include>
	<!--店铺信息-->
	<%
	ShopBean singleShop=(ShopBean)request.getAttribute("singleShop");
%>

	<div class="main comwid">
		<div class="shop-logo"></div>
		<div class="shop-message">
			<p>
				店铺号： <span>${singleShop.shopId}</span>
			</p>
			<p>
				店铺地址： <span>${singleShop.shopAddress}</span>
			</p>
			<p class="colle">
				<a href="">收藏店铺
			</p>
		</div>
		<!--店铺招牌-->

		<hr />
		<!--商品展示-->
		<div class="goods-show">
			<div class="goods-recommend left">
				<h3>商品推荐</h3>
				<c:choose>
					<c:when test="${ empty requestScope.shopAllGoods }">
						<tr height="100">
							<td colspan="5" align="center">您的推荐商品为空！</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="shopAllGoods" items="${requestScope.shopAllGoods}">
							<div class="re-goods">
								<img src="${shopAllGoods.goodsPictureMax}" alt="衣服" />
								<p>&yen;${shopAllGoods.goodsVipPrice}</p>
								<p>
									<a
										href="GoodsServlet?action=showSingleGoods&goodsId=${shopAllGoods.goodsId}&showType=all">${shopAllGoods.goodsName}</a>
								</p>

							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>



			</div>
			<div class="shop left">
				<img src="${sessionScope.singleShop.shopMainImages}" alt="店铺图片" />
				<div class="message left">
					<p>店铺号：${sessionScope.singleShop.shopId}</p>
					<p>店铺名称：${sessionScope.singleShop.shopNickName}</p>
					<p>
						店铺地址：<i id="address">${sessionScope.singleShop.shopAddress}</i><span
							style="color:red">(3.18km)</span>
					</p>
					<p class="login-header">
						导航： <a href="javascript:void(0);" class="showMap">查看路线</a>
					</p>
					</p>
					<div class="haddin">
						<div class="login">
							<div class="login-title">
								地图导航<span><a href="javascript:void(0);"
									class="close-login">关闭</a></span>
							</div>
							<div id="allmap"></div>
						</div>
					</div>
				<div style="margin-top:15px;">
				<p style="float:left">分类：</p>
				<ul>
				<li style="float:left;padding:5px 15px;margin-right:3px;background:#fff;"><a href="">男装</a></li>
				<li style="float:left;padding:5px 15px;margin-right:3px;background:#fff;"><a href="">女装</a></li>
				<li style="float:left;padding:5px 15px;margin-right:3px;background:#fff;	"><a href="">鞋靴</a></li>
				</ul>
				</div>
				</div>
			</div>


			<!--折扣活动-->
			<div class="discount left com">
				<h3>上新商品</h3>

				<c:choose>
					<c:when test="${ empty requestScope.showSingleShopNewGoods }">
						<tr height="100">
							<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的上新商品为空！</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="showSingleShopNewGoods"
							items="${requestScope.showSingleShopNewGoods}" begin="1" end="3" step="1">
							<div class="up_normal_list change left">
								<img src="${showSingleShopNewGoods.goodsPictureMax}" alt="衣服图片" />
								<p>&yen;${showSingleShopNewGoods.goodsPrice}</p>
								<a
									href="GoodsServlet?action=showSingleGoods&goodsId=${showSingleShopNewGoods.goodsId}&showType=all"><i>${showSingleShopNewGoods.goodsName}</i></a><br>
								<span class="location">${showSingleShopNewGoods.goodsAddress}</span>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<!--秒杀活动-->
			<div class="seckill left com">
				<h3>折扣商品</h3>
				<c:choose>
					<c:when test="${ empty requestScope.showSingleShopVipGoods }">
						<tr height="100">
							<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的折扣商品为空！</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="showSingleShopVipGoods"
							items="${requestScope.showSingleShopVipGoods}" begin="1" end="3" step="1">
							<div class="up_normal_list change left" > 
								<img src="${showSingleShopVipGoods.goodsPictureMax}" alt="衣服图片" />
								<p>&yen;${showSingleShopVipGoods.goodsPrice}</p>
								<a
									href="GoodsServlet?action=showSingleGoods&goodsId=${showSingleShopVipGoods.goodsId}&showType=all"><i>${showSingleShopVipGoods.goodsName}</i></a><br>
								<span class="location">${showSingleShopVipGoods.goodsAddress}</span>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="all-goods left">
				<h3>所有普通商品信息</h3>

				<c:choose>
					<c:when test="${ empty requestScope.showSingleShopComGoods }">
						<tr height="100">
							<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的普通商品为空！</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="showSingleShopComGoods"
							items="${requestScope.showSingleShopComGoods}">
							<div class="up_normal_list left">
								<img src="${showSingleShopComGoods.goodsPictureMax}" alt="衣服图片" />
								<p>&yen;${showSingleShopComGoods.goodsPrice}</p>
								<a
									href="GoodsServlet?action=showSingleGoods&goodsId=${showSingleShopComGoods.goodsId}&showType=all">
									<i>${showSingleShopComGoods.goodsName}</i>
								</a><br> <span class="location">${showSingleShopComGoods.goodsAddress}</span>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
		</div>
		
			</div>
	</div>






	<div class="blank"></div>
	<!--底部信息-->
	<jsp:include page="../view/frontEnd.jsp"></jsp:include>
</body>
</html>

<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
     // 添加带有定位的导航控件
  var navigationControl = new BMap.NavigationControl({
    // 靠左上角位置
    anchor: BMAP_ANCHOR_TOP_LEFT,
    // LARGE类型
    type: BMAP_NAVIGATION_CONTROL_LARGE,
    // 启用显示定位
    enableGeolocation: true
  });
  map.addControl(navigationControl);
  // 添加定位控件
  var geolocationControl = new BMap.GeolocationControl();
  geolocationControl.addEventListener("locationSuccess", function(e){
    // 定位成功事件
    var address = '';
    address += e.addressComponent.province;
    address += e.addressComponent.city;
    address += e.addressComponent.district;
    address += e.addressComponent.street;
    address += e.addressComponent.streetNumber;
    alert("当前定位地址为：" + address);
  });
  geolocationControl.addEventListener("locationError",function(e){
    // 定位失败事件
    alert(e.message);
  });
  map.addControl(geolocationControl);
  
  var mapType1 = new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]});
    var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT});

    var overView = new BMap.OverviewMapControl();
    var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
    map.addControl(mapType1);          //2D图，卫星图
        map.addControl(mapType2);          //左上角，默认地图控件

    map.centerAndZoom(point,17);
     map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
    map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
     var adress=document.getElementById("address");
    var walking = new BMap.WalkingRoute(map, {renderOptions:{map: map, autoViewport: true}});
    //walking.search("天坛公园", "故宫");
      //var walking = new BMap.WalkingRoute(map, {renderOptions:{map: map, autoViewport: true}});
   walking.search("成都市龙泉驿区十陵镇成都大学", adress.innerHTML);
     map.addTileLayer(new BMap.PanoramaCoverageLayer());
    var panorama = new BMap.Panorama('allmap'); 
   panorama.setPov({heading: -40, pitch: 6});
  // map.addEventListener("click", showInfo);
  // function showInfo(e){
      //  alert(e.point.lng + ", " + e.point.lat);
         // alert('从大渡口区到江北区的距离是：'+(map.getDistance(pointA,pointB)).toFixed(2)+' 米。');
        //panorama.setPosition(new BMap.Point(e.point.lng,e.point.lat)); //根据经纬度坐标展示全景图  
   // }

  
</script>
