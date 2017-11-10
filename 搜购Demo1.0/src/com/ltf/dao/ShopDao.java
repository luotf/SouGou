package com.ltf.dao;

import java.util.List;

import com.ltf.vo.ShopBean;

public interface ShopDao {
	
	//1.增加商家	
	public boolean addShopDao(ShopBean shopBean);
	//2.删除商家	
	public boolean deleteShopDao(int shopId);
	//3.修改商家个人信息	
	public boolean modifyShopDao(int shopId,ShopBean shopBean);
	//4.修改商家个人密码
	public boolean modifyShopPasswordDao(int shopId,String shopPassword);
	//5.显示所有已审核/未审核的商家列表 		
	public List showAllShopDao(int tag);
	//6.按照ID显示单个商家具体信息	
	public ShopBean showSingleShopDao(int shopId);
	//7.按照用户名显示单个商家具体信息
	public ShopBean showSingleShopDao(String shopName);
	//8.商家登录 	
	public boolean shopLoginDao(ShopBean shopBean);
	//9.审核商家	
	public boolean checkShopDao(int shopId);
	//10.检查该商家是否存在
	public boolean checkShopExistDao(String shopName);
	//7.查询店铺的最大ID号
	public int showShopMaxId();
}
