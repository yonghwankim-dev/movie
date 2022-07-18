<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.com.yh.lotte.UrlPaths"%>
<style>
.success-div {
  margin-left: auto;
  margin-right: auto;
  padding: 20px;
  text-align: center;
  border: none;
}
.btns {
  margin-top: 20px;
}
.btn {
  width: 370px;
}
</style>

<div class="success-div">
	<h2>회원가입이 완료되었습니다 !</h2>
	<div class="btns">
		<a href="${pageContext.request.contextPath}${UrlPaths.LOTTE}" class="btn btn-primary">홈페이지 바로가기</a>
		<br>
		<a href="${pageContext.request.contextPath}${UrlPaths.LOGIN}" class="btn">로그인 바로가기</a>
	</div>
</div>
