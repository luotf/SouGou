package com.ltf.dao;

import java.util.List;

import com.ltf.vo.GoodsBean;

public interface GoodsDao {
	
	//1.增加商品
	public boolean addGoodsDao(GoodsBean goodsBean);	
	//2.刪除商品
	public boolean deleteGoodsDao(int goodsId);			
	//3.修改商品
	public boolean modifyGoodsDao(int goodsId,GoodsBean goodsBean);
	//4.显示所有商品列表
	public List showAllGoodsDao(int goodsTypeId,int isNew_Vip_KillGoods,int num);
	//5.显示单个商品详情
	public GoodsBean showSingleGoodsDao(int goodsId);     
	//6.显示单个商店所有商品	
	public List showSingleShopGoodsDao(int shopId);
	//7.显示单个商店个别商品	
	public List showSingleShopGoodsDao(int shopId,int num);
	//8.显示单个商店个别商品不同活动的商品
	public List showSingleShopGoodsDao(int shopId,int goodsTypeId,int isNew_Vip_KillGoods,int num);
	//9.查询商品的最大ID号
	public int showGoodsMaxId();
	//10.显示所有未审核商品列表	
	public List showAllNoCheckGoodsDao();
	//11.显示单个店铺的所有未审核商品列表	
	public List showShopNoCheckGoodsDao(int shopId);
	//12.根据用户的搜索关键字来显示商品列表
	public List showKeyWordsGoodsDao(String keywords);
	//13.审核商品
	public boolean checkGoodsDao(int goodsId);
	//14.下架商品
	public boolean is_soldOutDao(int goodsId);
	//15.上架商品
	public boolean putAwayGoodsDao(int goodsId);
	//16.查询当个商店下架商品
	public List showSingleShopSoldOutDao(int shopId);
	//17.查询所有商店下架商品
	public List showAllShopSoldOutDao();
}
