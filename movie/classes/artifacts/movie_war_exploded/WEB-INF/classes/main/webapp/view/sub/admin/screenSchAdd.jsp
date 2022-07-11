<!-- 팝업 내용 -->
<div id="screenSch_add_form" class="form_popup">
    <form id="screenSchFrm" class="form_container">
    
        <h1>상영일정</h1>

        <div class="form_row">
            <label for="screen_date"><b>상영일자</b></label>
            <input type="text" placeholder="2022-03-29" name="screen_date" required>
        </div>

        <div class="form_row">
            <label for="start_time"><b>시작시간</b></label>
			<input type="text" placeholder="12:00" name="start_time" required>            
        </div>
        
        <div class="form_row">
            <label for="end_time"><b>종료시간</b></label>
			<input type="text" placeholder="12:00" name="end_time" required>            
        </div>
        
        <div class="form_row">
            <label for="screen_num"><b>상영회차</b></label>
			<input type="text" placeholder="1" name="screen_num" required>            
        </div>
        
        <div class="form_row hidden">
            <label for="movie_code"><b>영화코드</b></label>
			<input type="text" name="movie_code" value="${movie_code}" readonly>            
        </div>
        
        <div class="form_row hidden">
            <label for="theater_code"><b>상영관코드</b></label>
			<input type="text" name="theater_code" value="${theater_code}" readonly>            
        </div>
        
        <div class="form_row hidden">
            <label for="theater_code"><b>상영코드</b></label>
			<input type="text" name="screen_code" value="${screen_code}" readonly>            
        </div>
        
        <div class="form_row form_btn">
            <button type="button" id="screenSchAddBtn">추가</button>
            <button type="button" onclick="closeScreenSchAddForm()">닫기</button>
        </div>
        
    </form>
</div>
<script>
$('#screenSchAddBtn').on('click', function() {
	$.ajax({
			url : '/movie/admin/screenSch/add.do',
			type : 'post',
			data : $('#screenSchFrm').serialize(),
			success : function(data){
				if (data.code === 'ok') {
					alert('상영일정이 추가되었습니다.');	
				}else if(data.code === 'no'){
					alert("상영일정 추가가 실패되었습니다.");
				}
				location.href = '/movie/admin/screenSch/admin.do?theater_code=' + data.theater_code
						      + '&movie_code=' + data.movie_code
						      + '&screen_code=' + data.screen_code;
			}
			,
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json'
	});
});
</script>
<!-- //팝업 내용-->

