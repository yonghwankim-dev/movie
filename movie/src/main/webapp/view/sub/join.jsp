<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 페이지 타이틀 -->
<h2 class="pageTitle">회원가입</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="join-form form-horizontal">
  <form action="join.do" method="post">
  	<div class="form-group">
  	  <label class="col-sm-3 control-label" for="joinNm">이름</label>
  	  <div class="col-sm-9">
	    <input type="text" class="form-control join-field" id="joinNm" required pattern="[가-힣]+$" required name="name">
  	  </div>
  	</div>
  	
  	<div class="form-group tel-group">
	  <label class="col-sm-3 control-label" for="firstPh">전화번호</label>
      <div class="col-sm-9">
        <div class="row">
          <div class="col-xs-3">
	        <input class="form-control" type="text" placeholder="010" id="firstPh" required pattern="(010)" maxlength="3" name="firstTel">  		
          </div>
      
          <span class="ph-span"> - </span>
      
          <div class="col-xs-3">
            <input class="form-control" type="text" placeholder="0000" id="middlePh" required pattern="[0-9]{4}" maxlength="4" name="middleTel" title="전화번호 두 번째 자리">
          </div>
      
          <span class="ph-span"> - </span>
      
          <div class="col-xs-3">
            <input class="form-control" type="text" placeholder="0000" id="lastPh" required pattern="[0-9]{4}" maxlength="4" name="lastTel" title="전화번호 마지막 자리">
          </div>
        </div>
      </div>
  	</div>
	
	<div class="form-group email-group">
	  <label class="col-sm-3 control-label" for="joinEm">이메일</label>
  	  <div class="col-sm-9">
  	    <div class="row">
  	    	<div class="col-xs-5">
	  	      <input type="text" class="form-control" placeholder="UserID" id="joinEm" required name="userId">
	  	    </div>
	  	    
	  	    <span class="email-dash">@</span>
	  	    
	  	    <div class="col-xs-6">
	  	      <input type="text" class="form-control" placeholder="Server" id="server" required name="userServer" title="이메일 뒷자리">
	  	    </div>
  	    </div>
  	  </div>
	</div>
  	
	<div class="form-group">
	  <label class="col-sm-3 control-label" for="joinId">아이디</label>
	  <div class="col-sm-9">
	    <input type="text" class="form-control" id="joinId" name="id">	  
	  	<div class="msg" id="checkId"></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-sm-3 control-label" for="joinPw">비밀번호</label>
	  <div class="col-sm-9">
	    <input type="password" class="form-control" id="joinPw" required name="pw">
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-sm-3 control-label" for="joinPwCheck">비밀번호 재확인</label>
	  <div class="col-sm-9">
	    <input type="password" class="form-control" id="joinPwCheck" required>
	  	<div class="msg" id="checkPw"></div>
	  </div>
	</div>
		
	<div class="form-group">
	  <label class="col-sm-3 control-label" for="option1">성별</label>
	  <div class="col-sm-9">
	    <span class="radio">
    	  <label for="option1">	    	
    	    <input type="radio" class="btn-check" name="gender" id="option1" autocomplete="off" checked value="남성"> 남성
    	  </label>
	    </span>
	    
	    <span class="radio">
	      <label for="option2">
	        <input type="radio" class="btn-check" name="gender" id="option2" autocomplete="off" value="여성"> 여성
	      </label>
	    </span>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-sm-3 control-label" for="year">생년월일</label>
	  <div class="col-sm-9">
	    <div class="row">
	      <div class="col-xs-4">
	        <input type="text" class="form-control" id="year" required pattern="[0-9]{4}" placeholder="YYYY" maxlength="4" required name="year" title="년">
	      </div>
	    
	      <div class="col-xs-4">
	        <input type="text" class="form-control" id="mon" required pattern="[0-9]{2}" placeholder="MM" maxlength="2" required name="month" title="월">
	      </div>
	    
	      <div class="col-xs-4">
	        <input type="text" class="form-control" id="day" required pattern="[0-9]{2}" placeholder="DD" maxlength="2" required name="day" title="일">
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-sm-3 control-label" for="post">주소</label>
	  <div class="col-sm-9">
	    <div class="row">
    	  <div class="col-xs-6">
	        <input id="post" type="text" class="form-control" placeholder="우편번호" readonly onclick="findAddr()" name="zip">
	      </div>
	    
	      <div class="col-xs-6">	    
	        <input id="addr" type="text" class="form-control" placeholder="도로명주소" title="도로명주소" readonly name="loadAdd">
	      </div>
	    </div>
	    
	    <input type="text" class="form-control" placeholder="상세주소" title="상세주소" id="detailAddr" name="detailAdd">
	  </div>
	</div>
	
	<input type="submit" value="회원가입" class="btn btn-danger submit-join">
  </form>
</div>
<script>

$('#joinId').on('keyup', function() {
	$.ajax({
		url : '<%=request.getContextPath() %>/check.do',
		type : 'post',
		data : {'id' : $('#joinId').val()},
		success : function(a) {
			if(a.code == 'ok' && $('#joinId').val() != "") {
				$('#checkId').html(a.msg).css('color', 'green');
			} else if($('#joinId').val() == "") {
				$('#checkId').html("아이디를 입력해주세요.").css('color', 'orange');
			} else {
				$('#checkId').html(a.msg).css('color', 'red');
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});

$('#joinPwCheck, #joinPw').on('keyup', function() {
	if(($('#joinPw').val() != "" && $('#joinPwCheck').val() != "") && $('#joinPw').val() == $('#joinPwCheck').val()) {
		$('#checkPw').html("사용 가능한 비밀번호입니다.").css('color', 'green');
	} else if($('#joinPw').val() == "" && $('#joinPwCheck').val() == "") {
		$('#checkPw').html("비밀번호를 입력해주세요.").css('color', 'orange');
	} else {
		$('#checkPw').html("비밀번호를 다시한번 확인해주세요.").css('color', 'red');
	}
});

function findAddr() {
	new daum.Postcode({
		oncomplete: function(data) {
			console.log(data);
			
			var roadAddr = data.roadAddress;
			var jibunAddr = data.jibunAddress;
			
			document.getElementById('post').value = data.zonecode;
			if(roadAddr != ''){
				document.getElementById('addr').value = roadAddr;
			} else if(jibunAddr != '') {
				document.getElementById('addr').value = jibunAddr;
			}
		}
	}).open();
};
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- //여기까지 페이지 내용 -->
