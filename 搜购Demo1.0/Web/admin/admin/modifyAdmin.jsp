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
    <link rel="stylesheet" href="<%=path %>/css/user/user-index.css"/>
    <link rel="stylesheet" href="<%=path %>/css/normalize.css"/>
    <script src="<%=path %>/js/jquery-1.7.1.min.js"></script>
    <script src="<%=path %>/js/jquery.cityselect.js"></script>
    <script src="<%=path %>/js/city.min.js"></script>
    <script>
        $(".main .content #citySelect").citySelect({
            nodata: "none",
            required: false,
        });
    </script>
</head>
<body>

<!--个人主页信息-->
<div class="main comwid" style="margin-top: 10px;">
    <div class="content left" style="border: none;">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;亲爱的管理员，这是你的个人基本资料</p>
        <hr/>
        <div class="message">
            <p>
                <span class="left">当前头像:</span>
                <img src="images/touxiang.png" alt="头像"/>
            </p>
            <p>
                <span>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</span>
                <input type="text" value="${sessionScope.admin.adminNickName}" class="input" placeholder="管理员" /><br>
            </p>
            <p>
                <span>管理员编号:</span>
                <input type="text" value="${sessionScope.admin.adminId}" placeholder="001" class="input" />
            </p>
            <p>
                <span>电&nbsp;话&nbsp;号&nbsp;码:</span>
                <input type="text" value="${sessionScope.admin.adminPhone}" maxlength="20" size="20" class="input" placeholder="李四" />
            </p>
           
            <p>
                <span>注&nbsp;册&nbsp;时&nbsp;间:</span>
                <input type="text" value="${sessionScope.admin.adminAddTime}"  placeholder="2017-05-17 15:23:02" class="input" />
            </p>
            <p>
                <a href="" class="save">保存</a>
            </p>
        </div>
    </div>
</div>






</body>
</html>