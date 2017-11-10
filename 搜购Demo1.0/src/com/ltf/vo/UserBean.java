package com.ltf.vo;

public class UserBean {
	private int userId=-1;                          //用户ID
	private String userName="";						//用户名
	private String userPassword="";					//用户密码	
	private String userNickName="";					//用户昵称
	private String userPhone="";					//电话号码
	private String userEmail="";                    //用户邮箱
	private String userImages="";					//用户头像
	private String userSex="";						//用户性别
	private String userAddTime="";					//用户添加时间
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserImages() {
		return userImages;
	}
	public void setUserImages(String userImages) {
		this.userImages = userImages;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserAddTime() {
		return userAddTime;
	}
	public void setUserAddTime(String userAddTime) {
		this.userAddTime = userAddTime;
	}
	
}
