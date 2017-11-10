<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page  errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head lang="en">
   <base href="<%=basePath%>">
    <title>装修店铺</title>
    <link rel="stylesheet" href="<%=path %>/css/shop-admin/add-goods.css"/>
    <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path %>/js/shop-admin.js"></script>
</head>
<body>
<%
	ShopBean singleShop=(ShopBean)request.getSession().getAttribute("singleShop");
%>
<div class="main">
    <p class="title">装修店铺</p>
    <div class="add-message">
        <p>编辑店铺信息</p>
        <form action="" method="post" enctype="multipart/form-data">
            <p>
                <span>店铺名称</span>
                <input type="text" value="${singleShop.shopNickName}" placeholder="不能多于20个字" size="80" maxlength="20"  class="input"/>
            </p>
            <p>
                <span>店长姓名</span>
                <input type="text" value="${singleShop.shopManager}" class="input price" size="15"/>
            </p>
            <p>
                <span>店铺电话</span>
                <input type="text" value="${singleShop.shopPhone}" class="input price" size="15"/>
            </p>
            <p>
                <span>商品简介</span>
                <input type="text" value="${singleShop.shopIntroduce}" placeholder="不能多于100个字" size="80" maxlength="40" class="input jianjie"/>
            </p>
            <p>
                <span>商品地址</span>
                <input type="text" value="${singleShop.shopAddress}"  placeholder="不能多于100个字" size="80" maxlength="40" class="input"/>
            </p>
            <p>
                <span>店铺运营</span>
                <input type="radio" name="inventory" checked/>开店
                <input type="radio" name="inventory"/>关店
            </p>
        </form>
        <form action="ShopServlet?action=modifyShop" class="form1">
            实体店店铺图片：
            <input type="file" id="file1" onchange="uploading1(this)"/>
            <div class="add-img-box">
                <div class="box">
                    <div class="add-img" id="add-img1"><img src="${singleShop.shopMainImages}" id="add1"></div>
                    <p><label for="file1">上传图片</label></p>
                </div>
            </div>
        </form>
    </div>
      <input type="submit" class="publish" value="保存店铺">
   
</div>
<script>
    function uploading1(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("add1");
            img.src = e.target.result;
            //或者 img.src = this.result;  //e.target == this
        }
        reader.readAsDataURL(file);
    }
</script>
</body>
</html>