<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle"> 영화관리 </h2>
<!-- //페이지 타이틀 -->

<!-- 페이지 내용 -->
<div class="admin_container">
    <div class="admin_column admin_menu">
        <ul>
            <li>
                <a href="#">상영관리</a>
            </li>
        </ul>
    </div>
    <div class="admin_column admin_content">
        <div class="content_container">
            <form id="screenListFrm" action="/movie/admin/screen/delete.do" method="post">
                <div class="screen_date_table">
                    <table>
                        <thead>
                            <tr>
                                <td>구분</td>
                                <td>상영코드</td>
                                <td>영화제목</td>
                                <td>상영관이름</td>
                                <td>상영일자</td>
                                <td>상영시간</td>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="screen" items="${screens}" varStatus="status">
                        		<tr>
                        			<td>
                        				<input type="checkbox" name="screen_code" value="${screen.screen_code}"/>	
                        			</td>
                        			<td>
                                    	<span>${screen.screen_code}</span>
	                                </td>
	                                <td>
	                                    <span>${screen.movie_title}</span>
	                                </td>
	                                <td>
	                                    <span>${screen.theater_name}</span>
	                                </td>
	                                <td>
	                                    <span>
	                                    	<fmt:formatDate value="${screen.screen_date}" pattern="YYYY-MM-dd" type="date"/>
	                                    </span>
	                                </td>
	                                <td>
	                                    <span>
	                                    	<fmt:formatDate value="${screen.screen_time}" pattern="HH:MM" type="time"/>
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
<jsp:include page="./screen_add.jsp" />
<!-- //상영일정 추가 팝업 내용 -->


