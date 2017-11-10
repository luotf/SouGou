package com.ltf.dao;

import java.util.List;

import com.ltf.vo.SuperAdminBean;

public interface SuperAdminDao {

	//1.修改超管个人信息	 
	public boolean modifySuperAdmin(int superAdminId);
	//2.修改超管个人密码 
	public boolean modifySuperAdminPassword(int superAdminId,String password);
	//3.显示所有超管列表	
	public List showAllSuperAdmin();
	//4.显示超管信息
	public SuperAdminBean showSingleSuperAdmin(int superAdminId);
	//5.超管登陆	
	public boolean superAdminLogin(SuperAdminBean superAdminBean);

}
