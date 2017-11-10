<%@ page language="java" import="java.util.*,com.ltf.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head lang="en">
   <base href="<%=basePath%>">
    <title>搜购打折区</title>
   <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path %>/js/Myjs.js"></script>
    <script src="<%=path %>/js/login.js"></script>
   <link rel="stylesheet" href="<%=path %>/css/jquery.slideBox.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
<link rel="stylesheet" href="<%=path %>/css/common.css"/>
<link rel="stylesheet" href="<%=path %>/css/sale.css"/>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=9lKrnYhjbCexpqGIAoNUmiePIMWiu3WS"></script>
</head>
<body>
<!--头部信息-->
<jsp:include page="../view/frontTop.jsp"></jsp:include>

<!--折扣区-->

<%
	GoodsBean singleGoods=(GoodsBean)request.getAttribute("singleGoods");
	ShopBean singleShop=(ShopBean)request.getAttribute("singleShop");
	
%>
<div class="content_box">
    <div class="content comwid">
        <!--清楚浮动，添加空白-->
        <div class="blank"></div>
        <div class="content_top">
            <div class="content_top_left left">
                <h2 class="left">折扣区</h2>
                <p class="left">——商品详情</p>
                <div class="border_right"></div>
                <div class="border_bottom clearfix"></div>
                <div class="shpwPicture clearfix">
                    <div class="shpwPicture_left left">
                       <img src="${singleGoods.goodsPictureView1}" alt=""/>
                       <img src="${singleGoods.goodsPictureView2}" alt=""/>
                       <img src="${singleGoods.goodsPictureView3}" alt=""/>
                    </div>
                    <div class="shpwPicture_right left">
                        <img src="${singleGoods.goodsPictureMax}" alt=""/>
                    </div>
                </div>
            </div>
            <div class="content_top_right left">
                <p>${singleShop.shopNickName}</p>
                <h1>${singleGoods.goodsName}</h1>           
                 <h3>${singleGoods.goodsIntroduce}</h3>
                <div class="price">             
                <s>&yen;${singleGoods.goodsPrice}</s>
                <span>-</span><span>&yen;${singleGoods.goodsVipPrice}</span>
                </div>
                <!--清楚浮动，添加空白-->
                <div class="blank"></div>          
                <div class="buy clearfix">
                   <p>尺寸</p>
                    <ul>
                        <li><a href="#">M</a></li>
                        <li><a href="#">L</a></li>
                        <li><a href="#">XL</a></li>
                        <li><a href="#">XXL</a></li>
                    </ul>
                   <p>库存</p>
                    <ul>
                        <li><a href="#">670件</a></li>
                    </ul>
                    <p>浏览</p>
                    <ul>
                        <li><a href="#">${singleGoods.goodsReadNum}</a></li>
                    </ul>
                </div>
     
                <p class="login-header location"><i id="adress">${singleGoods.goodsAddress}</i><span style="color:red">(3.5km)</span><a href="javascript:void(0);" class="showMap" >查看地图</a></p>
    <div class="haddin">
        <div class="login">
        <div class="login-title">地图导航<span><a href="javascript:void(0);" class="close-login">关闭</a></span></div>
        <div id="allmap"></div> 
            </div>
        </div>
                <a href="#" class="service">联系商家</a>
        </div>
        <div class="blank"></div>
        <div class="content_bottom comwid">
            <h2>该店铺其他商品</h2>
            <ul class="shop_others left">
      <c:choose>
		<c:when test="${ empty requestScope.shopAllGoods }"><tr height="100">
				<td colspan="5" align="center">您的商品为空！</td></tr>
		</c:when>
		<c:otherwise>
		<c:forEach var="shopAllGoods" items="${requestScope.shopAllGoods}">
       <li><a href="GoodsServlet?action=showSingleGoods&goodsId=${shopAllGoods.goodsId}&showType=all">
       <img src="${shopAllGoods.goodsPictureMax}" alt="店铺其他商品"/></a></li>	
        </c:forEach>	
        </c:otherwise>	
        </c:choose>    
            </ul>	
            <div class="shop_information left">
                <img src="${singleShop.shopMainImages}" class="left" alt="店铺头像"/>
                <ul class="left">
                    <li>店铺名称：<span>${singleShop.shopNickName}</span></li>
                    <a href><li>店铺地址：<span>${singleShop.shopAddress}</span></li></a>
                    <li>距您距离：<span>3.5公里</span></li>
                    <li><a href="ShopServlet?action=showSingleShop&shopId=${singleShop.shopId}&showType=all" >进店逛逛</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--清楚浮动，添加空白-->
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
     var adress=document.getElementById("adress");
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
