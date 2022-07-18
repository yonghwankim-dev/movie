/**
 *
 */

import urlPaths from "/movie/js/UrlPaths/urlPaths.js";

$('#joinId').on('keyup', function() {
	$.ajax({
		url : urlPaths.CHECK_ID,
		type : 'post',
		data : {'id' : $('#joinId').val()},
		success : function(data) {
			if(data.code == 'ok' && $('#joinId').val() != "") {
				$('#checkId').html(data.msg).css('color', 'green');
			} else if($('#joinId').val() == "") {
				$('#checkId').html("아이디를 입력해주세요.").css('color', 'orange');
			} else {
				$('#checkId').html(data.msg).css('color', 'red');
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});

$('#checkPhoneBtn').on('click', function(){
		const phone = $('#firstPh').val()
		            + '-' 
                    + $('#middlePh').val()
					+ '-'
                    + $('#lastPh').val();
 
		$.ajax({
		url : urlPaths.CHECK_PHONE,
		type : 'post',
		data : {'phone' : phone},
		success : function(data) {
			if(data.code == 'ok' && $('#firstPh').val() != ""
			                     && $('#middlePh').val() != ""
                                 && $('#lastPh').val() != "") { // 연락처 입력 가능
				$('#checkPhone').html(data.msg).css('color', 'green');
			} else if($('#firstPh').val() === ""
			       || $('#middlePh').val() === ""
                   || $('#lastPh').val() === "") { // 연락처 정보가 공백인 경우
				$('#checkPhone').html("연락처를 입력해주세요.").css('color', 'orange');
			} else { // 이미 존재하는 연락처가 있는 경우
				$('#checkPhone').html(data.msg).css('color', 'red');
			}			
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});

$('#checkEmailBtn').on('click', function(){
		const email = $('#joinEm').val()
		            + '@' 
                    + $('#server').val();
		$.ajax({
		url : urlPaths.CHECK_EMAIL,
		type : 'post',
		data : {'email' : email},
		success : function(data) {
			if(data.code == 'ok' && $('#joinEm').val() != ""
			                     && $('#server').val() != "") { // 이메일 입력 가능
				$('#checkEmail').html(data.msg).css('color', 'green');
			} else if($('#joinEm').val() === ""
			       || $('#server').val() === "") { // 이메일 정보가 공백인 경우
				$('#checkEmail').html("이메일을 입력해주세요.").css('color', 'orange');
			} else { // 이미 존재하는 이메일이 있는 경우
				$('#checkEmail').html(data.msg).css('color', 'red');
			}			
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});

$('#joinPwCheck, #joinPw').on('keyup', function() {
	if(($('#joinPw').val() != "" && $('#joinPwCheck').val() != "") 
       && 
       $('#joinPw').val() == $('#joinPwCheck').val()) {
		$('#checkPw').html("사용 가능한 비밀번호입니다.").css('color', 'green');
	}else if($('#joinPw').val() == "" && $('#joinPwCheck').val() == "") {
		$('#checkPw').html("비밀번호를 입력해주세요.").css('color', 'orange');
	}else {
		$('#checkPw').html("비밀번호를 다시한번 확인해주세요.").css('color', 'red');
	}
});

$("#post").on("click", function(){
	new daum.Postcode({
		oncomplete: function(data) {
			const roadAddr = data.roadAddress;
			const jibunAddr = data.jibunAddress;

			document.getElementById('post').value = data.zonecode;
			if(roadAddr != ''){
				document.getElementById('addr').value = roadAddr;
			} else if(jibunAddr != '') {
				document.getElementById('addr').value = jibunAddr;
			}
		}
	}).open();
})

$('#joinBtn').on('click', function() {
	$.ajax({
		url : urlPaths.SIGNUP,
		type : 'post',
		data : $('#joinFrm').serialize(),
		success : function(data) {
			if(data.code == 'ok'){
				alert("회원가입에 성공하셨습니다.");
				location.href = urlPaths.SUCCESS_SIGNUP;
			}
			else{
				alert("회원가입에 실패하셨습니다.");
				location.href = urlPaths.SIGNUP;
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});