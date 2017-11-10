<%@ page language="java" import="java.util.*,com.ltf.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page  errorPage="error.jsp" %>
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

<%
	GoodsBean singleGoods=(GoodsBean)request.getAttribute("singleGoods");
%>
<div class="content_box">
    <div class="content comwid">
        <!--清楚浮动，添加空白-->
       <span style="color:#ffffff;font-size:20px;width:  90px;padding:6px 9px;display:block;background:rgba(61, 170, 252, 0.77);margin-bottom:-57px;">商品详情</span>
        <div class="content_top">
            <div class="content_top_left left">
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
                <div class="buy clearfix" style="bottom: 263px;">
                  <p>商品分类</p><ul>               
                        <li style="background:rgba(61, 170, 252, 0.77);">服装</li>
                        </ul>
                        </div>
                        
                    <div class="buy clearfix" style="bottom: 203px;">
                  <p>商品价格</p><ul>               
                        <li style="background:rgba(61, 170, 252, 0.77);"><s>&yen;${singleGoods.goodsPrice}</s>
                        <span>-</span><span>&yen;${singleGoods.goodsVipPrice}</span>
                        </li>
                        </ul>
                        </div>
               
                <!--清楚浮动，添加空白-->
                <div class="blank"></div>
                               
                <div class="buy clearfix" style="bottom: 159px;">
                   <p>活动类型</p>
                   <ul>               
                        <li style="background:rgba(61, 170, 252, 0.77);"><c:choose>
			<c:when test="${singleGoods.isNew_Vip_KillGoods==0}">
					<span class="goods-type">普通商品</span>
			</c:when>
			<c:when test="${singleGoods.isNew_Vip_KillGoods==1}">
					<span class="goods-type">上新商品</span>
			</c:when>
			<c:when test="${singleGoods.isNew_Vip_KillGoods==2}">
					<span class="goods-type">折扣商品</span>
			</c:when>
			<c:when test="${singleGoods.isNew_Vip_KillGoods==3}">
					<span class="goods-type">秒杀商品</span>
			</c:when>
                  </c:choose></li>
                   </ul>
                   <p>库存</p>
                    <ul>
                        <li style="background:rgba(61, 170, 252, 0.77);"><span class="goods-type">有</span></li>
                    </ul>
                   </div> 
                <div class="buy clearfix">
                  <p>上传时间</p><ul>               
                        <li style="background:rgba(61, 170, 252, 0.77);">${singleGoods.goodsAddTime}</li>
                        </ul>
                        </div>
               
               
     
                <p class="login-header location"><i id="adress">${singleGoods.goodsAddress}</i><span style="color:red">(3.5km)</span><a href="javascript:void(0);" class="showMap" style="background:rgba(61, 170, 252, 0.77);" >查看地址</a></p>
    <div class="haddin">
        <div class="login">
        <div class="login-title">地图导航<span><a href="javascript:void(0);" class="close-login">关闭</a></span></div>
        <div id="allmap"></div> 
            </div>
        </div>
        </div>
        <div class="blank"></div>
       
        </div>
    </div>
</div>

<!--清楚浮动，添加空白-->
<div class="blank"></div>
<!--底部信息-->

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
