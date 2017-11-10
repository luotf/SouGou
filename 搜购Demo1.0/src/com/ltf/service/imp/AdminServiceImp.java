package com.ltf.service.imp;

import java.util.List;

import com.ltf.dao.AdminDao;
import com.ltf.dao.ShopDao;
import com.ltf.dao.imp.AdminDaoImp;
import com.ltf.dao.imp.ShopDaoImp;
import com.ltf.service.AdminService;
import com.ltf.vo.AdminBean;
import com.ltf.vo.ShopBean;

public class AdminServiceImp implements AdminService {
	AdminDao adminDao=new AdminDaoImp();
	boolean f=false;
	String message="";
	String forward="";
	
	@Override
	public boolean adminLoginServ(AdminBean adminBean) {
		
		return adminDao.adminLoginDao(adminBean);
	}

	@Override
	public List showAllAdminServ(int tag) {
		
		return adminDao.showAllAdminDao(tag);
	}

	@Override
	public AdminBean showSingleAdminServ(int adminId) {
		
		return adminDao.showSingleAdminDao(adminId);
	}
	//3.按照用户名查看单个管理员信息
	public AdminBean showSingleAdminServ(String adminName){
		return adminDao.showSingleAdminDao(adminName);
		
	}
	

	@Override
	public String[] addAdminServ(AdminBean adminBean) {
		f=adminDao.addAdminDao(adminBean);
		if(f){
			//增加管理员成功
			forward="/admin/shop/show.jsp";
			message="<li>增加管理员成功</li>";
		}
		else{
			//增加管理员失败
			forward="/front/shop/index.jsp";
			message="<li>增加管理员失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] modifyAdminServ(int adminId, AdminBean adminBean) {
		f=adminDao.modifyAdminDao(adminId, adminBean);
		if(f){
			//修改管理员个人信息成功
			forward="/admin/shop/show.jsp";
			message="<li>修改管理员个人信息成功</li>";
		}
		else{
			//修改管理员个人信息失败
			forward="/front/shop/index.jsp";
			message="<li>修改管理员个人信息失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] modifyAdminPasswordServ(int adminId, String adminPassword) {
		f=adminDao.modifyAdminPasswordDao(adminId, adminPassword);
		if(f){
			//修改管理员信息成功
			forward="/admin/shop/show.jsp";
			message="<li>修改管理员信息成功</li>";
		}
		else{
			//修改管理员密码失败
			forward="/front/shop/index.jsp";
			message="<li>修改管理员密码失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] deleteAdminServ(int adminId) {
		f=adminDao.deleteAdminDao(adminId);
		if(f){
			//删除管理员成功
			forward="/admin/shop/show.jsp";
			message="<li>删除管理员成功</li>";
		}
		else{
			//删除管理员失败
			forward="/front/shop/index.jsp";
			message="<li>删除管理员失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] checkAdminServ(int adminId) {
		f=adminDao.checkAdminDao(adminId);
		if(f){
			//审核管理员成功
			forward="/admin/shop/show.jsp";
			message="<li>审核管理员成功</li>";
		}
		else{
			//审核管理员失败
			forward="/front/shop/index.jsp";
			message="<li>审核管理员失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] checkAdminExistServ(String adminName) {
		f=adminDao.checkAdminExistDao(adminName);
		if(f){
			//管理员名不存在
			forward="/admin/goodsType/success.jsp";
			message="<li>管理员名不存在，可以使用</li>";
		}
		else{
			//管理员名存在，不可以使用
			forward="/front/goods/error.jsp";
			message="<li>店管理员名存在，不可以使用</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

}
