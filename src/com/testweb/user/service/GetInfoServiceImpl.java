package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserVO;

public class GetInfoServiceImpl implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = (String)request.getSession().getAttribute("user_id");
		
		UserVO vo = UserDAO.getInstance().getInfo(id);
		
		request.setAttribute("vo", vo);
	}

}
