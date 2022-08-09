<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<!-- 팝업 내용 -->
<div id="modal_form" class="form_popup">
    <form id="screenSchFrm" class="form_container">
    
        <h1>영화</h1>

        <div class="form_row">
            <label for="name"><b>영화명</b></label>
            <input id="name" name="name" type="text" placeholder="이름" required>
        </div>

        <div class="form_row">
            <label for="audi_rating"><b>관람등급</b></label>
            <select id="audi_rating" name="audi_rating">
                <option value="0">전체</option>
                <option value="7">7세</option>
                <option value="12">12세</option>
                <option value="15">15세</option>
                <option value="19">19세</option>
            </select>
        </div>

        <div class="form_row">
            <label for="runtime"><b>상영시간</b></label>
            <input id="runtime" name="runtime" type="number" placeholder="100(분)" required>
        </div>
        
        <div class="form_row form_btn">
            <button type="button" id="addBtn">추가</button>
            <button type="button" data-dismiss="modal">닫기</button>
        </div>
        
    </form>
</div>

<script>
$('#addBtn').on('click', function() {
	$.ajax({
			url : '${pageContext.request.contextPath}${UrlPaths.MOVIE_ADD}',
			type : 'post',
			data : $('#screenSchFrm').serialize(),
			success : function(data){
				if (data.code === 'ok') {
					alert('영화가 추가되었습니다.');
				}else if(data.code === 'no'){
					alert("영화제거가 실패되었습니다.");
				}
				location.href = '${pageContext.request.contextPath}${UrlPaths.MOVIE_HOME}';
			}
			,
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json'
	});
});
</script>