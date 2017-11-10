package com.ltf.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltf.conn.DB;
import com.ltf.dao.GoodsTypeDao;
import com.ltf.vo.GoodsBean;
import com.ltf.vo.GoodsTypeBean;

public class GoodsTypeDaoImp extends DB implements GoodsTypeDao {
	 
	 Connection conn;
	 PreparedStatement  ps;
	 ResultSet  rs;
	 GoodsTypeBean goodsTypeBean;
	 boolean f=false;
	
	/**
	 * @功能 增加商品类别
	 * @参数 goodsTypeBean传入的GoodsTypeBean对象
	 * @返回值 boolean型，增加商品是否成功
	 */
	public boolean addGoodsTypeDao(GoodsTypeBean goodsTypeBean) {
		String sql="insert into goodstype"
				+ "(goodsTypeName,goodsTypeAddTime,tag) "
				+ "values(?,?,?)";
		int i=this.excuteUpdate(sql, new String[]
				{goodsTypeBean.getGoodsTypeName(),goodsTypeBean.getGoodsTypeAddTime(),""+goodsTypeBean.getTag()});
		 if(i>0) 
			f=true;
		return f;
	}

	/**
	 * @功能 删除商品类别
	 * @参数 goodsTypeId传入要删除类别的ID值
	 * @返回值 boolean型，删除商品是否成功
	 */
	public boolean deleteGoodsTypeDao(int goodsTypeId) {
		String sql="delete from goodstype where goodsTypeId=?";
		int i=this.excuteUpdate(sql, new String[]{""+goodsTypeId});
		if(i>0)
			f=true;
		return f;
	}
	
	/**
	 * @功能 修改商品类别
	 * @参数 goodsTypeId传入要修改类别的ID值
	 * @返回值 boolean型，增加商品是否成功
	 */
	public boolean modifyGoodsTypeDao(int goodsTypeId,GoodsTypeBean goodsTypeBean) {
		String sql="update goodstype set goodsTypeName=?where goodsTypeId=?";
		int i=this.excuteUpdate(sql, new String[]{goodsTypeBean.getGoodsTypeName(),""+goodsTypeId});
		if(i>0)
			f=true;
		return f;
	}

	/**
	 * @功能 显示所有商品类别
	 * @参数 
	 * @返回值 list集合
	 */
	public List showAllGoodsTypeDao() {
		List goodsTypeList = new ArrayList();
		String sql = "select * from goodstype";
		rs=this.excuteQuery(sql,null);
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品类别信息 */
					goodsTypeBean = new GoodsTypeBean();
					goodsTypeBean.setGoodsTypeId(rs.getInt(1));
					goodsTypeBean.setGoodsTypeName(rs.getString(2));
					goodsTypeBean.setGoodsTypeAddTime(rs.getString(3));
					goodsTypeBean.setTag(rs.getInt(4));
					goodsTypeList.add(goodsTypeBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsTypeList;
	}

	/**
	 * @功能 显示单个类别信息
	 * @参数 goodsTypeId传入要显示类别信息的ID值
	 * @返回值 GoodsTypeBean
	 */
	public GoodsTypeBean showSingleGoodsTypeDao(int goodsTypeId) {
		String sql = "select * from goodstype where goodsTypeId=?";
		rs=this.excuteQuery(sql,new String[]{""+goodsTypeId});
		if(rs!=null){
			try {
				while (rs.next()) {
					
					/* 获取单个类别具体信息 */
					goodsTypeBean = new GoodsTypeBean();
					goodsTypeBean.setGoodsTypeId(rs.getInt(1));
					goodsTypeBean.setGoodsTypeName(rs.getString(2));
					goodsTypeBean.setGoodsTypeAddTime(rs.getString(3));
					goodsTypeBean.setTag(rs.getInt(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsTypeBean;
		
	}
	
	/**
	 * @功能 查看该商品类别是否存在
	 * @参数 goodsTypeName传入要查看是否存在的类别信息的名称
	 * @返回值  boolean型，返回是否存在，返回true表示存在相同类别
	 */
		public boolean checkGoodsTypeExistDao(String goodsTypeName){
			String sql = "select * from goodstype where goodsTypeName=?";
			rs=this.excuteQuery(sql,new String[]{goodsTypeName});
			if(rs==null){
				f=true;
			}
			return f;
		}

}
