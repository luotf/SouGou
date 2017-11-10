package com.ltf.dao;

import java.util.List;

import com.ltf.vo.GoodsTypeBean;

public interface GoodsTypeDao {
	
	//1.增加商品类别
	public boolean addGoodsTypeDao(GoodsTypeBean goodsTypeBean);
	//2.删除商品类别
	public boolean deleteGoodsTypeDao(int goodsTypeId);
	//3.修改商品类别
	public boolean modifyGoodsTypeDao(int goodsTypeId,GoodsTypeBean goodsTypeBean);
	//4.显示所有商品类别
	public List showAllGoodsTypeDao();
	//5.显示单个类别信息
	public GoodsTypeBean showSingleGoodsTypeDao(int goodsTypeId);
	//6.查看该商品类别是否存在
	public boolean checkGoodsTypeExistDao(String goodsTypeName);
}
