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
        <a href="">编辑信息</a>
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
            <td>用户名</td>
            <td>密码</td>
            <td>昵称</td>
            <td>邮箱</td>
            <td>电话</td>
            <td>注册时间</td>
            <td class="opera">更多操作</td>
        </tr>
        <tr>
            <td><input type="checkbox"/></td>
            <td><input type="text" value="111"/></td>
            <td><input type="text" value="123456"/></td>
            <td><input type="text" value="哈哈"/></td>
            <td><input type="email" value="894653@qq.com"/></td>
            <td><input type="tel" value="13569856214"/></td>
            <td><input type="text" value="2017-05-12"/></td>
            <td class="opera">
                <a href="">保存</a>
                <a href="">删除</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>