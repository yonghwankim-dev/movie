<%@page import="kr.com.yh.lottecgvbox.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>LOTTE CGV BOX</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/common/favicon.ico">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
<script src="<%=request.getContextPath() %>/js/plugins/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/slick.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/main.js"></script>
</head>
<body>

	<!-- header -->
	<jsp:include page="./layout/header.jsp" />
	<!-- //header -->
	
	<!-- main -->
	<div id="container">
		<main id="main">
			<!-- 메인 비주얼 -->
			<div class="mainVisual">
				<div class="items" id="mainVisualSlider">
					<%  List<MovieVO> list = (List<MovieVO>) request.getAttribute("movieList");
					
						for (int i = 0; i < list.size(); i++) { %>
							<% MovieVO vo = list.get(i); %>
							<div class="item">
								<a href="javascript:void(0);" title="예고편 보기" data-cd="<%=vo.getMovie_code() %>">
									<img src="<%=request.getContextPath() %>/images/main/main_<%=vo.getMovie_code() %>.jpg" alt="">
								</a>
							</div>
						<% } %>
				</div>
				
				<div class="controls">
					<button type="button" id="mainVisualPrev" class="control prev">
						<i class="xi-angle-left" aria-hidden="true"></i>
						<span class="sr-only">이전</span>
					</button>
					
					<button type="button" data-slider="mainVisualSlider" class="control stop">
						<i class="xi-pause" aria-hidden="true"></i>
						<span class="sr-only">정지</span>
					</button>
					
					<button type="button" data-slider="mainVisualSlider" class="control play">
						<i class="xi-play" aria-hidden="true"></i>
						<span class="sr-only">재생</span>
					</button>
					
					<button type="button" id="mainVisualNext" class="control next">
						<i class="xi-angle-right" aria-hidden="true"></i>
						<span class="sr-only">다음</span>
					</button>
				</div>
			</div>
			<!-- //메인 비주얼 -->
			
			<!-- 무비차트 -->
			<div class="movieChart">
				<div class="container">
					<h2 class="sr-only">무비차트</h2>
				
					<div class="items" id="movieChartSlider">
						<div class="item">
							<a href="javascript:void(0);">
								<span class="img">
									<img src="<%=request.getContextPath() %>/images/common/movie01.jpg" alt="">
								</span>
							</a>
						</div>
						
						<div class="item">
							<a href="javascript:void(0);">
								<span class="img">
									<img src="<%=request.getContextPath() %>/images/common/movie02.jpg" alt="">
								</span>
							</a>
						</div>
						
						<div class="item">
							<a href="javascript:void(0);">
								<span class="img">
									<img src="<%=request.getContextPath() %>/images/common/movie03.jpg" alt="">
								</span>
							</a>
						</div>
						
						<div class="item">
							<a href="javascript:void(0);">
								<span class="img">
									<img src="<%=request.getContextPath() %>/images/common/movie04.jpg" alt="">
								</span>
							</a>
						</div>
						
						<div class="item">
							<a href="javascript:void(0);">
								<span class="img">
									<img src="<%=request.getContextPath() %>/images/common/movie05.jpg" alt="">
								</span>
							</a>
						</div>
					</div>
					
					<div class="controls">
						<button type="button" id="movieChartPrev" class="control prev">
							<i class="xi-angle-left" aria-hidden="true"></i>
							<span class="sr-only">이전</span>
						</button>
						
						<button type="button" id="movieChartNext" class="control next">
							<i class="xi-angle-right" aria-hidden="true"></i>
							<span class="sr-only">다음</span>
						</button>
					</div>
				</div>
			</div>
			<!-- //무비차트 -->
			
			<!-- 공지사항 -->
			<div class="notice">
				<div class="container">
					<h2>공지사항</h2>
					
					<div class="inner">
						<a href="" class="title">22년 VIP 선정 기준 변경 및 추가 기준 관련 안내</a>
						<a href="" class="btnMore">
							<i class="xi-plus" aria-hidden="true"></i>
							<span class="sr-only">더보기</span>
						</a>
					</div>
				</div>
			</div>
			<!-- //공지사항 -->
		</main>
	</div>
	<!-- //main -->
	
	<!-- footer -->
	<jsp:include page="./layout/footer.jsp" />
	<!-- //footer -->
	
	<script>
		/* 메인 비주얼 클릭 시 예고편 영상 팝업 뜨게 하기 */
		$('.mainVisual .item a').on('click', function(){
			let cd = $(this).attr('data-cd');
			return showTrailer(cd);
		});
	</script>

</body>
</html>