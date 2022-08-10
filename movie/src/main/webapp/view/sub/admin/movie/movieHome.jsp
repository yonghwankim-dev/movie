<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 페이지 내용 -->
<div class="d-flex">
    <jsp:include page="../layout/sideMenu.jsp" />

    <div class="container">
        <div class="col-4 m-0">
            <form action="${pageContext.request.contextPath}${UrlPaths.MOVIE_HOME}" class="d-flex" role="search">
                <select name="category">
                    <option value="name">이름</option>
                    <option value="audi_rating">관람등급</option>
                </select>
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="content">
                <button class="btn btn-outline-success" type="submit">검색</button>
            </form>
        </div>
        <form id="form">
        <table id="table" class="table table-hover table-striped">
            <thead>
            <tr>
                <th>구분</th>
                <th>영화코드</th>
                <th>이름</th>
                <th>관람등급</th>
                <th>상영시간</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="m" items="${movies}" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="movie_code" value="${m.movie_code}"/></td>
                    <td>${m.movie_code}</td>
                    <td>
                        <a class="text-decoration-none text-dark"
                           href="${pageContext.request.contextPath}${UrlPaths.MOVIE_DETAIL}?movie_code=${m.movie_code}">${m.name}</a>
                    </td>
                    <td>${m.audi_rating}</td>
                    <td>${m.runtime}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_form">추가</button>
        <button type="button" id="deleteBtn" class="btn btn-danger">제거</button>
        </form>
    </div>
</div>
<!-- 영화 추가 모달 -->
<jsp:include page="movieAdd.jsp"/>
<!-- //영화 추가 모달 -->
<!-- //페이지 내용 -->

<script>
    $('#deleteBtn').on('click', function() {
        $.ajax({
            type : 'post',
            url : "${pageContext.request.contextPath}${UrlPaths.MOVIE_DELETE}",
            data : $('#form').serialize(),
            success : function(data) {
                if (data.code === 'ok') {
                    alert('영화가 제거되었습니다.');
                } else if (data.code === 'no') {
                    alert("영화 제거가 실패되었습니다.");
                }
                location.href = "${pageContext.request.contextPath}${UrlPaths.MOVIE_HOME}";
            },
            error : function(xhr) {
                alert(xhr.status);
            },
            dataType : 'json'
        });
    });
</script>





