package com.ltf.vo;

public class AdminBean {
	private int adminId=-1;                      //普通管理员ID
	private String adminName="";				//普通管理员用户名
	private String adminPassword="";			//普通管理员密码
	private String adminNickName="";			//普通管理员昵称
	private String adminPhone="";					//普通管理员电话号码
	private String adminImages="";				//普通管理员头像
	private String adminAddTime="";				//普通管理员添加时间
	private int tag=-1;							//普通管理员审核情况(0：未审核，1：已审核)
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminNickName() {
		return adminNickName;
	}
	public void setAdminNickName(String adminNickName) {
		this.adminNickName = adminNickName;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public String getAdminImages() {
		return adminImages;
	}
	public void setAdminImages(String adminImages) {
		this.adminImages = adminImages;
	}
	public String getAdminAddTime() {
		return adminAddTime;
	}
	public void setAdminAddTime(String adminAddTime) {
		this.adminAddTime = adminAddTime;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	
}
