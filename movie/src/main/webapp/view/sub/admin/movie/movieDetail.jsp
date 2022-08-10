<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 페이지 내용 -->
<div class="d-flex">
    <jsp:include page="../layout/sideMenu.jsp" />

    <div class="container">
        <form>
            <table id="movieTable" class="table">
                <tbody>
                    <tr>
                        <th>영화코드</th>
                        <td>${movie.movie_code}</td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>${movie.name}</td>
                    </tr>
                    <tr>
                        <th>관람등급</th>
                        <td>${movie.audi_rating}</td>
                    </tr>
                    <tr>
                        <th>상영시간</th>
                        <td>${movie.runtime}분</td>
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
        location.href = "${pageContext.request.contextPath}${UrlPaths.MOVIE_MODIFY}?movie_code=${movie.movie_code}";
    });
</script>