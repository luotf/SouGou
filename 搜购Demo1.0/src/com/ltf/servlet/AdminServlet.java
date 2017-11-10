package com.ltf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltf.service.AdminService;
import com.ltf.service.imp.AdminServiceImp;
import com.ltf.vo.AdminBean;

public class AdminServlet extends HttpServlet {

	AdminService adminService=new AdminServiceImp();
	public AdminServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("addAdmin"))
			this.addAdmin(request, response); 	// 增加管理员
		if (action.equals("deleteAdmin"))
			this.deleteAdmin(request, response); // 删除管理员
		if (action.equals("modifyAdmin"))
			this.modifyAdmin(request, response); 	// 修改管理员信息
		if (action.equals("modifyAdminPassword"))
			this.modifyAdminPassword(request, response); 	// 修改管理员密码
		if (action.equals("showAllAdmin"))
			this.showAllAdmin(request, response); // 显示所有审核管理员
		if (action.equals("showNoCheckAdmin"))
			this.showNoCheckAdmin(request, response); // 显示所有未审核管理员
		if (action.equals("showSingleAdmin"))
			this.showSingleAdmin(request, response); // 显示单个管理员信息
		if (action.equals("adminLogin"))
			this.adminLogin(request, response); // 管理员登录
		if (action.equals("checkAdmin"))
			this.checkAdmin(request, response); // 审核管理员
		if (action.equals("checkAdminExist"))
			this.checkAdminExist(request, response); // 检查管理员名是否存在
		if (action.equals("loginOut"))
			this.loginOut(request, response); // 用户注销
		
	}

	
	private void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		System.out.println("注销成功");
		response.sendRedirect("admin/adminLogin.jsp");
	}

	private void checkAdminExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminName=request.getParameter("adminName");
		String[] messages=adminService.checkAdminExistServ(adminName);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}

	private void checkAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		String[] messages=adminService.checkAdminServ(adminId);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}

	private void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		AdminBean adminBean=new AdminBean();
		AdminBean adminBean1=new AdminBean();
		String msg="validate";
		String key = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String validate = request.getParameter("validate");
		if (key.equals(validate)){  //首先判断验证码是否正确
		adminBean.setAdminName(request.getParameter("userName"));
		adminBean.setAdminPassword(request.getParameter("password"));
		if(adminService.adminLoginServ(adminBean)){
			adminBean1=adminService.showSingleAdminServ(adminBean.getAdminName());
			System.out.println("欢迎管理员：“"+adminBean1.getAdminNickName()+"”登录");
			request.getSession().setAttribute("admin",adminBean1);
			msg="success";
		}
		else{
			System.out.println("登录失败");
			msg="error";
		
		}
		}
		System.out.println("验证码错误");
		out.print(msg);
		out.flush();
        out.close();
	}

	private void showSingleAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		AdminBean singleAdmin=new AdminBean();
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		singleAdmin=adminService.showSingleAdminServ(adminId);
		request.setAttribute("singleAdmin", singleAdmin);
		RequestDispatcher rd=request.getRequestDispatcher("/front/admin/adminMessage.jsp");
		rd.forward(request,response);
	}

	private void showNoCheckAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List allNoCheckAdminList=null;
		int tag=0;
		allNoCheckAdminList=adminService.showAllAdminServ(tag);
		request.setAttribute("allNoCheckAdminList", allNoCheckAdminList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/admin/adminNoCheckList.jsp");
		rd.forward(request,response);
	}

	private void showAllAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List allAdminList=null;
		int tag=1;
		allAdminList=adminService.showAllAdminServ(tag);
		request.setAttribute("allAdminList", allAdminList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/admin/adminList.jsp");
		rd.forward(request,response);
		
	}

	private void modifyAdminPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		String adminPassword=request.getParameter("adminPassword");
		String[] messages=adminService.modifyAdminPasswordServ(adminId, adminPassword);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}

	private void modifyAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		AdminBean adminBean=new AdminBean();
		adminBean.setAdminNickName(request.getParameter("adminNickName"));
		adminBean.setAdminPhone(request.getParameter("adminPhone"));
		adminBean.setAdminImages(request.getParameter("adminImages"));
		String[] messages=adminService.modifyAdminServ(adminId, adminBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}

	private void deleteAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		String[] messages=adminService.deleteAdminServ(adminId);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}

	private void addAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AdminBean adminBean=new AdminBean();
		adminBean.setAdminName(request.getParameter("adminName"));
		adminBean.setAdminPassword(request.getParameter("adminPassword"));
		adminBean.setAdminNickName(request.getParameter("adminNickName"));
		adminBean.setAdminPhone(request.getParameter("adminPhone"));
		adminBean.setAdminImages(request.getParameter("adminImages"));
		
		SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String adminAddTime=format.format(new Date());
		adminBean.setAdminAddTime(adminAddTime);
		int tag=0;
		adminBean.setTag(tag);
		String[] messages=adminService.addAdminServ(adminBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
		
	}

	public void init() throws ServletException {
		
	}

}
