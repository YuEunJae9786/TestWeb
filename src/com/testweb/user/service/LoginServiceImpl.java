package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.model.UserDAO;

public class LoginServiceImpl implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(UserDAO.getInstance().login(id, pw) == 1) {
			request.getSession().setAttribute("user_id", id);
		}
		
	}

}
