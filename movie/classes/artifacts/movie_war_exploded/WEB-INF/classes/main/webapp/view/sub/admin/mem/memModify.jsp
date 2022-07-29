<%@ page import="kr.com.yh.lotte.UrlPaths" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- 페이지 내용 -->
<div class="d-flex">
    <jsp:include page="../layout/sideMenu.jsp" />

    <div class="container">
        <form id="modifyFrm">
            <table id="memTable" class="table">
                <tbody>
                    <tr>
                        <th>회원코드</th>
                        <td><input type="text" class="form-control" name="mem_code" value="${mem.mem_code}" readonly></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>
                            <input type="text" class="form-control join-field" id="joinNm" required pattern="[가-힣]+$" required name="name" value="${mem.name}">
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>
                            <div class="row m-0">
                                <div class="col-xs-4">
                                    <input type="text" class="form-control" id="year" required pattern="[0-9]{4}" placeholder="YYYY" maxlength="4" required name="year" title="년" value="${fn:substring(mem.birthday,0,4)}">
                                </div>

                                <div class="col-xs-4">
                                    <input type="text" class="form-control" id="mon" required pattern="[0-9]{2}" placeholder="MM" maxlength="2" required name="month" title="월"  value="${fn:substring(mem.birthday,5,7)}">
                                </div>

                                <div class="col-xs-4">
                                    <input type="text" class="form-control" id="day" required pattern="[0-9]{2}" placeholder="DD" maxlength="2" required name="day" title="일"  value="${fn:substring(mem.birthday,8,10)}">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>
                            <div class="row m-0">
                                <div class="col-xs-3">
                                    <input class="form-control" type="text" placeholder="010" id="firstPh" required pattern="(010)" maxlength="3" name="firstTel" value="${fn:substring(mem.contact,0,3)}">
                                </div>

                                <span class="ph-span"> - </span>

                                <div class="col-xs-3">
                                    <input class="form-control" type="text" placeholder="0000" id="middlePh" required pattern="[0-9]{4}" maxlength="4" name="middleTel" title="전화번호 두 번째 자리" value="${fn:substring(mem.contact,4,8)}">
                                </div>

                                <span class="ph-span"> - </span>

                                <div class="col-xs-3">
                                    <input class="form-control" type="text" placeholder="0000" id="lastPh" required pattern="[0-9]{4}" maxlength="4" name="lastTel" title="전화번호 마지막 자리" value="${fn:substring(mem.contact,9,13)}">
                                </div>

                                <div class="col-xs-3">
                                    <input type="button" class="btn" id="checkPhoneBtn" value="중복확인"/>
                                </div>
                            </div>
                            <div class="msg" id="checkPhone"></div>

                        </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            <input id="post" type="text" class="form-control" placeholder="우편번호" name="zip" readonly>
                            <input id="addr" type="text" class="form-control" placeholder="도로명주소" title="도로명주소" readonly name="loadAdd">
                            <input type="text" class="form-control" placeholder="상세주소" id="detailAddr" name="detailAdd"/>
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>
                            <div class="row m-0">
                                <div class="col-xs-5">
                                    <input type="text" class="form-control" placeholder="UserID" id="joinEm" required name="userId" value="${fn:substringBefore(mem.email,"@")}">
                                </div>

                                <span class="email-dash">@</span>

                                <div class="col-xs-6">
                                    <input type="text" class="form-control" placeholder="Server" id="server" required name="userServer" title="이메일 뒷자리" value="${fn:substringAfter(mem.email,"@")}">
                                </div>
                                <div class="col-xs-2">
                                    <input type="button" class="btn" id="checkEmailBtn" value="중복확인"/>
                                </div>
                            </div>
                            <div class="msg" id="checkEmail"></div>
                        </td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>
                            <input type="text" class="form-control" id="joinId" name="id" value="${mem.id}">
                            <div class="msg" id="checkId"></div>
                        </td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>
                            <span class="radio">
                              <label for="option1">
                                <input type="radio" class="btn-check" name="gender" id="option1" autocomplete="off" value="M" ${mem.gender eq 'M' ? 'checked' : ''}> 남성
                              </label>
                            </span>

                            <span class="radio">
                              <label for="option2">
                                <input type="radio" class="btn-check" name="gender" id="option2" autocomplete="off" value="F" ${mem.gender eq 'F' ? 'checked' : ''}> 여성
                              </label>
                            </span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <button type="button" id="memModifyBtn" class="btn btn-primary">수정</button>
            <a href="/movie/admin/mem/detail?mem_code=${mem.mem_code}" class="btn btn-light">뒤로가기</a>
        </form>

    </div>
</div>
<!-- //페이지 내용 -->
<script>
    $('#memModifyBtn').on('click', function() {
        $.ajax({
            type : 'post',
            url : "${pageContext.request.contextPath}${UrlPaths.MEM_MODIFY}",
            data : $('#modifyFrm').serialize(),
            success : function(data) {
                if (data.code === 'ok') {
                    alert('회원정보가 수정되었습니다.');
                } else if (data.code === 'no') {
                    alert("회원정보 수정이 실패하였습니다.");
                }
                location.href = "${pageContext.request.contextPath}${UrlPaths.MEM_DETAIL}?mem_code=${mem.mem_code}";
            },
            error : function(xhr) {
                alert(xhr.status);
            },
            dataType : 'json'
        });
    });
</script>

<script type="module" src="${pageContext.request.contextPath}/js/signUp/signUp.js?<%= System.currentTimeMillis()%>"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>