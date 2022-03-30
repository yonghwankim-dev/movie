<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 페이지 타이틀 -->
<h2 class="pageTitle">로그인</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="login-form">
  <form action="login.do" method="post" id="loginFrm">
    <input type="text" class="form-control login-field" placeholder="아이디" title="아이디" name="id" id="id">
	<input type="password" class="form-control login-field" placeholder="비밀번호" title="비밀번호" name="pw" id="pw">
	<input type="button" value="로그인" class="btn btn-submit" id="btn">
	
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
<script>
$('#btn').on('click', function() {
	$.ajax({
		url : '<%=request.getContextPath() %>/login.do',
		type : 'post',
		data : $('#loginFrm').serialize(),
		success : function(data) {
			if($('#adminLogin').is(':checked')) {
				if($('#id').val() == ("admin") && $('#pw').val() == ("admin")){
					alert('관리자 권한으로 로그인 되었습니다.');
					location.href = '<%=request.getContextPath() %>/main.do';
				} else {
					alert('관리자 권한 로그인에 실패하였습니다.');
				}
			} else {			
			if (data.code == 'ok') {
				alert('로그인 되었습니다.');
				location.href = '<%=request.getContextPath() %>/main.do';
			} else if($('#id').val() == "") {
				alert('아이디를 입력 해주세요.');
				$('#id').focus();
			} else if($('#pw').val() == "") {
				alert('비밀번호를 입력 해주세요.');
				$('#pw').focus();
			} else {
				alert('회원정보가 일치하지 않습니다.');
				location.href = '<%=request.getContextPath() %>/login.do';
			}
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});
if($('#adminLogin').is(':checked')) {
	if($('#id').val().equals("admin") && $('#pw').val().equals("admin")){
	}
}
</script>
<!-- //여기까지 페이지 내용 -->
