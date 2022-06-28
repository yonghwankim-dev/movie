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
<div class="row bg-white" style="width: 1200px; height : 875px;">
	<div class="book">
		<div class="group_top">
			<span>예매 정보</span>
        </div>
        <div class="book-info right_bar">
        	<div class="movie-info bottom_bar">
        		<span class="movie-info-img">
        			<img src="/movie/images/common/MOVIE1.jpg">
        		</span>
        		<strong class="movie-info-title">
        			<span class="ic_grade gr_12">12</span>
        			탑건: 매버릭(2D)
        		</strong>
        		<dl>
        			<dt>일시</dt>
        			<dd>2022-06-24 (금) 22:35 ~ 24:55</dd>
        			<dt>영화관</dt>
        			<dd>가산디지털 5관 - 2D</dd>
        			<dt>인원</dt>
        			<dd>성인1</dd>
        		</dl>
        		
        	</div>	
        	<div class="seat-info bottom_bar">
        		<dl>
        			<dt>좌석</dt>
        			<dd>A23</dd>
        		</dl>
        	</div>
        	<div class="addProduct-info">
        		<h6>추가상품 구매</h6>
        	</div>
        </div>
	</div>
	<div class="pay_method">
		<div class="group_top">
			<span>결제 수단</span>
        </div>
        <div class="pay_method-info right_bar">
        	<div class="discount-info bottom_bar">
        		<h6>할인/포인트</h6>
        		<div class="discount-row l_point d-flex">
        			<button type="button" class="flex-fill">L.POINT <span style="color:#2aa3fe; font-weight: 700;">조회</span></button>
        			<button type="button" class="flex-fill">L.POINT 카드번호</button>
        		</div>
        		
        		<div class="discount-row other d-flex justify-content-between">
	        		<button type="button" class="discount-btn">VIP/Friends <span class="txt_cnt">0</span></button>
	        		<button type="button" class="discount-btn">관람권 <span class="txt_cnt">0</span></button>
	        		<button type="button" class="discount-btn">할인권 <span class="txt_cnt">0</span></button>
	        		<button type="button" class="discount-btn">제휴포인트/할인</button>
        		</div>
        	</div>
        	<div class="group_payment-info">
        		<h6>최종 결제수단</h6>
        		<div class="group_payment-row pay_methods">
        			<ul class="list_pay_item">
        				<li><button type="button" class="pay-btn cate1">신용카드</button></li>
        				<li><button type="button" class="pay-btn cate2">엘페이</button></li>
        				<li><button type="button" class="pay-btn cate3">간편결제</button></li>
        				<li><button type="button" class="pay-btn cate4">내통장결제</button></li>
        				<li><button type="button" class="pay-btn cate5">휴대폰</button></li>
        			</ul>
        		</div>
        	</div>	
        </div>
        
	</div>
	<div class="payment">
		<div class="group_top">
			<span>결제하기</span>
        </div>
        <div class="save_point-info bottom_bar d-flex align-items-center justify-content-between">
        	<div class="save_point-col save_point-box d-flex align-items-center">
        		<div class="saveing_box">
	        		<input type="checkbox" id="chkSavingPoint" checked/>
	        		<label for="chkSavingPoint" class="ty2">
	        			L.POINT 적립
	        		</label>        		
        		</div>        		
        		<div class="tooltip_box">
        			<button id="ic_question" class="ic_question" type="button"></button>
        			
        			<div id="ic_question_tooltip" class="hidden">
        				<div>
        					<button type="button" class="btn_close"></button>
        				</div>
        				<div>
        					<strong>L.POINT 적립 안내</strong>
	        				<ul>
	        					<li><p>ID적립은 로그인 ID로 자동 적립 됩니다.</p></li>
	        					<li><p>카드번호적립은 결제 후 LPOINT 카드 번호를 직접 입력하여, 적립이 가능합니다.</p></li>
	        					<li><p>L.PAY로 결제하시면, L.PAY 가입 시 인증한 L.POINT ID로 적립됩니다.</p></li>
	        					<li><p>롯데시네마 관람권 구매, 제휴 모바일 쿠폰사용에 대한 건은 포인트가 적립되지 않습니다.</p></li>
	        					<li><p>포인트별 적립내용은 다음과 같습니다.</p></li>
	        					<li><p>L.POINT : L.POINT 카드 또는 롯데 신용카드 번호 입력시 회원등급에 따라 차등 적립 됩니다. 단, 미등록 카드번호 입력시 결제금액의 0.1%가 적립됩니다.</p></li>
	        				</ul>
        				</div>        				
        			</div>
        		</div>
        	</div>
        	<div class="save_point-col radio-box">
        		<span>
        			<input type="radio" id="idRadio" name="savRadio"/>
        			<label for="idRadio">ID적립</label>
        		</span>
        		<span>
        			<input type="radio" id="cardRadio" name="savRadio"/>
        			<label for="cardRadio">카드적립</label>
        		</span>
        		
        	</div>
        </div>
        <div style="width:415px; height:510px;">
        
        </div>
        <div class="price-info bg-secondary">
			<div>
				<span>상품금액</span>
				<span>12,000 원</span>
			</div>
			<div>
				<span>할인금액</span>
				<span>0 원</span>
			</div>
			<div>
				<span>결제금액</span>
				<span>총 12,000 원</span>
			</div>        
			
        </div>
	</div>	
</div>
<!-- //페이지 내용 -->

<script>
$(function(){
	$("#ic_question").on("click", function(){
		$("#ic_question_tooltip").show();
	});	
	$("#ic_question_tooltip .btn_close").on("click", function(){
		$("#ic_question_tooltip").hide();
	})
});

</script>