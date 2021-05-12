<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
        
    <section>
        
        <div class="container">
            <div class="row">
                
                <h2>게시판 목록</h2>
                <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="background-color: #9DCAFF; text-align: center;">번호</th>
                            <th style="background-color: #9DCAFF; text-align: center;">제목</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성자</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="vo" items="${list }">
	                        <tr>
	                            <td>${vo.bno }</td>
	                            <td><a href="content.bbs?bno=${vo.bno }">${vo.title }</a></td>
	                            <td>${vo.writer }</td>
	                            <td>${vo.regdate }</td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="text-center">
                    <ul class="pagination pagination-sm">
                    	
                    	<c:if test="${pageVO.prev }">
                        	<li><a href="list.bbs?pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
                        </c:if>
                        
                        <c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
                        	<li class="${pageVO.pageNum eq num ? 'active' : '' }">
                        	<a href="list.bbs?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
                        </c:forEach>
                        
                        <c:if test="${pageVO.next }">
                        	<li><a href="list.bbs?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
                        </c:if>
                    </ul>
                    <button class="btn btn-info pull-right" onclick="location.href='write.bbs'">글쓰기</button>
                </div>
                
            </div>
        </div>
    </section>
        
<%@ include file="../include/footer.jsp" %>