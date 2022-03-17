<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header id="header">
	<div class="container-fluid">
		<h1 id="logo">
			<a href="<%=request.getContextPath() %>/main.do">
				<img src="<%=request.getContextPath() %>/images/common/logo.png" alt="LOTTE CGV BOX">
			</a>
		</h1>
		<% if(session.getAttribute("name") != null) {
		String name = (String)session.getAttribute("name");%>
		<p class="loginMsg"><%=name%>님 로그인</p>
		<% } else {%>
		<p class="loginMsg">로그인 후 이용해주세요.</p>
		<%} %>
		<div id="util">
			<ul>
				<!-- 로그인 시에는 로그인 -> 로그아웃으로 표출 및 회원탈퇴 표출 -->
				<% if (session.getAttribute("loginId") == null) { %>				
					<li><a href="<%=request.getContextPath() %>/login.do">로그인</a></li>
					<li><a href="<%=request.getContextPath() %>/join.do">회원가입</a></li>
				<% } else { %>
				<li><a href="javascript:void(0);" onclick="logout()" id="logout">로그아웃</a></li>
				<li><a href="<%=request.getContextPath() %>/delete.do">회원탈퇴</a></li>
				<%
				}
				%>
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