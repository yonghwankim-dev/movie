<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 페이지 내용 -->
<div class="d-flex">
	<jsp:include page="../layout/sideMenu.jsp" />
	
	<div class="container">
		<form id="screenListFrm">
			<table id="screenTable" class="table table-hover table-striped">
				<thead>
					<tr>
						<th>구분</th>
						<th>상영코드</th>
						<th>영화코드</th>
						<th>영화제목</th>
						<th>지역</th>
						<th>지점명</th>
						<th>상영관코드</th>
						<th>상영관이름</th>
						<th>상영시작일자</th>
						<th>상영종료일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" items="${screenAdmin}" varStatus="status">
						<tr>
							<td><input type="checkbox" name="screen_code"
								value="${s.screen.screen_code}" /></td>
							<td>${s.screen.screen_code}</td>
							<td>${s.movie.movie_code}</td>
							<td>

								<a class="text-decoration-none text-dark" 
								   href="${pageContext.request.contextPath}${UrlPaths.SCREEN_SCH_HOME}?theater_code=${s.theater.theater_code}&movie_code=${s.movie.movie_code}&screen_code=${s.screen.screen_code}">${s.movie.name}</a></td>
							<td>${s.cinema.loc}</td>
							<td>${s.cinema.name}</td>
							<td>${s.theater.theater_code}</td>
							<td>${s.theater.name}</td>
							<td><fmt:formatDate type="date" pattern="YYYY-MM-dd"
									value="${s.screen.start_date}" /></td>
							<td><fmt:formatDate type="date" pattern="YYYY-MM-dd"
									value="${s.screen.end_date}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<button type="button" class="btn btn-primary"
				data-toggle="modal" data-target="#screenAddModel">추가</button>
			<button type="button" id="screenDeleteBtn" class="btn btn-danger">제거</button>
		</form>
	</div>
</div>
<!-- 영화 상영추가 Modal -->
<div id="screenAddModel" class="modal fade" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">영화 상영 추가</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="screenFrm">
					<div class="form-group">
						<label for="movie_name">영화제목</label> 
						<select id="movie_name" name="movie_name" class="form-control form-control-sm">
							<c:forEach var="movie" items="${movies}">
								<option value="${movie.name}">${movie.name}</option>
							</c:forEach>
						</select>
						<br>
						
						<label for="loc">지역</label> 
						<select id="loc" name="loc" class="form-control form-control-sm">
							<c:forEach var="loc" items="${locs}">
								<option value="${loc.cinemaVO.loc}">${loc.cinemaVO.loc}</option>
							</c:forEach>
						</select>
						<br>
						
						<label for="cinemaSelect">지점명</label> 
						<select id="cinemaSelect" name="cinema_name" class="form-control form-control-sm">
							<c:forEach var="cinema" items="${cinemas}">
								<option data-loc="${cinema.loc}" value="${cinema.name}">${cinema.name}</option>
							</c:forEach>						
						</select>
						<br>
						
						<label for="theater_name">상영관이름</label> 
						<select id="theater_name" name="theater_name" class="form-control form-control-sm">
							<option value="1관">1관</option>
							<option value="2관">2관</option>
							<option value="3관">3관</option>
							<option value="4관">4관</option>
							<option value="5관">5관</option>
							<option value="6관">6관</option>
							<option value="7관">7관</option>
						</select>
						<br>
						
						<label for="start_date">상영시작일자</label> 
						<input id="start_date" type="date" class="form-control" name="start_date" required>
						<br>
							
						<label for="end_date">상영종료일자</label> 
						<input id="end_date" type="date" class="form-control" name="end_date" required>
						<br>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				<button type="button" class="btn btn-primary" id="screenAddBtn">추가</button>
			</div>
		</div>
	</div>
</div>

<script>
const changeCinemaByLoc = function(){
	// 선택한 지역
	const loc = $('#locSelect').val();
	
	// 선택한 지역에 속하는 영화지점 필터링
	$('#cinemaSelect option').each(function(){
		if($(this).data("loc") === loc){
			$(this).show();
		}else{
			$(this).hide();
		}
	});
	
	// 모든 선택 해제
	$('#cinemaSelect option').removeAttr("selected");
	// 선택한 지역의 첫번째 영화지점 선택 
	$('#cinemaSelect option').filter(function(){return $(this).attr('data-loc') === loc;})
							 .first()
	                         .attr('selected','selected');
};

$('#locSelect').ready(changeCinemaByLoc);

$('#locSelect').on('change', changeCinemaByLoc);

$('#screenAddBtn').on('click', function(){
	$.ajax({
		url : '${pageContext.request.contextPath}${UrlPaths.SCREEN_ADD}',
		type : 'post',
		data : $('#screenFrm').serialize(),
		success : function(data) {
			if (data.code === 'ok') {
				alert('영화 상영이 추가되었습니다.');
			} else if (data.code === 'no') {
				alert("영화 상영 추가가 실패하였습니다.");
			}
			location.href = '${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}';
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});	
});
</script>
<!-- //영화 상영추가 Modal -->

<script>
	$('#screenDeleteBtn').on('click', function() {
		$.ajax({
			type : 'post',
			url : "${pageContext.request.contextPath}${UrlPaths.SCREEN_DELETE}",
			data : $('#screenListFrm').serialize(),
			success : function(data) {
				if (data.code === 'ok') {
					alert('상영일정이 제거되었습니다.');
				} else if (data.code === 'no') {
					alert("상영일정 제거가 실패되었습니다.");
				}
				location.href = "${pageContext.request.contextPath}${UrlPaths.SCREEN_HOME}";
			},
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json'
		});
	});
</script>
<!-- //페이지 내용 -->






