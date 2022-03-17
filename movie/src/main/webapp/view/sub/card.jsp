<%@page import="kr.or.ddit.lottecgvbox.vo.CardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle">카드사 조회</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="card_wrap">
	<form action="" method="post" id="cardFrm">
		<% if (session.getAttribute("loginId") != null) { %>
			<input type="hidden" name="loginId" value="<%=session.getAttribute("loginId") %>">
			<input type="hidden" name="memCd" value="<%=session.getAttribute("memCd") %>">
		<% } %>
	
		<table class="table table-striped">
			<caption class="sr-only">카드사 조회 - 카드 선택, 카드사, 카드번호, 자주 쓰는 카드 정보 제공</caption>
			<colgroup>
				<col style="width: 10%;">
				<col style="width: 40%;">
				<col style="width: 40%;">
				<col style="width: 10%;">
			</colgroup>
			<thead>
				<tr>
					<th scope="col" class="text-center">
						<input type="checkbox" id="checkCardAll" title="카드 전체 선택">
					</th>
					<th scope="col" class="text-center">카드사</th>
					<th scope="col" class="text-center">카드번호</th>
					<th scope="col" class="text-center">자주 쓰는 카드</th>
				</tr>
			</thead>
			<tbody class="text-center">
				<% List<CardVO> cardList = (List<CardVO>) request.getAttribute("cardList"); %>
				
				<% if (cardList != null && cardList.size() > 0) { %>
					<% for (int i = 0; i < cardList.size(); i++) { %>
						<% CardVO vo = cardList.get(i); %>
					
						<tr>
							<td><input type="checkbox" name="card" title="카드 선택" value=""></td>
							<td><%=vo.getCardCom() %></td>
							<td><%=vo.getCardNum() %></td>
							<td>
								<% if (vo.getFavrCardAt().equals("Y")) { %>
									<i class="xi-check color_red" aria-hidden="true"></i>
								<% } else { %>
									<i class="xi-check color_grey" aria-hidden="true"></i>
								<% } %>
							</td>
						</tr>
					<% } %>
				<% } else { %>
					<tr>
						<td colspan="4">데이터가 없습니다.</td>
					</tr>
				<% } %>
			</tbody>
		</table>
	</form>
	
	<div class="btns">
		<button type="button" class="btn btn-danger" id="addCard">추가</button>
		<button type="button" class="btn" id="updateCard">수정</button>
		<button type="button" class="btn btn-default" id="deleteCard">삭제</button>
	</div>
</div>

<script>
	/* 카드 체크박스 전체 선택 */
	$('#checkCardAll').on('change', function(){
		let chk = $(this).prop('checked');
		$('[name="card"]').prop('checked', chk);
	});
	
	/* 전체 선택된 상태에서 하나라도 체크 해제 시 전체 선택 해제되게 */
	$(document).on('change', '[name="card"]', function(){
		if (!$(this).prop('checked')) {
			$('#checkCardAll').prop('checked', false);
		}
	});
	
	/* 카드사 등록 */
	$('#addCard').on('click', function(){
		let html = '';
		html += '<tr>';
		html += '	<td>';
		html += '		<input type="checkbox" name="card" title="카드 선택" value="">';
		html += '	</td>';
		html += '	<td>'
		html += '		<div class="col-xs-4 col-xs-offset-4">';
		html += '			<input type="text" name="cardCom" title="카드사" placeholder="카드사" class="form-control input-sm">';
		html += '		</div>';
		html += '	</td>';
		html += '	<td>'
		html += '		<div class="col-xs-4 col-xs-offset-4">';
		html += '			<input type="text" name="cardNum" title="카드번호" placeholder="카드번호" class="form-control input-sm">';
		html += '		</div>';
		html += '	</td>';
		html += '	<td>'
		html += '		<input type="checkbox" name="favrCardAt" title="자주 쓰는 카드">';
		html += '	</td>';
		html += '</tr>';
		
		$('#cardFrm tbody').append(html);
		
		if ($('#insertCard').length == 0) {			
			$(this).after('<button type="button" class="btn btn-success" id="insertCard">등록</button>');
		}
	});
	
	$(document).on('click', '#insertCard', function(){
		$.ajax({
			url: '<%=request.getContextPath() %>/insertCard.do',
			type: 'post',
			data: $('#cardFrm').serialize(),
			success: function(data){
				
			},
			error: function(xhr){
				alert(xhr.status);
			}
		});
	});
</script>
<!-- //여기까지 페이지 내용 -->