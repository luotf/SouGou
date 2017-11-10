<%@ page language="java" import="java.util.*,com.ltf.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
   <base href="<%=basePath%>">
    <title>增加商品</title>
    <link rel="stylesheet" href="<%=path %>/css/shop-admin/add-goods.css"/>
    <script src="<%=path %>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=path %>/js/shop-admin.js"></script>
    <script src="<%=path %>/js/jquery.select.js"></script>
   
</head>
<body>
<div class="main">
    <p class="title">添加商品信息</p>
    <div class="add-message">
        <p>填写商品基本信息</p>
        <form action="GoodsServlet?action=addGoods" method="post" enctype="multipart/form-data">
            <p>
                <input type="hidden" name="shopId" value="${sessionScope.shop.shopId}"/>
            </p>
            <p>
                <span>商品标题</span>
                <input type="text" name="goodsName" placeholder="不能多于20个字" size="40" maxlength="40" class="input"/>
            </p>
            <p>
                <span>商品简介</span>
                <input type="text" name="goodsIntroduce" placeholder="不能多于100个字" size="100" maxlength="100" class="input jianjie"/>
            </p>
            <p>
                <span >商品类型</span>
                <input type="radio" name="isNew_Vip_KillGoods" value="0" checked/>普通
                <input type="radio" name="isNew_Vip_KillGoods" value="1"/>上新
                <input type="radio" name="isNew_Vip_KillGoods" value="2"/>折扣
                <input type="radio" name="isNew_Vip_KillGoods" value="3"/>秒杀
            </p>
        <p class="vertical">  
                <span style="margin-top: 4px;display: block;float: left;">商品分类</span>
               
	<select id="mySelect" name="goodsTypeId">
		<option value="1" selected="selected">男装</option>
		<option value="2">女装</option>
		<option value="3">鞋靴</option>
	
</select>
</p>
            <p>
                <span>商品原价</span>
                <input type="text" class="input price" name="goodsPrice" size="15"/>
                <span>折扣价格</span>
                <input type="text" class="input price" name="goodsVipPrice" size="15"/>
                <span>秒杀价格</span>
                <input type="text" class="input price" name="goodsKillPrice" size="15"/>
                <span style="color:red">*没有则填0</span>
            </p>
            <p>
                <span>商品库存</span>
                <input type="radio" name="inventory" checked/>有
                <input type="radio" name="inventory"/>无
            </p>
            <p>
                <span>是否上架</span>
                <input type="radio" name="use" checked/>立刻上架
                <input type="radio" name="use"/>放入仓库
            </p>
            
            <p>
               
                <input type="hidden" value="四川省成都市龙泉驿区十陵镇56号" name="goodsAddress"/>
            </p>
       
      <div class="form1">
            商品展示图片：
            <input type="file" id="file1" name="goodsPictureMax" onchange="uploading1(this)"/>
            <input type="file" id="file2" name="goodsPictureView1" onchange="uploading2(this)"/>
            <input type="file" id="file3" name="goodsPictureView2" onchange="uploading3(this)"/>
            <input type="file" id="file4" name="goodsPictureView3" onchange="uploading4(this)"/>
            <div class="add-img-box">
                <div class="box">
                    <div class="add-img" id="add-img1"><img id="add1"></div>
                    <p><label for="file1" >点击上传</label></p>
                </div>
                <div class="box">
                    <div class="add-img" id="add-img2"><img id="add2"></div>
                    <p><label for="file2" >点击上传</label></p>
                </div>
                <div class="box">
                    <div class="add-img" id="add-img3"><img id="add3"></div>
                    <p><label for="file3" >点击上传</label></p>
                </div>
                <div class="box">
                    <div class="add-img" id="add-img4"><img id="add4"></div>
                    <p><label for="file4" >点击上传</label></p>
                </div>
            </div>
            </div>
             <input type="submit" class="publish" value="发布商品">
        </form>
        
    </div>

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
    function uploading2(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("add2");
            img.src = e.target.result;
            //或者 img.src = this.result;  //e.target == this
        }
        reader.readAsDataURL(file);
    }
    function uploading3(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("add3");
            img.src = e.target.result;
            //或者 img.src = this.result;  //e.target == this
        }
        reader.readAsDataURL(file);
    }
    function uploading4(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("add4");
            img.src = e.target.result;
            //或者 img.src = this.result;  //e.target == this
        }
        reader.readAsDataURL(file);
    }
    

	$(function () {

	   // $("#mySelect").select(); 不传参数可以这样写
		$("#mySelect").select({
			width: "180px",
		});
		//可选参数,不填就是默认值
		//width: "180px",            //生成的select框宽度
		//listMaxHeight:"200px",     //生成的下拉列表最大高度
		//themeColor: "#00bb9c",    //主题颜色
		//fontColor: "#000",        //字体颜色
		//fontFamily: "'Helvetica Neue', arial, sans-serif",    //字体种类
		//fontSize:"15px",           //字体大小
		//showSearch: false,        //是否启用搜索框
		//rowColor:"#fff",          //行原本的颜色
		//rowHoverColor: "#0faf03", //移动选择时，每一行的hover底色
		//fontHoverColor: "#fff",   //移动选择时，每一行的字体hover颜色
		//mainContent: "请选择",    //选择显示框的默认文字
		//searchContent: "关键词搜索"   //搜索框的默认提示文字  
	});

</script>
</body>
</html>