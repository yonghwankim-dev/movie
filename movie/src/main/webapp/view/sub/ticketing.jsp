<%@page import="kr.com.yh.lottecgvbox.vo.LocationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                		<!-- 영화 선택시 체크 표시 활성화 -->
                		<c:if test="${movie.movie_title eq movie_title}">
                			<c:set var="isActive" value="active"/>
                		</c:if>
                		<!-- 다른 영화들은 체크 표시 비활성화 -->
                		<c:if test="${movie.movie_title ne movie_title}">
                			<c:set var="isActive" value=""/>
                		</c:if>
                		
                		<li class="movie_item ${isActive}">    
	                        <a class="movie" href="/movie/ticketing.do?cinema_name=${cinema_name}&movie_title=${movie.movie_title}">
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
                	<input class="hidden input_selected_date" name="selected_date" value="${screen_date}"/>
                	<form id="change_screen_date" action="/movie/ticketing.do">
                		<input class="hidden input_cinema_name" name="cinema_name" value="${cinema_name}"/>
                		<input class="hidden input_movie_title" name="movie_title" value="${movie_title}"/>
	
                		<!-- 일자 출력 부분 -->
	                    <div class="owl-stage">
	                    </div>
	                    
                    </form>
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
                	<c:forEach var="movie" items="${movies}" varStatus="status">
                		<li>
                			<div id="${movie.movie_title}" class="tab_con ty5 active">
                				<div class="group_time_select">
                					<div class="time_select_tit">
                						<span class="ic_grade gr_${movie.movie_spectator}"></span>
                						<strong>${movie.movie_title}</strong>
                					</div>
                				</div>
                				<div class="timeSelect">
                					<ul class="list_hall">
                						<li>2D</li>
                					</ul>
                					
                					<ul class="list_time">
                						<c:forEach var="screen" items="${screens}" varStatus="s_status">
                							<c:if test="${screen.movie_title eq movie.movie_title}">
                								<li>
		                                            <a href="./person_seat.html">
		                                                <dl>
		                                                    <dt>상영시간</dt>
		                                                    <dd class="time">
		                                                        <strong>
		                                                        	<fmt:formatDate value="${screen.screen_time}" pattern="HH:mm"/>
		                                                        </strong>
		                                                    </dd>
		                                                    <dt>잔여석</dt>
		                                                    <dd class="seat">
		                                                        <strong>${screen.cur_seat}</strong>
		                                                        <span>/${screen.theater_seat_num}</span>
		                                                        
		                                                    </dd>
		                                                    <dt>상영관</dt>
		                                                    <dd class="hall">${screen.theater_name}</dd>
		                                                </dl>
		                                            </a>
                                        		</li>
                							</c:if>							
                						</c:forEach>
                					</ul>
                				</div>
                			</div>
                		</li>	
                	</c:forEach>	                
                </ul>
            </div>
            
        </div>
    </div>    
    <script type="module" src="<%=request.getContextPath() %>/js/ticketing.js?v=<%=System.currentTimeMillis() %>"></script>
<!-- //여기까지 페이지 내용 -->
