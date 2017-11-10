package com.ltf.service;

import java.util.List;

import com.ltf.vo.AdminBean;

public interface AdminService {
		//1.管理员登录
		public boolean adminLoginServ(AdminBean adminBean);
		//2.查看所有审核和未审核的管理员
		public List showAllAdminServ(int tag);
		//3.按照ID查看单个管理员信息
		public AdminBean showSingleAdminServ(int adminId);
		//3.按照用户名查看单个管理员信息
		public AdminBean showSingleAdminServ(String adminName);
		//5.管理员增加
		public String[] addAdminServ(AdminBean adminBean);
		//6.修改管理员信息
		public String[] modifyAdminServ(int adminId,AdminBean adminBean);
		//7.修改管理员登录密码
		public String[] modifyAdminPasswordServ(int adminId,String adminPassword);
		//8.删除管理员
		public String[] deleteAdminServ(int adminId);
		//9.审核管理员	
		public String[] checkAdminServ(int adminId);
		//10.检查管理员名是否存在	
		public String[] checkAdminExistServ(String adminName);
}
