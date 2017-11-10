<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>主页-搜购</title>
<link rel="shortcuticon" href="images/icon/favicon.ico"
	type="image/x-icon" />
<script src="<%=path%>/js/jquery-1.7.1.min.js"></script>
<script src="<%=path%>/js/jquery.slideBox.js"></script>
<script src="<%=path%>/js/index.js"></script>
<script src="<%=path%>/js/jquery.cityselect.js"></script>
<script src="<%=path%>/js/city.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/jquery.slideBox.css" />
<link rel="stylesheet" href="<%=path%>/css/index.css" />
<link rel="stylesheet" href="<%=path%>/css/common.css" />
<link rel="stylesheet" href="<%=path%>/css/normalize.css" />
<style type="text/css">
#mydiv {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -50;
}

.mouseOver {
	background: rgba(158, 158, 158, 0.23);
	color: #000;
}

.mouseOut {
	background: #FFFAFA;
}

#popDiv {
	z-index: 999;
}

#content_table tr {
	color: #908a8a;
}

#content_table td {
	padding-left: 4%;
	font-size: 14px;
	height: 25px;
}
</style>
<script>
	jQuery(function($) {
		$('#banner').slideBox({
			duration : 0.3,//滚动持续时间，单位：秒
			easing : 'linear',//swing,linear//滚动特效
			delay : 5,//滚动延迟时间，单位：秒
			hideClickBar : false,//不自动隐藏点选按键
			clickBarRadius : 10
		});
	});

	jQuery(function($) {
		$("#citySelect").citySelect({
			nodata : "none",
			required : false,
		});
		$(".change").on('click', function() {
			$('#citySelect').css({
				display : 'block'
			})
		})
	});
	
	var xmlHttp;
		//获取用户输入内容的关联信息的函数
		function getMoreContents(){
		var content = document.getElementById("keyword");
		if(content.value==""){
			clearContent();
			return;
		}
		//给服务器发送用户输入的内容，采用的是ajax异步发送数据，所以要使用XmlHttp对象。
		xmlHttp = createXmlHttp();
		var url = "GoodsServlet?action=showKeyWordsGoods&keyword="+content.value; 
		xmlHttp.open("GET",url,true)
		xmlHttp.onreadystatechange=callback;
		xmlHttp.send(null);
	  	}
	  	function createXmlHttp(){
	  	  	var xmlHttp;
	  	  	if(window.XMLHttpRequest){
	  	  		xmlHttp = new XMLHttpRequest();
	  	  	}
	  	  	if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			if(!xmlHttp){
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
	  	  	}
	  	  	return xmlHttp;
	  	}
	  	function callback(){
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){	
				var result = xmlHttp.responseText;
				var json = eval("("+result+")")
				setContent(json);
			}
		}
	  	}
	  	function setContent(contents){
	  		clearContent();
	  	  	//设定位置
	  	  	setLocation();
	  		var size = contents.length;
	  		if(size>12)
	  			size=12;
	  		//设置内容
	  		for(var i=0;i<size;i++){
	  	  		var nextNode = contents[i].goodsName;//代表json格式的第i个元素
	  	  		var tr = document.createElement("tr");
	  	  		var td = document.createElement("td");
	  	  		td.setAttribute("border","0");
	  	  		td.setAttribute("bgcolor","#FFFAFA");
	  	  		td.onmouseover = function(){
				this.className = 'mouseOver';
	  	  	  	}
	  	  	  	td.onmouseout = function(){
				this.className = 'mouseOut';
	  	  	  	}
	  	  	  	
	  	  	td.onclick = function(){ 
	  	  	document.getElementById("keyword").value =this.innerText;  
			      
			   }; 
			   td.onmousedown = function(){ 
			   //当鼠标点击一个关联数据时，自动在输入框添加数据 
			   
			   document.getElementById("keyword").value =this.innerText; 
			   var value=this.innerText;
			   //alert(value);
			   setTimeout(function(){
				   window.location.href= "GoodsServlet?action=showKeyWordsGoodsList&keyword="+value;
			   },0); 
			   }; 
			   //鼠标悬浮于关联数据上时，自动添加到输入框中 
			   /*  td.onmouseover = function(){ 
			   this.className = 'mouseOver'; 
			   if(td.innerText != null) 
			   document.getElementById("keyword").value =this.innerText; 
			 } */
	  	  	  	var text = document.createTextNode(nextNode); 
	  	  	  	td.appendChild(text);
	  	  	  	tr.appendChild(td);
	  	  	  	document.getElementById("content_table_body").appendChild(tr);	
	  	  	}
	  	  	
	  	}

	  	//清除数据
	  	function clearContent(){
		var contentTableBody = document.getElementById("content_table_body");
		var size = contentTableBody.childNodes.length;
		for(var i=size-1;i>=0;i--){
			contentTableBody.removeChild(contentTableBody.childNodes[i]);
		}
		document.getElementById("popDiv").style.border = "none";
	  	}
	  	//输入框失去焦点
	  	function keywordBlur(){
	  		clearContent();
	  	}
	  	//设置显示数据信息的位置
	  	function setLocation(){
		var content = document.getElementById("keyword");
		var width = content.offsetWidth;//输入框的宽度
		var left = content["offsetLeft"];//距离左边框的距离
		var top = content["offsetTop"]+content.offsetHeight;//距离顶部的距离
		//获得显示数据的Div
		var popDiv = document.getElementById("popDiv");
		popDiv.style.left = left+"px";
		popDiv.style.position="absolute";
		popDiv.style.top = top + "px";
		popDiv.style.width = width; 
		var content_table=document.getElementById("content_table");  			
		content_table.style.width = width+"px";
		
	  	}
	  	
	  	function getKeyList(){
	  		var con=document.getElementById("keyword");
	  		var value=con.value;
	
	  		 setTimeout(function(){
				   window.location.href= "GoodsServlet?action=showKeyWordsGoodsList&keyword="+value;
			   },0); 
	  	}
	</script>
</head>
<body>
	<%
	UserBean user=(UserBean)request.getSession().getAttribute("user");
%>
	<!--头部信息-->
	<jsp:include page="../front/view/frontTop.jsp"></jsp:include>
	<!--搜索栏目-->
	<nav class="comwid">
		<div class="nav-left left">
			<span class="left">您当前的位置：<strong id="loca-city">成都市</strong></span>
			<span class="change left">[<a href="#">切换城市</a>]
			</span><br> <br>
			<div id="citySelect">
				<select class="prov" id="province"></select> <select class="city"
					disabled="disabled" id="city"></select> <select class="dist"
					disabled="disabled" id="county"></select>
			</div>
		</div>
		<div class="nav-right left">
			<form action="#" method="get">
				<input style="position:relative" autocomplete="off" type="search"
					name="" class="search" id="keyword" onkeyup="getMoreContents()"
					onblur="keywordBlur()" onfocus="getMoreContents()"
					placeholder="请输入商品名称/商圈/店铺名称" />
				<button id="sou" onclick="getKeyList()" >搜附近</button>
				<div id="popDiv">
					<table id="content_table" bgcolor="#FFFAFA" border="0"
						cellspacing="0" cellpadding="0">
						<tbody id="content_table_body">
						</tbody>
					</table>
				</div>
			</form>
		</div>
	</nav>
	<!--广告、列表-->
	<div class="bannerbox comwid">
		<div class="banner_left">
			<div class="type list">
				<h2>服装</h2>
				<ul>
					<li><a href="InitServlet?goodsTypeId=1">男装</a></li>
					<li><a href="InitServlet?goodsTypeId=2">女装</a></li>
					<li><a href="InitServlet?goodsTypeId=3">鞋靴</a></li>
					<li><a href="#">童装</a></li>
					<li><a href="#">美妆</a></li>
					<li><a href="#">洗护</a></li>
					<li><a href="#">户外</a></li>
					<li><a href="#">箱包</a></li>
					<li><a href="#">配件</a></li>
					<li><a href="#">孕产</a></li>
				</ul>
			</div>
			<div class="nation list">
				<h2>超市</h2>
				<ul>
					<li><a href="#">零食</a></li>
					<li><a href="#">家具</a></li>
					<li><a href="#">熟食</a></li>
					<li><a href="#">生鲜</a></li>
					<li><a href="#">家电</a></li>
					<li><a href="#">数码</a></li>
					<li><a href="#">手机</a></li>
					<li><a href="#">珠宝</a></li>
					<li><a href="#">保健品</a></li>
					<li><a href="#">手表</a></li>
					<li><a href="#">眼镜</a></li>
					<li><a href="#">办公</a></li>
				</ul>
			</div>
			<div class="nameplate list">
				<h2>场所</h2>
				<ul>
					<li><a href="#">营业厅</a></li>
					<li><a href="#">歌舞厅</a></li>
					<li><a href="#">网吧</a></li>
					<li><a href="#">影城</a></li>
				</ul>
			</div>
		</div>
		<div id="banner" class="slideBox">
			<ul class="items">
				<li><a href="#" title="活动促销一"><img src="images/A1.jpg"></a></li>
				<li><a href="#" title="活动促销二"><img src="images/A2.jpg"></a></li>
				<li><a href="#" title="活动促销三"><img src="images/A3.jpg"></a></li>
				<li><a href="#" title="活动促销四"><img src="images/A4.jpg"></a></li>
			</ul>
		</div>
		<div class="banner_right">
			<c:choose>
				<c:when test="${ empty sessionScope.user }">
					<div class="banner_right_top">
						<img class="" src="images/A1.jpg" alt="img"
							style="width:100%;height: 120px;" /> </a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="banner_right_top">
						<a href="">
							<p>${user.userNickName}</p> <img class="tou"
							src="${user.userImages}" alt="img" />
						</a>
						<div class="qiandao">
							<img src="images/qiandao.png" alt="" /> <span><a href="#">签到</a></span>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="clearfix"></div>
			<hr />
			<div class="banner_right_middle">
				<a href="#">秒杀篮</a> <a href="#">预定篮</a> <a href="#">我的主页</a>
			</div>
			<div class="clearfix"></div>
			<hr />
			<div class="banner_right_bottom">
				<h1>爱好推荐&gt;</h1>
				<div class="clearfix"></div>
				<a href=""><img src="images/like1.png" alt="" /></a> <a href=""><img
					src="images/like2.png" alt="" /> </a> <a href=""><img
					src="images/like3.png" alt="" /> </a> <a href=""><img
					src="images/like4.png" alt="" /></a>
			</div>
		</div>
	</div>
	<!--清楚浮动，添加空白-->
	<div class="blank"></div>
	<!--上新、秒杀-->
	<div class="goods comwid clearfix">

		<div class="hot_search comwid">
			<img src="images/hot_search.png" alt="热搜图片" />
		</div>

		<!--上新区-->
		<div class="up_new goods_box">
			<div class="up_new_title">
				<span>上新区</span> <a
					href="GoodsServlet?action=showAllGoods&isNew_Vip_KillGoods=1&goodsTypeId=-1">去上新页&gt;</a>
			</div>
			<%
				request.setAttribute("name", "上新区");
			%>
			<!--具体的商品信息-->
			<c:choose>
				<c:when test="${ empty sessionScope.showNewGoods }">
					<tr height="100">
						<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的上新商品为空！</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="showNewGoods" items="${sessionScope.showNewGoods}">
						<!--具体上新的商品信息-->
						<div class="up_new_list left">
							<img src="${showNewGoods.goodsPictureMax}" alt="衣服图片" />
							<p>&yen;${showNewGoods.goodsPrice}</p>
							<a
								href="GoodsServlet?action=showSingleGoods&goodsId=${showNewGoods.goodsId}&showType=all "><i>${showNewGoods.goodsName}</i></a><br>
							<span class="location">${showNewGoods.goodsAddress}</span>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<!--秒杀区-->
		<div class="goods_box second_kill">
			<div class="up_new_title">
				<span>秒杀区</span> <a
					href="GoodsServlet?action=showAllGoods&isNew_Vip_KillGoods=3&goodsTypeId=-1">去秒杀页&gt;</a>
			</div>
			<%
				request.setAttribute("name", "秒杀区");
			%>
			<!--倒计时-->
			<div class="count_down">
				<p>距离女王节秒杀活动开始还有：</p>
				<span class="cd_span" id="cd_span1"></span> <span class="cd_span">天</span>
				<span class="cd_span" id="cd_span2"></span> <span class="cd_span">时</span>
				<span class="cd_span" id="cd_span3"></span> <span class="cd_span">分</span>
				<span class="cd_span" id="cd_span4"></span> <span class="cd_span">秒</span>
			</div>
			<c:choose>
				<c:when test="${ empty sessionScope.showKillGoods }">
					<tr height="100">
						<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的秒杀商品为空！</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="showKillGoods"
						items="${sessionScope.showKillGoods}">
						<!--具体秒杀的商品信息-->
						<div class="up_new_list left">
							<img src="${showKillGoods.goodsPictureMax}" alt="衣服图片" />
							<p>&yen;${showKillGoods.goodsPrice}</p>
							<a
								href="GoodsServlet?action=showSingleGoods&goodsId=${showKillGoods.goodsId}&showType=all "><i>${showKillGoods.goodsName}</i></a><br>
							<span class="location">${showKillGoods.goodsAddress}</span>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<!--折扣区-->
		<div class="goods_box">
			<div class="up_new_title">
				<span>折扣区</span><a
					href="GoodsServlet?action=showAllGoods&isNew_Vip_KillGoods=2&goodsTypeId=-1">去折扣页&gt;</a>
			</div>
			<%
				request.setAttribute("name", "折扣区");
			%>
			<!--具体打折的商品信息-->
			<c:choose>
				<c:when test="${ empty sessionScope.showVipGoods }">
					<tr height="100">
						<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的折扣商品为空！</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="showVipGoods" items="${sessionScope.showVipGoods}">
						<!--具体秒杀的商品信息-->
						<div class="up_new_list left">
							<img src="${showVipGoods.goodsPictureMax}" alt="衣服图片" />
							<p>&yen;${showVipGoods.goodsPrice}</p>
							<a
								href="GoodsServlet?action=showSingleGoods&goodsId=${showVipGoods.goodsId}&showType=all "><i>${showVipGoods.goodsName}</i></a><br>
							<span class="location">${showVipGoods.goodsAddress}</span>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="normal">
			<div class="up_normal_title">
				<span>普通区</span> <a
					href="GoodsServlet?action=showAllGoods&isNew_Vip_KillGoods=0&goodsTypeId=-1">去普通页&gt;</a>
			</div>
			<%
				request.setAttribute("name", "普通区");
			%>
			<c:choose>
				<c:when test="${ empty sessionScope.showCommonGoods }">
					<tr height="100">
						<td colspan="5" align="center">您的商品为空！</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="showComGoods"
						items="${sessionScope.showCommonGoods}">
						<div class="up_normal_list left">
							<img src="${showComGoods.goodsPictureMax}" alt="衣服图片" />
							<p>&yen;${showComGoods.goodsPrice}</p>
							<a
								href="GoodsServlet?action=showSingleGoods&goodsId=${showComGoods.goodsId}&showType=all "><i>${showComGoods.goodsName}</i></a><br>
							<span class="location">${showComGoods.goodsAddress}</span>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!--清楚浮动，添加空白-->
	<div class="blank"></div>
	<!--底部信息-->
	<jsp:include page="../front/view/frontEnd.jsp"></jsp:include>
	</div>
</body>
</html>
