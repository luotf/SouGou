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
            <td>商品类型</td>
            <td>店铺名称</td>
            <td>店长</td>
            <td>提交时间</td>
            <td>状态</td>
            <td class="opera">更多操作</td>
        </tr>
        <c:choose>
         <c:when test="${empty requestScope.allCheckGoodsList}">
        <tr height="100">
				<td>	<p style="color:red;font-size:17px;">未审核店铺为空！</p>
				</td></tr>
       </c:when>
        <c:otherwise>
        <c:forEach var="allCheckGoodsList"
					items="${requestScope.allCheckGoodsList}">
        
        <tr>
            <td class="choose"><input type="checkbox"/></td>
            <td><img src="${allCheckGoodsList.goodsPictureMax}" alt=""/></td>
            <td>${allCheckGoodsList.goodsId}</td>
            <td>${allCheckGoodsList.goodsName}</td>
            <td>上新</td>
            <td>海澜之家</td>
            <td>张三</td>
            <td>${allCheckGoodsList.goodsAddTime}</td>
            <td>待审核</td>
            <td class="opera">
                <a href="">编辑</a>
                <a href="GoodsServlet?action=checkGoods&goodsId=${allCheckGoodsList.goodsId}">通过</a>
                <a href="">不通过</a>
            </td>
        </tr>
        </c:forEach>
        </c:otherwise>
        </c:choose>
    </table>
</div>
</body>
</html>