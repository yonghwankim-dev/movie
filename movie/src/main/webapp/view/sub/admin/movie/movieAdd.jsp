<%@ page import="kr.com.yh.lotte.UrlPaths" %>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">영화 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="addForm">
                <div class="form_row">
                    <label for="name"><b>영화명</b></label>
                    <input id="name" name="name" class="form-control" type="text" placeholder="이름" required>
                </div>

                <div class="form_row">
                    <label for="audi_rating"><b>관람등급</b></label>
                    <select id="audi_rating" name="audi_rating" class="form-control">
                        <option value="0">전체</option>
                        <option value="7">7세</option>
                        <option value="12">12세</option>
                        <option value="15">15세</option>
                        <option value="19">19세</option>
                    </select>
                </div>

                <div class="form_row">
                    <label for="runtime"><b>상영시간</b></label>
                    <input id="runtime" name="runtime" class="form-control" type="number" placeholder="100(분)" required>
                </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="addBtn">추가</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>

<script>
$('#addBtn').on('click', function() {
	$.ajax({
			url : '${pageContext.request.contextPath}${UrlPaths.MOVIE_ADD}',
			type : 'post',
			data : $('#addForm').serialize(),
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