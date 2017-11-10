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
    <title></title>
    <link rel="stylesheet" href="<%=path %>/css/common.css"/>
    <link rel="stylesheet" href="<%=path %>/css/admin/all-shop.css"/>
   
</head>
<body>
<div class="way">
    <p>
        <span>您当前的位置：</span>
        <a href="">管理员&nbsp;>>&nbsp;</a>
        <a href="">查看所有商品</a>
    </p>
</div>

<!--搜索-->
<div class="search">
    搜索查询:
    <input type="search"/>
    <a href="">查询</a>
</div>

<!--显示所有商品-->
<div class="show-shop">
    <table>
        <tr class="title">
            <td class="choose">选择</td>
            <td>商品主图</td>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>商品类别</td>
            <td>活动类型</td>
            <td>店铺名称</td>
            <td>提交时间</td>
            <td class="opera">更多操作</td>
        </tr>
        
         <c:choose>
         <c:when test="${empty requestScope.allGoodslist}">
        <tr height="100">
				<td>	<p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">商品为空！</p>
				</td></tr>
       </c:when>
        <c:otherwise>
        <c:forEach var="allGoodslist"
					items="${requestScope.allGoodslist}">
        <tr>
            <td class="choose"><input type="checkbox"/></td>
            <td><img src="${allGoodslist.goodsPictureMax}" alt=""/></td>
            <td>${allGoodslist.goodsId}</td>
            <td>${allGoodslist.goodsName}</td>
            <c:choose>
							<c:when test="${allGoodslist.goodsTypeId==1}">
								 <td>男装</td>
							</c:when>
							
							<c:when test="${allGoodslist.goodsTypeId==2}">
								
								<td>女装</td>
							</c:when>
							<c:when test="${allGoodslist.goodsTypeId==3}">
								
								<td>鞋靴</td>
							</c:when>
						</c:choose>
            
            <c:choose>
							<c:when test="${allGoodslist.isNew_Vip_KillGoods==0}">
								 <td>普通商品</td>
							</c:when>
							<c:when test="${allGoodslist.isNew_Vip_KillGoods==1}">
								
								<td>上新商品</td>
							</c:when>
							<c:when test="${allGoodslist.isNew_Vip_KillGoods==2}">
								
								<td>折扣商品</td>
							</c:when>
							<c:when test="${allGoodslist.isNew_Vip_KillGoods==3}">
								
								<td>秒杀商品</td>
							</c:when>
						</c:choose>
           <c:choose>
							<c:when test="${allGoodslist.shopId==1}">
								 <td>店铺名称1</td>
							</c:when>
							<c:when test="${allGoodslist.shopId==2}">
								
								<td>店铺名称2</td>
							</c:when>
							<c:when test="${allGoodslist.shopId==3}">
								
								<td>店铺名称3</td>
							</c:when>
							
							
						</c:choose>
           
            <td>${allGoodslist.goodsAddTime}</td>
            <td class="opera">
                <a href="">编辑</a>
                <a href="">删除</a>
                <a href="">下架</a>
            </td>
        </tr>
        </c:forEach>
        </c:otherwise>
        </c:choose>
        
        
    </table>
    <%
 	MyPage myPage=(MyPage)request.getSession().getAttribute("page");
  
 	%>
	<%=myPage.printCtrl
	(Integer.parseInt(request.getAttribute("Page").toString()),
			"GoodsServlet?action="+request.getAttribute("url"),"&goodsTypeId=0&isNew_Vip_KillGoods=-1&type=1")%>
</div>
</body>
</html>
