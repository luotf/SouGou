package com.ltf.service.imp;

import java.util.List;

import com.ltf.dao.GoodsDao;
import com.ltf.dao.imp.GoodsDaoImp;
import com.ltf.service.GoodsService;
import com.ltf.vo.GoodsBean;

public class GoodsServiceImp implements GoodsService {
	
		GoodsDao goodsDao=new GoodsDaoImp();
		boolean f=false;
		String message="";
		String forward="";
	/**
	 * @功能 增加商品
	 * @参数 goodsId表示传入的商品的ID值
	 * @返回值 boolean型，增加商品是否成功
	 */
	public String[] addGoodsServ(GoodsBean goodsBean) {
		f=goodsDao.addGoodsDao(goodsBean);
		if(f){
			//修改商品成功页面
			forward="/admin/shop/addGoods.jsp";
			message="<li>增加商品成功</li>";
		}
		else{
			//修改商品失败页面
			forward="/admin/shop/error.jsp";
			message="<li>增加商品失败！请检查商品信息是否有误...</li>";
		
		}
		String[] messages={message,forward};
		return messages ;
	}
	
	
	public int showGoodsMaxId(){
		return goodsDao.showGoodsMaxId();
		
	}
	
	/**
	 * @功能 删除商品
	 * @参数 goodsId表示传入的商品的ID值
	 * @返回值 boolean型，删除商品是否成功
	 */
	public boolean deleteGoodsServ(int goodsId) {
		return goodsDao.deleteGoodsDao(goodsId);
	}

	/**
	 * @功能 修改商品
	 * @参数 goodsId表示传入的商品的ID值
	 * @返回值 boolean型，修改商品是否成功
	 */
	public String[] modifyGoodsServ(int goodsId, GoodsBean goodsBean) {
		
		 f=goodsDao.modifyGoodsDao(goodsId, goodsBean);
		 if(f){
				//修改商品成功页面
				forward="/admin/shop/modifyGoods.jsp";
				message="<li>修改商品成功</li>";
			}
			else{
				forward="/admin/shop/error.jsp";
				message="<li>增加商品失败！请检查商品信息是否有误...</li>";
			}
		 String[] messages={message,forward};
		 return messages ;
	}

	/** 
	 * @功能 查询指定类别、活动的商品
	 * @参数 goodsTypeId表示商品类别ID值，isNew_Vip_KillGoods表示商品的活动类型,num表示显示商品的条数，0表示所有
	 * @返回值 List集合
	 */
	public List showAllGoodsServ(int goodsTypeId, int isNew_Vip_KillGoods,
			int num) {
		
		return goodsDao.showAllGoodsDao(goodsTypeId, isNew_Vip_KillGoods, num);
	}

	/**
	 * @功能 显示单个商品详情
	 * @参数 goodsId表示显示商品详情的ID值
	 * @返回值 GoodsBean对象
	 */
	public GoodsBean showSingleGoodsServ(int goodsId) {
		
		return goodsDao.showSingleGoodsDao(goodsId);
	}

	/**
	 * @功能 显示单个商店的全部商品
	 * @参数 goodsId表示店铺的ID值
	 * @返回值 list集合
	 */
	public List showSingleShopGoodsServ(int shopId) {
		
		return goodsDao.showSingleShopGoodsDao(shopId);
	}
	
	/**
	 * @功能 显示单个商店的个别商品
	 * @参数 goodsId表示店铺的ID值，num为查询条数
	 * @返回值 list集合
	 */
	public List showSingleShopGoodsServ(int shopId,int num) {
		
		return goodsDao.showSingleShopGoodsDao(shopId,num);
	}
	
	public List showSingleShopGoodsServ(int shopId,int goodsTypeId,int isNew_Vip_KillGoods,int num){
		return goodsDao.showSingleShopGoodsDao(shopId, goodsTypeId, isNew_Vip_KillGoods, num);
	}
	
	/**
	 * @功能 根据用户关键字搜索显示查询商品列表
	 * @参数 keywords表示用户查询的关键字
	 * @返回值 list集合
	 */
	public List showKeyWordsGoodsServ(String keywords){
	
		return goodsDao.showKeyWordsGoodsDao(keywords);
	}

	/**
	 * @功能 显示未审核商品
	 * @参数 
	 * @返回值 list集合
	 */
	public List showAllNoCheckGoodsServ() {
		
		return goodsDao.showAllNoCheckGoodsDao();
	}
	/**
	 * @功能 显示单个店铺未审核商品
	 * @参数 
	 * @返回值 list集合
	 */
	public List showShopNoCheckGoodsServ(int shopId){
		return goodsDao.showShopNoCheckGoodsDao(shopId);
	}
	
	/**
	 * @功能 审核商品
	 * @参数 goodsId表示传入的未审核商品的ID值
	 * @返回值 boolean型，审核商品是否成功
	 */
	public String[] checkGoodsServ(int goodsId) {
		
		f=goodsDao.checkGoodsDao(goodsId);
		if(f){
			//商品审核成功,跳转到原页面
			forward="GoodsServlet?action=showAllNoCheckGoods";
			message="<li>商品审核成功</li>";
		}else{
			//商品审核失败,跳转到原页面，给出提示
			forward="/admin/admin/checkGoods.jsp";
			message="<li>商品审核失败！请检查商品信息是否有错...</li>";
		}
		 String[] messages={message,forward};
		return messages ;
	}
	/**
	 * @功能 显示当个商店下架商品
	 * @参数 goodsId表示传入的下架商品的ID值
	 * @返回值 boolean型，下架商品是否成功
	 */
	public boolean is_soldOutServ(int goodsId){
		return goodsDao.is_soldOutDao(goodsId);
	}
	/**
	 * @功能 显示当个商店上架商品
	 * @参数 goodsId表示传入的上架商品的ID值
	 * @返回值 boolean型，上架商品是否成功
	 */
		public boolean putAwayGoodsServ(int goodsId){
			return goodsDao.putAwayGoodsDao(goodsId);
		}
		
	/**
	 * @功能 显示当个商店下架商品
	 * @参数 goodsId表示传入的未审核商品的ID值
	 * @返回值 boolean型，审核商品是否成功
	 */
		public List showSingleShopSoldOutServ(int shopId){
			return goodsDao.showSingleShopSoldOutDao(shopId);
			
		}	
		
		/**
		 * @功能 显示所有商店下架商品
		 * @参数 goodsId表示传入的未审核商品的ID值
		 * @返回值 boolean型，审核商品是否成功
		 */
		
		public List showAllShopSoldOutServ(){
			return goodsDao.showAllShopSoldOutDao();
		}
}
