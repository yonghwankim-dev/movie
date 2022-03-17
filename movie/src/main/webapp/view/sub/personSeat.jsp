<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
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
                        <span class="thm">
                            <img src="../images/common/movie02.jpg">
                        </span>
                        <div class="group_infor">
                            <div class="bx_tit">
                                <span class="ic_grade gr_15"></span>
                                <strong>더 배트맨</strong>
                            </div>
                            <dl>
                                <dt>일시</dt>
                                <dd class="sub_info1">
                                    22.03.11<em>(금)</em>
                                    <span class="time">15:10 ~ 18:16</span>
                                </dd>
                                <dt>영화관</dt>
                                <dd class="sub_info1">가산디지털.3관.일반</dd>
                            </dl>
                        </div>
                    </div>
                    <div class="count_people">
                        <ul>
                            <li id="person_10" data-code="10" data-peple="청소년" data-count="0">
                                <strong class="tit">청소년</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus|10">감소</button>
                                     <div class="txt_num">0</div>
                                     <button class="btn_plus" id="Plus|10">증가</button>
                                 </span>
                            </li>
                            <li id="person_20" data-code="20" data-peple="성인" data-count="0">
                                <strong class="tit">성인</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus|20">감소</button>
                                     <div class="txt_num">0</div>
                                     <button class="btn_plus" id="Plus|20">증가</button>
                                 </span>
                            </li>
                            <li id="person_12" data-code="12" data-peple="노약자" data-count="0">
                                <strong class="tit">노약자</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus|12">감소</button>
                                     <div class="txt_num">0</div>
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
                        <a href="<%=request.getContextPath() %>/ticketing.do" class="back">뒤로가기</a>
                        <a href="<%=request.getContextPath() %>/store.do" class="pay">결제하기</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath() %>/js/personSeat.js"></script>
<!-- //여기까지 페이지 내용 -->