package com.ltf.dao;

import java.util.List;

import com.ltf.vo.UserBean;

public interface UserDao {
	
	//1.增加用户
	public boolean addUserDao(UserBean userBean);
	//2.删除用户
	public boolean deleteUserDao(int userId);
	//3.修改用户基本信息
	public boolean modifyUserDao(int userId,UserBean userBean);
	//4.修改用户密码
	public boolean modifyUserPasswordDao(int userId,String userPassword);
	//5.显示所有用户列表
	public List showAllUserDao();
	//6.按ID显示单个用户信息
	public UserBean showSingleUserDao(int userId);
	//7.按名称显示单个用户信息
	public UserBean showSingleUserDao(String userName);
	//8.用户登录
	public boolean userLoginDao(UserBean userBean);
	//9.检查用户名是否存在
	public boolean checkUserExistDao(String userName);
	//7.查询用户的最大ID号
		public int showUserMaxId();
	
}
