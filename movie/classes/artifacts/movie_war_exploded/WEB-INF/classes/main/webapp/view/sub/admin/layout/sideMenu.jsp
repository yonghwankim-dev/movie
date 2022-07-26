<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav flex-column">
				<a href="${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}" class="nav-link active" >회원관리</a>
				<a href="${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}" class="nav-link active" >영화관리</a>
				<a href="${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}" class="nav-link active" >영화관관리</a>
				<a href="${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}" class="nav-link active" >상영관리</a>
				<a href="${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}" class="nav-link active" >상영일정관리</a>
				<a href="${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}" class="nav-link active" >예약관리</a>
			</div>
		</div>
	</nav>
</div>


