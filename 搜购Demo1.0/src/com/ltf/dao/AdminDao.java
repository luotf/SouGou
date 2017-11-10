package com.ltf.dao;

import java.util.List;

import com.ltf.vo.AdminBean;

public interface AdminDao {
	
	//1.增加管理员
	public boolean addAdminDao(AdminBean adminBean);
	//2.删除管理员	
	public boolean deleteAdminDao(int adminId);
	//3.修改管理员个人信息
	public boolean modifyAdminDao(int adminId,AdminBean adminBean);
	//4.修改管理员密码
	public boolean modifyAdminPasswordDao(int adminId,String adminPassword);
	//5.显示所有已审核/未审核管理员	
	public List showAllAdminDao(int tag);
	//6.按照ID显示单个管理员信息	
	public AdminBean showSingleAdminDao(int adminId);
	//6.按照名称显示单个管理员信息	
	public AdminBean showSingleAdminDao(String adminName);
	//7.管理员登陆	
	public boolean adminLoginDao(AdminBean adminBean);
	//8.审核管理员	
	public boolean checkAdminDao(int adminId);
	//9.检查管理员是否存在
	public boolean checkAdminExistDao(String adminName);

}
