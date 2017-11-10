package com.ltf.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltf.conn.DB;
import com.ltf.dao.AdminDao;
import com.ltf.vo.AdminBean;
import com.ltf.vo.ShopBean;

public class AdminDaoImp extends DB implements AdminDao {
	
	 Connection conn;
	 PreparedStatement  ps;
	 ResultSet  rs;
	 AdminBean adminBean;
	
	 
	@Override
	public boolean addAdminDao(AdminBean adminBean) {
		 boolean f=false;
		String sql="insert into admin"
				+ "(adminName,adminPassword,adminNickName,adminPhone,"
				+ "adminImages,adminAddTime,tag)"
				+ "values(?,?,?,?,?,?,?)";
		int i=this.excuteUpdate(sql, new String[]
				{adminBean.getAdminName(),adminBean.getAdminPassword(),
				adminBean.getAdminNickName(),adminBean.getAdminPhone(),
				adminBean.getAdminImages(),adminBean.getAdminAddTime(),
				""+adminBean.getTag()});
		 if(i>0) 
			f=true;
		 	return f;
	}

	@Override
	public boolean deleteAdminDao(int adminId) {
		 boolean f=false;
		String sql="delete from admin where adminId=?";
		int i=this.excuteUpdate(sql, new String[]{""+adminId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean modifyAdminDao(int adminId, AdminBean adminBean) {
		 boolean f=false;
		String sql="update admin set adminNickName=?,adminPhone=?,"
				+ "adminImages=?where adminId=?";
		int i=this.excuteUpdate(sql, new String[]{adminBean.getAdminNickName(),adminBean.getAdminPhone(),
				adminBean.getAdminImages(),""+adminId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean modifyAdminPasswordDao(int adminId, String adminPassword) {
		 boolean f=false;
		String sql="update admin set adminPassword=?where adminId=?";
		int i=this.excuteUpdate(sql, new String[]{adminPassword,""+adminId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public List showAllAdminDao(int tag) {
		List allAdminList = new ArrayList();
		String sql = "select * from admin where tag=?";
		rs=this.excuteQuery(sql,new String[]{""+tag});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					adminBean = new AdminBean();
					adminBean.setAdminId((rs.getInt(1)));
					adminBean.setAdminName(rs.getString(2));
					adminBean.setAdminPassword(rs.getString(3));
					adminBean.setAdminNickName(rs.getString(4));
					adminBean.setAdminPhone(rs.getString(5));
					adminBean.setAdminImages(rs.getString(6));
					adminBean.setAdminAddTime(rs.getString(7));
					adminBean.setTag(rs.getInt(8));
					allAdminList.add(adminBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allAdminList;
	}

	@Override
	public AdminBean showSingleAdminDao(int adminId) {
		String sql = "select * from admin where adminId=?";
		rs=this.excuteQuery(sql,new String[]{""+adminId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取管理员信息 */
					adminBean = new AdminBean();
					adminBean.setAdminId((rs.getInt(1)));
					adminBean.setAdminName(rs.getString(2));
					adminBean.setAdminPassword(rs.getString(3));
					adminBean.setAdminNickName(rs.getString(4));
					adminBean.setAdminPhone(rs.getString(5));
					adminBean.setAdminImages(rs.getString(6));
					adminBean.setAdminAddTime(rs.getString(7));
					adminBean.setTag(rs.getInt(8));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return adminBean;
	}
	public AdminBean showSingleAdminDao(String adminName){
		String sql = "select * from admin where adminName=?";
		rs=this.excuteQuery(sql,new String[]{adminName});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取管理员信息 */
					adminBean = new AdminBean();
					adminBean.setAdminId((rs.getInt(1)));
					adminBean.setAdminName(rs.getString(2));
					adminBean.setAdminPassword(rs.getString(3));
					adminBean.setAdminNickName(rs.getString(4));
					adminBean.setAdminPhone(rs.getString(5));
					adminBean.setAdminImages(rs.getString(6));
					adminBean.setAdminAddTime(rs.getString(7));
					adminBean.setTag(rs.getInt(8));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return adminBean;
	}
	
	
	@Override
	public boolean adminLoginDao(AdminBean adminBean) {
		 boolean f=false;
		String sql = "select * from admin where adminName=? and adminPassword=?";
		rs=this.excuteQuery(sql,new String[]{adminBean.getAdminName(),adminBean.getAdminPassword()});
		try {
			if(rs.next())
				f=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkAdminDao(int adminId) {
		 boolean f=false;
		String sql="update admin set tag=1 where adminId=?";
		int i=this.excuteUpdate(sql, new String[]{""+adminId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean checkAdminExistDao(String adminName) {
		 boolean f=false;
		String sql = "select * from admin where adminName=?";
		rs=this.excuteQuery(sql,new String[]{adminName});
		if(rs==null)
			f=true;
		return f;
	}

}
