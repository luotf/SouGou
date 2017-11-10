package com.ltf.tools;

import java.util.ArrayList;
import java.util.List;

public class MyPage {
	public List list=null;
	private int recordCount=0;	//记录数
	private int pageSize=0;		//每页显示的记录数
	private int maxPage=0;		//最大页数

	//初始化分页信息
	public List getInitPage(List list,int Page,int pageSize){
		List newList=new ArrayList();
		this.list=list;
		recordCount=list.size();	//获取list集合的元素个数
		this.pageSize=pageSize;
		this.maxPage=getMaxPage();	//获取最大页数
		try{
		for(int i=(Page-1)*pageSize;i<=Page*pageSize-1;i++){
			try{
				if(i>=recordCount){break;}
			}catch(Exception e){}
				newList.add(list.get(i));
		}
		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}
		return newList;
	}
	//获取指定页的数据
	public List getAppointPage(int Page){
		List newList=new ArrayList();
		try{
			for(int i=(Page-1)*pageSize;i<=Page*pageSize-1;i++){
				try{
					if(i>=recordCount){break;}
				}catch(Exception e){}
					newList.add(list.get(i));
			}
			}catch(Exception e){
				e.printStackTrace();//输出异常信息
			}
			return newList;
	}
	//获取最大记录数
	public int getMaxPage(){
		int maxPage=(recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
		
		return maxPage;
	}
	//获取总记录数
	public int getRecordSize(){
		
		return recordCount;
	}
	
	//获取当前页数
	public int getPage(String str){
		
	
		if(str==null){//当页数等于null时，让其等于0
			str="0";
		}
		int Page=Integer.parseInt(str);
		if(Page<1){//当页数小于1时，让其等于1
			Page=1;
		}else{
			if(((Page-1)*pageSize+1)>recordCount){//当页数大于最大页数时，让其等于最大页数
				Page=maxPage;
			}
		}
		return Page;
	}

	/**
	 * 在页面中输出分页导航
	 * @param Page
	 * @param url
	 * @param para
	 * @return
	 */
	public String printCtrl(int Page,String url,String para){
		String strHtml="<table width='100%'  border='0' cellspacing='0' cellpadding='0' >"
				+ "<tr> <td class='page' height='24'"
				+ " align='center' style='background:white;'>当前页数：【"+Page+"/"+maxPage+"】&nbsp;";
		try{
		
		if(Page>1){
			strHtml=strHtml+"<a href='"+url+"&Page=1"+para+"'>第一页</a>　";
			strHtml=strHtml+"<a href='"+url+"&Page="+(Page-1)+para+"'>上一页</a>";			
		}
		
		if(Page<maxPage){
			strHtml=strHtml+"<a href='"+url+"&Page="+(Page+1)+para+"'>下一页</a>　"
					+ "<a href='"+url+"&Page="+maxPage+para+"'>最后一页&nbsp;</a>";
		}
		strHtml=strHtml+"</td> </tr>	</table>";
		}catch(Exception e){
			e.printStackTrace();
		}
		return strHtml;
	}	
}
