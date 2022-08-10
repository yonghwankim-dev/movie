<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 페이지 내용 -->
<div class="d-flex">
    <jsp:include page="../layout/sideMenu.jsp" />

    <div class="container">
        <form id="movieModifyForm">
            <table id="movieTable" class="table">
                <tbody>
                    <tr>
                        <th>영화코드</th>
                        <td><input type="text" class="form-control" id="movie_code" name="movie_code" value="${movie.movie_code}" readonly></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" class="form-control join-field" id="name" name="name" pattern="[가-힣]+$" value="${movie.name}" required/></td>
                    </tr>
                    <tr>
                        <th>관람등급</th>
                        <td>
                            <select id="audi_rating" name="audi_rating" class="form-control">
                                <option value="0" ${movie.audi_rating eq 0 ? 'selected' : ''}>전체</option>
                                <option value="7" ${movie.audi_rating eq 7 ? 'selected' : ''}>7세</option>
                                <option value="12" ${movie.audi_rating eq 12 ? 'selected' : ''}>12세</option>
                                <option value="15" ${movie.audi_rating eq 15 ? 'selected' : ''}>15세</option>
                                <option value="19" ${movie.audi_rating eq 19 ? 'selected' : ''}>19세</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>상영시간</th>
                        <td><input id="runtime" name="runtime" class="form-control" type="number" placeholder="100(분)" value="${movie.runtime}" required></td>
                    </tr>
                </tbody>
            </table>
            <button type="button" id="modifyBtn" class="btn btn-primary">수정</button>
            <a href="/movie/admin/movie/home" class="btn btn-light">뒤로가기</a>
        </form>

    </div>
</div>
<!-- //페이지 내용 -->
<script>
    $('#modifyBtn').on('click', function() {
        $.ajax({
            type : 'post',
            url : "${pageContext.request.contextPath}${UrlPaths.MOVIE_MODIFY}",
            data : $('#movieModifyForm').serialize(),
            success : function(data) {
                if (data.code === 'ok') {
                    alert('영화정보가 수정되었습니다.');
                } else if (data.code === 'no') {
                    alert("영화정보 수정이 실패하였습니다.");
                }
                location.href = "${pageContext.request.contextPath}${UrlPaths.MOVIE_DETAIL}?movie_code=${movie.movie_code}";
            },
            error : function(xhr) {
                alert(xhr.status);
            },
            dataType : 'json'
        });
    });
</script>