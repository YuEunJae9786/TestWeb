package com.testweb.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.service.DeleteServiceImpl;
import com.testweb.board.service.GetContentServiceImpl;
import com.testweb.board.service.GetListServiceImpl;
import com.testweb.board.service.IBoardService;
import com.testweb.board.service.RegistServiceImpl;
import com.testweb.board.service.UpdateServiceImpl;

@WebServlet("*.bbs")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
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
		
		IBoardService service = null;
		
		if(command.equals("/bbs/list.bbs")) { // 글 목록
			
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs.jsp").forward(request, response);
			
		} else if(command.equals("/bbs/write.bbs")) { // 글 등록 화면
			
			request.getRequestDispatcher("bbs_write.jsp").forward(request, response);
			
		} else if(command.equals("/bbs/regist.bbs")) { // 글 등록 요청
			
			service = new RegistServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.bbs");
		} else if(command.equals("/bbs/content.bbs")) { // 글 상세보기
			
			service = new GetContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs_content.jsp").forward(request, response);
		} else if(command.equals("/bbs/modify.bbs")) { // 글 수정 페이지
			
			service = new GetContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs_modify.jsp").forward(request, response);
		} else if(command.equals("/bbs/update.bbs")) { // 글 수정 요청
			
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("content.bbs?bno=" + request.getParameter("bno"));
		} else if(command.equals("/bbs/delete.bbs")) { // 글 삭제 요청
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.bbs");
		}
		
	}

}
