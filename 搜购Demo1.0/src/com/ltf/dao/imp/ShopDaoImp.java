package com.ltf.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltf.conn.DB;
import com.ltf.dao.ShopDao;
import com.ltf.vo.GoodsTypeBean;
import com.ltf.vo.ShopBean;

public class ShopDaoImp extends DB implements ShopDao {
	 Connection conn;
	 PreparedStatement  ps;
	 ResultSet  rs;
	 ShopBean shopBean=null;
	 boolean f=false;
	 
	 
	@Override
	public boolean addShopDao(ShopBean shopBean) {
		boolean f=false;
		String sql="insert into shop"
				+ "(shopName,shopPassword,shopNickName,shopIntroduce,shopManager,shopPhone,shopMainImages,shopAddress,"
				+ "shopAddTime,tag)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		int i=this.excuteUpdate(sql, new String[]
				{shopBean.getShopName(),shopBean.getShopPassword(),shopBean.getShopNickName(),
				shopBean.getShopIntroduce(),shopBean.getShopManager(),shopBean.getShopPhone(),
				shopBean.getShopMainImages(),shopBean.getShopAddress(),
				shopBean.getShopAddTime(),""+shopBean.getTag()});
		 if(i>0) 
			f=true;
		return f;
		
	}

	@Override
	public boolean deleteShopDao(int shopId) {
		boolean f=false;
		String sql="delete from shop where shopId=?";
		int i=this.excuteUpdate(sql, new String[]{""+shopId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean modifyShopDao(int shopId,ShopBean shopBean) {
		boolean f=false;
		String sql="update shop set shopNickName=?,shopIntroduce=?,shopManager=?"
				+ "shopPhone=?,shopMainImages=?,shopAddress=?where shopId=?";
		int i=this.excuteUpdate(sql, new String[]{shopBean.getShopNickName(),shopBean.getShopIntroduce(),
		shopBean.getShopManager(),shopBean.getShopPhone(),shopBean.getShopMainImages(),
		shopBean.getShopAddress(),""+shopId});
		if(i>0)
			f=true;
		return f;
	}
	
	
	public int showShopMaxId(){
		int maxId = 0;
		String sql = "select max(shopId) from shop";
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
	public boolean modifyShopPasswordDao(int shopId, String shopPassword) {
		boolean f=false;
		String sql="update shop set shopPassword=?where shopId=?";
		int i=this.excuteUpdate(sql, new String[]{shopPassword,""+shopId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public List showAllShopDao(int tag) {
		List allShopList = new ArrayList();
		String sql = "select * from shop where tag=?";
		rs=this.excuteQuery(sql,new String[]{""+tag});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					shopBean = new ShopBean();
					shopBean.setShopId(rs.getInt(1));
					shopBean.setShopName(rs.getString(2));
					shopBean.setShopPassword(rs.getString(3));
					shopBean.setShopNickName(rs.getString(4));
					shopBean.setShopIntroduce(rs.getString(5));
					shopBean.setShopManager(rs.getString(6));
					shopBean.setShopPhone(rs.getString(7));
					shopBean.setShopMainImages(rs.getString(8));
					shopBean.setShopAddress(rs.getString(9));
					shopBean.setShopAddTime(rs.getString(10));
					shopBean.setTag(rs.getInt(11));
					allShopList.add(shopBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allShopList;
	}

	@Override
	public ShopBean showSingleShopDao(int shopId) {
		String sql = "select * from shop where shopId=?";
		rs=this.excuteQuery(sql,new String[]{""+shopId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					shopBean = new ShopBean();
					shopBean.setShopId(rs.getInt(1));
					shopBean.setShopName(rs.getString(2));
					shopBean.setShopPassword(rs.getString(3));
					shopBean.setShopNickName(rs.getString(4));
					shopBean.setShopIntroduce(rs.getString(5));
					shopBean.setShopManager(rs.getString(6));
					shopBean.setShopPhone(rs.getString(7));
					shopBean.setShopMainImages(rs.getString(8));
					shopBean.setShopAddress(rs.getString(9));
					shopBean.setShopAddTime(rs.getString(10));
					shopBean.setTag(rs.getInt(11));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shopBean;
	}

	public ShopBean showSingleShopDao(String shopName){
		
		String sql = "select * from shop where shopName=?";
		rs=this.excuteQuery(sql,new String[]{shopName});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					shopBean = new ShopBean();
					shopBean.setShopId(rs.getInt(1));
					shopBean.setShopName(rs.getString(2));
					shopBean.setShopPassword(rs.getString(3));
					shopBean.setShopNickName(rs.getString(4));
					shopBean.setShopIntroduce(rs.getString(5));
					shopBean.setShopManager(rs.getString(6));
					shopBean.setShopPhone(rs.getString(7));
					shopBean.setShopMainImages(rs.getString(8));
					shopBean.setShopAddress(rs.getString(9));
					shopBean.setShopAddTime(rs.getString(10));
					shopBean.setTag(rs.getInt(11));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shopBean;

	}
	
	@Override
	public boolean shopLoginDao(ShopBean shopBean) {
		boolean f=false;
		String sql = "select * from shop where shopName=? and shopPassword=?";
		rs=this.excuteQuery(sql,new String[]{shopBean.getShopName(),shopBean.getShopPassword()});
		try {
			if(rs.next())
				f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkShopDao(int shopId) {
		boolean f=false;
		String sql="update shop set tag=1 where shopId=?";
		int i=this.excuteUpdate(sql, new String[]{""+shopId});
		if(i>0)
			f=true;
		return f;
	}

	@Override
	public boolean checkShopExistDao(String shopName) {
		boolean f=false;
		String sql = "select * from shop where shopName=?";
		rs=this.excuteQuery(sql,new String[]{shopName});
		if(rs==null)
			f=true;
		return f;
	}

}
