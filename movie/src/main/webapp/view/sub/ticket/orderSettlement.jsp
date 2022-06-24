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
	<div class="p-0">
		<div class="group_top">
			<span>결제하기</span>
        </div>
        <div class="save_point-info">
        	<span>적립</span>
        </div>
	</div>	
</div>
<!-- //페이지 내용 -->