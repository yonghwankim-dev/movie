<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 페이지 내용 -->
<div class="d-flex">
    <jsp:include page="../layout/sideMenu.jsp" />

    <div class="container">
        <form>
            <table id="memTable" class="table">
                <tbody>
                    <tr>
                        <th>회원코드</th>
                        <td>${mem.mem_code}</td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>${mem.name}</td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>${mem.birthday}</td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>${mem.contact}</td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>${mem.addr}</td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>${mem.email}</td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>${mem.id}</td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>${mem.gender}</td>
                    </tr>
                </tbody>
            </table>
            <button type="button" id="memModifyBtn" class="btn btn-primary">수정</button>
            <a href="/movie/admin/mem/home" class="btn btn-light">뒤로가기</a>
        </form>

    </div>
</div>
<!-- //페이지 내용 -->
