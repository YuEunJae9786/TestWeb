package com.testweb.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/bbs/modify.bbs", "/bbs/update.bbs", "/bbs/delete.bbs"})
public class BbsFilter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		String user_id = (String)session.getAttribute("user_id");
		String writer = request.getParameter("wirter");
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		PrintWriter out = res.getWriter();
		
		if(user_id == null) {
		
			out.println("<script>");
			out.println("alert('너는 로그인부터 해라')");
			out.println("location.href='/TestWeb/user/user_login.jsp'");
			out.println("</script>");
			return;
			
		}else if(writer == null || !user_id.equals(writer)) {
			
			out.println("<script>");
			out.println("alert('너는 권한이 없어요')");
			out.println("location.href='list.bbs'");
			out.println("</script>");
			return;
		}
		
		
		chain.doFilter(request, response);
	}
}
