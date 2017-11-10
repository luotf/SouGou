package com.ltf.vo;

public class GoodsTypeBean {
	private int goodsTypeId=-1;                      //商品类别ID
	private String goodsTypeName="";                 //商品类别名称
	private String goodsTypeAddTime="";              //商品类别添加时间
	private int tag=-1;                              //商品类别审核情况(0:未审核，1:已审核)
	
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public String getGoodsTypeAddTime() {
		return goodsTypeAddTime;
	}
	public void setGoodsTypeAddTime(String goodsTypeAddTime) {
		this.goodsTypeAddTime = goodsTypeAddTime;
	}
	
	
}
