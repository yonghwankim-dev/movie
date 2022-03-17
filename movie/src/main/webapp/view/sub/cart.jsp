<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <!-- 페이지 타이틀 -->
<h2 class="pageTitle"> 장바구니 </h2>
<!-- //페이지 타이틀 -->


<div class="cartList">
  <div id="cartStep">
	<ul id="cartStepList">
		<li class="step1">
			<img alt="cart" src="<%=request.getContextPath() %>/images/sub/iconmonstr-shopping-cart-2-240.png" id="cart"/>
			<div>
			<span>STEP 01</span><br>
			<strong>장바구니</strong>
			</div>
		</li>
		<li>
			<img alt="card" src="<%=request.getContextPath() %>/images/sub/iconmonstr-credit-card-6-240.png" id="card"/>
			<div>
			<span>STEP 02</span><br>
			<strong>결제하기</strong>
			</div>
		</li>
		
		<li>
			<img alt="user" src="<%=request.getContextPath() %>/images/sub/iconmonstr-user-6-240.png" id="user"/>
			<div>
			<span>STEP 03</span><br>
			<strong>결제완료</strong>
			</div>
		</li>
	</ul>
	</div>
	
<div>
  <table class="cartTable" border="1">
  <thead> 
      <tr id="cartStep0">
 	 	<th><input type="checkbox" id="chkBoxAll"></th>
        <th>상품명</th>
        <th>판매금액</th>
        <th>수량</th>
        <th>구매금액</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="checkbox" id="chkBox" name="chkBox" class="btn btn-primary btn-block"></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>
</div>
  <input type="button" value="선택 상품 삭제" class="btn btn-danger">

<!-- 금액 출력 테이블 -->
<div class="creditBox">
  <table class="creditBoxTable" border="1">
  <thead> 
      <tr id="cartStep0">
        <th>총 상품 금액</th>
        <th></th>
        <th>할인 금액</th>
        <th></th>
        <th>총 결제 예정 금액</th>
      </tr>
    </thead>
        <tbody>
      <tr>
        <td></td>
        <td><i class="xi-minus-circle-o xi-4x" id="minus"></i></td>
        <td></td>
        <td><img src="<%=request.getContextPath() %>/images/sub/3677263-200.png" id="equal"></td>
        <td></td>
      </tr>
    </tbody>
  </table>
</div>
<form action="memberBuy.do">
<input type="submit"  value="구매하기" class="btn btn-primary">
 </form>
</div>

<script>
$(function(){
	
	$("#chkBoxAll").click(function(){
		if($("#chkBoxAll").prop("checked")){
			$("input[name=chkBox]").prop("checked", true)
		} else {
			$("input[name=chkBox]").prop("checked", false)
		}
	})
	
});
	
	
</script>
