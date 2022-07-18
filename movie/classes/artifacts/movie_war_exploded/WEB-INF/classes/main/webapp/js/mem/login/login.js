/**
 * title : 로그인 처리
 * author : 김용환
 * date : 2022-05-24
 */

const login = function(){
	$.ajax({
		url : '/movie/login',
		type : 'post',
		data : $('#loginFrm').serialize(),
		success : function(data) {
			if($('#adminLogin').is(':checked')) {
				if($('#loginId').val() === "admin"){
					alert('관리자 권한으로 로그인 되었습니다.');
					location.href = '/movie/lotte';
				} else {
					alert('관리자 권한 로그인에 실패하였습니다.');
				}
			} else {			
				if (data.code === 'ok') {
					alert('로그인 되었습니다.');
					location.href = '/movie/lotte';
				} else if($('#loginId').val() === "") {
					alert('아이디를 입력 해주세요.');
					$('#loginId').focus();
				} else if($('#loginPwd').val() === "") {
					alert('비밀번호를 입력 해주세요.');
					$('#loginPwd').focus();
				} else {
					alert('회원정보가 일치하지 않습니다.');
					location.href = '/movie/login';
				}
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
};

// 로그인 버튼 클릭
$('#loginBtn').on('click', function() {
	if(!isId($('#loginId').val())){
		alert("ID 형식이 잘못되었습니다. (영문자로 시작하는 영문자 또는 숫자 4~20자)");
	}
	else if(!isPwd($('#loginPwd').val())){
		alert("PASSWORD 형식이 잘못되었습니다. (최소 4 자, 하나 이상의 문자와 하나의 숫자)");	
	}
	else if($('#loginId').val() === 'admin' && $('#adminLogin').is(':checked') === false){
		alert("관리자 로그인 체크박스를 선택하여주십시오.");
	}
	else{
		login();
	}
});