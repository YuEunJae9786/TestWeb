package com.testweb.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.model.BoardDAO;
import com.testweb.board.model.BoardVO;
import com.testweb.jdbc.util.PageVO;

public class GetListServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int pageNum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		List<BoardVO> list = BoardDAO.getInstance().getList(pageNum, amount);
		int total = BoardDAO.getInstance().getTotal();
		PageVO pageVO = new PageVO(pageNum, total, amount);
		
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("list", list);
	}

}
