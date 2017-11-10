<%@ page language="java" import="java.util.*,com.ltf.vo.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page  errorPage="error.jsp" %>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="<%=basePath%>">
    <title>错误页面</title>
     <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
	<link rel="stylesheet" href="<%=path %>/css/common.css"/>
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/error.css"  media="screen" />
</head>
<body>
<!--头部信息-->


<div id="da-wrapper" class="fluid">
        <div id="da-content">
            <div class="da-container clearfix">
            	<div id="da-error-wrapper">
                   	<div id="da-error-pin"></div>
                    <div id="da-error-code">
                    	error <span>404</span>
                    </div>
                	<h1 class="da-error-heading">您访问的页面出错了.....</h1>
                    <p>亲可以看看其他地方哦！ <a href="../index.jsp" target="_blank">进入首页</a></p>
                </div>
            </div>
        </div>

    </div>

</body>
</html>
