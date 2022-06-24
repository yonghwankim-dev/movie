<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
#container{
	height : 1400px;
	background-color : #444444;
}
</style>
 
 
 <!-- 페이지 타이틀 -->
<h2 class="pageTitle">인원/좌석 선택 </h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
 <div id="reserveStep02" class="section_step_con step02 active">
    <div class="article article_seat">
        <div class="group_top d-flex justify-content-center align-items-center">
            <h4 style="font-size: 18px; color: white;">인원/좌석 선택</h4>
            <p class="position-absolute" style="font-size: 13px; top:5px; right:30px; color:white;">인원은 최대 8명까지 선택 가능합니다.</p>
        </div>
        <div class="inner">
        	
        	
            <div id="PersonSeatCount">
                <div class="select_num_people_wrap">
                    <div class="movie_infor">
                        <div class="group_infor">
                            <div class="bx_tit" style="font-size: 17px;">
                            	<!-- 영화관람가 -->
                                <span class="badge badge-pill rounded-circle text-white gr_${screenSch.movie.audi_rating}">${screenSch.movie.audi_rating}</span>
                                <!-- 영화제목 -->
                                <strong>${screenSch.movie.name} (2D)</strong>
                            </div>
                            <dl>
                                <dt>일시</dt>
                                <dd class="sub_info1">
                                	<!-- 상영일자 -->
                                	<span>
                                		<fmt:formatDate value="${screenSch.screenSch.screen_date}" pattern="yy.MM.dd(E)"/>
                                	</span>
                                	<!-- 상영 시작/종료 시간 -->
                                    <span class="time">
                                    	${screenSch.screenSch.start_time}
	                                    ~ 
                                    	${screenSch.screenSch.end_time}
                                    </span>
                                </dd>
                                <dt>영화관</dt>
                                <!-- 영화관이름/상영관이름 -->
                                <dd class="sub_info1">${screenSch.cinema.name}.${screenSch.theater.name}</dd>
                            </dl>
                        </div>
                    </div>
                    <div class="count_people">
                    	<!-- 현재 선택 인원수 -->
                    	<input id="curSelectedPerson" class="hidden" name="curSelectedPerson" value="0"/>
                        <ul>
                            <li>
                                <strong class="tit">청소년</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus_10">감소</button>
                                     <input id="person_10" type="text" class="txt_num" name="person_10" value="0" readonly/>                                   
                                     <button class="btn_plus" id="Plus_10">증가</button>
                                 </span>
                            </li>
                            <li>
                                <strong class="tit">성인</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus_20">감소</button>
                                     <input id="person_20" type="text" class="txt_num" name="person_20" value="0" readonly/>
                                     <button class="btn_plus" id="Plus_20">증가</button>
                                 </span>
                            </li>
                            <li>
                                <strong class="tit">노약자</strong>
                                 <span class="bx_num">
                                     <button class="btn_mins" id="Minus_12">감소</button>
                                     <input id="person_12" type="text" class="txt_num" name="person_12" value="0" readonly/>
                                     <button class="btn_plus" id="Plus_12">증가</button>
                                 </span>
                            </li>
                        </ul>
                    </div>
                </div>                    
            </div>
            <div class="select_seat_wrap">
            	<div class="d-flex justify-content-center align-items-center" style="margin: 15px 0 25px;">
            		<p id="ticketMessageInfo" class="position-relative inline-block pl-9 text-white m-0" style="font-size: 11px;">- 인원을 선택하세요.</p>
            	</div>
                <div class="seat_wrap">
                    <div class="screen">
                        <span class="title_screen1">
                            SCREEN
                        </span>
                    </div>
                    <div class="showMap">
                    	 <div class="floor_bx">
	                    	 	<div class="seat_area" style="margin-top: 30px; width: 525px; height:275px;">
	                    	 		<c:set var="top_interval" value="25.4615"/>
	                    	 		<c:set var="seat_position" value="25.1875"/>
	                    	 		<c:set var="seat_interval" value="15.75"/>
	                    	 		<c:set var="seatNumStart" value="1"/>
	                    	 		<c:set var="seatNumEnd" value="17"/>
	                    	 		<c:set var="seatIndex" value="0"/>
	                    	 		
	                    	 		<c:forTokens var="row" items="A,B,C,D,E,F,G,H,I" delims="," varStatus="status">
			                    		<span class="seat_tit" style="left: -30px; top:${status.index * top_interval}px;">${row}</span>
			                    		<c:set var="left_val" value="0"/>
			                    			                    			
			                    		<c:forEach var="i" begin="${seatNumStart}" end="${seatNumEnd}">
			                    			<c:set var="s" value="${seats[seatIndex]}"/>
			                    			<c:choose>
			                    				<c:when test="${i==5 or i==11 or i==15}">
			                    					<c:set var="left_val" value="${left_val + seat_position + seat_interval}"/>
			                    				</c:when>
			                    				<c:otherwise>
			                    					<c:set var="left_val" value="${left_val + seat_position}"/>	
			                    				</c:otherwise>
			                    			</c:choose>
				                    		
					                    	<a href="javascript:void(0)" class="sel ${s.screenSchSeat.seat_status == 'R' ? 'reserved' : ''}" data-seat="${s.seat.seat_row}${s.seat.seat_col}" style="left:${21 + left_val}px; top:${status.index * top_interval}px;">
					                    		<span class="seat" style="top:0px;">${s.seat.seat_col}</span>
					                    	</a>
					                    	
					                    	<c:set var="seatIndex" value="${seatIndex+1}"/>
			                    		</c:forEach>	
	                    			</c:forTokens>
	                    		</div>
								<span class="w_bottom" style="top: 265px; left: 382px;">상영관 출입문입니다.</span>
                    	</div>
                    </div>
                </div>
            </div>
            <div class="seat_btm_box d-flex align-items-center">
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
                    <div class="group_left col-10">
                        <dl class="total_price">
                            <dt>총 합계</dt>
                            <dd>
                                <strong id="totalPrice">0</strong> 원
                            </dd>
                        </dl>
                        
                    </div>
                    <div class="group_right col-2">
	                    <form id="payFrm">
			        		<!-- 예매일자 -->
			        		<input id="book_date" class="hidden" name="book_date" value="${screenSch.screenSch.screen_date}"/>
			        		<!-- 상영관코드 -->
			        		<input id="theater_code" class="hidden" name="theater_code" value="${screenSch.screenSch.theater_code}"/>
			        		<!-- 회원코드 -->
			        		<input id="mem_code" class="hidden" name="mem_code" value="${memCd}"/>
			        		<!-- 상영코드 -->
			        		<input id="screen_sch_code" class="hidden" name="screen_sch_code" value="${screenSch.screenSch.screen_sch_code}"/>
			        		
							<!-- 선택한 좌석 -->
							<input id="selectedSeatNames" class="hidden" name="seat" value=""/>
								        		
	                        <button type="button" id="bookSeatBtn" class="bookSeat">결재하기</button>
	                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
// 10(청소년):10000원, 20(성인):14000원, 12(노약자):7000
const age = {
		10 : 10000,
		20 : 14000,
		12 : 7000
};

// 좌석 선택 완료 여부
let isCompletedSeatSelected = false;

// target input 태그의 값을 1 증가
function incrementPerson(target){
	const cnt = Number(target.val()) + 1;
	if(cnt <= 8){
		target.val(cnt);
	}	
}

// target input 태그의 값을 1 감소
function decrementPerson(target){
	const cnt = Number(target.val()) - 1;
	if(cnt >= 0){
		target.val(cnt);
	}	
}

// 청소년-성인-노약자의 총 인원수 참조
function getTotalPerson(){
	let cnt = 0;
	
	Object.keys(age).forEach(function(key){
		cnt += Number($("input[name='person_"+key+"']").val());
	});
	
	return cnt;
}

// 현재 선택한 인원수 값을 1 감소
function decrementCurSelectedPerson(){
	const target = $("#curSelectedPerson");
	const cnt = Number(target.val()) - 1;
	if(cnt >= 0){
		target.val(cnt);		
	}
}

// 현재 선택한 인원수 값을 1 증가
function incrementCurSelectedPerson(){
	const target = $("#curSelectedPerson");
	const cnt = Number(target.val()) + 1;
	
	target.val(cnt);
}

// 현재 선택한 인원수 참조
function getCurSelectedPerson(){
	return Number($("#curSelectedPerson").val());
}

// 현재 선택한 인원수 설정
function changeCurSelectedPerson(){
	$("#curSelectedPerson").val($(".sel.on").length);			
}

// 계산된 영화표 값 게산
function getTotalPrice(){	
	let sum = 0;
	Object.keys(age).forEach(function(key){
		sum += Number($("input[name='person_"+key+"']").val()) * age[key];
	});
	
	return sum;
}

// 현재 선택된 좌석 초기화
function resetCurSelectedSeat(){
	$(".sel.on").removeClass("on");
	$(".sel.no_select").removeClass("no_select");
}

// 좌석 금액 초기화
function resetTotalPriceSeat(){
	$("#totalPrice").text(0);
}

// 좌석 선택 완료
function completeSeatSelected(){
	$(".sel").addClass("no_select"); // 선택한 좌석을 제외한 나머지 좌석을 비활성화
	let selectedSeatNames = "";	
	$.each($(".sel.on"), function(index, value){
		selectedSeatNames += ($(value).data("seat") + " ");
	});
	$("#selectedSeatNames").val(selectedSeatNames.trim());
	
	isCompletedSeatSelected = true;	
}

// 좌석 선택 완료 리셋
function resetCompleteSeatSelected(){
	$(".sel.no_select").removeClass("no_select");
	isCompletedSeatSelected = false;	
}

$(function(){	
	// 청소년/성인/노약자 감소-증가 버튼 이벤트 설정
	Object.keys(age).forEach(function(key){
		$("#Minus_"+key).on("click", function(){
			decrementPerson($("input[name='person_"+key+"']"));
			resetCurSelectedSeat();
			resetTotalPriceSeat();
		});
		$("#Plus_"+key).on("click", function(){
			incrementPerson($("input[name='person_"+key+"']"));
			resetCurSelectedSeat();
			resetTotalPriceSeat();
		});
	});
	
	// 좌석 버튼 클릭 이벤트
	$(".sel:not(.reserved)").on("click", function(){
		// 인원수가 0명이면 선택되지 않게 함
		if(getTotalPerson() === 0){
			return;
		}else{
			$(this).toggleClass("on");
			
			// 현재 선택한 인원수 변경
			changeCurSelectedPerson();	
		}
		
		
		
		// 좌석 선택 완료 검사
		if(getCurSelectedPerson() === getTotalPerson()){
			$("#totalPrice").text(getTotalPrice());
			completeSeatSelected();	
		}else if(isCompletedSeatSelected === true){
			resetTotalPriceSeat();
			resetCompleteSeatSelected();
		}else{
			resetCompleteSeatSelected();
		}
		
	});
	
	// 결제하기 버튼 클릭 이벤트
	$('#bookSeatBtn').on('click', function() {
		const data = {
			"book_date"         : $("#payFrm #book_date").val(),
			"theater_code"      : $("#payFrm #theater_code").val(),
			"mem_code"          : $("#payFrm #mem_code").val(),
			"screen_sch_code"   : $("#payFrm #screen_sch_code").val(),
			"person_10"         : $("#person_10").val(),
			"person_20"         : $("#person_20").val(),
			"person_12"         : $("#person_12").val(),
			"totalPrice"        : $("#totalPrice").text(),
			"selectedSeatNames" : $("#selectedSeatNames").val()
		};
		
		$.ajax({
				url : "<%=request.getContextPath() %>/bookSeat.do",
				type : 'post',
				data : data,
				success : function(data){
					if (data.code === 'ok') {
						alert('예매가 성공했습니다.');	
					}else if(data.code === 'no'){
						alert("예매에 실패했습니다.");
					}
					location.href = '<%=request.getContextPath() %>/main.do';
				}
				,
				error : function(xhr) {
					alert(xhr.status);
				},
				dataType : 'json'
		});
	});
});


</script>
<!-- <script src="<%=request.getContextPath() %>/js/personSeat.js?v=<%=System.currentTimeMillis() %>"></script> -->
<!-- //여기까지 페이지 내용 -->