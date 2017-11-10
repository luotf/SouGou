package com.ltf.service.imp;

import java.util.List;







import com.ltf.dao.GoodsTypeDao;
import com.ltf.dao.imp.GoodsTypeDaoImp;
import com.ltf.service.GoodsTypeService;
import com.ltf.vo.GoodsTypeBean;

public class GoodsTypeServiceImp implements GoodsTypeService {
	
	GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImp();
	boolean f=false;

	String forward="";
	String message="";
	
	@Override
	public String[] addGoodsTypeServ(GoodsTypeBean goodsTypeBean) {
		
		f=goodsTypeDao.addGoodsTypeDao(goodsTypeBean);
		if(f){
			//删除商品类别成功页面
			forward="/admin/goodsType/success.jsp";
			message="<li>增加商品类别成功</li>";
		}
		else{
			//删除商品类别失败页面
			forward="/front/goods/error.jsp";
			message="<li>增加商品类别失败！请检查商品类别是否有误...</li>";
		}
		String[] messages={"+message+","+forward+"};
		return messages;
	}

	@Override
	public String[] deleteGoodsTypeServ(int goodsTypeId) {
		f=goodsTypeDao.deleteGoodsTypeDao(goodsTypeId);
		if(f){
			//删除商品类别成功页面
			forward="/admin/goodsType/success.jsp";
			message="<li>删除商品类别成功</li>";
		}
		else{
			//删除商品类别失败页面
			forward="/front/goods/error.jsp";
			message="<li>删除商品类别失败！</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages ;
				
	}

	@Override
	public String[] modifyGoodsTypeServ(int goodsTypeId,GoodsTypeBean goodsTypeBean) {
		// TODO Auto-generated method stub
		f=goodsTypeDao.modifyGoodsTypeDao(goodsTypeId,goodsTypeBean);
		
		if(f){
			//删除商品类别成功页面
			forward="/admin/goodsType/success.jsp";
			message="<li>修改商品类别成功</li>";
		}else{
			//删除商品类别失败页面
			forward="/front/goods/error.jsp";
			message="<li>修改商品类别失败！</li>";
		}
		
		String[] messages={"+forward+","+message+"};
		return messages;		
	}

	@Override
	public List showAllGoodsTypeServ() {
		
		return goodsTypeDao.showAllGoodsTypeDao();
	}

	@Override
	public GoodsTypeBean showSingleGoodsTypeServ(int goodsTypeId) {
		// TODO Auto-generated method stub
		return goodsTypeDao.showSingleGoodsTypeDao(goodsTypeId);
	}
	
	public String[] checkGoodsTypeExistServ(String goodsTypeName){
		f=goodsTypeDao.checkGoodsTypeExistDao(goodsTypeName);
		if(f){
			//商品类别不存在
			forward="/admin/goodsType/success.jsp";
			message="<li>类别名不存在，可以使用</li>";
		}
		else{
			//类别名存在，不可以使用
			forward="/front/goods/error.jsp";
			message="<li>类别名存在，不可以使用</li>";
		}
		String[] messages={"+forward+","+message+"};
		return messages;
		
	}

}
