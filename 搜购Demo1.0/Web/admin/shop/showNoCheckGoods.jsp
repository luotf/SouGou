<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  errorPage="error.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head lang="en">
<base href="<%=basePath%>">
<title></title>
<link rel="stylesheet" href="<%=path%>/css/shop-admin/all-class.css" />
<script src="<%=path%>/js/jquery-3.1.1.min.js" language="JavaScript"
	type="text/javascript" charset="gbk"></script>
<script src="<%=path%>/js/all-goods.js" language="JavaScript"
	type="text/javascript" charset="gbk"></script>
<script src="<%=path%>/js/zeroModal.js"></script>
<link rel="stylesheet" href="<%=path%>/css/zeroModal.css" />
</head>
<body>
	<!--显示商品信息-->
	<div class="title">
		<p></p>
		<p>商品编号</p>
		<p>商品名称</p>
		<p>商品类型</p>
		<p>发布时间</p>
		<p>商品状态</p>
		<p>更多操作</p>
	</div>
	<div class="show-goods">
		<!--一条商品的信息-->
		<c:choose>
			<c:when test="${ empty requestScope.shopNoCheckGoodsList }">
				<tr height="100">
					<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的未审核商品为空！</p>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="shopNoCheckGoodsList"
					items="${requestScope.shopNoCheckGoodsList}">
					<p>
						<span class="goods-picture"><img
							src="${shopNoCheckGoodsList.goodsPictureMax}" alt="图片" /></span> <span
							class="goods-id" style="width:10%;">${shopNoCheckGoodsList.goodsId}</span>
						<span class="goods-title"><a
							href="GoodsServlet?action=showSingleGoods&goodsId=${shopNoCheckGoodsList.goodsId}&showType=show">${shopNoCheckGoodsList.goodsName}</a></span>
						<c:choose>
							<c:when test="${shopNoCheckGoodsList.isNew_Vip_KillGoods==0}">
								<span class="goods-type">普通商品</span>
							</c:when>
							<c:when test="${shopNoCheckGoodsList.isNew_Vip_KillGoods==1}">
								<span class="goods-type">上新商品</span>
							</c:when>
							<c:when test="${shopNoCheckGoodsList.isNew_Vip_KillGoods==2}">
								<span class="goods-type">折扣商品</span>
							</c:when>
							<c:when test="${shopNoCheckGoodsList.isNew_Vip_KillGoods==3}">
								<span class="goods-type">秒杀商品</span>
							</c:when>
						</c:choose>

						<span class="goods-time">${shopNoCheckGoodsList.goodsAddTime}</span>
						<span class="goods-type" style="color:red"> 未审核</span> <span
							class="goods-opera"> <a
							href="GoodsServlet?action=showSingleGoods&goodsId=${shopNoCheckGoodsList.goodsId}&showType=modify">编辑</a>
							<a
							href="javascript:zeroModal.confirm('确定下架吗？', function() {window.location='GoodsServlet?action=deleteGoods&goodsId=${shopNoCheckGoodsList.goodsId}';})"
							class="editor">下架</a>
					</p>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>