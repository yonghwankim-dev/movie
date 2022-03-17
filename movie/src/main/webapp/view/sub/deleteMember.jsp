<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 페이지 타이틀 -->
<h2 class="pageTitle">회원탈퇴</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<form action="delete.do" method="post">
	<div class="delete-div" id="deletefrm">
		<input type="password" id="deletePw" name="pw" title="현재 비밀번호" class="form-control" placeholder="현재 비밀번호를 입력해주세요.">
		<input type="button" id="delete-btn" class="btn btn-danger btn-block" value="회원탈퇴">
		<input type="button" id="back" class="btn btn-block" value="메인으로 돌아가기">
	</div>
</form>

<script>
$('#delete-btn').on('click', function() {
	$.ajax({
		url : '<%=request.getContextPath()%>/delete.do',
		type : 'post',
		data : {'pw' : $('#deletePw').val()},
		success : function(data) {
			if(data.code == 'success') {
				alert(data.msg);
				location.href = '<%=request.getContextPath() %>/main.do';
			} else {
				alert(data.msg);
				location.href = '<%=request.getContextPath() %>/delete.do';
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});
</script>
<!-- //여기까지 페이지 내용 -->