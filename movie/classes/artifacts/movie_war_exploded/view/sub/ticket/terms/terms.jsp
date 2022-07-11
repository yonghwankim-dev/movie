<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Modal -->
<div id="termModal">
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-termsize">
			<div id="tabs" class="modal-content modal-termsize">
				<div class="modal-header">
					<div class="modal-title-wrap">
						<h5 class="modal-title" id="staticBackdropLabel">결제대행서비스 약관보기</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>	
					<div>
						<ul class="nav nav-pills nav-fill flex-nowrap">
							  <li class="nav-item">
							    <a class="nav-link active" href="#tabs-1">전자금융거래 <br>이용약관</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="#tabs-2">고유식별정보 <br> 수집 및 이용 안내</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="#tabs-3">개인정보의 <br> 수집 및 이용동의</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="#tabs-4">개인정보 <br> 제공 및 위탁혐의</a>
							  </li>
						</ul>
					</div>
				</div>
				<div class="modal-body">
					<div id="tabs-1" class="tabItem">
						<jsp:include page="/view/sub/ticket/terms/term_content1.jsp"/>
					</div>
					<div id="tabs-2" class="tabItem hidden">
						<jsp:include page="/view/sub/ticket/terms/term_content2.jsp"/>
					</div>
					<div id="tabs-3" class="tabItem hidden">
						<jsp:include page="/view/sub/ticket/terms/term_content3.jsp"/>
					</div>
					<div id="tabs-4" class="tabItem hidden">
						<jsp:include page="/view/sub/ticket/terms/term_content4.jsp"/>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
							aria-label="Close">
						확인
					</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

	$(function(){
		$(".nav-link").on("click", function(){
			clickTab($(this).attr("href"));
		});
	});
	
	function clickTab(tab){

		const selected = $(".nav-link").filter(function(idx, item){
			return $(item).attr("href") === tab;
		});

		// tab 활성화/비활성화
		$(".nav-link").removeClass("active");
		$(selected).addClass("active");

		// tab 내용 활성화/비활성화
		$(".tabItem").addClass("hidden"); // 다른 탭의 내용들을 전부 가림
		$(tab).removeClass("hidden");  	  // 선택한 탭의 내용을 보여줌		
	}
</script>