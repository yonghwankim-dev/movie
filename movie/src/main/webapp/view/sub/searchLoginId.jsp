<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="searchLoginId-form">
    	<form action="searchLoginId.do" method="post" id="searchLoginIdfrm">
    	<label class="col-sm-3 control-label" for="searchName">이름</label>
    		<input type="text" id="searchName" placeholder="이름" class="form-control" name="searchName"> <br>
    			<div class="form-group tel-group">
	  <label class="col-sm-3 control-label" for="firstPh">전화번호</label>
      <div class="col-sm-9">
        <div class="row">
          <div class="col-xs-3">
	        <input class="form-control" type="text" placeholder="010" id="firstTel" required pattern="(010)" maxlength="3" name="firstTel">  		
          </div>
      
          <span class="ph-span"> - </span>
      
          <div class="col-xs-3">
            <input class="form-control" type="text" placeholder="0000" id="middleTel" required pattern="[0-9]{4}" maxlength="4" name="middleTel" title="전화번호 두 번째 자리">
          </div>
      
          <span class="ph-span"> - </span>
      
          <div class="col-xs-3">
            <input class="form-control" type="text" placeholder="0000" id="lastTel" required pattern="[0-9]{4}" maxlength="4" name="lastTel" title="전화번호 마지막 자리">
          </div>
        </div>
      </div>
  	</div>  	
      <input type="button" value="아이디찾기" class="btn btn-submit" id="btn">
</form>
    </div>
<script>
$('#btn').on('click', function() {
	$.ajax({
		url : '<%=request.getContextPath()%>/searchLoginId.do',
		type : 'post',
		data : $('#searchLoginIdfrm').serialize(),
		success : function(data) {
			if(data.loginId != null) {
			alert("입력하신 정보 검색결과 아이디는 \"" + data.loginId + "\"입니다.");
			} else {
				alert(data.msg);
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});
</script>