<%@ page language="java" import="java.util.*,com.ltf.tools.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
<base href="<%=basePath%>">
<title>搜购秒杀区</title>
<script src="<%=path %>/js/jquery-1.7.1.min.js"></script>
<script src="<%=path %>/js/Myjs.js"></script>
<link rel="stylesheet" href="<%=path %>/css/common.css" />
<link rel="stylesheet" href="<%=path %>/css/seckill.css" />
<link rel="stylesheet" href="<%=path %>/css/index.css" />
</head>
<body>
	<!--头部信息-->
	<jsp:include page="../view/frontTop.jsp"></jsp:include>
	<!--搜索栏目-->
	<nav>
		<div class="nav-left left">
			
		</div>
		<div class="nav-right left">
			<form action="#" method="get">
				<input type="search" name="" class="search"
					placeholder="请输入商品名称/商圈/店铺名称" />
				<button name="">搜附近</button>
			</form>
		</div>
	</nav>
	<div class="goods1 comwid clearfix">
		<!--秒杀区主页面-->
		<div class="content comwid">
			<div class="content_btn right">
				<span class="price left">按价格</span>
				<div class="price_btn left">
					<a href="#" class="a_fir">从低到高</a> <a href="#">从高到低</a>
				</div>
				<span class="price left">按距离</span>
				<div class="price_btn left">
					<a href="#">由近到远</a> <a href="#">由远到近</a>
				</div>
			</div>
			<!--清楚浮动，添加空白-->
			<div class="blank1"></div>
			<div class="hot_search comwid">
				<img src="images/hot_search.png" alt="热搜图片" />
			</div>
			<div class="goods_box1">
				<div class="content_sec">
					<!--具体的商品信息-->
					<c:choose>
						<c:when test="${ empty requestScope.allGoodslist }">
							<tr height="100">
								<td colspan="5" align="center">您的商品为空！</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="allGoodslist"
								items="${requestScope.allGoodslist}">
								<div class="up_new_list1 left">
									<img
										src="${allGoodslist.goodsPictureMax}" alt="衣服图片" />
										<p>&yen;${allGoodslist.goodsPrice}</p> <p><a
										href="GoodsServlet?action=showSingleGoods&goodsId=${allGoodslist.goodsId}&showType=all "><i>${allGoodslist.goodsName}</i></a></p><br>
									<span class="location">${allGoodslist.goodsAddress}<span
										style="color:red">(350m)</span></span>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
				 
		</div>
		
		
		<div style="margin-bottom:1px;"><%
 	MyPage myPage=(MyPage)request.getSession().getAttribute("page");
	String isNew_Vip_KillGoods=request.getParameter("isNew_Vip_KillGoods");
 	%>
	<%=myPage.printCtrl
	(Integer.parseInt(request.getAttribute("Page").toString()),
			"GoodsServlet?action="+request.getAttribute("url"),"&goodsTypeId=0&isNew_Vip_KillGoods="+isNew_Vip_KillGoods)%>
			</div>
		</div>
	</div>
	<!--清楚浮动，添加空白-->
	<div class="blank"></div>
	<!--底部信息-->
	<jsp:include page="../view/frontEnd.jsp"></jsp:include>
</body>
</html>