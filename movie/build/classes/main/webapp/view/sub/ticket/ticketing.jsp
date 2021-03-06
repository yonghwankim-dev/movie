<%@page import="kr.com.yh.lotte.UrlPaths"%>
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
<div class="row bg-white" style="height : 900px;">
        <div class="col-4 p-0">
            <div class="group_top">
                <span>영화관</span>
            </div>
            <div class="row m-0" style="height: 840px;">
            	<div class="col-6 p-0">
            		<div class="locations h-100 bg-light">
            			<ul class="list-group">
		                	<c:forEach var="location" items="${locations}" varStatus="status">
		                		<li class="list-group-item border-0 rounded-0 small text-dark bg-light ${location.cinemaVO.loc eq loc ? 'active' : ''}">
		                        	<a class="text-dark text-decoration-none" href="${pageContext.request.contextPath}${UrlPaths.TICKET}?loc=${location.cinemaVO.loc}">${location.cinemaVO.loc}<span>(${location.cinema_cnt})</span><img src="/movie/images/sub/check.png" class="float-right invisible"></a>
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
									<a class="text-dark text-decoration-none" href="${pageContext.request.contextPath}${UrlPaths.TICKET}?loc=${loc}&cinema_name=${cinema.name}">
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
            <div id="movies" class="bg-light" style="height : 840px">
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
                		
                		<li class="list-group-item d-flex align-items-center justify-content-between border-0 bg-transparent ${movie.name eq movie_name ? 'active' : ''}">    
	                        <a class="movie d-flex align-items-center text-decoration-none text-dark" href="${pageContext.request.contextPath}${UrlPaths.TICKET}?loc=${loc}&cinema_name=${cinema_name}&movie_name=${movie.name}">
								<span class="badge badge-pill rounded-circle text-white gr_${movie.audi_rating}">${movie.audi_rating}</span>
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
            	<!-- 영화 상영 달력 -->
                <div class="container">
                	<input class="hidden input_selected_date" name="selected_date" value="${screen_date}"/>
                	<form id="screenDateFrm" method="get" action="${pageContext.request.contextPath}${UrlPaths.TICKET}">
                		<input class="hidden input_cinema_name" name="cinema_name" value="${cinema_name}"/>
                		<input class="hidden input_movie_name" name="movie_name" value="${movie_name}"/>
	
						<div id="dates">
							<div class="date_select_wrap">
								<div class="slide_wrap slide_reserve_date">
								    <ul class="owl-carousel owl-loaded">
								    	<div class="owl-stage-outer">
										    <div class="owl-stage"> 
										    	<c:forEach begin="1" end="27">
											    	<div class="owl-item mySlides">
											    		<c:set var="day"><ldt:getDayOfMonth value="${date}"/></c:set>
											    		<c:set var="month"><ldt:getMonthValue value="${date}"/></c:set>
											    		<c:set var="dayOfWeek"><ldt:getDayOfWeek value="${date}"/></c:set>
											    		<c:set var="screenDate"><ldt:formatDateTime value="${date}"/></c:set>
												    	<li>  
												    		<c:if test="${(day == today) || (day == 1)}">
												    			<strong class="month">${month}월</strong>
												    		</c:if>
									                    	<span class="date">
									                    		<label>
									                    			<input type="radio" name="screenDate" data-playdate="${screenDate}" value="${screenDate}" onchange="this.form.submit()"
									                    					${screen_date eq screenDate ? 'checked' : ''}>
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
									<div class="owl-nav">
								    	<button type="button" class="owl-prev bg-transparent border-0" onclick="plusSlides(-5)"><span aria-label="Previous">&lt;</span></button>
								    	<button type="button" class="owl-next bg-transparent border-0" onclick="plusSlides(5)"><span aria-label="Next">&gt;</span></button>
								    </div>
								</div>							
							</div>
						</div>
                    </form>
                </div>

				<!-- 영화 상영시간 리스트 -->
				<div id="movieScreenSchTime">
	                <ul class="list-group">
	                	<c:forEach var="movie" items="${movies}" varStatus="status">
	                		<!-- 선택한 영화만 상영일정을 출력 -->
	                		<c:if test="${(movie_name eq movie.name) or (empty movie_name)}">
		                		<li class="list-group-item border-0">
		                			<div id="${movie.name}" class="tab_con ty5 active">
		                				<div class="group_time_select">
		                					<div class="time_select_tit">
		                						<span class="ic_grade gr_${movie.audi_rating}"></span>
		                						<strong>${movie.name}</strong>
		                					</div>
		                				</div>
		                				<div class="timeSelect">
		                					<h6>2D</h6>
		                					<ul class="list_time">
		                						<c:forEach var="s" items="${screenSchs}" varStatus="s_status">
		                							
		                							<c:if test="${s.movie.name eq movie.name}">
		                								<li>
				                                            <a class="screenSchBtn text-decoration-none text-dark" href="javascript:void(0)" data-screen_sch_code="${s.screenSch.screen_sch_code}">
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
	                		</c:if>
	
	                	</c:forEach>	                
	                </ul>				
				</div>                

            </div>
           
        </div>
</div>
    
<script>
	$('.locations .active img').toggleClass("invisible");
	$('.cinemas .active img').toggleClass("invisible");
	$('#movies .active img').toggleClass("invisible");
	$(".date em[data-dayOfWeek='토']").parents(".date").css("color", "blue");
	$(".date em[data-dayOfWeek='일']").parents(".date").css("color", "red");
	
	$(".screenSchBtn").on("click", function(){
		const memCd = "<%=session.getAttribute("memCd")%>"; 
		if(memCd === null){
			alert("로그인 후 시도해주세요");
			return;
		}	
		
		location.href = "${pageContext.request.contextPath}${UrlPaths.PERSON_SEAT}?screen_sch_code=" + $(this).data('screen_sch_code');
	});
</script>
<script>
let start = 1;
let end   = 5;
showSlides(start, end);

// Next/previous controls
function plusSlides(n) {
  showSlides(start+=n, end +=n);
}

function showSlides(start, end) {
  let i;
  let slides = document.querySelectorAll(".mySlides");
  
  if(start > slides.length || end < 1){
    return;
  }

  if (end > slides.length) {end = slides.length}

  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for(i = start; i <= end; i++){
    slides[i-1].style.display = "inline-block";
  }
}
</script>
<script type="module" src="${pageContext.request.contextPath}/js/ticketing.js?v=<%=System.currentTimeMillis() %>"></script>
<!-- //여기까지 페이지 내용 -->
