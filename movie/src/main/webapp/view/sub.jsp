<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>LOTTE CGV BOX</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="/movie/images/common/favicon.ico">
<link rel="stylesheet" href="/movie/css/sub/ticketing/orderSettlement.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/movie/css/sub/ticketing/personSeat.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/movie/css/sub/ticketing/ticket.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/movie/css/sub.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/movie/css/layout.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/movie/css/common.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/movie/css/board.css?v=<%=System.currentTimeMillis() %>">

<!-- jQuery --> 
<script src="/movie/js/plugins/jquery-3.6/jquery-3.6.0.min.js"></script>
<script src="/movie/js/plugins/jquery-3.6/slick.min.js"></script>
<!-- jQuery -->


<!-- bootstrap -->
<link rel="stylesheet" href="/movie/css/plugins/bootstrap-4.6/bootstrap.min.css">
<script src="/movie/js/plugins/bootstrap-4.6/bootstrap.min.js"></script>
<!-- //bootstrap -->


<script src="/movie/js/common.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="/movie/js/sub.js?v=<%=System.currentTimeMillis() %>"></script>

<!-- sub/admin 영화 상영 관리 -->
<link rel="stylesheet" href="/movie/css/sub/admin/screenAdd.css?v=<%=System.currentTimeMillis() %>">
<script src="/movie/js/admin/screenAdd.js"></script>
<script src="/movie/js/admin/screenSchAdd.js"></script>

<!-- //sub/admin 영화 상영 관리 -->
</head>
<body>

	<!-- header -->
	<jsp:include page="./layout/header.jsp" />
	<!-- //header -->
	
	<!-- sub -->
	<div id="container">
		<!-- 서브 비주얼 -->
		<div class="subVisual">
			<img src="/movie/images/sub/sub_visual01.jpg" alt="">
		</div>
		<!-- //서브 비주얼 -->
	
		<div class="container">
			<div id="sub">
				<!-- 페이지뷰 -->
				<div id="pageView">
					<jsp:include page="./sub/${requestScope.fileNm }.jsp" />
				</div>
				<!-- //페이지뷰 -->
			</div>
		</div>
	</div>
	<!-- //sub -->
	
	<!-- footer -->
	<jsp:include page="./layout/footer.jsp" />
	<!-- //footer -->

</body>
</html>