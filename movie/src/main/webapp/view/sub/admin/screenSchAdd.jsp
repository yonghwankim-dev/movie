<!-- 팝업 내용 -->
<div id="screenSch_add_form" class="form_popup">
    <form id="screenFrm" action="/movie/admin/screen/add.do" method="post" class="form_container">
    
        <h1>상영일정</h1>

        <div class="form_row">
            <label for="movie_name"><b>영화제목</b></label>
            <input type="text" placeholder="영화제목" name="movie_name" required>
        </div>

        <div class="form_row">
            <label for="loc"><b>지역</b></label>
            <select name="loc">
                <option value="서울">서울</option>
                <option value="대전">대전</option>
            </select>
        </div>
        
        <div class="form_row">
            <label for="cinema_name"><b>지점명</b></label>
            <select name="cinema_name">
                <option value="가산디지털">가산디지털</option>
                <option value="가양">가양</option>
            </select>
        </div>
        
        <div class="form_row">
            <label for="theater_name"><b>상영관이름</b></label>
            <select name="theater_name">
                <option value="1관">1관</option>
                <option value="2관">2관</option>
            </select>
        </div>
        
        <div class="form_row">
            <label for="start_date"><b>상영시작일자</b></label>
            <input type="text" placeholder="2022-03-29" name="start_date" required>
        </div>
        <div class="form_row">
            <label for="end_date"><b>상영종료일자</b></label>
            <input type="text" placeholder="2022-03-29" name="end_date" required>
        </div>
        
        <div class="form_row form_btn">
            <button type="button" id="screenAddBtn">추가</button>
            <button type="button" onclick="closeScreenAddForm()">닫기</button>
        </div>
        
    </form>
</div>
<script>
$('#screenAddBtn').on('click', function() {
	$.ajax({
			url : '/movie/admin/screen/add.do',
			type : 'post',
			data : $('#screenFrm').serialize(),
			success : function(data){
				if (data.code === 'ok') {
					alert('상영일정이 추가되었습니다.');	
				}else if(data.code === 'no'){
					alert("상영일정 추가가 실패되었습니다.");
				}
				location.href = '/movie/admin/admin.do';
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

