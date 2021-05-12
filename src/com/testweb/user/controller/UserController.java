package com.testweb.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.service.DeleteServiceImpl;
import com.testweb.user.service.GetInfoServiceImpl;
import com.testweb.user.service.IUserService;
import com.testweb.user.service.JoinServiceImpl;
import com.testweb.user.service.LoginServiceImpl;
import com.testweb.user.service.UpdateServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String command = request.getRequestURI().substring(request.getContextPath().length());
		
		System.out.println(command);
		
		IUserService service;
		
		if(command.equals("/user/join.user")) { // 회원가입 요청
			
			service = new JoinServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("user_login.jsp");
		} else if(command.equals("/user/login.user")) { // 로그인 요청
			
			service = new LoginServiceImpl();
			service.execute(request, response);
			
			if(request.getSession().getAttribute("user_id") != null) {
				response.sendRedirect("user_mypage.jsp");
			} else {
				response.sendRedirect("user_login.jsp");
			}
			
		} else if(command.equals("/user/getInfo.user")) { // 정보변경 화면 요청
			
			service = new GetInfoServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("user_mypageinfo.jsp").forward(request, response);
		} else if(command.equals("/user/update.user")) { // 정보변경 요청
			
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("login.user");
		} else if(command.equals("/user/logout.user")) { // 로그아웃 요청 
			
			request.getSession().invalidate();
			
			response.sendRedirect("user_login.jsp");
		} else if(command.equals("/user/delete.user")) { // 회원탈퇴 요청
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("logout.user");
		}
		
		
	}

}
