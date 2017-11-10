package com.ltf.vo;

public class GoodsBean {
	private int goodsId=-1;                           //商品ID
	private int shopId=-1;                            //商品所属店铺
	private int goodsTypeId=-1;                       //商品所属类别
	private String goodsName="";                      //商品名称
	private String goodsIntroduce="";                 //商品信息介绍
	private String goodsPictureMax="";                //商品详情页面图片展示的图片路径
	private String goodsPictureView1="";              //商品详情页面图片展示1的图片路径
	private String goodsPictureView2="";              //商品详情页面图片展示2的图片路径
	private String goodsPictureView3="";              //商品详情页面图片展示3的图片路径
	private String goodsAddress="";                   //商品所在地址
	private String goodsAddTime="";                   //商品上传时间
	private float goodsPrice=0;                       //商品价格
	private float goodsVipPrice=0;                    //商品打折价格
	private float goodsKillPrice=0;                   //商品秒杀价格
	private int isNew_Vip_KillGoods=0;                //商品是否为新品、打折品、秒杀品（默认0，无任何活动，1为新品，2为打折品，3为秒杀品）
	private int goodsCollectNum=0;                    //商品收藏次数
	private int goodsReadNum=0;                       //商品浏览数目
	private int tag=-1;                               //商品审核情况(0：未审核，1：已审核)
	private int is_soldOut=-1; 						  //商品是否上架
	
	
	public int getIs_soldOut() {
		return is_soldOut;
	}
	public void setIs_soldOut(int is_soldOut) {
		this.is_soldOut = is_soldOut;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}
	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}
	
	public String getGoodsPictureMax() {
		return goodsPictureMax;
	}
	public void setGoodsPictureMax(String goodsPictureMax) {
		this.goodsPictureMax = goodsPictureMax;
	}
	public String getGoodsPictureView1() {
		return goodsPictureView1;
	}
	public void setGoodsPictureView1(String goodsPictureView1) {
		this.goodsPictureView1 = goodsPictureView1;
	}
	public String getGoodsPictureView2() {
		return goodsPictureView2;
	}
	public void setGoodsPictureView2(String goodsPictureView2) {
		this.goodsPictureView2 = goodsPictureView2;
	}
	public String getGoodsPictureView3() {
		return goodsPictureView3;
	}
	public void setGoodsPictureView3(String goodsPictureView3) {
		this.goodsPictureView3 = goodsPictureView3;
	}
	public String getGoodsAddress() {
		return goodsAddress;
	}
	public void setGoodsAddress(String goodsAddress) {
		this.goodsAddress = goodsAddress;
	}
	public String getGoodsAddTime() {
		return goodsAddTime;
	}
	public void setGoodsAddTime(String goodsAddTime) {
		this.goodsAddTime = goodsAddTime;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public float getGoodsVipPrice() {
		return goodsVipPrice;
	}
	public void setGoodsVipPrice(float goodsVipPrice) {
		this.goodsVipPrice = goodsVipPrice;
	}
	public float getGoodsKillPrice() {
		return goodsKillPrice;
	}
	public void setGoodsKillPrice(float goodsKillPrice) {
		this.goodsKillPrice = goodsKillPrice;
	}
	public int getIsNew_Vip_KillGoods() {
		return isNew_Vip_KillGoods;
	}
	public void setIsNew_Vip_KillGoods(int isNew_Vip_KillGoods) {
		this.isNew_Vip_KillGoods = isNew_Vip_KillGoods;
	}
	public int getGoodsCollectNum() {
		return goodsCollectNum;
	}
	public void setGoodsCollectNum(int goodsCollectNum) {
		this.goodsCollectNum = goodsCollectNum;
	}
	public int getGoodsReadNum() {
		return goodsReadNum;
	}
	public void setGoodsReadNum(int goodsReadNum) {
		this.goodsReadNum = goodsReadNum;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	
}
