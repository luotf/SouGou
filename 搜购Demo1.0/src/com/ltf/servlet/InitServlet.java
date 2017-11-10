package com.ltf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltf.service.GoodsService;
import com.ltf.service.imp.GoodsServiceImp;

public class InitServlet extends HttpServlet {

	GoodsService goodsService=new GoodsServiceImp();
	int goodsTypeId=-1;
	public InitServlet() {
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
		
		 this.goodsTypeId=Integer.parseInt(request.getParameter("goodsTypeId"));
	
		//1.左侧分类栏信息展示
		this.showLeftGoodsType(request,response);
		//2.首页轮播图信息展示
		this.showSlideGoods(request,response);
		//3.爱好推荐信息展示4条
		this.showLikeGoods(request,response);
		//4.上新区信息展示6条
		this.showNewGoods(request,response);
		//5.秒杀区信息展示3条
		this.showKillGoods(request,response);
		//6.折扣区信息展示6条
		this.showVipGoods(request,response);
		//7.普通区信息展示无限条
		this.showCommonGoods(request,response);
		
		RequestDispatcher rd=request.getRequestDispatcher("/front/showIndex.jsp");
		rd.forward(request,response);
	}

	/**
	 * @功能 普通区信息展示无限条
	 * @param request
	 * @param response
	 */
	private void showCommonGoods(HttpServletRequest request,
			HttpServletResponse response) {
		
		List showCommonGoods=null;
		                   //不按商品类别查询
		int isNew_Vip_KillGoods=0;            //活动类型为普通商品
		int num=0;                            //不限制条数
		showCommonGoods=goodsService.showAllGoodsServ(goodsTypeId, isNew_Vip_KillGoods, num);
		request.getSession().setAttribute("showCommonGoods", showCommonGoods);
		
	}
	
	/**
	 * @功能 秒杀区信息展示3条
	 * @param request
	 * @param response
	 */
	private void showKillGoods(HttpServletRequest request,
			HttpServletResponse response) {
		
		List showKillGoods=null;
		              //不按商品类别查询
		int isNew_Vip_KillGoods=3;            //活动类型为秒杀商品
		int num=3;                            //限制条数3条
		showKillGoods=goodsService.showAllGoodsServ(goodsTypeId, isNew_Vip_KillGoods, num);
		request.getSession().setAttribute("showKillGoods", showKillGoods);
		
	}
	/**
	 * @功能 折扣区信息展示6条
	 * @param request
	 * @param response
	 */
	private void showVipGoods(HttpServletRequest request,
			HttpServletResponse response) {
		
		List showVipGoods=null;
		                  //不按商品类别查询
		int isNew_Vip_KillGoods=2;            //活动类型为秒杀商品
		int num=6;                            //限制条数3条
		showVipGoods=goodsService.showAllGoodsServ(goodsTypeId, isNew_Vip_KillGoods, num);
		request.getSession().setAttribute("showVipGoods", showVipGoods);
		
	}
	/**
	 * @功能 上新区信息展示6条
	 * @param request
	 * @param response
	 */
	private void showNewGoods(HttpServletRequest request,
			HttpServletResponse response) {

		List showNewGoods=null;
		                   //不按商品类别查询
		int isNew_Vip_KillGoods=1;            //活动类型为秒杀商品
		int num=6;                            //限制条数3条
		showNewGoods=goodsService.showAllGoodsServ(goodsTypeId, isNew_Vip_KillGoods, num);
		request.getSession().setAttribute("showNewGoods", showNewGoods);
		
	}
	/**
	 * @功能 爱好推荐信息展示4条
	 * @param request
	 * @param response
	 */
	private void showLikeGoods(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}
	/**
	 * @功能 首页轮播图信息展示
	 * @param request
	 * @param response
	 */
	private void showSlideGoods(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}
	/**
	 * @功能 左侧分类栏信息展示
	 * @param request
	 * @param response
	 */
	private void showLeftGoodsType(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}
	
	public void init() throws ServletException {
		
	}

}
