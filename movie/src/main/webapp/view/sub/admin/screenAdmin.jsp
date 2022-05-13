<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle"> 상영관리 </h2>
<!-- //페이지 타이틀 -->

<!-- 페이지 내용 -->
<div class="admin_container">
	<jsp:include page="./layout/sideMenu.jsp" />
	    
    <div class="admin_column admin_content">
        <div class="content_container">
            <form id="screenListFrm" action="/movie/admin/screen/delete.do" method="post">
                <div class="screen_date_table">
                    <table id="screenTable">
                        <thead>
                            <tr>
                                <td>구분</td>
                                <td>상영코드</td>
                                <td>영화코드</td>
                                <td>영화제목</td>
                                <td>지역</td>
                                <td>지점명</td>
                                <td>상영관코드</td>
                                <td>상영관이름</td>
                                <td>상영시작일자</td>
                                <td>상영종료일자</td>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="s" items="${screenAdmin}" varStatus="status">
                        		<tr>
                        			<td>
                        				<input type="checkbox" name="screen_code" value="${s.screen.screen_code}"/>	
                        			</td>
                        			<td>
                                    	<span>${s.screen.screen_code}</span>
	                                </td>
                        			<td>
                                    	<span>${s.movie.movie_code}</span>
	                                </td>
	                                <td>
                                    	<span>${s.movie.name}</span>
	                                </td>
	                                <td>
                                    	<span>${s.cinema.loc}</span>
	                                </td>
	                                <td>
                                    	<span>${s.cinema.name}</span>
	                                </td>
	                                <td>
                                    	<span>${s.theater.theater_code}</span>
	                                </td>
	                                <td>
                                    	<span>${s.theater.name}</span>
	                                </td>
	                                <td>
                                    	<span>
                                    		<fmt:formatDate value="${s.screen.start_date}" pattern="YYYY-MM-dd" type="date"/>
                                    	</span>
	                                </td>
	                                <td>	                                
                                    	<span>
                                    		<fmt:formatDate value="${s.screen.end_date}" pattern="YYYY-MM-dd" type="date"/>
                                    	</span>
	                                </td>
                        		</tr>
                        	</c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="screen_date_control">
                    <button type="button" onclick="openScreenAddForm()">추가</button>
                    <button type="button" id="screenDeleteBtn">제거</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
$('#screenTable tbody tr').hover(function(){
	$('#screenTable tbody tr').css('background', '#eee');
}, function(){
	$('#screenTable tbody tr').css('background', '#fff');
});

$('#screenTable tbody tr').on('click', function(){
	const tr = $(this);
	const td = tr.children();
	
	const theater_code = $.trim(td.eq(6).text());
	const movie_code = $.trim(td.eq(2).text());
	const screen_code = $.trim(td.eq(1).text());
	

	$(location).attr('href'
				   , '/movie/admin/screenSch/admin.do?theater_code='+theater_code+'&movie_code='+movie_code+'&screen_code='+screen_code); 
});

$('#screenDeleteBtn').on('click', function() {
	$.ajax({
			url : '/movie/admin/screen/delete.do',
			type : 'post',
			data : $('#screenListFrm').serialize(),
			success : function(data){
				if (data.code === 'ok') {
					alert('상영일정이 제거되었습니다.');	
				}else if(data.code === 'no'){
					alert("상영일정 제거가 실패되었습니다.");
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
<!-- //페이지 내용 -->



<!-- 상영일정 추가 팝업 내용 -->
<jsp:include page="./screenAdd.jsp" />
<!-- //상영일정 추가 팝업 내용 -->


