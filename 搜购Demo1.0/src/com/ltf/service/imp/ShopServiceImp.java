package com.ltf.service.imp;

import java.util.List;

import com.ltf.dao.ShopDao;
import com.ltf.dao.imp.ShopDaoImp;
import com.ltf.service.ShopService;
import com.ltf.vo.ShopBean;

public class ShopServiceImp implements ShopService {
	
	ShopDao shopDao=new ShopDaoImp();
	boolean f=false;
	String message="";
	String forward="";
	@Override
	public boolean shopLoginServ(ShopBean shopBean) {
		
		return shopDao.shopLoginDao(shopBean);
	}

	@Override
	public List showAllShopServ(int tag) {
		
		return shopDao.showAllShopDao(tag);
	}

	//7.显示最大的店铺ID号
		public int showShopMaxId(){
			return shopDao.showShopMaxId();
		}
	
	@Override
	public ShopBean showSingleShopServ(int shopId) {
	
		return 	shopDao.showSingleShopDao(shopId);
	}
	//3.按照用户名查看单个商家信息
	public ShopBean showSingleShopServ(String shopName){
		return 	shopDao.showSingleShopDao(shopName);
	}
	
	@Override
	public String[] addShopServ(ShopBean shopBean) {
		f=shopDao.addShopDao(shopBean);
		if(f){
			//增加店铺成功
			forward="/admin/shop/success.jsp";
			message="<li>增加店铺成功</li>";
		}
		else{
			//增加店铺失败
			forward="/front/shop/error.jsp";
			message="<li>增加店铺失败</li>";
		}
		String[] messages={message,forward};
		return messages;
	}

	@Override
	public String[] modifyShopServ(int shopId, ShopBean shopBean) {
		f=shopDao.modifyShopDao(shopId, shopBean);
		if(f){
			//修改店铺信息成功
			forward="/admin/shop/success.jsp";
			message="<li>修改店铺信息成功</li>";
		}
		else{
			//修改店铺信息失败
			forward="/front/shop/error.jsp";
			message="<li>修改店铺信息失败</li>";
		}
		String[] messages={message,forward};
		return messages;
	}

	@Override
	public String[] modifyShopPasswordServ(int shopId, String shopPassword) {
		f=shopDao.modifyShopPasswordDao(shopId, shopPassword);
		if(f){
			//修改店铺密码成功
			forward="/admin/shop/success.jsp";
			message="<li>修改店铺密码成功</li>";
		}
		else{
			//修改店铺密码失败
			forward="/front/shop/error.jsp";
			message="<li>修改店铺密码失败</li>";
		}
		String[] messages={message,forward};
		return messages;
	}

	@Override
	public String[] deleteShopServ(int shopId) {
		f=shopDao.deleteShopDao(shopId);
		if(f){
			//删除店铺成功
			forward="/admin/shop/success.jsp";
			message="<li>删除店铺成功</li>";
		}
		else{
			//删除店铺失败
			forward="/front/shop/error.jsp";
			message="<li>删除店铺失败</li>";
		}
		String[] messages={message,forward};
		return messages;
	}

	@Override
	public String[] checkShopServ(int shopId) {
		f=shopDao.checkShopDao(shopId);
		if(f){
			//审核店铺成功
			forward="ShopServlet?action=showNoCheckShop";
			message="<li>审核店铺成功</li>";
		}
		else{
			//审核店铺失败
			forward="/front/shop/error.jsp";
			message="<li>审核店铺失败</li>";
		}
		String[] messages={message,forward};
		return messages;
	}

	@Override
	public String[] checkShopExistServ(String shopName) {
		f=shopDao.checkShopExistDao(shopName);
		if(f){
			//店铺名不存在
			forward="/admin/goodsType/success.jsp";
			message="<li>店铺名不存在，可以使用</li>";
		}
		else{
			//店铺名存在，不可以使用
			forward="/front/goods/error.jsp";
			message="<li>店铺名存在，不可以使用</li>";
		}
		String[] messages={message,forward};
		return messages;
	}

}
