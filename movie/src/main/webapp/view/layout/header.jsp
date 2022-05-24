<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header id="header">
	<div class="container-fluid">
		<h1 id="logo">
			<a href="${pageContext.request.contextPath}/main.do">
				<img src="${pageContext.request.contextPath}/images/common/logo.png" alt="LOTTE CGV BOX">
			</a>
		</h1>
		
		<c:choose>
			<c:when test="${not empty sessionScope.name}">
				<p class="loginMsg">${sessionScope.name}님 로그인</p>
			</c:when>
			<c:otherwise>
				<p class="loginMsg">로그인 후 이용해주세요.</p>	
			</c:otherwise>	
		</c:choose>
		
		<div id="util">
			<ul>
				<!-- 로그인 시에는 로그인 -> 로그아웃으로 표출 및 회원탈퇴 표출 -->
				<c:choose>
					<c:when test="${empty sessionScope.loginId}">
						<li><a href="${pageContext.request.contextPath}/login.do">로그인</a></li>
						<li><a href="${pageContext.request.contextPath}/join.do">회원가입</a></li>					
					</c:when>
					<c:otherwise>
				<li><a href="javascript:void(0);" onclick="logout()" id="logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/delete.do">회원탈퇴</a></li>					
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	
	<!-- menu -->
	<jsp:include page="./menu.jsp" />
	<!-- //menu -->
</header>
<script>
function logout(){
	var result = confirm("로그아웃 하시겠습니까 ?");
	if(result) {
		location.href = '<%=request.getContextPath()%>/logout.do';
	}
}
</script>