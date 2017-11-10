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
	type="text/javascript" ></script>
<script src="<%=path%>/js/all-goods.js" language="JavaScript"
	type="text/javascript" ></script>
<script src="<%=path%>/js/zeroModal.js"></script>
<link rel="stylesheet" href="<%=path%>/css/zeroModal.css" />

<style>
       .div{
            width: 151px;
            height: 110px;
            background-color:rgba(0, 188, 212, 0.64);
            color: white;
            line-height: 99px;
            text-align: center;
            position: absolute;
            top: 35%;
            left: 45%;
            opacity: 0;
            border-radius: 5px;
        }
    </style>
<script type="text/javascript">
	function createRequest(url) {
		
		http_request = false;
		if (window.XMLHttpRequest) { // 非IE浏览器
		http_request = new XMLHttpRequest(); //创建XMLHttpRequest对象
		} else if (window.ActiveXObject) { // IE浏览器
			try {
		http_request = new ActiveXObject("Msxml2.XMLHTTP"); //创建XMLHttpRequest对象
			} catch (e) {
				try {
	http_request = new ActiveXObject("Microsoft.XMLHTTP"); //创建XMLHttpRequest对象
				} catch (e) {
				}
			}
		}
		if (!http_request) {
			alert("不能创建XMLHttpRequest对象实例！");
			return false;
		}
	http_request.onreadystatechange = getResult; //调用返回结果处理函数
	
		http_request.open('POST', url, true); //创建与服务器的连接
		http_request.send(null); //向服务器发送请求
	}
	function getResult() {
		if (http_request.readyState == 4) { // 判断请求状态
			
			
			if (http_request.status == 200) { // 请求成功，开始处理返回结果
				show();
				setTimeout(aa,1000); 
				function aa(){
					window.location.href= http_request.responseText;
				}
			} else { // 请求页面有错误
				alert("您所请求的页面有错误！");
			}
		}
	}
	
	function show(){
		var box=$('.div')
        box.animate({
            opacity:'1',
            width:'151px',
            height:'110px'
        },1000)
        box.animate({
            opacity:'0'
        },1000)
        box.animate({
            top:'35%'
        },10)
    }
function deleteGoods(url) {
		createRequest(url);
	}
</script>

</head>

<body>
	<!--显示商品信息-->
	<div class="div" style="">操作成功</div>
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
			<c:when test="${ empty requestScope.singleShopSoldGoodsList }">
				<tr height="100">
					<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">您的下架商品为空！</p>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="singleShopSoldGoodsList"
					items="${requestScope.singleShopSoldGoodsList}">
					<p>
						<span class="goods-picture"><img
							src="${singleShopSoldGoodsList.goodsPictureMax}" alt="图片" /></span> <span
							class="goods-id" style="width:10%;">${singleShopSoldGoodsList.goodsId}</span>
						<span class="goods-title"><a
							href="GoodsServlet?action=showSingleGoods&goodsId=${singleShopSoldGoodsList.goodsId}&showType=show">${singleShopSoldGoodsList.goodsName}</a></span>
						<c:choose>
							<c:when test="${singleShopSoldGoodsList.isNew_Vip_KillGoods==0}">
								<span class="goods-type">普通商品</span>
							</c:when>
							<c:when test="${singleShopSoldGoodsList.isNew_Vip_KillGoods==1}">
								<span class="goods-type">上新商品</span>
							</c:when>
							<c:when test="${singleShopSoldGoodsList.isNew_Vip_KillGoods==2}">
								<span class="goods-type">折扣商品</span>
							</c:when>
							<c:when test="${singleShopSoldGoodsList.isNew_Vip_KillGoods==3}">
								<span class="goods-type">秒杀商品</span>
							</c:when>
						</c:choose>

						<span class="goods-time">${singleShopSoldGoodsList.goodsAddTime}</span>
						<span class="goods-type" style="color:red">已下架</span> <span
							class="goods-opera"> 
							<a href="GoodsServlet?action=showSingleGoods&goodsId=${singleShopSoldGoodsList.goodsId}&showType=show">查看</a>
							<a
							href="GoodsServlet?action=showSingleGoods&goodsId=${singleShopSoldGoodsList.goodsId}&showType=modify">编辑</a>		
							<a
							href="javascript:zeroModal.confirm('确定上架吗？', function() 
							{
							deleteGoods('GoodsServlet?action=putAwayGoods&goodsId=${singleShopSoldGoodsList.goodsId}&shopId=${sessionScope.shop.shopId}');
							})"
							class="editor">上架</a>
					</p>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>