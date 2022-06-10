<%@page import="java.time.temporal.TemporalUnit"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.LocalDateTime"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ldt" tagdir="/WEB-INF/tags/localDateTime" %>

<c:set var="now" value="<%=LocalDateTime.now() %>"/>
<c:set var="date" value="${now}"/>
<c:set var="today"><ldt:getDayOfMonth value="${now}"/></c:set>

<style>
#container{
	height : 1400px;
	background-color : #444444;
}
</style>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle"> 예매 </h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="row bg-white">
        <div class="col-4 p-0">
            <div class="group_top">
                <span>영화관</span>
            </div>
            <div class="d-flex h-100">
            	<div class="col-6 p-0">
            		<div class="locations h-100 bg-light">
            			<ul class="list-group">
		                	<c:forEach var="location" items="${locations}" varStatus="status">
		                		<li class="list-group-item border-0 rounded-0 small text-dark bg-light ${location.cinemaVO.loc eq loc ? 'active' : ''}">
		                        	<a class="text-dark text-decoration-none" href="/movie/ticketing/ticketing.do?loc=${location.cinemaVO.loc}">${location.cinemaVO.loc}<span>(${location.cinema_cnt})</span><img src="/movie/images/sub/check.png" class="float-right invisible"></a>
								</li>
							</c:forEach>
	                	</ul>
            		</div>
            	</div>   
            	<div class="col-6 p-0">
            		<div class="cinemas">
						<ul class="list-group" style="max-height:950px; overflow-y:auto;">
							<c:forEach var="cinema" items="${cinemas}">
								<li class="list-group-item border-0 rounded-0 small ${cinema.name eq cinema_name ? 'active' : ''}">
									<a class="text-dark text-decoration-none" href="/movie/ticketing/ticketing.do?loc=${loc}&cinema_name=${cinema.name}">
										${cinema.name}
										<img src="/movie/images/sub/check.png" class="float-right invisible">
									</a>
								</li>
							</c:forEach>
						</ul>            		
            		</div>
            	</div>             
            </div>
        </div>  

        <div class="col-4 p-0">
            <div class="group_top">
                	<c:if test="${not empty movie_name}">
                		<span>${movie_name}</span>
                	</c:if>
                	<c:if test="${empty movie_name}">
                		<span>영화선택</span>
                	</c:if>
            </div>
            <div id="movies">
                <ul class="list-group">
                	<c:forEach var="movie" items="${movies}" varStatus="status">
                		<!-- 영화 선택시 체크 표시 활성화 -->
                		<c:if test="${movie.name eq movie_name}">
                			<c:set var="isActive" value="active"/>
                		</c:if>
                		<!-- 다른 영화들은 체크 표시 비활성화 -->
                		<c:if test="${movie.name ne movie_name}">
                			<c:set var="isActive" value=""/>
                		</c:if>
                		
                		<li class="list-group-item d-flex align-items-center justify-content-between ${movie.name eq movie_name ? 'active' : ''}">    
	                        <a class="movie d-flex align-items-center text-decoration-none text-dark" href="/movie/ticketing/ticketing.do?loc=${loc}&cinema_name=${cinema_name}&movie_name=${movie.name}">
								<!-- <span class="ic_grade gr_${movie.audi_rating}"></span> -->
								<span class="badge badge-pill rounded-circle text-white gr_${movie.audi_rating}">15</span>
								<span class="ml-1">${movie.name}</span>
	                        </a>
	                       	<img src="/movie/images/sub/check.png" class="float-right invisible">
                    	</li>	
                	</c:forEach>
                </ul>                
            </div>
        </div>

        <div class="col-4 p-0">
            <div class="group_top">
                <span>상영 날짜 선택</span>
            </div>
            <div id="times">
                <div class="container">
                	<input class="hidden input_selected_date" name="selected_date" value="${screen_date}"/>
                	<form id="change_screen_date" action="/movie/ticketing/ticketing.do">
                		<input class="hidden input_cinema_name" name="cinema_name" value="${cinema_name}"/>
                		<input class="hidden input_movie_name" name="movie_name" value="${movie_name}"/>
	
                		<!-- 일자 출력 부분
	                    <div class="owl-stage">
	                    </div>
	                    -->
						<div id="dates">
							<div class="date_select_wrap">
								<div class="slide_wrap slide_reserve_date">
								    <ul class="owl-carousel owl-loaded">
								    	<div class="owl-stage-outer">
										    <div class="owl-stage"> 
										    	<c:forEach begin="1" end="27">
											    	<div class="owl-item">
											    		<c:set var="day"><ldt:getDayOfMonth value="${date}"/></c:set>
											    		<c:set var="month"><ldt:getMonthValue value="${date}"/></c:set>
											    		<c:set var="dayOfWeek"><ldt:getDayOfWeek value="${date}"/></c:set>
												    	<li>  
												    		<c:if test="${(day == today) || (day == 1)}">
												    			<strong class="month">${month}월</strong>
												    		</c:if>
									                    	<span class="date">
									                    		<label>
									                    			<input type="radio" name="radioDate" data-displayyn="Y" data-playdate="2022-06-08" data-isplaydate="Y" data-playweek="오늘">
									                    			<strong>${day}</strong>
									                    			<c:choose>
									                    				<c:when test="${day == today}">
									                    					<em data-dayOfWeek="${dayOfWeek}">오늘</em>
									                    				</c:when>
									                    				<c:otherwise>
									                    					<em data-dayOfWeek="${dayOfWeek}">${dayOfWeek}</em>
									                    				</c:otherwise>
									                    			</c:choose>
									                    		</label>
									                    	</span>
												    	</li>						    	
											    	</div>
											    	<c:set var="date"><ldt:plusDays value="${date}" days="1"/></c:set>											    										    	
										    	</c:forEach>					    
										    </div>						    	
								    	</div>
								    </ul>							
								</div>							
							</div>


						</div>
                    </form>
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
    
<script>
	$('.locations .active img').toggleClass("invisible");
	$('.cinemas .active img').toggleClass("invisible");
	$('#movies .active img').toggleClass("invisible");
	
</script>
<script type="module" src="<%=request.getContextPath() %>/js/ticketing.js?v=<%=System.currentTimeMillis() %>"></script>
<!-- //여기까지 페이지 내용 -->
