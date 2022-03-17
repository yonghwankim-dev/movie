<%@page import="kr.com.yh.lottecgvbox.vo.LocationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!-- 페이지 타이틀 -->
<h2 class="pageTitle"> 예매 </h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="wrap_reserve">
        <div class="article article_cinema">
            <div class="group_top">
                <h4 class="tit">영화관</h4>
            </div>
            <div class="cinema_select_wrap">
                <ul class="depth1_list">
                	<c:forEach var="location" items="${locations}" varStatus="status">
                		<li class="depth1 ${status.index eq 0 ? 'active' : ''}">
                        	<a class="location" href="#none">${location.location_name}<span>(${location.cinema_count})</span></a>
                        
	                        <div class="depth2 ${status.index eq 0 ? 'active' : ''}">
	                            <ul class="cinema_list">
		                        	<c:forEach var="cinema" items="${cinemas}" varStatus="status">
			                        	<c:if test="${location.location_name eq cinema.cinema_location}">
			                        		<li class="cinema_item ${cinema.cinema_name eq cinema_name ? 'active' : ''}">
			                                    <a class="cinema" href="/movie/ticketing.do?cinema_name=${cinema.cinema_name}">
			                                    	${cinema.cinema_name}
			                                    </a>
			                                </li>
			                        	</c:if>
			                        </c:forEach>
	                        	</ul>
	                        </div>
						</li>
					</c:forEach>
                </ul>
            </div>
        </div>  

        <div class="article article_movie">
            <div class="group_top">
                <h4 class="tit">영화 선택</h4>
            </div>
            <div class="movie_select_wrap">
                <ul class="movie_list">
                	<c:forEach var="movie" items="${movies}" varStatus="status">
                		<li class="movie_item">    
	                        <a class="movie" href="#none">
								<span class="ic_grade gr_${movie.movie_spectator}"></span>
								<strong class="tit">${movie.movie_title}</strong>
	                        </a>
                    	</li>	
                	</c:forEach>
                </ul>                
            </div>
        </div>

        <div class="article article_time">
            <div class="group_top">
                <h4 class="tit">상영 날짜 선택</h4>
            </div>
            <div class="time_select_wrap">
                <div class="date_select_wrap">
                    <div class="owl-stage">
                    </div>
                    <div class="owl-nav">
                        <button type="button" class="owl-prev disabled" >
                            <span aria-label="Previous"> ‹ </span>
                        </button>
                        <button type="button" class="owl-next">
                            <span aria-label="Next">›</span>
                        </button>
                    </div>
                </div>
                <ul class="tab_wrap outer">
                    <li>
                        <div id="더 배트맨" class="tab_con ty5 active">
                            <div class="group_time_select">
                                <div class="time_select_tit">
                                    <span class="ic_grade gr_15">
                                    </span>
                                    <strong>더 배트맨</strong>
                                </div>
                                <div class="time_select_wrap timeSelect">
                                    <ul class="list_hall">
                                        <li>2D</li>
                                    </ul>
                                    <ul class="list_time">
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>11:50</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>140</strong>
                                                        <span>/180</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">6관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>12:55</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>185</strong>
                                                        <span>/282</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">10관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>14:05</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>138</strong>
                                                        <span>/180</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">3관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div id="이상한 나라의 수학자" class="tab_con ty5 active">
                            <div class="group_time_select">
                                <div class="time_select_tit">
                                    <span class="ic_grade gr_12">
                                    </span>
                                    <strong>이상한 나라의 수학자</strong>
                                </div>
                                <div class="time_select_wrap timeSelect">
                                    <ul class="list_hall">
                                        <li>2D</li>
                                    </ul>
                                    <ul class="list_time">
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>13:30</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>예약마감</strong>
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">2관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>14:50</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>106</strong>
                                                        <span>/164</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">1관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>15:50</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>96</strong>
                                                        <span>/42</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">2관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>17:15</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>109</strong>
                                                        <span>/164</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">1관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>18:10</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>96</strong>
                                                        <span>/142</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">2관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>19:40</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>103</strong>
                                                        <span>/164</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">1관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>20:30</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>94</strong>
                                                        <span>/142</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">2관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div id="메리 미" class="tab_con ty5 active">
                            <div class="group_time_select">
                                <div class="time_select_tit">
                                    <span class="ic_grade gr_15">
                                    </span>
                                    <strong>메리 미</strong>
                                </div>
                                <div class="time_select_wrap timeSelect">
                                    <ul class="list_hall">
                                        <li>2D</li>
                                    </ul>
                                    <ul class="list_time">
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>12:30</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>150</strong>
                                                        <span>/218</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">4관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>17:10</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>150</strong>
                                                        <span>/218</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">4관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div id="블랙 라이트" class="tab_con ty5 active">
                            <div class="group_time_select">
                                <div class="time_select_tit">
                                    <span class="ic_grade gr_15">
                                    </span>
                                    <strong>블랙 라이트</strong>
                                </div>
                                <div class="time_select_wrap timeSelect">
                                    <ul class="list_hall">
                                        <li>2D</li>
                                    </ul>
                                    <ul class="list_time">
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>10:55</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>123</strong>
                                                        <span>/184</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">6관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="./person_seat.html">
                                                <dl>
                                                    <dt>상영시간</dt>
                                                    <dd class="time">
                                                        <strong>17:00</strong>
                                                    </dd>
                                                    <dt>잔여석</dt>
                                                    <dd class="seat">
                                                        <strong>96</strong>
                                                        <span>/142</span>
                                                        
                                                    </dd>
                                                    <dt>상영관</dt>
                                                    <dd class="hall">2관</dd>
                                                </dl>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            
        </div>
    </div>
    
        

    
    <script type="module" src="<%=request.getContextPath() %>/js/ticketing.js"></script>
<!-- //여기까지 페이지 내용 -->
