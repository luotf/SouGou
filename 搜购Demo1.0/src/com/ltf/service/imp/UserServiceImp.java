package com.ltf.service.imp;

import java.util.List;

import com.ltf.dao.AdminDao;
import com.ltf.dao.UserDao;
import com.ltf.dao.imp.AdminDaoImp;
import com.ltf.dao.imp.UserDaoImp;
import com.ltf.service.UserService;
import com.ltf.vo.AdminBean;
import com.ltf.vo.UserBean;

public class UserServiceImp implements UserService {
	
	UserDao userDao=new UserDaoImp();
	boolean f=false;
	String message="";
	String forward="";
	
	@Override
	public boolean userLoginServ(UserBean userBean) {
		
		return f=userDao.userLoginDao(userBean);
	}

	public UserBean showSingleUserServ(String userName){
		return userDao.showSingleUserDao(userName);
		
	}
	
	@Override
	public List showAllUserServ() {
		// TODO Auto-generated method stub
		return userDao.showAllUserDao();
	}

	@Override
	public UserBean showSingleUserServ(int userId) {
		// TODO Auto-generated method stub
		return userDao.showSingleUserDao(userId);
	}

	@Override
	public int showUserMaxId(){
		
		return userDao.showUserMaxId();
	}
	
	@Override
	public String[] addUserServ(UserBean userBean) {
		f=userDao.addUserDao(userBean);
		if(f){
			//增加用户成功
			forward="/front/user/register-2.jsp";
			message="<li>增加用户成功</li>";
		}
		else{
			//增加用户失败
			forward="/front/user/index.jsp";
			message="<li>增加用户失败</li>";
		}
		 String[] messages={message,forward};
		return messages ;
	}

	@Override
	public String[] modifyUserServ(int userId, UserBean userBean) {
		f=userDao.modifyUserDao(userId, userBean);
		if(f){
			//修改用户个人信息成功
			forward="/front/user/userInfo.jsp";
			message="<li>修改用户个人信息成功</li>";
		}
		else{
			//修改用户个人信息失败
			forward="/front/user/userInfo.jsp";
			message="<li>修改用户个人信息失败</li>";
		}
		 String[] messages={message,forward};
		return messages ;
	}

	@Override
	public String[] modifyUserPasswordServ(int userId, String userPassword) {
		f=userDao.modifyUserPasswordDao(userId, userPassword);
		if(f){
			//修改用户信息成功
			forward="/admin/user/show.jsp";
			message="<li>修改用户信息成功</li>";
		}
		else{
			//修改用户密码失败
			forward="/front/user/index.jsp";
			message="<li>修改用户密码失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] deleteUserServ(int userId) {
		f=userDao.deleteUserDao(userId);
		if(f){
			//删除用户成功
			forward="/admin/user/show.jsp";
			message="<li>删除用户成功</li>";
		}
		else{
			//删除用户失败
			forward="/front/user/index.jsp";
			message="<li>删除用户失败</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
	}

	@Override
	public String[] checkUserExistServ(String userName) {
		f=userDao.checkUserExistDao(userName);
		if(f){
			//用户名不存在
			forward="/admin/user/success.jsp";
			//message="/images/icon/gou.png";
			message="<img src='images/icon/gou.png' style='margin-top:10px;'>";
		}
		else{
			//用户名存在，不可以使用
			forward="/front/user/error.jsp";
			message="用户名存在，不可以使用";
		}
		String[] messages={""+message,""+forward};
		return messages ;
	}

}
