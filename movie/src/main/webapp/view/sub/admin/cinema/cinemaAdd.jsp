<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.com.yh.lotte.UrlPaths" %>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">영화관 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="addForm">
                <div class="form_row">
                    <label for="name"><b>영화관 이름</b></label>
                    <input id="name" name="name" class="form-control" type="text" placeholder="이름" required>
                </div>
                <div class="form_row">
                    <label for="loc"><b>영화관 이름</b></label>
                    <select id="loc" name="loc">
                        <c:forEach var="loc" items="locations">
                            <option value="${loc}">${loc}</option>
                        </c:forEach>
                    </select>
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
			url : '${pageContext.request.contextPath}${UrlPaths.CINEMA_ADD}',
			type : 'post',
			data : $('#addForm').serialize(),
			success : function(data){
				if (data.code === 'ok') {
					alert('영화관이 추가되었습니다.');
				}else if(data.code === 'no'){
					alert("영화관 추가가 실패되었습니다.");
				}
				location.href = '${pageContext.request.contextPath}${UrlPaths.CINEMA_HOME}';
			}
			,
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json'
	});
});
</script>