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
        <a href="">查询用户</a>
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
        <tr class="title" >
            <td class="choose">选择</td>
            <td>用户名</td>
            <td>密码</td>
            <td>昵称</td>
            <td>邮箱</td>
            <td>电话</td>
            <td>注册时间</td>
            <td class="opera">更多操作</td>
        </tr>
        
       
        <c:choose>
         <c:when test="${empty requestScope.allUserList}">
        <tr height="100">
				<td>	<p style="color:red;font-size:17px;">无用户！</p>
				</td></tr>
       </c:when>
        <c:otherwise>
        <c:forEach var="allUserList"
					items="${requestScope.allUserList}">
        <tr  style="height:40px;">
            <td><input type="checkbox"/></td>
            <td>${allUserList.userName}</td>
            <td>${allUserList.userPassword}</td>
            <td>${allUserList.userNickName}</td>
            <td>${allUserList.userEmail}</td>
            <td>${allUserList.userPhone}</td>
            <td>${allUserList.userAddTime}</td>
            <td class="opera">
                <a href="editor-user.html">编辑</a>
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