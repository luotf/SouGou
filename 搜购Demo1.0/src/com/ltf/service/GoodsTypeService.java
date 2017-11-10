package com.ltf.service;

import java.util.List;

import com.ltf.vo.GoodsTypeBean;

public interface GoodsTypeService {
		//1.增加商品类别
		public String[] addGoodsTypeServ(GoodsTypeBean goodsTypeBean);
		//2.删除商品类别
		public String[] deleteGoodsTypeServ(int goodsTypeId);
		//3.修改商品类别
		public String[] modifyGoodsTypeServ(int goodsTypeId,GoodsTypeBean goodsTypeBean);
		//4.显示所有商品类别
		public List showAllGoodsTypeServ();
		//5.显示单个类别信息
		public GoodsTypeBean showSingleGoodsTypeServ(int goodsTypeId);
		//6.检查商品类别是否存在
		public String[] checkGoodsTypeExistServ(String goodsTypeName);
}
