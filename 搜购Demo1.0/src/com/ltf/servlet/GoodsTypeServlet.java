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

import com.ltf.service.GoodsTypeService;
import com.ltf.service.imp.GoodsTypeServiceImp;
import com.ltf.vo.GoodsBean;
import com.ltf.vo.GoodsTypeBean;

public class GoodsTypeServlet extends HttpServlet {

	public GoodsTypeServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("showAllGoodsType"))
			this.showAllGoodsType(request, response); // 显示所有商品类别
		if (action.equals("showSingleGoods"))
			this.showSingleGoodsType(request, response); // 显示单个商品类别详情
		if (action.equals("addGoods"))
			this.addGoodsType(request, response); 	// 增加商品类别
		if (action.equals("modifyGoods"))
			this.modifyGoodsType(request, response); // 修改商品信息类别
		if (action.equals("deleteGoods"))
			this.deleteGoodsType(request, response); // 删除商品类别
		if (action.equals("checkGoodsTypeExist"))
			this.checkGoodsTypeExist(request, response); // 检查商品类别是否存在
		
	}
	

	private void checkGoodsTypeExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeService goodsTypeService=new GoodsTypeServiceImp();
		String goodsTypeName=request.getParameter("goodsTypeName");
		String[] messages=goodsTypeService.checkGoodsTypeExistServ(goodsTypeName);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}


	private void deleteGoodsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeService goodsTypeService=new GoodsTypeServiceImp();
		int goodsTypeId=Integer.parseInt(request.getParameter("goodsTypeId"));
		String[] messages=goodsTypeService.deleteGoodsTypeServ(goodsTypeId);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void modifyGoodsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeService goodsTypeService=new GoodsTypeServiceImp();
		GoodsTypeBean goodsTypeBean=new GoodsTypeBean();
		int goodsTypeId=Integer.parseInt(request.getParameter("goodsTypeId"));
		goodsTypeBean.setGoodsTypeName(request.getParameter("goodsTypeName"));
		String[] messages=goodsTypeService.modifyGoodsTypeServ(goodsTypeId, goodsTypeBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void addGoodsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeService goodsTypeService=new GoodsTypeServiceImp();
		GoodsTypeBean goodsTypeBean=new GoodsTypeBean();
		int tag=1;
		goodsTypeBean.setTag(tag);//设置该商品类别未审核
		SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String goodsTypeAddTime=format.format(new Date());
		goodsTypeBean.setGoodsTypeAddTime(goodsTypeAddTime);
		goodsTypeBean.setGoodsTypeName(request.getParameter("goodsTypeName"));
		String[] messages=goodsTypeService.addGoodsTypeServ(goodsTypeBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void showSingleGoodsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		GoodsTypeService goodsTypeService=new GoodsTypeServiceImp();
		GoodsTypeBean singleTypeGoods=new GoodsTypeBean();
		int goodsTypeId=Integer.parseInt(request.getParameter("goodsTypeId"));
		singleTypeGoods=goodsTypeService.showSingleGoodsTypeServ(goodsTypeId);
		request.setAttribute("singleTypeGoods", singleTypeGoods);
		//跳转到单个商品商品类别详情页面
		RequestDispatcher rd=request.getRequestDispatcher("/front/goodsType/singleGoodsType.jsp");
		rd.forward(request,response);
	}


	private void showAllGoodsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeService goodsTypeService=new GoodsTypeServiceImp();
		List allGoodsTypeList=null;
		allGoodsTypeList=goodsTypeService.showAllGoodsTypeServ();
		request.setAttribute("allGoodsTypeList", allGoodsTypeList);
		//跳转到所有商品类别列表
		RequestDispatcher rd=request.getRequestDispatcher("/front/goodsType/allGoodsTypeList.jsp");
		rd.forward(request,response);
		
	}
	
	public void init() throws ServletException {
		
	}

}
