package com.ltf.service;

import java.util.List;

import com.ltf.vo.GoodsBean;

public interface GoodsService {
	
	//1.增加商品
	public String[] addGoodsServ(GoodsBean goodsBean);	
	//2.刪除商品
	public boolean deleteGoodsServ(int goodsId);			
	//3.修改商品
	public String[] modifyGoodsServ(int goodsId,GoodsBean goodsBean);
	//4.显示所有商品列表
	public List showAllGoodsServ(int goodsTypeId,int isNew_Vip_KillGoods,int num);
	//5.显示单个商品详情
	public GoodsBean showSingleGoodsServ(int goodsId);     
	//6.显示单个商店所有商品	
	public List showSingleShopGoodsServ(int shopId);
	//7.显示单个商店个别商品	
	public List showSingleShopGoodsServ(int shopId,int num);
	//8.显示单个商店个别商品的活动商品	
	public List showSingleShopGoodsServ(int shopId,int goodsTypeId,int isNew_Vip_KillGoods,int num);
	//9.显示最大的商品ID号
	public int showGoodsMaxId();
	//10.按用户关键字搜索显示商品列表
	public List showKeyWordsGoodsServ(String keywords);
	//11.显示所有未审核商品列表	
	public List showAllNoCheckGoodsServ();
	//12.显示单个未审核商品列表	
	public List showShopNoCheckGoodsServ(int shopId);
	//13.审核商品
	public String[] checkGoodsServ(int goodsId);
	//14.下架商品
	public boolean is_soldOutServ(int goodsId);
	//15.上架商品
	public boolean putAwayGoodsServ(int goodsId);
	//16.显示当个商店下架商品
	public List showSingleShopSoldOutServ(int shopId);
	//17.显示所有商店下架商品
	public List showAllShopSoldOutServ();
}
