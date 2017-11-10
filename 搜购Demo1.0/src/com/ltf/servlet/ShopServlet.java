package com.ltf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ltf.service.GoodsService;
import com.ltf.service.ShopService;
import com.ltf.service.imp.GoodsServiceImp;
import com.ltf.service.imp.ShopServiceImp;
import com.ltf.vo.ShopBean;

public class ShopServlet extends HttpServlet {

	ShopService shopService=new ShopServiceImp();
	public ShopServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy();
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("addShop"))
			this.addShop(request, response); 	// 增加店铺
		if (action.equals("deleteShop"))
			this.deleteShop(request, response); // 删除店铺
		if (action.equals("modifyShop"))
			this.modifyShop(request, response); 	// 修改店铺信息
		if (action.equals("modifyShopPassword"))
			this.modifyShopPassword(request, response); 	// 修改店铺密码
		if (action.equals("showAllShop"))
			this.showAllShop(request, response); // 显示所有审核店铺
		if (action.equals("showNoCheckShop"))
			this.showNoCheckShop(request, response); // 显示所有未审核店铺
		if (action.equals("showSingleShop"))
			this.showSingleShop(request, response); // 显示单个店铺信息
		if (action.equals("shopLogin"))
			this.shopLogin(request, response); // 店铺登录
		if (action.equals("checkShop"))
			this.checkShop(request, response); // 审核店铺
		if (action.equals("checkShopExist"))
			this.checkShopExist(request, response); // 检查店铺名是否存在
		if (action.equals("loginOut"))
			this.loginOut(request, response); // 退出店铺
	}
		
	
	
	

	private void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		System.out.println("注销成功");
		response.sendRedirect("admin/adminLogin.jsp");
		
	}


	/**
	 * @功能  检查店铺名是否存在
	 * @param request
	 * @param response
	 */
	
	private void checkShopExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ShopService shopService=new ShopServiceImp();
		String shopName=request.getParameter("shopName");
		String[] messages=shopService.checkShopExistServ(shopName);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}
	
	/**
	 * @功能  审核店铺
	 * @param request
	 * @param response
	 */
	private void checkShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int shopId=Integer.parseInt(request.getParameter("shopId"));
		String[] messages=shopService.checkShopServ(shopId);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}

	/**
	 * @功能  店铺登录
	 * @param request
	 * @param response
	 */
	private void shopLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String msg="validate";
		ShopBean shopBean=new ShopBean();
		ShopBean shopBean1=new ShopBean();
		String key = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String validate = request.getParameter("validate");
		if (key.equals(validate)){  //首先判断验证码是否正确
		
		shopBean.setShopName(request.getParameter("userName"));
		shopBean.setShopPassword(request.getParameter("password"));
		System.out.println(request.getParameter("userName")+":"+request.getParameter("password"));
		if(shopService.shopLoginServ(shopBean)){
			System.out.println("用户名:"+request.getParameter("userName")+"登陆成功");
			shopBean1=shopService.showSingleShopServ(shopBean.getShopName());
			System.out.println("欢迎商家：“"+shopBean1.getShopNickName()+"”登录");
			request.getSession().setAttribute("shop",shopBean1);
			msg="success";
		}
		else{
			System.out.println("登陆失败");
			msg="error";
		}
		}
		System.out.println("验证码错误");
		out.print(msg);
		out.flush();
        out.close();
		
	}

		/**
		 * @功能  显示单个商店具体信息
		 * @param request
		 * @param response
		 */
	private void showSingleShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ShopService shopService=new ShopServiceImp();
		ShopBean singleShop=new ShopBean();
		
		int shopId=Integer.parseInt(request.getParameter("shopId"));
		System.out.println("店铺编号为："+shopId);
		singleShop=shopService.showSingleShopServ(shopId);
		
		String forward="";
		
		String showType=request.getParameter("showType");
	//	String adminShop=request.getParameter("admin");
		GoodsService goodsService=new GoodsServiceImp();
		
		if(showType==null){
				showType="";
				request.getSession().setAttribute("singleShop", singleShop);
				forward="/admin/shop/modifyShop.jsp";
		}
		if(showType.equals("all")){
			//显示店铺推荐4条信息
			List shopAllGoods=null;
			shopAllGoods=goodsService.showSingleShopGoodsServ(shopId,4);
			request.setAttribute("shopAllGoods", shopAllGoods);
			
			//显示店铺的普通商品
			int goodsTypeId=-1;    //goodsTypeId=-1 小于0,不按商品类别显示
			int isNew_Vip_KillGoods=0;  //isNew_Vip_KillGoods=0表示普通商品
			int num=0;   // num=0表示不限制查询条数
			List showAllSingleGoods=goodsService.showSingleShopGoodsServ(shopId, goodsTypeId, isNew_Vip_KillGoods, num);
			request.setAttribute("showSingleShopComGoods",showAllSingleGoods);
			
			//显示店铺的上新商品
			isNew_Vip_KillGoods=1;  //isNew_Vip_KillGoods=1表示上新商品
			showAllSingleGoods=goodsService.showSingleShopGoodsServ(shopId, goodsTypeId, isNew_Vip_KillGoods, num);
			request.setAttribute("showSingleShopNewGoods",showAllSingleGoods);
			
			//显示店铺的折扣商品
			isNew_Vip_KillGoods=2;  //isNew_Vip_KillGoods=0表示上新商品
			showAllSingleGoods=goodsService.showSingleShopGoodsServ(shopId, goodsTypeId, isNew_Vip_KillGoods, num);
			request.setAttribute("showSingleShopVipGoods",showAllSingleGoods);
		
			//if(adminShop.equals("front"))
			//	forward="/front/shop/singleShop.jsp";
			
			//if(adminShop.equals("shop"))
				//forward="/admin/shop/showAllGoods.jsp";
			forward="/front/shop/singleShop.jsp";
			
			
		}
		request.getSession().setAttribute("singleShop", singleShop);
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request,response);
	}

	/**
	 * @功能  显示所有未审核商店列表
	 * @param request
	 * @param response
	 */
	private void showNoCheckShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List allNoCheckShopList=null;
		int tag=0;   			 //0表示未审核
		allNoCheckShopList=shopService.showAllShopServ(tag);
		request.setAttribute("allNoCheckShopList", allNoCheckShopList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/admin/checkShop.jsp");
		rd.forward(request,response);
	}

	/**
	 * @功能  显示所有审核商店列表
	 * @param request
	 * @param response
	 */
	private void showAllShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ShopService shopService=new ShopServiceImp();
		List allShopList=null;
		int tag=1;   			 //1表示审核
		allShopList=shopService.showAllShopServ(tag);
		request.setAttribute("allShopList", allShopList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/admin/showAllShop.jsp");
		rd.forward(request,response);
		
		
	}

	/**
	 * @功能  修改店铺登录密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void modifyShopPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ShopService shopService=new ShopServiceImp();
		int  shopId=Integer.parseInt(request.getParameter("shopId"));
		String shopPassword=request.getParameter("shopPassword");
		String[] messages=shopService.modifyShopPasswordServ(shopId, shopPassword);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void modifyShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ShopService shopService=new ShopServiceImp();
		ShopBean shopBean=new ShopBean();
		int shopId=Integer.parseInt(request.getParameter("shopId"));
		shopBean.setShopNickName(request.getParameter("shopNickName"));
		shopBean.setShopIntroduce(request.getParameter("shopIntroduce"));
		shopBean.setShopMainImages(request.getParameter("shopMainImages"));
		shopBean.setShopAddress(request.getParameter("shopAddress"));
		shopBean.setShopManager(request.getParameter("shopManager"));
		shopBean.setShopPhone(request.getParameter("shopPhone"));
		String[] messages=shopService.modifyShopServ(shopId, shopBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void deleteShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		//ShopService shopService=new ShopServiceImp();
		int shopId=Integer.parseInt(request.getParameter("shopId"));
		String[] messages=shopService.deleteShopServ(shopId);
		
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void addShop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ShopService shopService=new ShopServiceImp();
		//request.setCharacterEncoding("utf-8");
		SmartUpload su = new SmartUpload();
		ShopBean shopBean=new ShopBean();
		Request req = su.getRequest();
		long maxsize = 10 * 1024 * 1024; // 设置每个上传文件的大小，为10MB
		su.initialize(this.getServletConfig(), request, response);
		su.setMaxFileSize(maxsize); // 限制上传文件的大小
		su.setAllowedFilesList("jpg,gif,bmp,png"); // 设置允许上传的文件类型
		try {
			su.upload();
		} catch (SmartUploadException e1) {

			e1.printStackTrace();
		}
		shopBean.setShopName(req.getParameter("shopName"));
		shopBean.setShopPassword(req.getParameter("shopPassword"));
		shopBean.setShopNickName(new String(req.getParameter("shopNickName").trim()
				.getBytes(), "UTF-8"));
		shopBean.setShopIntroduce(new String(req.getParameter("shopIntroduce").trim()
				.getBytes(), "UTF-8"));
		shopBean.setShopManager(new String(req.getParameter("shopManager").trim()
				.getBytes(), "UTF-8"));
		shopBean.setShopPhone(req.getParameter("shopPhone"));
		shopBean.setShopAddress(new String(req.getParameter("shopAddress").trim()
				.getBytes(), "UTF-8"));
		SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String shopAddTime=format.format(new Date());
		shopBean.setShopAddTime(shopAddTime);
		int tag=0;    //0表示店铺未审核
		shopBean.setTag(tag);
		File file = null;
		String shopMainImages = "";
		int maxId = shopService.showShopMaxId() + 1;
			file = su.getFiles().getFile(0); // 获取上传的文件，因为只上传了一个文件，所以可直接获取
			if (!file.isMissing()) { // 如果选择了文件
				// 图片信息在数据表中的id字段值+“.”+文件后缀名;最后生成例如“front\photo\pic\12.bmp”路径
				shopMainImages = "images/shop/" + maxId + "A" + "."
							+ file.getFileExt();
				shopBean.setShopMainImages(shopMainImages);
					
				try {
					file.saveAs(shopMainImages, File.SAVEAS_VIRTUAL);
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		String[] messages=shopService.addShopServ(shopBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	public void init() throws ServletException {
		
	}

}
