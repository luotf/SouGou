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
        <a href="">查看所有店铺</a>
    </p>
</div>

<!--搜索-->
<div class="search">
    搜索查询:
    <input type="search"/>
    <a href="">查询</a>
</div>

<!--显示所有店铺-->
<div class="show-shop">
    <table>
        <tr class="title">
            <td class="choose">选择</td>
            <td>店铺实体图</td>
            <td>店铺编号</td>
            <td>店铺名称</td>
            <td>店铺地址</td>
            <td>电话</td>
            <td>注册时间</td>
            <td class="opera">更多操作</td>
        </tr>
        <c:choose>
        <c:when test="${empty requestScope.allShopList}">
        <tr height="100">
					<td><p style="margin:5px 3px 1px 17px;color:red;font-size:17px;">店铺为空！</p>
				</td></tr>
       </c:when>
        <c:otherwise>
        <c:forEach var="allShopList"
					items="${requestScope.allShopList}">
         <tr>
         <td class="choose"><input type="checkbox"/></td>
            <td><img src="${allShopList.shopMainImages}" alt=""/></td>
            <td>${allShopList.shopId}</td>
            <td>${allShopList.shopNickName}</td>
            <td>${allShopList.shopAddress}</td>
            <td>${allShopList.shopPhone}</td>
            <td>${allShopList.shopAddTime}</td>
            <td class="opera">
                <a href="">编辑</a>
                <a href="">删除</a>
            </td>
        
        </tr>
        </c:forEach>
        </c:otherwise>
       
        </c:choose>
       
    </table>
</div>
</body>
</html>