<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(request.isRequestedSessionIdValid()) {
		session.invalidate();
	}
%>
<div class="logout-div">
	<h2>로그아웃이 완료되었습니다.</h2>
	<div class="btns">
		<a href="/movie/main.do" class="btn btn-danger">홈페이지 바로가기</a>
		<a href="/movie/login.do" class="btn">로그인 바로가기</a>
	</div>
</div>