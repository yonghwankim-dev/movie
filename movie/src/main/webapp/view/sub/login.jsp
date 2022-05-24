<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 페이지 타이틀 -->
<h2 class="pageTitle">로그인</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="login-form">
  <form action="login.do" method="post" id="loginFrm">
    <input type="text" class="form-control login-field" placeholder="아이디" title="아이디" name="loginId" id="loginId">
	<input type="password" class="form-control login-field" placeholder="비밀번호" title="비밀번호" name="loginPwd" id="loginPwd">
	<input type="button" value="로그인" class="btn btn-submit" id="loginBtn">
	
 	<div class="checkbox text-left">
 		<label for="adminLogin">
 			<input type="checkbox" name="adminLogin" id="adminLogin"> 관리자 로그인
 		</label>
 	</div>
  </form>
 
  <ul class="list_st1 text-left">
    <li><a href="/movie/searchLoginId.do">아이디를 잊어버리셨나요?</a></li>
    <li><a href="#">비밀번호를 잊어버리셨나요?</a></li>
  </ul>
</div>
<!-- //여기까지 페이지 내용 -->
<script src="<%=request.getContextPath() %>/js/regExp/regExp.js"></script>
<script src="<%=request.getContextPath() %>/js/mem/login/login.js"></script>
