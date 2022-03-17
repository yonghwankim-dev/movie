<%@page import="kr.or.ddit.lottecgvbox.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle">스낵음료</h2>
<!-- //페이지 타이틀 -->

<div class="store"> 
	<div class="storeList">
	
	<form action="cart.do" method="post">
	<a href="" id="combo1">
	  <div>
	    <img alt="" src="<%=request.getContextPath()%>/images/sub/popcombo1.jpg">
	  </div>
	  <div id="combo1Info">
	    <div>
	      <h4 name="prodNm">즉석구이콤보</h4>
	      <p style="color: gray; font-size: small;">카라멜팝콘M+즉석구이(몸통or다리)+탄산음료M2</p>
	    </div>
	    <div>
	      <h4 name="prodPri">13,500원</h4>
	    </div>
	      <input type="button" class="btn btn-primary" id="buyChk" value="구매하기">
	  </div>
	</a>
	
	<a href="" id="combo2">
	  <div>
	    <img alt="" src="<%=request.getContextPath()%>/images/sub/popcombo2.jpg">
	  </div>
	  <div id="combo2Info">
	    <div>
	      <h4 name="">더블콤보</h4>
	      <p style="color: gray; font-size: small;">카라멜팝콘M+오리지널팝콘M+탄산음료M2</p>
	    </div>
	    <div>
	      <h4>13,000원</h4>
	    </div>
	    <input type="button" class="btn btn-primary" id="buyChk" value="구매하기">
	  </div>
	  
	</a>

	<a href="" id="combo3">
	  <div>
	    <img alt="" src="<%=request.getContextPath()%>/images/sub/popcombo3.jpg">
	  </div>
	  <div id="combo3Info">
	    <div>
	      <h4>스위트콤보</h4>
	      <p style="color: gray; font-size: small;">오리지널팝콘L+탄산음료M2</p>
	    </div>
	    <div>
	      <h4>9,000원</h4>
	    </div>
	    <input type="button" class="btn btn-primary" id="buyChk" value="구매하기">
	  </div>
	</a>

	<a href="" id="caramelpop">
	  <div>
	    <img alt="" src="<%=request.getContextPath()%>/images/sub/caramelpop.jpg">
	  </div>
	  <div id="popInfo">
	    <div>
	      <h4>카라멜팝콘 L</h4>
	      <p style="color: gray; font-size: small;">카라멜팝콘L</p>
	    </div>
	    <div>
	      <h4>6,000원</h4>
	    </div>
	    <input type="button" class="btn btn-primary" id="buyChk" value="구매하기">
	  </div>
	</a>

	<a href="" id="cider">
	  <div>
	    <img alt="" src="<%=request.getContextPath()%>/images/sub/cider.jpg">
	  </div>
	  <div id="ciderInfo">
	    <div>
	      <h4>사이다 M</h4>
	      <p style="color: gray; font-size: small;">사이다M</p>
	    </div>
	    <div>
	      <h4>2,500원</h4>
	    </div>
	    <input type="button" class="btn btn-primary" id="buyChk" value="구매하기">
	  </div>
	</a>

	<a href="" id="coke">
	  <div>
	    <img alt="" src="<%=request.getContextPath()%>/images/sub/coke.jpg">
	  </div>
	  <div id="cokeInfo">
	    <div>
	      <h4>콜라 M</h4>
	      <p style="color: gray; font-size: small;">콜라 M</p>
	    </div>
	    <div>
	      <h4>2,500원</h4>
	    </div>
	    <input type="button" class="btn btn-primary" id="buyChk" value="구매하기">
	  </div>
	</a>
	<input type="submit" value="결제하기" class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/cart.do'" id="buySnack">
	</form>
	</div>
	
</div>

<script>
$(".btn .btn-primary").on("click", function () {
	confirm("장바구니에 담으시겠습니까?");
	
	if (true) {
	
		$.ajax({
			
			type : "get",
			url : "<%=request.getContextPath()%>/store.do",
			data : {},
			success : function() {
				
			},
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : "json"
		});
	}
 });

</script>