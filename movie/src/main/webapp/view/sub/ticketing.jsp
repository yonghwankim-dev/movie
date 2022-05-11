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
                        	<a class="location" href="#none">${location.cinemaVO.loc}<span>(${location.cinema_cnt})</span></a>
                        
	                        <div class="depth2 ${status.index eq 0 ? 'active' : ''}">
	                            <ul class="cinema_list">
		                        	<c:forEach var="cinema" items="${cinemas}" varStatus="status">
			                        	<c:if test="${location.cinemaVO.loc eq cinema.loc}">
			                        		<li class="cinema_item ${cinema.name eq cinema_name ? 'active' : ''}">
			                                    <a class="cinema" href="/movie/ticketing/ticketing.do?cinema_name=${cinema.name}">
			                                    	${cinema.name}
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
                <h4 class="tit">
                	<c:if test="${not empty movie_name}">
                		${movie_name}
                	</c:if>
                	<c:if test="${empty movie_name}">
                		영화선택
                	</c:if>
                </h4>
            </div>
            <div class="movie_select_wrap">
                <ul class="movie_list">
                	<c:forEach var="movie" items="${movies}" varStatus="status">
                		<!-- 영화 선택시 체크 표시 활성화 -->
                		<c:if test="${movie.name eq movie_name}">
                			<c:set var="isActive" value="active"/>
                		</c:if>
                		<!-- 다른 영화들은 체크 표시 비활성화 -->
                		<c:if test="${movie.name ne movie_name}">
                			<c:set var="isActive" value=""/>
                		</c:if>
                		
                		<li class="movie_item ${isActive}">    
	                        <a class="movie" href="/movie/ticketing/ticketing.do?cinema_name=${cinema_name}&movie_name=${movie.name}">
								<span class="ic_grade gr_${movie.audi_rating}"></span>
								<strong class="tit">${movie.name}</strong>
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
                	<form id="change_screen_date" action="/movie/ticketing/ticketing.do">
                		<input class="hidden input_cinema_name" name="cinema_name" value="${cinema_name}"/>
                		<input class="hidden input_movie_name" name="movie_name" value="${movie_name}"/>
	
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
                			<div id="${movie.name}" class="tab_con ty5 active">
                				<div class="group_time_select">
                					<div class="time_select_tit">
                						<span class="ic_grade gr_${movie.audi_rating}"></span>
                						<strong>${movie.name}</strong>
                					</div>
                				</div>
                				<div class="timeSelect">
                					<ul class="list_hall">
                						<li>2D</li>
                					</ul>
                					
                					<ul class="list_time">
                						<c:forEach var="s" items="${screenSchs}" varStatus="s_status">
                							<c:if test="${s.movie.name eq movie.name}">
                								<li>
		                                            <a href="/movie/personSeat.do?screen_sch_code=${s.screenSch.screen_sch_code}">
		                                                <dl>
		                                                    <dt>상영시간</dt>
		                                                    <dd class="time">
		                                                        <strong>
		                                                        	${s.screenSch.start_time}
		                                                        </strong>
		                                                    </dd>
		                                                    <dt>잔여석</dt>
		                                                    <dd class="seat">
		                                                        <strong>${s.theater_seat_cnt - s.book_seat_cnt}</strong>
		                                                        <span>/${s.theater_seat_cnt}</span>
		                                                        
		                                                    </dd>
		                                                    <dt>상영관</dt>
		                                                    <dd class="hall">${s.theater.name}</dd>
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
