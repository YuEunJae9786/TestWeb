package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserVO;

public class JoinServiceImpl implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int phone1 = Integer.parseInt(request.getParameter("phone1"));
		int phone2 = Integer.parseInt(request.getParameter("phone2"));
		int phone3 = Integer.parseInt(request.getParameter("phone3"));
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		UserVO vo = new UserVO(id, pw, name, phone1, phone2, phone3, email1, email2, address1, address2);
		
		UserDAO.getInstance().join(vo);
	}

}
