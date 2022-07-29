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
            <form action="${pageContext.request.contextPath}${UrlPaths.MEM_FIND}" method="post" class="d-flex" role="search">
                <select name="category">
                    <option value="name">이름</option>
                    <option value="id">아이디</option>
                    <option value="contact">연락처</option>
                </select>
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="content">
                <button class="btn btn-outline-success" type="submit">검색</button>
            </form>
        </div>
        <form id="memListFrm">
        <table id="memTable" class="table table-hover table-striped">
            <thead>
            <tr>
                <th>구분</th>
                <th>회원코드</th>
                <th>이름</th>
                <th>생년월일</th>
                <th>연락처</th>
                <th>주소</th>
                <th>이메일</th>
                <th>아이디</th>
                <th>성별</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="m" items="${mems}" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="mem_code" value="${m.mem_code}"/></td>
                    <td>${m.mem_code}</td>
                    <td>
                        <a class="text-decoration-none text-dark"
                           href="${pageContext.request.contextPath}${UrlPaths.MEM_DETAIL}?mem_code=${m.mem_code}">${m.name}</a>
                    </td>
                    <td>${m.birthday}</td>
                    <td>${m.contact}</td>
                    <td>${m.addr}</td>
                    <td>${m.email}</td>
                    <td>${m.id}</td>
                    <td>${m.gender}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#memAddModal">추가</button>
        <button type="button" id="memDeleteBtn" class="btn btn-danger">제거</button>
        </form>
    </div>
</div>
<!-- 회원 추가 모달 -->
<jsp:include page="memAdd.jsp"/>
<!-- //회원 추가 모달 -->
<!-- //페이지 내용 -->

<script>
    $('#memDeleteBtn').on('click', function() {
        $.ajax({
            type : 'post',
            url : "${pageContext.request.contextPath}${UrlPaths.MEM_DELETE}",
            data : $('#memListFrm').serialize(),
            success : function(data) {
                if (data.code === 'ok') {
                    alert('회원이 제거되었습니다.');
                } else if (data.code === 'no') {
                    alert("회원 제거가 실패되었습니다.");
                }
                location.href = "${pageContext.request.contextPath}${UrlPaths.MEM_HOME}";
            },
            error : function(xhr) {
                alert(xhr.status);
            },
            dataType : 'json'
        });
    });
</script>





