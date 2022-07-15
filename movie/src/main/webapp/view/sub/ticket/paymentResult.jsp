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

<!-- 페이지 내용 -->
<div id="paymentResult">
<div class="row bg-white" style="width: 1200px; height : 875px;">
	<!-- 결제 완료 -->
	<div id="payment">
		<div class="group_top">
			<span>결제 완료</span>
    	</div>
    	
    	<!-- 결제 완료 내용 -->
    	<div id="payment-info">
    		<!-- 결제 성공 안내문 -->
    		<div class="payment-notice">
    			<img alt="카드결제 완료" src="/movie/images/sub/credit-card-regular.svg"/>
    			<h6>${sessionScope.mem.name} 회원님, 결제가 성공적으로 완료되었습니다.</h6>
    		</div>
    		
    		<!-- 티켓 정보 내용 -->
    		<div class="payment-ticket">
    			<div class="d-flex bottom_bar">
    				<div class="col-4 ticket-img">
    					<img alt="영화 포스터" src="/movie/images/common/MOVIE1.jpg">
    				</div>
    				<div class="col-8 ticket-info">
    					<div class="row">
	    					<ul>
	    						<li>
	    							<label>예매번호</label>
	    							<strong>${paymentResult.book.book_code}</strong>
	    						</li>
	    						<li>
	    							<label>상영일시</label>
	    							<span>
										<fmt:formatDate value="${paymentResult.screenSch.screen_date}" pattern="yyyy-MM-dd (E)"/>
										${paymentResult.screenSch.start_time}
										  ~
										${paymentResult.screenSch.end_time}
									</span>
	    						</li>
	    						<li>
	    							<label>상영관</label>
	    							<span>${paymentResult.cinema.loc} ${paymentResult.cinema.name} ${paymentResult.theater.name}</span>
	    						</li>
	    						<li>
	    							<label>관람인원</label>
	    							<span>
										<c:if test="${paymentResult.book.teenager > 0}">
											청소년${paymentResult.book.teenager} &nbsp;
										</c:if>

										<c:if test="${paymentResult.book.adult > 0}">
											성인${paymentResult.book.adult} &nbsp;
										</c:if>

										<c:if test="${paymentResult.book.senior > 0}">
											노약자${paymentResult.book.senior} &nbsp;
										</c:if>
									</span>
	    						</li>
	    						<li>
	   								<label>좌석</label>
	   								<span>
										<c:forEach var="seat" items="${paymentResult.seats}">
											${seat.seat_row}${seat.seat_col} &nbsp;
										</c:forEach>
									</span>
	    						</li>
	    					</ul>    					
    					</div>
    					<div class="row d-flex justify-content-center">
    						<button id="receiveTicketToPhoneBtn" type="button">휴대폰으로 바로티켓 받기</button>
    					</div>    					
    				</div>
    			</div>

    			<div class="flex-column ticket-price">
    				<div class="row ticket-price-info">
    					<label class="d-flex justify-content-between" style="width: 180px;">
							주문금액
							<span>
								<fmt:formatNumber value="${paymentResult.book.total_price}" pattern="#,###"/>원
							</span>
						</label>

						<img class="ic_minus" src="/movie/images/sub/iconmonstr-minus-6-240.png"/>
    					
    					<label class="d-flex justify-content-between" style="width: 180px;">
							할인금액
							<span>0원</span>
						</label>

    					<img class="ic_equal" src="/movie/images/sub/iconmonstr-equal.png"/>
    					
    					<label class="d-flex justify-content-between" style="width: 220px;">
							총 결제 금액
							<span>
								<fmt:formatNumber value="${paymentResult.book.total_price}" pattern="#,###"/>원
							</span>
						</label>
    				</div>
    				<div class="row ticket-price-method d-flex justify-content-end">
						<div class="d-flex justify-content-between align-items-center" style="width: 220px;">
							<label class="pay_method_badge">
								신용카드
							</label>
							<span style="font-size: 12px;">토스</span>
						</div>
    				</div>
    			</div>
    		</div>	
    		
    		<!-- 주의사항 안내문 -->
    		<div class="payment-warning">
    			<ul>
    				<li>온라인 예매 및 추가상품 구매 취소는 상영 시작 20분 전까지 온라인에서 가능합니다.</li>
    				<li>상영시작 20분전 이후 부터는 영화관 현장에서만 취소 가능합니다.</li>
    				<li>반드시 전체 취소만 가능하며, 예매나 추가상품중 부분 취소는 불가능합니다.</li>
    				<li>추가상품 수령 완료 시 예매 및 상품 취소 모두 불가능합니다.</li>
    				<li>포토티켓 발권 완료 시 환불은 발권된 포토티켓 모두 지참 후 해당 영화관에서만 가능합니다.</li>
    				<li>무대인사,스폐셜상영회,GV,라이브뷰잉 등 특별 상영 회차의 예매 취소는 상영전일 23시 59분 59초까지만 취소 가능합니다.</li>
    				<li>적립 에정 L.POINT는 영화 관람 다음 날 적립됩니다.</li>
    				<li>예고편 상영 등 사정에 의해 본 영화 시작이 10여분 정도 차이날 수 있습니다.</li>
    				<li>개인정보 보호 정책에 따라 주민번호로 예매 티켓을 찾을 수 없습니다. 꼭 예매번호를 확인해 주세요.</li>
    				<li>스토어에서 구매한 상품은 마이페이지 > 예매/구매 내역에서 확인 및 사용할 수 있습니다.</li>
    			</ul>
    		</div>
    		<!-- 페이지 이동 -->
    		<div class="payment-pageMoveBtn">
    			<button id="payHistoryBtn" type="button">결재내역</button>
    			<button id="storeBtn" type="button">스토어 바로가기</button>
    			<button id="homeBtn" type="button">홈으로 바로가기</button>
    			
    		</div>
    	</div>
	</div>
	
</div>
</div>
<!-- //페이지 내용 -->

<script>
	$(function(){
		$("#homeBtn").on("click", function(){
			location.href = "/movie/main.do";
		});
	});

</script>