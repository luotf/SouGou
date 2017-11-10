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

import net.sf.json.JSONArray;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ltf.service.GoodsService;
import com.ltf.service.ShopService;
import com.ltf.service.imp.GoodsServiceImp;
import com.ltf.service.imp.ShopServiceImp;
import com.ltf.tools.MyPage;
import com.ltf.vo.GoodsBean;
import com.ltf.vo.ShopBean;

public class GoodsServlet extends HttpServlet {
	MyPage page=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoodsServlet() {
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
		if (action.equals("showAllGoods"))
			this.showAllGoods(request, response); // 显示所有商品
		if (action.equals("showAdminSingleShopGoods"))
			this.showAdminSingleShopGoods(request, response); // 后台管理员显示所有商品
		if (action.equals("showSingleGoods"))
			this.showSingleGoods(request, response); // 显示单个商品详情
		if (action.equals("addGoods"))
			this.addGoods(request, response); 	// 增加商品
		if (action.equals("modifyGoods"))
			this.modifyGoods(request, response); // 修改商品信息
		if (action.equals("deleteGoods"))
			this.deleteGoods(request, response); // 删除商品
		if (action.equals("showSingleShopGoods"))
			this.showSingleShopGoods(request, response); // 显示单个商店所有商品
		if (action.equals("checkGoods"))
			this.checkGoods(request, response); 	// 审核商品
		if (action.equals("is_soldOut"))
			this.is_soldOut(request, response); 	// 下架商品
		if (action.equals("putAwayGoods"))
			this.putAwayGoods(request, response); 	// 下架商品
		if (action.equals("showShopNoCheckGoods"))
			this.showShopNoCheckGoods(request, response); // 显示店铺的未审核商品
		if (action.equals("showAllNoCheckGoods"))
			this.showAllNoCheckGoods(request, response); // 显示所有的未审核商品
		if (action.equals("showSingleShopSoldOut"))
			this.showSingleShopSoldOut(request, response); // 显示单个店铺的下架商品
		if (action.equals("showAllShopSoldOut"))
			this.showAllShopSoldOut(request, response); // 显示所有店铺的下架商品
		if (action.equals("showKeyWordsGoods"))
			this.showKeyWordsGoods(request, response); // 按关键字查询商品信息
		if (action.equals("showKeyWordsGoodsList"))
			this.showKeyWordsGoodsList(request, response); // 按关键字查询商品列表
	}
	
	
	private void putAwayGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		GoodsService goodsService = new GoodsServiceImp();
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		String forward = "";
		String messages = "";
		if (goodsService.putAwayGoodsServ(goodsId)) {
			messages = "商品上架成功";
			forward = "GoodsServlet?action=showSingleShopSoldOut&shopId="
					+ shopId + "";
			System.out.println("商品上架后路径为:" + forward);
		} else {
			messages = "商品上架失败";
			forward = "/admin/shop/showAllGoods.jsp";
		}
		PrintWriter out = response.getWriter();
		out.println(forward);
		
	}

	private void showAllShopSoldOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		List allShopSoldGoodsList = null;
		allShopSoldGoodsList = goodsService.showAllShopSoldOutServ();
		request.setAttribute("allShopSoldGoodsList", allShopSoldGoodsList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/admin/soldOutGoods.jsp");
		rd.forward(request, response);
	}

	private void showSingleShopSoldOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		List singleShopSoldGoodsList = null;
		int shopId=Integer.parseInt(request.getParameter("shopId"));
		singleShopSoldGoodsList = goodsService.showSingleShopSoldOutServ(shopId);
		request.setAttribute("singleShopSoldGoodsList", singleShopSoldGoodsList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/shop/soldOutGoods.jsp");
		rd.forward(request, response);
		
	}

	private void is_soldOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		GoodsService goodsService = new GoodsServiceImp();
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		String forward = "";
		String messages = "";
		if (goodsService.is_soldOutServ(goodsId)) {
			messages = "商品下架成功";
			forward = "GoodsServlet?action=showSingleShopGoods&shopId="
					+ shopId + "";
			System.out.println("商品下架后路径为：" + forward);
		} else {
			messages = "商品下架失败";
			forward = "/admin/shop/showAllGoods.jsp";
		}
		PrintWriter out = response.getWriter();
		out.println(forward);
	
	}

	private void showKeyWordsGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		List keyWordsList=null;
		String strPage = request.getParameter("Page");
		int Page = 1;
		String keywords=request.getParameter("keyword"); 
				if (strPage == null) {
					page = new MyPage();
					keyWordsList=goodsService.showKeyWordsGoodsServ(keywords);
				int pageSize = 12;
				keyWordsList = page.getInitPage(keyWordsList, Page,
						pageSize);
				request.getSession().setAttribute("page", page);
				}else{
					page = (MyPage) request.getSession().getAttribute("page");
					Page = page.getPage(strPage);
					keyWordsList = page.getAppointPage(Page);
				}
			request.setAttribute("allGoodslist", keyWordsList);
			request.getSession().setAttribute("page", page);
			request.setAttribute("Page", Page);
			request.setAttribute("url", "showKeyWordsGoodsList");
			request.getRequestDispatcher("/front/goods/goodsList.jsp").forward(request, response);
			}
	
	private void showKeyWordsGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		GoodsService goodsService = new GoodsServiceImp();
		List keyWordsList=null;
		String keywords=request.getParameter("keyword"); 
			if(keywords!=null){
				System.out.println("搜索框内容为："+keywords);
				keyWordsList=goodsService.showKeyWordsGoodsServ(keywords);
				//将list集合转换成json格式
				response.getWriter().write(JSONArray.fromObject(keyWordsList).toString());	
			}
		
	}

	private void showAllNoCheckGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		List allCheckGoodsList = null;
		allCheckGoodsList = goodsService.showAllNoCheckGoodsServ();
		request.setAttribute("allCheckGoodsList", allCheckGoodsList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/admin/checkGoods.jsp");
		rd.forward(request, response);

	}

	private void showShopNoCheckGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		List shopNoCheckGoodsList = null;
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		shopNoCheckGoodsList = goodsService.showShopNoCheckGoodsServ(shopId);
		request.setAttribute("shopNoCheckGoodsList", shopNoCheckGoodsList);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/shop/showNoCheckGoods.jsp");
		rd.forward(request, response);
	}

	private void showAdminSingleShopGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String strPage = request.getParameter("Page");
		int Page = 1;
		GoodsService goodsService = new GoodsServiceImp();
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		List showAllSingleShopGoods = null;
		if (strPage == null) {
			page = new MyPage();
		showAllSingleShopGoods = goodsService.showSingleShopGoodsServ(shopId);
		int pageSize = 7;
		showAllSingleShopGoods = page.getInitPage(showAllSingleShopGoods, Page,
				pageSize);
		request.getSession().setAttribute("page", page);
		int isType = Integer.parseInt(request.getParameter("isType"));
		int goodsTypeId = -1;
		int isNew_Vip_KillGoods = 0; // isNew_Vip_KillGoods=1表示上新商品
		int num = 0;
		if (isType == 1) {
			// 显示店铺的上新商品
			isNew_Vip_KillGoods = 1; // isNew_Vip_KillGoods=1表示上新商品
			showAllSingleShopGoods = goodsService.showSingleShopGoodsServ(
					shopId, goodsTypeId, isNew_Vip_KillGoods, num);
			
			showAllSingleShopGoods = page.getInitPage(showAllSingleShopGoods, Page,
					pageSize);
			request.getSession().setAttribute("page", page);
		}
		if (isType == 2) {
			isNew_Vip_KillGoods = 2; // isNew_Vip_KillGoods=2表示折扣商品
			showAllSingleShopGoods = goodsService.showSingleShopGoodsServ(
					shopId, goodsTypeId, isNew_Vip_KillGoods, num);
			showAllSingleShopGoods = page.getInitPage(showAllSingleShopGoods, Page,
					pageSize);
			request.getSession().setAttribute("page", page);
		}
		if (isType == 3) {
			isNew_Vip_KillGoods = 3; // isNew_Vip_KillGoods=3表示秒杀商品
			showAllSingleShopGoods = goodsService.showSingleShopGoodsServ(
					shopId, goodsTypeId, isNew_Vip_KillGoods, num);
			showAllSingleShopGoods = page.getInitPage(showAllSingleShopGoods, Page,
					pageSize);
			request.getSession().setAttribute("page", page);
		}
		}else{
		
			page = (MyPage) request.getSession().getAttribute("page");
			Page = page.getPage(strPage);
			showAllSingleShopGoods = page.getAppointPage(Page);
		}
		
		request.setAttribute("showAllSingleShopGoods", showAllSingleShopGoods);
		request.getSession().setAttribute("page", page);
		request.setAttribute("Page", Page);
		request.setAttribute("url", "showAdminSingleShopGoods");
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/shop/showAllGoods.jsp");
		rd.forward(request, response);
	}

	private void checkGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String[] messages = goodsService.checkGoodsServ(goodsId);
		RequestDispatcher rd = request.getRequestDispatcher(messages[1]);
		rd.forward(request, response);
	}

	private void showSingleGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		GoodsBean singleGoods = null;
		String forward = "";
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		System.out.println("goodsId:" + goodsId);
		singleGoods = goodsService.showSingleGoodsServ(goodsId);
		request.setAttribute("singleGoods", singleGoods);
		String showType = request.getParameter("showType");
		if (showType.equals(""))
			showType = "";
		if (showType.equals("all")) {
			// 显示店铺推荐5条信息
			List shopAllGoods = null;
			shopAllGoods = goodsService.showSingleShopGoodsServ(
					singleGoods.getShopId(), 5);
			request.setAttribute("shopAllGoods", shopAllGoods);
			ShopService shopService = new ShopServiceImp();
			ShopBean singleShop = new ShopBean();
			singleShop = shopService
					.showSingleShopServ(singleGoods.getShopId());
			request.setAttribute("singleShop", singleShop);
			forward = "/front/goods/goodsInfo.jsp";
		}
		if (showType.equals("modify")) {
			forward = "/admin/shop/modifyGoods.jsp";
		}
		if (showType.equals("show")) {
			forward = "/admin/shop/showGoodsInfo.jsp";
		}
		// 跳转到单个商品详情页面
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	private void adminShowAllGoods(HttpServletRequest request,
			HttpServletResponse response) {

	}

	private void showSingleShopGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		
		String strPage = request.getParameter("Page");
		int Page = 1;
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		List singleShopGoodsList = null;
		if (strPage == null) {
			page = new MyPage();
			singleShopGoodsList = goodsService.showSingleShopGoodsServ(shopId);
			int pageSize = 7;
			singleShopGoodsList = page.getInitPage(singleShopGoodsList, Page,
					pageSize);
			request.getSession().setAttribute("page", page);
			
		} else {
			page = (MyPage) request.getSession().getAttribute("page");
			Page = page.getPage(strPage);
			singleShopGoodsList = page.getAppointPage(Page);
		}
		request.setAttribute("showAllSingleShopGoods", singleShopGoodsList);
		request.getSession().setAttribute("page", page);
		request.setAttribute("Page", Page);
		request.setAttribute("url", "showSingleShopGoods");
		request.getRequestDispatcher("/admin/shop/showAllGoods.jsp").forward(request, response);;
		
	}

	private void deleteGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		GoodsService goodsService = new GoodsServiceImp();
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int shopId = Integer.parseInt(request.getParameter("shopId"));
		String forward = "";
		String messages = "";
		if (goodsService.deleteGoodsServ(goodsId)) {
			messages = "删除商品成功";
			forward = "GoodsServlet?action=showSingleShopGoods&shopId="
					+ shopId + "";
			System.out.println("跳转路径为：" + forward);
		} else {
			messages = "删除商品失败";
			forward = "/admin/shop/showAllGoods.jsp";
		}
		PrintWriter out = response.getWriter();
		out.println(forward);

	}

	private void modifyGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SmartUpload su = new SmartUpload();
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

		GoodsService goodsService = new GoodsServiceImp();
		GoodsBean modifyGoods = new GoodsBean();
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		modifyGoods.setShopId(Integer.parseInt(req.getParameter("shopId")));
		modifyGoods.setGoodsTypeId(Integer.parseInt(req
				.getParameter("goodsTypeId")));
		modifyGoods.setGoodsName(new String(req.getParameter("goodsName")
				.getBytes(), "UTF-8"));
		modifyGoods.setGoodsIntroduce(new String(req.getParameter(
				"goodsIntroduce").getBytes(), "UTF-8"));
		modifyGoods.setGoodsAddress(new String(req.getParameter("goodsAddress")
				.getBytes(), "UTF-8"));
		modifyGoods.setGoodsPrice(Float.parseFloat(req
				.getParameter("goodsPrice")));
		modifyGoods.setGoodsVipPrice(Float.parseFloat(req
				.getParameter("goodsVipPrice")));
		modifyGoods.setGoodsKillPrice(Float.parseFloat(req
				.getParameter("goodsKillPrice")));
		modifyGoods.setIsNew_Vip_KillGoods(Integer.parseInt(req
				.getParameter("isNew_Vip_KillGoods")));
		
		int is_soldOut=Integer.parseInt(req.getParameter("is_soldOut"));
		modifyGoods.setIs_soldOut(is_soldOut);
		
		File file = null;
		String goodsPictureMax = "";
		for (int i = 0; i < su.getFiles().getCount(); i++) {
			file = su.getFiles().getFile(i); // 获取上传的文件，因为只上传了一个文件，所以可直接获取
			if (!file.isMissing()) { // 如果选择了文件
				switch (i) {
				case 0:
					goodsPictureMax = "images/goods/Max/" + goodsId + "A" + "."
							+ file.getFileExt();
					modifyGoods.setGoodsPictureMax(goodsPictureMax);
					break;
				case 1:
					goodsPictureMax = "images/goods/View/" + goodsId + "B_1"
							+ "." + file.getFileExt();
					modifyGoods.setGoodsPictureView1(goodsPictureMax);
					break;
				case 2:
					goodsPictureMax = "images/goods/View/" + goodsId + "B_2"
							+ "." + file.getFileExt();
					modifyGoods.setGoodsPictureView2(goodsPictureMax);
					break;
				case 3:
					goodsPictureMax = "images/goods/View/" + goodsId + "B_3"
							+ "." + file.getFileExt();
					modifyGoods.setGoodsPictureView3(goodsPictureMax);
					break;
				}// switch
				try {
					file.saveAs(goodsPictureMax, File.SAVEAS_VIRTUAL);
				} catch (SmartUploadException e) {
				
					e.printStackTrace();
				}
			}// if
		}// for

		String[] messages = goodsService.modifyGoodsServ(goodsId, modifyGoods);
		request.setAttribute("messages", messages[0]);
		RequestDispatcher rd = request.getRequestDispatcher(messages[1]);
		rd.forward(request, response);
	}

	private void addGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SmartUpload su = new SmartUpload();
		GoodsService goodsService = new GoodsServiceImp();
		GoodsBean addGoods = new GoodsBean();
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

		addGoods.setShopId(Integer.parseInt(req.getParameter("shopId")));
		addGoods.setGoodsTypeId(Integer.parseInt(req
				.getParameter("goodsTypeId")));
		int goodsTypeId = Integer.parseInt(req.getParameter("goodsTypeId"));

		addGoods.setGoodsName(new String(req.getParameter("goodsName")
				.getBytes(), "UTF-8"));

		addGoods.setGoodsIntroduce(new String(req
				.getParameter("goodsIntroduce").getBytes(), "UTF-8"));
		addGoods.setGoodsAddress(new String(req.getParameter("goodsAddress")
				.getBytes(), "UTF-8"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String goodsAddTime = format.format(new Date());
		addGoods.setGoodsAddTime(goodsAddTime);
		addGoods.setGoodsPrice(Float.parseFloat(req.getParameter("goodsPrice")));
		addGoods.setGoodsVipPrice(Float.parseFloat(req
				.getParameter("goodsVipPrice")));
		addGoods.setGoodsKillPrice(Float.parseFloat(req
				.getParameter("goodsKillPrice")));
		addGoods.setIsNew_Vip_KillGoods(Integer.parseInt(req
				.getParameter("isNew_Vip_KillGoods")));
		int goodsReadNum = 0;
		int goodsCollectNum = 0;
		int tag = 0; // tag=0表示商品未审核
		addGoods.setGoodsReadNum(goodsReadNum);
		addGoods.setGoodsCollectNum(goodsCollectNum);
		addGoods.setTag(tag);
		//int is_soldOut=Integer.parseInt(req.getParameter("is_soldOut"));
		int is_soldOut=0;
		addGoods.setIs_soldOut(is_soldOut);
		
		// 图片上传
		File file = null;
		String goodsPictureMax = "";
		int maxId = goodsService.showGoodsMaxId() + 1;
		for (int i = 0; i < su.getFiles().getCount(); i++) {
			file = su.getFiles().getFile(i); 
			if (!file.isMissing()) { // 如果选择了文件
				switch (i) {
				case 0:
					goodsPictureMax = "images/goods/Max/" + maxId + "A" + "."
							+ file.getFileExt();
					addGoods.setGoodsPictureMax(goodsPictureMax);
					break;
				case 1:
					goodsPictureMax = "images/goods/View/" + maxId + "B_1"
							+ "." + file.getFileExt();
					addGoods.setGoodsPictureView1(goodsPictureMax);
					break;
				case 2:
					goodsPictureMax = "images/goods/View/" + maxId + "B_2"
							+ "." + file.getFileExt();
					addGoods.setGoodsPictureView2(goodsPictureMax);
					break;
				case 3:
					goodsPictureMax = "images/goods/View/" + maxId + "B_3"
							+ "." + file.getFileExt();
					addGoods.setGoodsPictureView3(goodsPictureMax);
					break;
				}// switch
				try {
					file.saveAs(goodsPictureMax, File.SAVEAS_VIRTUAL);
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}// if
		}// for

		String[] messages = goodsService.addGoodsServ(addGoods);
		request.setAttribute("messages", messages[0]);
		RequestDispatcher rd = request.getRequestDispatcher(messages[1]);
		rd.forward(request, response);

	}

	private void showAllGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImp();
		String strPage = request.getParameter("Page");
		int Page = 1;
		List allGoodslist = null;
		String forward = "/front/goods/goodsList.jsp";
		int goodsTypeId = Integer.parseInt(request.getParameter("goodsTypeId"));
		String type = request.getParameter("type");
		if (goodsTypeId == 0)
			goodsTypeId = -1; 		// -1表示不区分商品类别
		int isNew_Vip_KillGoods = Integer.parseInt(request
				.getParameter("isNew_Vip_KillGoods"));
		int num = 0; 				// 0 表示所有
		int pageSize=0;
		if (type == null) {
			type = "";
			forward = "/front/goods/goodsList.jsp";
			pageSize = 12;
		}
		if (type.equals("1")) {
			forward = "/admin/admin/showAllGoods.jsp";
			pageSize = 15;
		}
		
		if (strPage == null) {
			page = new MyPage();
			allGoodslist = goodsService.showAllGoodsServ(goodsTypeId,
					isNew_Vip_KillGoods, num);
			allGoodslist = page.getInitPage(allGoodslist, Page,
					pageSize);
			request.getSession().setAttribute("page", page);
		} else {
			page = (MyPage) request.getSession().getAttribute("page");
			Page = page.getPage(strPage);
			allGoodslist = page.getAppointPage(Page);
		}
		request.setAttribute("allGoodslist", allGoodslist);
		request.getSession().setAttribute("page", page);
		request.setAttribute("Page", Page);
		request.setAttribute("url", "showAllGoods");
		// 跳转到显示所有商品列表页面
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
	public void init() throws ServletException {

	}

}
