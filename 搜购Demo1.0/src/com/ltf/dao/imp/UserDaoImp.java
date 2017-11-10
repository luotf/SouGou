package com.ltf.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltf.conn.DB;
import com.ltf.dao.UserDao;
import com.ltf.vo.AdminBean;
import com.ltf.vo.ShopBean;
import com.ltf.vo.UserBean;

public class UserDaoImp extends DB implements UserDao {

	 Connection conn;
	 PreparedStatement  ps;
	 ResultSet  rs;
	 UserBean userBean;
	
	@Override
	public boolean addUserDao(UserBean userBean) {
		 boolean f=false;
		String sql="insert into user (userName,userPassword,userNickName,userEmail,userPhone,"
				+ "userImages,userSex,userAddTime)"
				+ "values(?,?,?,?,?,?,?,?)";
		int i=this.excuteUpdate(sql, new String[]
				{userBean.getUserName(),userBean.getUserPassword(),userBean.getUserNickName(),
				userBean.getUserEmail(),userBean.getUserPhone(),userBean.getUserImages(),
				userBean.getUserSex(),userBean.getUserAddTime()});
		 if(i>0) 
			f=true;
		return f;
	}

	public int showUserMaxId(){
		int maxId = 0;
		String sql = "select max(userId) from user";
		rs = this.excuteQuery(sql, null);
		if(rs!=null){
			try {
				if(rs.next())
					maxId = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maxId;
}
	
	@Override
	public boolean deleteUserDao(int userId) {
		 boolean f=false;
		String sql="delete from user where userId=?";
		int i=this.excuteUpdate(sql, new String[]{""+userId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean modifyUserDao(int userId,UserBean userBean) {
		 boolean f=false;
		String sql="update user set userNickName=?,userEmail=?,"
				+ "userPhone=?,userImages=?,userSex=? where userId=?";
		int i=this.excuteUpdate(sql, new String[]{userBean.getUserNickName(),
				userBean.getUserEmail(),userBean.getUserPhone(),userBean.getUserImages(),
				userBean.getUserSex(),""+userId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean modifyUserPasswordDao(int userId, String userPassword) {
		 boolean f=false;
		String sql="update user set userPassword=?where userId=?";
		int i=this.excuteUpdate(sql, new String[]{userPassword,""+userId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public List showAllUserDao() {
		List allUserList = new ArrayList();
		String sql = "select * from user";
		rs=this.excuteQuery(sql,null);
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					userBean = new UserBean();
					userBean.setUserId((rs.getInt(1)));
					userBean.setUserName(rs.getString(2));
					userBean.setUserPassword(rs.getString(3));
					userBean.setUserNickName(rs.getString(4));
					userBean.setUserEmail(rs.getString(5));
					userBean.setUserPhone(rs.getString(6));
					userBean.setUserImages(rs.getString(7));
					userBean.setUserAddTime(rs.getString(8));
					userBean.setUserAddTime(rs.getString(9));
					allUserList.add(userBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allUserList;
	}

	@Override
	public UserBean showSingleUserDao(int userId) {
		String sql = "select * from user where userId=?";
		rs=this.excuteQuery(sql,new String[]{""+userId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					userBean = new UserBean();
					userBean.setUserId((rs.getInt(1)));
					userBean.setUserName(rs.getString(2));
					userBean.setUserPassword(rs.getString(3));
					userBean.setUserNickName(rs.getString(4));
					userBean.setUserEmail(rs.getString(5));
					userBean.setUserPhone(rs.getString(6));
					userBean.setUserImages(rs.getString(7));
					userBean.setUserAddTime(rs.getString(8));
					userBean.setUserAddTime(rs.getString(9));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userBean;
	}

	@Override
	public UserBean showSingleUserDao(String userName) {
	//	select * from user where userName=?
		String sql = "select * from user where userName=?";
		rs=this.excuteQuery(sql,new String[]{userName});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取用户信息 */
					userBean = new UserBean();
					userBean.setUserId((rs.getInt(1)));
					userBean.setUserName(rs.getString(2));
					userBean.setUserPassword(rs.getString(3));
					userBean.setUserNickName(rs.getString(4));
					userBean.setUserEmail(rs.getString(5));
					userBean.setUserPhone(rs.getString(6));
					userBean.setUserImages(rs.getString(7));
					userBean.setUserAddTime(rs.getString(8));
					userBean.setUserAddTime(rs.getString(9));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userBean;
	}

	@Override
	public boolean userLoginDao(UserBean userBean) {
		 boolean f=false;
		String sql = "select * from user where userName=? and userPassword=?";
		//System.out.println("账号："+userBean.getUserName()+"——"+"密码："+userBean.getUserPassword());
		rs=this.excuteQuery(sql,new String[]{userBean.getUserName(),userBean.getUserPassword()});
		//System.out.println(rs);
		try {
			if(rs.next())
				f=true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkUserExistDao(String userName) {
		 
		boolean f=false;
		String sql = "select * from user where userName=?";
		rs=this.excuteQuery(sql,new String[]{userName});
		
		try {
			if(!rs.next())
				f=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
 
}
