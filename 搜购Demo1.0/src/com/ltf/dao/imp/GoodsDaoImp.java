package com.ltf.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltf.conn.DB;
import com.ltf.dao.GoodsDao;
import com.ltf.vo.GoodsBean;

public class GoodsDaoImp extends DB implements GoodsDao {
	
	 Connection conn;
	 PreparedStatement  ps;
	 ResultSet  rs;
	 GoodsBean goodsBean;
	 boolean f=false;
	 @Override
	
	/**
	 * @功能 增加商品
	 * @参数 goodsBean表示传入的商品对象
	 * @返回值 boolean型，增加商品是否成功
	 */
	public boolean addGoodsDao(GoodsBean goodsBean) {
		
		String sql="insert into goods"
				+ "(shopId,goodsTypeId,goodsName,goodsIntroduce,"
				+ "goodsPictureMax,goodsPictureView1,goodsPictureView2,goodsPictureView3,"
				+ "goodsAddress,goodsPrice,goodsKillPrice,goodsVipPrice,isNew_Vip_KillGoods,"
				+ "goodsAddTime,goodsCollectNum,goodsReadNum,tag,is_soldOut) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i=this.excuteUpdate(sql, new String[]
				{""+goodsBean.getShopId(),""+goodsBean.getGoodsTypeId(),goodsBean.getGoodsName(),
				goodsBean.getGoodsIntroduce(),
				goodsBean.getGoodsPictureMax(),goodsBean.getGoodsPictureView1(),
				goodsBean.getGoodsPictureView2(),goodsBean.getGoodsPictureView3(),
				goodsBean.getGoodsAddress(),""+goodsBean.getGoodsPrice(),
				""+goodsBean.getGoodsKillPrice(),""+goodsBean.getGoodsVipPrice(),
				""+goodsBean.getIsNew_Vip_KillGoods(),""+goodsBean.getGoodsAddTime(),
				""+goodsBean.getGoodsCollectNum(),""+goodsBean.getGoodsReadNum(),
				""+goodsBean.getTag(),""+goodsBean.getIs_soldOut()});
		 if(i>0) 
			f=true;
		 	return f;
	}

	/**
	 * @功能 删除商品
	 * @参数 goodsId表示传入的商品的ID值
	 * @返回值 boolean型，删除商品是否成功
	 */
	public boolean deleteGoodsDao(int goodsId) {
		
		String sql="delete from goods where goodsId=?";
		int i=this.excuteUpdate(sql, new String[]{""+goodsId});
		if(i>0)
			f=true;
		return f;
	}

	/**
	 * @功能 查询单个商店下架商品
	 * @参数 goodsId表示传入的商品的ID值
	 * @返回值 List型，返回下架商品集合
	 */
		public List showSingleShopSoldOutDao(int shopId){
			List singleShopSoldOutGoodslist = new ArrayList();
			String sql = "select * from goods where shopId=? and is_soldOut=0 order by goodsId";
			rs=this.excuteQuery(sql, new String[]{""+shopId});
			if(rs!=null){
				try {
					while (rs.next()) {
						/* 获取商品信息 */
						goodsBean = new GoodsBean();
						goodsBean.setGoodsId(rs.getInt(1));
						goodsBean.setShopId(rs.getInt(2));
						goodsBean.setGoodsTypeId(rs.getInt(3));
						goodsBean.setGoodsName(rs.getString(4));
						goodsBean.setGoodsIntroduce(rs.getString(5));
						goodsBean.setGoodsPictureMax(rs.getString(6));					
						goodsBean.setGoodsPictureView1(rs.getString(7));
						goodsBean.setGoodsPictureView2(rs.getString(8));
						goodsBean.setGoodsPictureView3(rs.getString(9));
						goodsBean.setGoodsAddress(rs.getString(10));
						goodsBean.setGoodsPrice(rs.getInt(11));
						goodsBean.setGoodsKillPrice(rs.getInt(12));
						goodsBean.setGoodsVipPrice(rs.getInt(13));
						goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
						goodsBean.setGoodsAddTime(rs.getString(15));
						goodsBean.setGoodsCollectNum(rs.getInt(16));
						goodsBean.setGoodsReadNum(rs.getInt(17));
						goodsBean.setTag(rs.getInt(18));
						goodsBean.setIs_soldOut(rs.getInt(19));
						singleShopSoldOutGoodslist.add(goodsBean);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return singleShopSoldOutGoodslist;
		}
	/**
	* @功能 查询所有商店下架商品
	* @参数 goodsId表示传入的商品的ID值
	* @返回值 List型
	*/
		public List showAllShopSoldOutDao(){
			List allShopSoldOutGoodslist = new ArrayList();
			String sql = "select * from goods where is_soldOut=0 order by goodsAddTime";
			rs=this.excuteQuery(sql, null);
			if(rs!=null){
				try {
					while (rs.next()) {
						/* 获取商品信息 */
						goodsBean = new GoodsBean();
						goodsBean.setGoodsId(rs.getInt(1));
						goodsBean.setShopId(rs.getInt(2));
						goodsBean.setGoodsTypeId(rs.getInt(3));
						goodsBean.setGoodsName(rs.getString(4));
						goodsBean.setGoodsIntroduce(rs.getString(5));
						goodsBean.setGoodsPictureMax(rs.getString(6));					
						goodsBean.setGoodsPictureView1(rs.getString(7));
						goodsBean.setGoodsPictureView2(rs.getString(8));
						goodsBean.setGoodsPictureView3(rs.getString(9));
						goodsBean.setGoodsAddress(rs.getString(10));
						goodsBean.setGoodsPrice(rs.getInt(11));
						goodsBean.setGoodsKillPrice(rs.getInt(12));
						goodsBean.setGoodsVipPrice(rs.getInt(13));
						goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
						goodsBean.setGoodsAddTime(rs.getString(15));
						goodsBean.setGoodsCollectNum(rs.getInt(16));
						goodsBean.setGoodsReadNum(rs.getInt(17));
						goodsBean.setTag(rs.getInt(18));
						goodsBean.setIs_soldOut(rs.getInt(19));
						allShopSoldOutGoodslist.add(goodsBean);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return allShopSoldOutGoodslist;
		}
	
	/**
	 * @功能 修改商品
	 * @参数 goodsId表示传入的商品的ID值
	 * @返回值 boolean型，修改商品是否成功
	 */
	public boolean modifyGoodsDao(int goodsId,GoodsBean goodsBean ) {
		
		String sql="update goods set shopId=?, goodsTypeId=?,goodsName=?,goodsIntroduce=?,"
				+ "goodsPictureMax=?,goodsPictureView1=?,goodsPictureView2=?,"
				+ "goodsPictureView3=?,goodsAddress=?,goodsPrice=?,goodsKillPrice=?,goodsVipPrice=?,"
				+ "isNew_Vip_KillGoods=?,is_soldOut=?where goodsId=?";
		int i=this.excuteUpdate(sql, new String[]{""+goodsBean.getShopId(),
				""+goodsBean.getGoodsTypeId(),goodsBean.getGoodsName(),
				goodsBean.getGoodsIntroduce(),
				goodsBean.getGoodsPictureMax(),goodsBean.getGoodsPictureView1(),
				goodsBean.getGoodsPictureView2(),goodsBean.getGoodsPictureView3(),
				goodsBean.getGoodsAddress(),""+goodsBean.getGoodsPrice(),
				""+goodsBean.getGoodsKillPrice(),""+goodsBean.getGoodsVipPrice(),
				""+goodsBean.getIsNew_Vip_KillGoods(),""+goodsBean.getIs_soldOut(),""+goodsId});
		if(i>0)
			f=true;
		return f;
	}

	/** 
	 * @功能 查询指定类别、活动的商品
	 * @参数 goodsTypeId表示商品类别ID值，isNew_Vip_KillGoods表示商品的活动类型,num表示显示商品的条数，0表示所有
	 * @返回值 List集合
	 */
	public List showAllGoodsDao(int goodsTypeId, int isNew_Vip_KillGoods, int num) {
		List allGoodslist = new ArrayList();
		String sql = "";
		if (goodsTypeId<=0){				
			if(isNew_Vip_KillGoods<0)
			{
				sql = "select * from goods where tag=1 and is_soldOut=1 order by goodsAddTime "; 
				rs=this.excuteQuery(sql, null);
			}
			//不按商品类别查询，查询出 isNew_Vip_KillGoods 类型活动的商品前num条记录
			
			else if (num!=0) 
			sql = "select * from goods where isNew_Vip_KillGoods=? and tag=1 and is_soldOut=1 order by goodsAddTime  LIMIT "+num+""; 
			else  
			sql = "select * from goods where isNew_Vip_KillGoods=? and tag=1 and is_soldOut=1 order by goodsAddTime "; 
			rs=this.excuteQuery(sql, new String[] {""+isNew_Vip_KillGoods});
		}
		else{ 
			if(num!=0)					       
			                    //按商品类别查询，查询出 isNew_Vip_KillGoods 活动商品前num条记录
			  sql = "select * from goods where goodsTypeId=? and isNew_Vip_KillGoods=? and tag=1 and is_soldOut=1 order by goodsAddTime  LIMIT "+num+"";
			else         
			 					//按商品类别查询，查询出所有 isNew_Vip_KillGoods 活动的商品
			  sql = "select * from goods where goodsTypeId=? and isNew_Vip_KillGoods=? and tag=1 and is_soldOut=1 order by goodsAddTime ";
			           
			rs=this.excuteQuery(sql, new String[] {""+goodsTypeId,""+isNew_Vip_KillGoods});
		}
		if(rs!=null){
				try {
					while (rs.next()) {
						/* 获取商品信息 */
						goodsBean = new GoodsBean();
						goodsBean.setGoodsId(rs.getInt(1));
						goodsBean.setShopId(rs.getInt(2));
						goodsBean.setGoodsTypeId(rs.getInt(3));
						goodsBean.setGoodsName(rs.getString(4));
						goodsBean.setGoodsIntroduce(rs.getString(5));
						goodsBean.setGoodsPictureMax(rs.getString(6));					
						goodsBean.setGoodsPictureView1(rs.getString(7));
						goodsBean.setGoodsPictureView2(rs.getString(8));
						goodsBean.setGoodsPictureView3(rs.getString(9));
						goodsBean.setGoodsAddress(rs.getString(10));
						goodsBean.setGoodsPrice(rs.getInt(11));
						goodsBean.setGoodsKillPrice(rs.getInt(12));
						goodsBean.setGoodsVipPrice(rs.getInt(13));
						goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
						goodsBean.setGoodsAddTime(rs.getString(15));
						goodsBean.setGoodsCollectNum(rs.getInt(16));
						goodsBean.setGoodsReadNum(rs.getInt(17));
						goodsBean.setTag(rs.getInt(18));
						goodsBean.setIs_soldOut(rs.getInt(19));
						allGoodslist.add(goodsBean);
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
		}
		return allGoodslist;
	}
	
	
	public int showGoodsMaxId(){
			int maxId = 0;
			String sql = "select max(goodsId) from goods";
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
	
	
	/**
	 * @功能 查询指定商品的详细内容
	 * @参数 goodsId为商品ID值
	 * @返回值 GoodsBean类对象，封装了商品信息
	 */
	public GoodsBean showSingleGoodsDao(int goodsId) {
		
		String sql = "select * from goods where goodsId=?";
		rs=this.excuteQuery(sql, new String[]{""+goodsId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品信息 */
					goodsBean = new GoodsBean();
					goodsBean.setGoodsId(rs.getInt(1));
					goodsBean.setShopId(rs.getInt(2));
					goodsBean.setGoodsTypeId(rs.getInt(3));
					goodsBean.setGoodsName(rs.getString(4));
					goodsBean.setGoodsIntroduce(rs.getString(5));
					goodsBean.setGoodsPictureMax(rs.getString(6));					
					goodsBean.setGoodsPictureView1(rs.getString(7));
					goodsBean.setGoodsPictureView2(rs.getString(8));
					goodsBean.setGoodsPictureView3(rs.getString(9));
					goodsBean.setGoodsAddress(rs.getString(10));
					goodsBean.setGoodsPrice(rs.getInt(11));
					goodsBean.setGoodsKillPrice(rs.getInt(12));
					goodsBean.setGoodsVipPrice(rs.getInt(13));
					goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
					goodsBean.setGoodsAddTime(rs.getString(15));
					goodsBean.setGoodsCollectNum(rs.getInt(16));
					goodsBean.setGoodsReadNum(rs.getInt(17));
					goodsBean.setTag(rs.getInt(18));
					goodsBean.setIs_soldOut(rs.getInt(19));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsBean;
	}

	/**
	 * @功能 显示单个商店所有商品商品
	 * @参数 shopId表示传入的商店的ID值
	 * @返回值 List集合
	 */
	public List showSingleShopGoodsDao(int shopId) {
		List singleShopGoodslist = new ArrayList();
		String sql = "select * from goods where shopId=? and tag=1 and is_soldOut=1 order by goodsId DESC";
		rs=this.excuteQuery(sql, new String[]{""+shopId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品信息 */
					goodsBean = new GoodsBean();
					goodsBean.setGoodsId(rs.getInt(1));
					goodsBean.setShopId(rs.getInt(2));
					goodsBean.setGoodsTypeId(rs.getInt(3));
					goodsBean.setGoodsName(rs.getString(4));
					goodsBean.setGoodsIntroduce(rs.getString(5));
					goodsBean.setGoodsPictureMax(rs.getString(6));					
					goodsBean.setGoodsPictureView1(rs.getString(7));
					goodsBean.setGoodsPictureView2(rs.getString(8));
					goodsBean.setGoodsPictureView3(rs.getString(9));
					goodsBean.setGoodsAddress(rs.getString(10));
					goodsBean.setGoodsPrice(rs.getInt(11));
					goodsBean.setGoodsKillPrice(rs.getInt(12));
					goodsBean.setGoodsVipPrice(rs.getInt(13));
					goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
					goodsBean.setGoodsAddTime(rs.getString(15));
					goodsBean.setGoodsCollectNum(rs.getInt(16));
					goodsBean.setGoodsReadNum(rs.getInt(17));
					goodsBean.setTag(rs.getInt(18));
					goodsBean.setIs_soldOut(rs.getInt(19));
					singleShopGoodslist.add(goodsBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return singleShopGoodslist;
	}
	
	/**
	 * @功能 显示单个商店个别商品，num为商品条数
	 * @参数 shopId表示传入的商店的ID值
	 * @返回值 List集合
	 */
	public List showSingleShopGoodsDao(int shopId,int num) {
		List singleShopGoodslist = new ArrayList();
		String sql = "select * from goods where shopId=? and is_soldOut=1 order by goodsAddTime  LIMIT "+num+"";
		rs=this.excuteQuery(sql, new String[]{""+shopId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品信息 */
					goodsBean = new GoodsBean();
					goodsBean.setGoodsId(rs.getInt(1));
					goodsBean.setShopId(rs.getInt(2));
					goodsBean.setGoodsTypeId(rs.getInt(3));
					goodsBean.setGoodsName(rs.getString(4));
					goodsBean.setGoodsIntroduce(rs.getString(5));
					goodsBean.setGoodsPictureMax(rs.getString(6));					
					goodsBean.setGoodsPictureView1(rs.getString(7));
					goodsBean.setGoodsPictureView2(rs.getString(8));
					goodsBean.setGoodsPictureView3(rs.getString(9));
					goodsBean.setGoodsAddress(rs.getString(10));
					goodsBean.setGoodsPrice(rs.getInt(11));
					goodsBean.setGoodsKillPrice(rs.getInt(12));
					goodsBean.setGoodsVipPrice(rs.getInt(13));
					goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
					goodsBean.setGoodsAddTime(rs.getString(15));
					goodsBean.setGoodsCollectNum(rs.getInt(16));
					goodsBean.setGoodsReadNum(rs.getInt(17));
					goodsBean.setTag(rs.getInt(18));
					goodsBean.setIs_soldOut(rs.getInt(19));
					singleShopGoodslist.add(goodsBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return singleShopGoodslist;
	}
	/**
	 * @功能 显示单个商店个别不同活动商品，num为商品条数
	 * @参数 shopId表示传入的商店的ID值
	 * @返回值 List集合
	 */
	public List showSingleShopGoodsDao(int shopId,int goodsTypeId,int isNew_Vip_KillGoods,int num){
		List singleShopGoodslist = new ArrayList();
		String sql = "";
		if (goodsTypeId<=0){				
				//不按商品类别查询，查询出 isNew_Vip_KillGoods 类型活动的商品前num条记录
			if (num!=0) 
			sql = "select * from goods where isNew_Vip_KillGoods=? and shopId=? and is_soldOut=1 order by goodsAddTime  LIMIT "+num+""; 
			else  
			sql = "select * from goods where isNew_Vip_KillGoods=? and shopId=? and is_soldOut=1 order by goodsAddTime "; 
			rs=this.excuteQuery(sql, new String[] {""+isNew_Vip_KillGoods,""+shopId});
		}
		else{ 
			if(num!=0)					       
			                    //按商品类别查询，查询出 isNew_Vip_KillGoods 活动商品前num条记录
			  sql = "select * from goods where goodsTypeId=? and isNew_Vip_KillGoods=? and shopId=? and is_soldOut=1 order by goodsAddTime DESC LIMIT "+num+"";
			else         
			 					//按商品类别查询，查询出所有 isNew_Vip_KillGoods 活动的商品
			  sql = "select * from goods where goodsTypeId=? and isNew_Vip_KillGoods=? and shopId=? and is_soldOut=1 order by goodsAddTime DESC";
			           
			rs=this.excuteQuery(sql, new String[] {""+goodsTypeId,""+isNew_Vip_KillGoods,""+shopId});
		}
		if(rs!=null){
				try {
					while (rs.next()) {
						/* 获取商品信息 */
						goodsBean = new GoodsBean();
						goodsBean.setGoodsId(rs.getInt(1));
						goodsBean.setShopId(rs.getInt(2));
						goodsBean.setGoodsTypeId(rs.getInt(3));
						goodsBean.setGoodsName(rs.getString(4));
						goodsBean.setGoodsIntroduce(rs.getString(5));
						goodsBean.setGoodsPictureMax(rs.getString(6));					
						goodsBean.setGoodsPictureView1(rs.getString(7));
						goodsBean.setGoodsPictureView2(rs.getString(8));
						goodsBean.setGoodsPictureView3(rs.getString(9));
						goodsBean.setGoodsAddress(rs.getString(10));
						goodsBean.setGoodsPrice(rs.getInt(11));
						goodsBean.setGoodsKillPrice(rs.getInt(12));
						goodsBean.setGoodsVipPrice(rs.getInt(13));
						goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
						goodsBean.setGoodsAddTime(rs.getString(15));
						goodsBean.setGoodsCollectNum(rs.getInt(16));
						goodsBean.setGoodsReadNum(rs.getInt(17));
						goodsBean.setTag(rs.getInt(18));
						goodsBean.setIs_soldOut(rs.getInt(19));
						singleShopGoodslist.add(goodsBean);
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
		}
		return singleShopGoodslist;
		
	}

	/**
	 * @功能 通过用户的关键字搜索显示商品列表
	 * @参数 keywords为用户的关键词
	 * @返回值 List集合
	 */
	public List showKeyWordsGoodsDao(String keywords){
		List keyWordsGoodsList = new ArrayList();
		String sql = "select * from goods where goodsName like '%"+keywords+"%' or goodsIntroduce like '%"+keywords+"%'";
		//rs=this.excuteQuery(sql, new String[]{'%' + keywords + '%','%' + keywords + '%'});
		rs=this.excuteQuery(sql, null);
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品信息 */
					goodsBean = new GoodsBean();
					goodsBean.setGoodsId(rs.getInt(1));
					goodsBean.setShopId(rs.getInt(2));
					goodsBean.setGoodsTypeId(rs.getInt(3));
					goodsBean.setGoodsName(rs.getString(4));
					goodsBean.setGoodsIntroduce(rs.getString(5));
					goodsBean.setGoodsPictureMax(rs.getString(6));			
					goodsBean.setGoodsPictureView1(rs.getString(7));
					goodsBean.setGoodsPictureView2(rs.getString(8));
					goodsBean.setGoodsPictureView3(rs.getString(9));
					goodsBean.setGoodsAddress(rs.getString(10));
					goodsBean.setGoodsPrice(rs.getInt(11));
					goodsBean.setGoodsKillPrice(rs.getInt(12));
					goodsBean.setGoodsVipPrice(rs.getInt(13));
					goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
					goodsBean.setGoodsAddTime(rs.getString(15));
					goodsBean.setGoodsCollectNum(rs.getInt(16));
					goodsBean.setGoodsReadNum(rs.getInt(17));
					goodsBean.setTag(rs.getInt(18));
					goodsBean.setIs_soldOut(rs.getInt(19));
					//goodsBean.setGoodsName(rs.getString(4));
					keyWordsGoodsList.add(goodsBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return keyWordsGoodsList;
		
	}
	
	
	/**
	 * @功能 显示所有未审核商品列表
	 * @参数 
	 * @返回值 List集合
	 */
	public List showAllNoCheckGoodsDao() {
		List allNoCheckGoodslist = new ArrayList();
		String sql = "select * from goods where tag=0";
		rs=this.excuteQuery(sql, null);
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品信息 */
					goodsBean = new GoodsBean();
					goodsBean.setGoodsId(rs.getInt(1));
					goodsBean.setShopId(rs.getInt(2));
					goodsBean.setGoodsTypeId(rs.getInt(3));
					goodsBean.setGoodsName(rs.getString(4));
					goodsBean.setGoodsIntroduce(rs.getString(5));
					goodsBean.setGoodsPictureMax(rs.getString(6));					
					goodsBean.setGoodsPictureView1(rs.getString(7));
					goodsBean.setGoodsPictureView2(rs.getString(8));
					goodsBean.setGoodsPictureView3(rs.getString(9));
					goodsBean.setGoodsAddress(rs.getString(10));
					goodsBean.setGoodsPrice(rs.getInt(11));
					goodsBean.setGoodsKillPrice(rs.getInt(12));
					goodsBean.setGoodsVipPrice(rs.getInt(13));
					goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
					goodsBean.setGoodsAddTime(rs.getString(15));
					goodsBean.setGoodsCollectNum(rs.getInt(16));
					goodsBean.setGoodsReadNum(rs.getInt(17));
					goodsBean.setTag(rs.getInt(18));
					goodsBean.setIs_soldOut(rs.getInt(19));
					allNoCheckGoodslist.add(goodsBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allNoCheckGoodslist;
	}
	public List showShopNoCheckGoodsDao(int shopId){
		List shopNoCheckGoodslist = new ArrayList();
		String sql = "select * from goods where shopId=? and tag=0";
		rs=this.excuteQuery(sql, new String[]{""+shopId});
		if(rs!=null){
			try {
				while (rs.next()) {
					/* 获取商品信息 */
					goodsBean = new GoodsBean();
					goodsBean.setGoodsId(rs.getInt(1));
					goodsBean.setShopId(rs.getInt(2));
					goodsBean.setGoodsTypeId(rs.getInt(3));
					goodsBean.setGoodsName(rs.getString(4));
					goodsBean.setGoodsIntroduce(rs.getString(5));
					goodsBean.setGoodsPictureMax(rs.getString(6));					
					goodsBean.setGoodsPictureView1(rs.getString(7));
					goodsBean.setGoodsPictureView2(rs.getString(8));
					goodsBean.setGoodsPictureView3(rs.getString(9));
					goodsBean.setGoodsAddress(rs.getString(10));
					goodsBean.setGoodsPrice(rs.getInt(11));
					goodsBean.setGoodsKillPrice(rs.getInt(12));
					goodsBean.setGoodsVipPrice(rs.getInt(13));
					goodsBean.setIsNew_Vip_KillGoods(rs.getInt(14));
					goodsBean.setGoodsAddTime(rs.getString(15));
					goodsBean.setGoodsCollectNum(rs.getInt(16));
					goodsBean.setGoodsReadNum(rs.getInt(17));
					goodsBean.setTag(rs.getInt(18));
					goodsBean.setIs_soldOut(rs.getInt(19));
					shopNoCheckGoodslist.add(goodsBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shopNoCheckGoodslist;
	}
	
	/**
	 * @功能 审核商品
	 * @参数 goodsId表示传入的未审核商品的ID值
	 * @返回值 boolean型，审核商品是否成功
	 */
	public boolean checkGoodsDao(int goodsId) {
		String sql="update goods set tag=1 where goodsId=?";
		int i=this.excuteUpdate(sql, new String[]{""+goodsId});
		if(i>0)
			f=true;
		return f;
	}
	/**
	 * @功能 下架商品
	 * @参数 goodsId表示传入的未审核商品的ID值
	 * @返回值 boolean型，下架商品是否成功
	 */
	public boolean is_soldOutDao(int goodsId){
		String sql="update goods set is_soldOut=0 where goodsId=?";
		int i=this.excuteUpdate(sql, new String[]{""+goodsId});
		if(i>0)
			f=true;
		return f;
	}
	
	/**
	 * @功能 上架商品
	 * @参数 goodsId表示传入的未审核商品的ID值
	 * @返回值 boolean型，上架商品是否成功
	 */
		public boolean putAwayGoodsDao(int goodsId){
			String sql="update goods set is_soldOut=1 where goodsId=?";
			int i=this.excuteUpdate(sql, new String[]{""+goodsId});
			if(i>0)
				f=true;
			return f;
		}
}
