package com.ltf.vo;

public class ShopBean {
	private int shopId=-1;                           //商家ID
	private String shopName="";                      //店铺名称
	private String shopPassword="";                 //店铺介绍
	private String shopNickName="";                 //店铺名称
	private String shopIntroduce="";                 //店铺介绍
	private String shopManager="";                   //店长
	private String shopPhone="";                     //商店电话号码
	private String shopMainImages="";                //店铺封面照片
	private String shopAddress="";                   //店铺所处地址
	private String shopAddTime="";                   //店铺添加时间
	private int tag=-1;                              //店铺审核情况(0:未审核，1:已审核)
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	public String getShopPassword() {
		return shopPassword;
	}
	public void setShopPassword(String shopPassword) {
		this.shopPassword = shopPassword;
	}
	public String getShopNickName() {
		return shopNickName;
	}
	public void setShopNickName(String shopNickName) {
		this.shopNickName = shopNickName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopIntroduce() {
		return shopIntroduce;
	}
	public void setShopIntroduce(String shopIntroduce) {
		this.shopIntroduce = shopIntroduce;
	}
	public String getShopManager() {
		return shopManager;
	}
	public void setShopManager(String shopManager) {
		this.shopManager = shopManager;
	}
	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public String getShopMainImages() {
		return shopMainImages;
	}
	public void setShopMainImages(String shopMainImages) {
		this.shopMainImages = shopMainImages;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopAddTime() {
		return shopAddTime;
	}
	public void setShopAddTime(String shopAddTime) {
		this.shopAddTime = shopAddTime;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	
}
