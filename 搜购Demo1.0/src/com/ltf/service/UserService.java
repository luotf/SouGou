package com.ltf.service;

import java.util.List;

import com.ltf.vo.AdminBean;
import com.ltf.vo.UserBean;

public interface UserService {
			//1.普通用户登录
			public boolean userLoginServ(UserBean userBean);
			//2.查看所有审核和未审核的普通用户
			public List showAllUserServ();
			//3.按照ID查看单个普通用户信息
			public UserBean showSingleUserServ(int userId);
			//4.按照用户名查看单个普通用户信息
			public UserBean showSingleUserServ(String userName);
			//5.普通用户增加
			public String[] addUserServ(UserBean userBean);
			//6.修改普通用户信息
			public String[] modifyUserServ(int userId,UserBean userBean);
			//7.修改普通用户登录密码
			public String[] modifyUserPasswordServ(int userId,String userPassword);
			//8.删除普通用户
			public String[] deleteUserServ(int userId);
			//9.检查普通用户名是否存在	
			public String[] checkUserExistServ(String userName);
			//7.显示最大的用户ID号
			public int showUserMaxId();
}
