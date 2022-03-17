<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle">비회원 영화 예매</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="nonMember_wrap">
  <div class="container">

    <div class="topbox_st1">
	    <i class="xi-desktop" aria-hidden="true"></i>
	    	
    	<div class="inner">
    		<h3>
		      <strong class="color_red">STEP 2</strong> 개인정보(휴대폰번호, 법정생년월일, 비밀번호) 입력
		    </h3>
		    <p>개인정보를 잘못 입력하시면 예매내역 및 확인/취소 및 티켓 발권이 어려울 수 있으니, 입력하신 정보를 다시 한번 확인해주시기 바랍니다.</p>
    	</div>
    </div>
    
  	<p>모든 항목은 <strong class="color_red">필수 입력사항</strong>입니다.</p> <br>
  
  <form class="form-horizontal" method="post" action="nonMember.do">
    <div class="form-group">
      <label class="control-label col-sm-2" for="birth">법정생년월일(8자리)</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="birth" maxlength="8" required="required" name="nMemBir">
      </div>
    </div>
    
    
    <div class="form-group phone">
      <label class="control-label col-sm-2" for="pwd">휴대폰번호</label>
      <div class="col-sm-10">      
        <select title="휴대폰 번호 앞자리" name="txtMobile1" class="form-control" id="txtMobile1">
          <option value="010">010</option>
          <option value="011">011</option>
          <option value="016">016</option>
          <option value="017">017</option>
          <option value="018">018</option>
          <option value="019">019</option>
        </select>    
        -
        <input type="text" class="form-control only-number" id="txtMobile2" maxlength="4" required="required" pattern="[0-9]{3,4}" name="txtMobile2">
        -
        <input type="text" class="form-control only-number" id="txtMobile3" maxlength="4" required="required" pattern="[0-9]{3,4}" name="txtMobile3">
        <input type="button" class="form-control only-number" id="txtMobileBtn" value="인증번호 받기">
      </div>
    </div>
    


    <div class="form-group">
      <label class="control-label col-sm-2" for="tel">인증번호(4자리)</label>
      <div class="col-sm-6">
        <input type="password" class="form-control" id="certifi" maxlength="4" required="required" pattern="[0-9]{4}">
      </div>
      <div class="col-sm-2">
        <input type="button" class="form-control only-number" id="txtMobileChk" value="인증확인">
      </div>
      <span class="col-sm-2" id="txtMobileChkRst"></span>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="pw">비밀번호(4자리)</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="pw" maxlength="4" required="required" pattern="[0-9]{4}" name="nMemPw">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwCheck">비밀번호확인</label>
      <div class="col-sm-8">
        <input type="password" class="form-control" id="pwChk" maxlength="4" required="required" pattern="[0-9]{4}">
      </div>
        <span id="pwChkPrint" class="col-sm-2"></span>
    </div>

      <div class="text-center">
    	<button type="submit" class="btn btn-default" id="nonRes">비회원 예매하기</button>
      </div>
  </form>
</div>
</div>
  
  <script>
  let phoneNumber = "";
  let code = "";
    $("#txtMobileBtn").on("click", function() {
		phoneNumber = $("#txtMobile1").val()+$("#txtMobile2").val()+$("#txtMobile3").val();
		//console.log(phoneNumber);
		alert("인증번호가 발송되었습니다.\n확인 후 인증번호를 입력해주세요.");
		 $.ajax({
	    	
	    	type:"get",
	    	url :"<%=request.getContextPath()%>/nonMemberCertification.do",
	    	data: { "phoneNumber" : phoneNumber},
	    	success : function(data) {
	    		
	    		if (data == null) {
					alert("휴대폰 번호가 올바르지 않습니다.\n올바른 번호를 입력해주세요.");
				} else {
					code = data.num;
				}
			},
			error: function(xhr) {
				alert(xhr.status);
			},
			dataType: "json"
	    });
	});
    
    
    
    $("#txtMobileChk").on("click", function() {
		
    	if ($("#certifi").val() == code) {
    		$("#txtMobileChkRst").html("인증번호 일치").css("color", "green");
		} else {
    		$("#txtMobileChkRst").html("인증번호 불일치").css("color", "red");
		}
	});
    
    
    $("#pwChk").on("keyup",function(){
    	
    	if ($("#pwChk").val().length != 0) {
			if ($("#pw").val() == $("#pwChk").val()) {
				$("#pwChkPrint").html("비밀번호 일치").css("color", "green");
			} else {
				$("#pwChkPrint").html("비밀번호 불일치").css("color", "red");
			}
		}
    });
  </script>
 <!-- //여기까지 페이지 내용 -->