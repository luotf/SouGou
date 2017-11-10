package com.ltf.service;

import java.util.List;

import com.ltf.vo.ShopBean;

public interface ShopService {
	
	//1.商家登录
	public boolean shopLoginServ(ShopBean shopBean);
	//2.查看所有审核和未审核商家
	public List showAllShopServ(int tag);
	//3.按照ID查看单个商家信息
	public ShopBean showSingleShopServ(int shopId);
	//3.按照用户名查看单个商家信息
	public ShopBean showSingleShopServ(String shopName);
	//4.增加商家
	public String[] addShopServ(ShopBean shopBean);
	//5.修改商家信息
	public String[] modifyShopServ(int shopId,ShopBean shopBean);
	//6.修改商家登录密码
	public String[] modifyShopPasswordServ(int shopId,String shopPassword);
	//7.删除个人商家
	public String[] deleteShopServ(int shopId);
	//8.审核商家	
	public String[] checkShopServ(int shopId);
	//9.检查商家名是否存在	
	public String[] checkShopExistServ(String shopName);
	//7.显示最大的店铺ID号
	public int showShopMaxId();

}
