<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <!-- 페이지 타이틀 -->
<h2 class="pageTitle">인원/좌석 선택 </h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
 <div id="reserveStep02" class="section_step_con step02 active">
    <div class="article article_seat">
        <div class="group_top">
            <h4 class="tit">인원/좌석 선택</h4>
        </div>
        <div class="inner">
        	
        	
            <div id="PersonSeatCount">
                <div class="select_num_people_wrap">
                    <div class="movie_infor">
                        <div class="group_infor">
                            <div class="bx_tit">
                                <span class="ic_grade gr_${movieInfo.movie_spectator}"></span>
                                <strong>${movieInfo.movie_title}</strong>
                            </div>
                            <dl>
                                <dt>일시</dt>
                                <dd class="sub_info1">
                                	<span>
                                		<fmt:formatDate value="${movieInfo.screen_date}" pattern="yy.MM.dd(E)"/>
                                	</span>
                                    <span class="time">
	                                    <fmt:formatDate value="${movieInfo.screen_time}" pattern="HH:mm"/>
	                                    ~ 
	                                    <fmt:formatDate value="${movieInfo.end_time}" pattern="HH:mm"/>
                                    </span>
                                </dd>
                                <dt>영화관</dt>
                                <dd class="sub_info1">${movieInfo.cinema_name}.${movieInfo.theater_name}</dd>
                            </dl>
                        </div>
                    </div>
                    <div class="count_people">
                        <ul>
                            <li id="person_10" data-code="10" data-peple="청소년" data-count="0">
                                <strong class="tit">청소년</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus|10">감소</button>
                                     <input type="text" class="txt_num" name="person_10" value="0" readonly/>                                   
                                     <button class="btn_plus" id="Plus|10">증가</button>
                                 </span>
                            </li>
                            <li id="person_20" data-code="20" data-peple="성인" data-count="0">
                                <strong class="tit">성인</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus|20">감소</button>
                                     <input type="text" class="txt_num" name="person_20" value="0" readonly/>
                                     <button class="btn_plus" id="Plus|20">증가</button>
                                 </span>
                            </li>
                            <li id="person_12" data-code="12" data-peple="노약자" data-count="0">
                                <strong class="tit">노약자</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus|12">감소</button>
                                     <input type="text" class="txt_num" name="person_12" value="0" readonly/>
                                     <button class="btn_plus" id="Plus|12">증가</button>
                                 </span>
                            </li>
                        </ul>
                    </div>
                </div>                    
            </div>
            <div class="select_seat_wrap">
                <div id="container" class="seat_wrap">
                    <div class="screen">
                        <span class="title_screen1">
                            SCREEN
                        </span>
                    </div>
                    <div class="showMap">
                        <div class="table_container">
                            <table id="showMapTable">
                                <tbody id="showMapTableBody">
                                </tbody>
                            </table>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="seat_btm_box">
                <div class="seat_type_box">
                    <div class="top_info">
                        <span class="seat_type1">선택 좌석</span>
                        <span class="seat_type2">선택 가능</span>
                        <span class="seat_type3">예매 완료</span>
                        <span class="seat_type4">선택 불가</span>
                    </div>
                </div>
            </div>
            <div id="PersonSeatSummery">
                <div class="select_seat_result">
                    <div class="group_left">
                        <dl class="total_price">
                            <dt>총 합계</dt>
                            <dd>
                                <strong>0</strong> 원
                            </dd>
                        </dl>
                        
                    </div>
                    <div class="group_right">
	                    <form action="/movie/pay.do" method="post">
			        		<!-- 예매일자 -->
			        		<input class="hidden" name="ticketing_date" value="${movieInfo.screen_date}"/>
			        		<!-- 회원코드 -->
			        		<input class="hidden" name="mem_code" value="${memCd}"/>
			        		<!-- 상영코드 -->
			        		<input class="hidden" name="screen_code" value="${screen_code}"/>
			        		<!-- 청년 인원수 -->
			        		<input id="input_person_10" class="hidden" name="person_10" value="0"/>
			        		<!-- 성인 인원수 -->
			        		<input id="input_person_20" class="hidden" name="person_20" value="0"/>
			        		<!-- 노약자 인원수 -->
			        		<input id="input_person_12" class="hidden" name="person_12" value="0"/>
			        		<!-- 총합계 -->
			        		<input id="input_price" class="hidden" name="price" value="0"/>
							<!-- 선택한 좌석 -->
							<input id="input_seat" class="hidden" name="seat" value=""/>
								        		
	                        <a href="/movie/ticketing.do" class="back">뒤로가기</a>
	                        <input type="submit" class="pay" value="결재하기"/>
	                    </form>
                    </div>
                </div>
            </div>
       		
        </div>
    </div>
</div>
<script src="<%=request.getContextPath() %>/js/personSeat.js?v=<%=System.currentTimeMillis() %>"></script>
<!-- //여기까지 페이지 내용 -->