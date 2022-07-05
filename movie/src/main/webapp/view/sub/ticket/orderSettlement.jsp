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

<!-- 이용약관 모달 -->
<c:import url="/view/sub/ticket/terms/terms.jsp"/>

<!-- 페이지 내용 -->
<div id="orderSettlement">
<div class="row bg-white" style="width: 1200px; height : 875px;">

	<!-- 예매 정보 -->
	<div class="book">
		<div class="group_top">
			<span>예매 정보</span>
        </div>
        <!-- 예매 정보 내용 -->
        <div class="book-info right_bar">
        	<!-- 영화 예매 정보 -->
        	<div class="movie-info bottom_bar">
        		<span class="movie-info-img">
        			<img src="/movie/images/common/MOVIE1.jpg">
        		</span>
        		<strong class="movie-info-title">
        			<span class="ic_grade gr_12">12</span>
        			${movie.name}(2D)
        		</strong>
        		<dl>
        			<dt>일시</dt>
        			<dd><fmt:formatDate value="${screenSch.screen_date}" pattern="yyyy-MM-dd (E)"/> ${screenSch.start_time} ~ ${screenSch.end_time}</dd>
        			<dt>영화관</dt>
        			<dd>${cinema.name} ${theater.name} - 2D</dd>
        			<dt>인원</dt>
        			<dd>
        				<c:if test="${book.teenager >= 1}">
        					성인${book.teenager}&nbsp;
        				</c:if>
        				<c:if test="${book.adult >= 1}">
        					청소년${book.adult}&nbsp;
        				</c:if>
        				<c:if test="${book.senior >= 1}">
        					노약자${book.senior}&nbsp;
        				</c:if>        				
        			</dd>
        		</dl>
        		
        	</div>	
        	<!-- 좌석 예매 정보 -->
        	<div class="seat-info bottom_bar">
        		<dl>
        			<dt>좌석</dt>
        			<dd>
        				<c:forEach var="seat" items="${seats}">
        					${seat.seat_row}${seat.seat_col}&nbsp;
        				</c:forEach>
        			</dd>
        		</dl>
        	</div>
        	
        	<!-- 추가상품 예매 정보 -->
        	<div class="addProduct-info">
        		<h6>추가상품 구매</h6>
        	</div>
        </div>
	</div>
	
	<!-- 결제 수단 -->
	<div class="pay_method">
		<div class="group_top">
			<span>결제 수단</span>
        </div>
        
		<!-- 결제 수단 내용 -->
        <div class="pay_method-info right_bar">
        	<!-- 할인 및 포인트 정보 -->
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
        	
        	<!-- 최종 결제 수단 정보 -->
        	<div class="group_payment-info">
        		<h6>최종 결제수단</h6>
        		<div class="group_payment-row pay_methods">
        			<ul class="list_pay_item">
        				<li><button type="button" class="pay-btn cate1" data-cate="cate1">신용카드</button></li>
        				<li><button type="button" class="pay-btn cate2" data-cate="cate2">엘페이</button></li>
        				<li><button type="button" class="pay-btn cate3" data-cate="cate3">간편결제</button></li>
        				<li><button type="button" class="pay-btn cate4" data-cate="cate4">내통장결제</button></li>
        				<li><button type="button" class="pay-btn cate5" data-cate="cate5">휴대폰</button></li>
        			</ul>
        		</div>
        	</div>
        	
        
        	<!-- 간편결제 정보 -->
        	<div id="easyPay_wrap" class="hidden">
        		<div class="easyPay">
        			<button type="button" class="easyPay_btn">
	        			<span class="thm">
	        				<img src="/movie/images/sub/payment_simple_kakao.png">
	        				</span><br>
	        			<span>카카오페이</span>
	        		</button>
        			<button type="button" class="easyPay_btn">
	        			<span class="thm">
	        				<img src="/movie/images/sub/payment_simple_payco.png">
	        				</span><br>
	        			<span>페이코</span>
	        		</button>
	        		<button type="button" class="easyPay_btn">
	        			<span class="thm">
	        				<img src="/movie/images/sub/payment_simple_npay.png">
	        				</span><br>
	        			<span>네이버페이</span>
	        		</button>
        			<button type="button" class="easyPay_btn">
	        			<span class="thm">
	        				<img src="/movie/images/sub/payment_simple_toss.png">
	        				</span><br>
	        			<span>토스</span>
	        		</button>
        			<button type="button" class="easyPay_btn">
	        			<span class="thm">
	        				<img src="/movie/images/sub/payment_simple_chai.svg">
	        				</span><br>
	        			<span>차이나페이</span>
	        		</button>
        			<button type="button" class="easyPay_btn">
	        			<span class="thm">
	        				<img src="/movie/images/sub/payment_simple_tbee.png">
	        				</span><br>
	        			<span>모바일캐시비/티머니</span>
	        		</button>
        		</div>
        	</div>
        </div>
	</div>
	
	<!-- 결제하기 -->
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
        		<!-- L.POINT 적립 도움말 -->
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
        <div class="payment_agency_agree-wrap hidden">
	        <div class="payment_agency_agree bottom_bar">
	        	<div class="payment_agency_agree_all">
					<input type="checkbox" id="chkAgreePayAgency"/>
					<label for="chkAgreePayAgency" class="ty2">
			        	결제대행서비스 약관 동의
			        </label>        	
	        	</div>
		        <div class="payment_agency_agree_list">
		        	<input type="checkbox" id="chkAgreeElectronicTrade"/>
					<label for="chkAgreeElectronicTrade" class="ty2">
			        	전자금융거래 이용약관 동의
						<a href="#tabs-1" id="btnAgreeElectronicTrade" data-target="tab1">
			        		약관보기 >
			        	</a>
			        </label>
	
			        <input type="checkbox" id="chkAgreeUniqueIdentifyInfo"/>
					<label for="chkAgreeUniqueIdentifyInfo" class="ty2">
			        	고유식별정보 수집 및 이용안내
			        	<a href="#tabs-2" id="btnAgreeUniqueIdentifyInfo" data-target="tab2">
			        		약관보기 >
			        	</a>
			        </label>
					<input type="checkbox" id="chkAgreePersonInfo"/>
					<label for="chkAgreePersonInfo" class="ty2">
			        	개인정보 수집 및 이용동의
			        	<a href="#tabs-3" id="btnAgreePersonInfo" data-target="tab3">
			        		약관보기 >
			        	</a>
			        </label>
			        <input type="checkbox" id="chkAgreePersonInfoThrid"/>
					<label for="chkAgreePersonInfoThrid" class="ty2">
			        	개인정보 제3자 제공/위탁동의
			        	<a href="#tabs-4" id="btnAgreePersonInfoThrid" data-target="tab4">
			        		약관보기 >
			        	</a>
			        </label>	
		        </div>
	       	</div>
        
        </div>
        

        <div class="price-info">
			<div class="product_price price-info-item">
				<div class="price_title">
					<strong>상품금액</strong>
				</div>
				<div class="price_content">
					<strong>${book.total_price} 원</strong>
				</div>
				
				
			</div>
			<div class="sale_price price-info-item">
				<div class="price_title">
					<strong>할인금액</strong>
				</div>
				<div class="price_content">
					<strong>- 0 원</strong>
				</div>
			</div>
			<div class="total_price price-info-item">
				<div class="price_title">
					<strong>결제금액</strong>
				</div>
				<div class="price_content">
					<strong>총 ${book.total_price} 원</strong>
				</div>
			</div>        
			<div class="pay_btn_wrap price-info-item">
				<button type="button" id="pay">결제하기</button>
			</div>
        </div>
	</div>	
</div>
</div>

<!-- //페이지 내용 -->

<script>
$(function(){
	// L.POINT 적립 도움말 버튼 클릭
	$("#ic_question").on("click", function(){
		$("#ic_question_tooltip").show();
	});	
	
	// L.POINT 적립 도움말 창의 닫기 버튼 클릭
	$("#ic_question_tooltip .btn_close").on("click", function(){
		$("#ic_question_tooltip").hide();
	});
	
	// 최종결제수단 버튼 클릭
	$(".pay-btn").on("click", function(){
		const cateName = $(this).data("cate");		
		toggleClassBubble(cateName);
		
		if(cateName === "cate1"){
			$("#easyPay_wrap").addClass("hidden");
			$("#lpay_wrap").addClass("hidden");
		}else if(cateName === "cate2"){
			$("#lpay_wrap").toggleClass("hidden");
			$("#easyPay_wrap").addClass("hidden");
		}else if(cateName === "cate3"){
			$("#lpay_wrap").addClass("hidden");
			$("#easyPay_wrap").toggleClass("hidden");
		}else{
			$("#lpay_wrap").addClass("hidden");
			$("#easyPay_wrap").addClass("hidden");	
		}
		payment_agency_agreeWrapToggle();
	});
		
	// 약관보기 버튼 클릭
	$(".payment_agency_agree_list a").on("click", function(){
		clickTab($(this).attr("href"));
		$("#termModal #staticBackdrop").modal();
	});
	
	// 결제 방법 버튼에 버블 효과를 활성화/비활성화
	function toggleClassBubble(cate){
		const selected = $(".pay-btn").filter(function(index, item){
			return $(item).data("cate") === cate;
		});
		const other = $(".pay-btn").not(selected); 

		$(selected).toggleClass("bubble"); // 선택환 결제 방법에 버블을 활성화/비활성화	
		$(other).removeClass("bubble");    // 선택한 결제 방법 버튼을 제외한 다른 버블 효과를 비활성화
	}

	// 약관동의 창을 활성화/비활성화
	// cateName : cate-1, cate-2, ... cate-N
	function payment_agency_agreeWrapToggle(){
		if($(".pay-btn.bubble").length >= 1){
			$(".payment_agency_agree-wrap").removeClass("hidden");	
		}else{
			$(".payment_agency_agree-wrap").addClass("hidden");
		}
	}
	
	
	
	// 약관 동의를 4개 전부 체크했는지 검사
	function isAllCheckTerms(){
		const chks = $(".payment_agency_agree_list input[type='checkbox']");

		return $(chks).filter(":checked").length == 4 ? true : false;
	}
	
	// 신용카드를 선택했는지 검사
	function isSelectedCreditCard(){
		return $(".cate1").hasClass("bubble");		 
	}
			
	// 결제대행서비스 약관 동의 체크박스 클릭
	$("#chkAgreePayAgency").on("click", function(){
		const sub_chks = $(".payment_agency_agree_list input[type='checkbox']");
		
		if($(this).is(":checked")){
			$(sub_chks).prop("checked", true);
		}else{
			$(sub_chks).prop("checked", false);
		}
	});
	
	// 결제하기 버튼 클릭
	$("#pay").on("click", function(){
		
		if(isAllCheckTerms() && isSelectedCreditCard()){
			getMerchant_uid().then(function(data){
				const merchant_uid = data.book_code;
				requestPay(merchant_uid);
			});			
		}else if(!isAllCheckTerms()){
			const yn = confirm("결제대행서비스 약관에 동의하셔야 구매가 가능합니다. 동의하시겠습니까?");
			if(yn){
				$(".payment_agency_agree_list input[type='checkbox']").prop("checked", true);			
			}
		}else{
			alert("최종 결제 수단을 선택해주세요");
		};
		
	});
	
	
});
</script>

<!-- 외부 결제 API -->
<script>
    const IMP = window.IMP;
	
	
	function getMerchant_uid(){
		return $.when($.ajax({
			url : '/movie/ticketing/orderSettlement/getNextBookCode',
			type : 'post',
			success : function(data) {
				if (data.code === 'ok') {
												
				} else if (data.code === 'no') {
					alert("예매번호를 가져오는데 실패하였습니다.");
				}
			},
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : "json"
		}));		
	}
	
    function requestPay(merchant_uid) {
        // IMP.request_pay(param, callback) 결제창 호출    
        IMP.init("imp50795017");
        
        IMP.request_pay({ // param
            pg: "danal_tpay",
            pay_method: "card",
            merchant_uid: merchant_uid,
            name: "영화표",
            amount: 12000,
            buyer_email: "yh.kim951107@gmail.com",
            buyer_name: "김용환",
            buyer_tel: "010-1234-5678",
            buyer_addr: "서울특별시 강남구 신사동",
            buyer_postcode: "01181"
        }, function (rsp) { // callback
            if (rsp.success) {
            	// 결제 성공 시 로직,
                alert("결제가 성공하였습니다.");
            } else {
                // 결제 실패시 로직
                alert("결제가 실패하였습니다.");
            }
        });
      }
</script>