<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    
    <!--회원가입 폼만 적용되는 css-->
    <style type="text/css">
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 0 auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
        
        
        .form-group > .sel {
            width: 120px;
            display: inline-block;
            
        }
    </style>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>회원가입<small>(가운데정렬)</small></h2>

                    <form action="join.user" method="post" name="joinForm">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="id" placeholder="아이디를 (영문포함 4~12자 이상)" name="id">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" id="password" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)" name="pw">
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" id="password-confrim" placeholder="비밀번호를 확인해주세요." name="pwCheck">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input class="form-control sel" placeholder="010" name="phone1"> -
                            <input class="form-control sel" placeholder="xxxx" name="phone2"> -
                            <input class="form-control sel" placeholder="xxxx" name="phone3">
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input class="form-control sel" name="email1">@
                            <select class="form-control sel" name="email2">
                                <option>naver.com</option>
                                <option>gmail.com</option>
                                <option>daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" class="form-control" id="addr-basic" placeholder="기본주소" name="address1">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="addr-detail" placeholder="상세주소" name="address2">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="check()">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='user_login.jsp'">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>
    
    <script>
    	function check(){
    		
    		if(document.joinForm.id.value.length < 4 || document.joinForm.id.value.length > 12){
    			alert("아이디는 영문포함 4글자 이상 12글자 이하 입니다.")
    			document.joinForm.id.focus();
    			return;
    		} else if(document.joinForm.pw.value.length < 8){
    			alert("비밀번호는 (영 대/소문자, 특수문자, 숫자) 3종류 조합 8글자 이상 입니다")
    			document.joinForm.pw.focus();
    			return;
    		} else if(document.joinForm.pw.value != document.joinForm.pwCheck.value){
    			alert("비밀번호와 비밀번호 확인이 다릅니다");
    			document.joinForm.pwCheck.focus();
    			return;
    		} else if(document.joinForm.name.value.length == ""){
    			alert("이름은 필수사항 입니다");
    			document.joinForm.name.focus();
    			return;
    		} else{
    			alert("회원가입을 축하합니다 !");
    			document.joinForm.submit();
    		}
    		
    	}
    </script>

<%@ include file="../include/footer.jsp" %>