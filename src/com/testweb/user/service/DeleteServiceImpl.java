package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.model.UserDAO;

public class DeleteServiceImpl implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = (String)request.getSession().getAttribute("id");
		
		UserDAO.getInstance().delete(id);
		
		request.getSession().invalidate();
	}

}
