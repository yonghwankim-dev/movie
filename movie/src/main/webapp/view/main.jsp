<%@page import="kr.com.yh.lotte.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>LOTTE CGV BOX</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="/movie/images/common/favicon.ico">
<link rel="stylesheet" href="/movie/css/main.css">
<script src="/movie/js/plugins/jquery-3.6.0.min.js"></script>
<script src="/movie/js/plugins/bootstrap.min.js"></script>
<script src="/movie/js/plugins/slick.min.js"></script>
<script src="/movie/js/common.js"></script>
<script src="/movie/js/main.js"></script>

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
					<c:forEach var="movie" items="${movieList}" varStatus="status">
						<c:if test="${status.index < 4}">
							<div class="item">
								<a href="javascript:void(0);" title="예고편 보기" data-cd="${movie.movie_code} %>">
									<img src="/movie/images/main/${movie.movie_code}.jpg" alt="">
								</a>
							</div>
						</c:if>
					</c:forEach>
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
						<c:forEach var="i" begin="1" end="5">
							<div class="item">
								<a href="javascript:void(0);">
									<span class="img">
										<img src="/movie/images/common/movie0${i}.jpg" alt="">
									</span>
								</a>
							</div>
						</c:forEach>
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
		</main>
	</div>
	<!-- //main -->
	
	<!-- footer -->
	<jsp:include page="./layout/footer.jsp" />
	<!-- //footer -->
</body>
</html>