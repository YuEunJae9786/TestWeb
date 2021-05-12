<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    <form action="update.user" method="post" name="updateForm">
                    
                    <p>*표시는 필수 입력 표시입니다</p>
                    <table class="table">
                        <tbody class="m-control">
                            <tr>
                                <td class="m-title">*ID</td>
                                <td><input class="form-control input-sm" value="${vo.id }" name="id" readonly></td>
                            </tr>
                            <tr>
                                <td class="m-title">*이름</td>
                                <td><input class="form-control input-sm" value="${vo.name }" name="name"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호</td>
                                <td><input class="form-control input-sm" name="pw"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호확인</td>
                                <td><input class="form-control input-sm" name="pwCheck"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*E-mail</td>
                                <td>
                                    <input class="form-control input-sm" value="${vo.email1 }" name="email1">@
                                    <select class="form-control input-sm sel" name="email2">
                                        <option ${vo.email2 == 'naver.com' ? 'selected' : '' }>naver.com</option>
                                        <option ${vo.email2 == 'gmail.com' ? 'selected' : '' }>gmail.com</option>
                                        <option ${vo.email2 == 'daum.net' ? 'selected' : '' }>daum.net</option>
                                    </select>
                                    <button class="btn btn-info" onclick="emailCheck()">중복확인</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*휴대폰</td>
                                <td>
                                    <input class="form-control input-sm sel" value="${vo.phone1 }" name="phone1"> -
                                    <input class="form-control input-sm sel" value="${vo.phone2 }" name="phone2"> -
                                    <input class="form-control input-sm sel" value="${vo.phone3 }" name="phone3">
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*주소</td>
                                <td><input class="form-control input-sm add" value="${vo.address1 }" name="address1"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*상세주소</td>
                                <td><input class="form-control input-sm add" value="${vo.address2 }" name="address2"></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <div class="titlefoot">
                        <button class="btn" onclick="submitCheck()">수정</button>
                        <button class="btn" onclick="location.href='user_mypage.jsp'">목록</button>
                    </div>
                    </form>
                    
                </div>


            </div>

        </div>

    </section>
    
<%@ include file="../include/footer.jsp" %>

<script>
	
	function emailCheck(){
		
	}
	
	function submitCheck(){
		
		if(document.updateForm.pw.value != document.updateForm.pwCheck.value){
			alert("비밀번호를 확인하세요");
			document.updateForm.pw.focus();
		} else{
			document.updateForm.submit();
		}
		
	}
	
</script>