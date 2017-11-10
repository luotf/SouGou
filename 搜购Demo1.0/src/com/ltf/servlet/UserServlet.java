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

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ltf.service.UserService;
import com.ltf.service.imp.UserServiceImp;
import com.ltf.vo.AdminBean;
import com.ltf.vo.UserBean;

public class UserServlet extends HttpServlet {

	UserService userService=new UserServiceImp();
	public UserServlet() {
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
		if (action.equals("addUser"))
			this.addUser(request, response); 	// 增加用户
		if (action.equals("deleteUser"))
			this.deleteUser(request, response); // 删除用户
		if (action.equals("modifyUser"))
			this.modifyUser(request, response); 	// 修改用户信息
		if (action.equals("modifyUserPassword"))
			this.modifyUserPassword(request, response); 	// 修改用户密码
		if (action.equals("showAllUser"))
			this.showAllUser(request, response); // 显示所有用户
		if (action.equals("showSingleUser"))
			this.showSingleUser(request, response); // 显示单个用户信息
		if (action.equals("UserLogin"))
			this.UserLogin(request, response); // 用户登录
		if (action.equals("checkUserExist"))
			this.checkUserExist(request, response); // 检查用户名是否存在
		if (action.equals("loginOut"))
			this.loginOut(request, response); // 用户注销
		
	}
	private void validate(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			// 检查是否是正确的验证码
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	
		
	}


	private void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getSession().invalidate();
		System.out.println("注销成功");
		response.sendRedirect("index.jsp");
		
	}


	private void checkUserExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String[] messages=userService.checkUserExistServ(userName);
		PrintWriter out=response.getWriter();
		out.print(messages[0]);
		
	}


	private void UserLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserBean userBean=new UserBean();
		UserBean userBean1=null;
		String msg="validate";
		String key = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String validate = request.getParameter("validate");
		if (key.equals(validate)){  //首先判断验证码是否正确
			userBean.setUserName(request.getParameter("userName"));
			userBean.setUserPassword(request.getParameter("userPassword"));
			if(userService.userLoginServ(userBean)){
				userBean1=userService.showSingleUserServ(userBean.getUserName());
				System.out.println("欢迎用户：“"+userBean1.getUserNickName()+"”登录");
				request.getSession().setAttribute("user",userBean1);
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
	
	private void showSingleUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBean singleUser=new UserBean();
		int userId=Integer.parseInt(request.getParameter("userId"));
		singleUser=userService.showSingleUserServ(userId);
		request.setAttribute("singleUser", singleUser);
		RequestDispatcher rd=request.getRequestDispatcher("/front/user/userMessage.jsp");
		rd.forward(request,response);
	}


	private void showAllUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List allUserList=null;
		allUserList=userService.showAllUserServ();
		request.setAttribute("allUserList", allUserList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/admin/showAllUser.jsp");
		rd.forward(request,response);
	}


	private void modifyUserPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userId"));
		String userPassword=request.getParameter("userPassword");
		String[] messages=userService.modifyUserPasswordServ(userId, userPassword);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void modifyUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		Request req = su.getRequest();
		long maxsize = 10 * 1024 * 1024; // 设置每个上传文件的大小，为10MB
		su.initialize(this.getServletConfig(), request, response);
		su.setMaxFileSize(maxsize); // 限制上传文件的大小
		su.setAllowedFilesList("jpg,gif,bmp,png"); // 设置允许上传的文件类型
		try {
			su.upload();
		} catch (SmartUploadException e1) {
			e1.printStackTrace();
		}
		int userId=Integer.parseInt(req.getParameter("userId"));
		System.out.println("Id:"+userId);
		UserBean userBean=new UserBean();
		String userSex="";
		userBean.setUserNickName(new String(req.getParameter("userNickName")
				.getBytes(), "UTF-8"));
		userBean.setUserPhone(req.getParameter("userPhone"));
		String sex=req.getParameter("sex");
		if (sex == null)
			sex = "";
		if(sex.equals("0"))
			userSex="男";
		else if(sex.equals("1"))
			userSex="女";
		System.out.println("性别为:"+userSex);
		userBean.setUserSex(userSex);
		userBean.setUserEmail(req.getParameter("userEmail"));
		File file = null;
		String userImages = "";
		//int maxId = userService.showUserMaxId() + 1;
		file = su.getFiles().getFile(0); // 获取上传的文件，因为只上传了一个文件，所以可直接获取
		if (!file.isMissing()) { // 如果选择了文件
			userImages = "images/user/" + userId  + "."
						+ file.getFileExt();
			userBean.setUserImages(userImages);
			try {
				file.saveAs(userImages, File.SAVEAS_VIRTUAL);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		}

		String[] messages=userService.modifyUserServ(userId, userBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userId"));
		String[] messages=userService.deleteUserServ(userId);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean userBean=new UserBean();
		userBean.setUserName(request.getParameter("userName"));
		userBean.setUserPassword(request.getParameter("userPassword"));
		userBean.setUserPhone(request.getParameter("userPhone"));
		
		//设置默认
		String userNickName=request.getParameter("userName");
		userBean.setUserNickName(userNickName);
		String userSex="女";
		userBean.setUserSex(userSex);
		String userEmail="";
		userBean.setUserEmail(userEmail);
		String userImages="images/touxiang.jpg";
		userBean.setUserImages(userImages);
		SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String userAddTime=format.format(new Date());
		userBean.setUserAddTime(userAddTime);
		String[] messages=userService.addUserServ(userBean);
		request.setAttribute("messages",messages[0]);
		RequestDispatcher rd=request.getRequestDispatcher(messages[1]);
		rd.forward(request,response);
	}


	public void init() throws ServletException {
		
	}

}
