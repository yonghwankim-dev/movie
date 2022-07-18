<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle"> 상영일정관리 </h2>
<!-- //페이지 타이틀 -->

<!-- 페이지 내용 -->
<div class="admin_container">
	<jsp:include page="../layout/sideMenu.jsp" />
	
    <div class="container">
		<form id="screenSchListFrm">				
				<!-- 상영관코드 -->
				<input type="text" class="hidden" name="theater_code" value="${theater_code}" readonly>
				<!-- 영화코드 -->
				<input type="text" class="hidden" name="movie_code" value="${movie_code}" readonly>
				<!-- 상영코드 -->
				<input type="text" class="hidden" name="screen_code" value="${screen_code}" readonly>				
            	
                <table class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <td>구분</td>
                                <td>상영일정코드</td>
                                <td>상영일자</td>
                                <td>시작시간</td>
                                <td>종료시간</td>
                                <td>상영회차</td>
                                <td>영화코드</td>
                                <td>상영관코드</td>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="s" items="${screenSchs}" varStatus="status">
                        		<tr>
                        			<td>
                        				<input type="checkbox" name="screen_sch_code" value="${s.screen_sch_code}"/>	
                        			</td>
                        			<td>
                                    	<span>${s.screen_sch_code}</span>
	                                </td>
                        			<td>
                                    	<span>${s.screen_date}</span>
	                                </td>	                                
                        			<td>
                                    	<span>${s.start_time}</span>
	                                </td>
									<td>
                                    	<span>${s.end_time}</span>
	                                </td>
									<td>
                                    	<span>${s.screen_num}</span>
	                                </td>
									<td>
                                    	<span>${s.movie_code}</span>
	                                </td>
									<td>
                                    	<span>${s.theater_code}</span>
	                                </td>	                        		        
                        		</tr>
                        	</c:forEach>
                        </tbody>
                    </table>

				<button type="button" onclick="openScreenSchAddForm()" class="btn btn-primary">추가</button>
				<button type="button" id="screenSchDeleteBtn" class="btn btn-danger">제거</button>
            </form>
    </div>
</div>

<script>
$('#screenSchDeleteBtn').on('click', function() {
	$.ajax({
			url : '${pageContext.request.contextPath}${UrlPaths.SCREEN_SCH_DELETE}',
			type : 'post',
			data : $('#screenSchListFrm').serialize(),
			success : function(data){
				if (data.code === 'ok') {
					alert('상영일정이 제거되었습니다.');	
				}else if(data.code === 'no'){
					alert("상영일정 제거가 실패되었습니다.");
				}
				location.href = '${pageContext.request.contextPath}${UrlPaths.SCREEN_SCH_HOME}?theater_code=' + data.theater_code
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
<!-- //페이지 내용 -->



<!-- 상영일정 추가 팝업 내용 -->
<jsp:include page="screenSchAdd.jsp" />
<!-- //상영일정 추가 팝업 내용 -->
