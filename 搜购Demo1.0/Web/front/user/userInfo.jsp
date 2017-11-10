<%@ page language="java" import="java.util.*,com.ltf.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
    <title>用户信息</title>
    <link rel="stylesheet" href="<%=path%>/css/common.css"/>
    <link rel="stylesheet" href="<%=path%>/css/user/user-index.css"/>
    <link rel="stylesheet" href="<%=path%>/css/normalize.css"/>
    <script src="<%=path%>/js/jquery-1.7.1.min.js"></script>
    <script src="<%=path%>/js/jquery.cityselect.js"></script>
    <script src="<%=path%>/js/city.min.js"></script>
    <link rel="stylesheet" href="<%=path %>/css/shop-admin/add-goods.css"/>
    
</head>
<body>
<!--头部信息-->
<jsp:include page="../view/frontTop.jsp"></jsp:include>

<%
	UserBean user=(UserBean)request.getSession().getAttribute("user");
%>
<!--个人主页信息-->

<div class="main comwid" style="margin-top:75px;">
    <div class="menu left">
        <img src="${user.userImages}" alt="头像"/>
        <ul>
            <li><a href="front/user/userSafe.jsp">安全设置</a></li>
            <li><a href="front/user/userInfo.jsp" style="color:#fff;background:rgb(241, 207, 120);">个人资料</a></li>
            <li><a href="front/user/modifyPwd.jsp">修改密码</a></li>
            <li><a href="front/user/userOrder.jsp">我的预定</a></li>
            <li><a href="front/user/collection.jsp">我的收藏</a></li>
        </ul>
    </div>
   
   
   
    <div class="content left">
     <form action="UserServlet?action=modifyUser" method="post" id="modifyUser" enctype="multipart/form-data">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;亲爱的用户，这是你的个人基本资料</p>
        <hr/>
        <div class="message">
            
                <span class="left">当前头像:</span>
                <input type="file" id="file1" name="userImages" style="display: none" onchange="uploading1(this)"/>
                <div class="add-img" id="add-img1" style="width:35%"><img src="${user.userImages}" id="add1"></div>
        	<label for="file1" style="padding-left:10.5%;">上传图片</label>
           
          <p>
             <span>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</span>
              <input type="text" maxlength="20" size="40" class="input" name="userNickName" value="${user.userNickName}"/><br>
   
          </p>
            <p>
                <span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
                <input type="text" maxlength="20" size="40"  name="userEmail" value="${user.userEmail}" class="input"/>
            </p>
            
            <p>
                <span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                <input type="radio" name="sex" class="sex" value="0" checked/>男
                <input type="radio" name="sex" class="sex" value="1"/>女
            </p>
            <p>
                <span>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日:</span>
                <select>
                    <option value="">年</option>
                    <option value="">2017年</option>
                    <option value="">2016年</option>
                    <option value="">2015年</option>
                    <option value="">2014年</option>
                    <option value="">2013年</option>
                    <option value="">2012年</option>
                    <option value="">2011年</option>
                    <option value="">2010年</option>
                    <option value="">1997年</option>
                    <option value="">1996年</option>
                    <option value="">1995年</option>
                    <option value="">1994年</option>
                    <option value="">1993年</option>
                    <option value="">1992年</option>
                    <option value="">1991年</option>
                    <option value="">1990年</option>
                </select>
                <select name="" id="">
                    <option value="">月</option>
                    <option value="">1</option>
                    <option value="">2</option>
                    <option value="">3</option>
                    <option value="">4</option>
                    <option value="">5</option>
                    <option value="">6</option>
                    <option value="">7</option>
                    <option value="">8</option>
                    <option value="">9</option>
                    <option value="">10</option>
                    <option value="">11</option>
                    <option value="">12</option>
                </select>
            </p>
            <p>
            <span class="left">家庭地址：</span>
            <div id="citySelect">
                <select class="prov" id="province"></select>
                <select class="city" disabled="disabled" id="city"></select>
                <select class="dist" disabled="disabled" id="county"></select>
            </div>
            </p>
            
            <div class="blank"></div>
            <p>
             <span>电话号码：</span>
              <input type="text" maxlength="20" size="40" class="input" name="userPhone" value="${user.userPhone}"/><br>
   
          </p>
            <p>
                <span>详细地址：</span>
                <input type="text" maxlength="20" size="40" class="input"/>
            </p>
           <input type="hidden" name="userId" value="${user.userId}" />
            <p>
             <a href="javascript:void(0)" onclick="document.getElementById('modifyUser').submit();" class="save">保存</a>
            </p>
          
        </div>
          </form>
    </div>
  
</div>

</body>
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
</html>