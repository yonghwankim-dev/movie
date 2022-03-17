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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sub.css">
<script src="<%=request.getContextPath() %>/js/plugins/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/slick.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/sub.js"></script>
</head>
<body>

	<!-- header -->
	<jsp:include page="./layout/header.jsp" />
	<!-- //header -->
	
	<!-- sub -->
	<div id="container">
		<!-- 서브 비주얼 -->
		<div class="subVisual">
			<img src="<%=request.getContextPath() %>/images/sub/sub_visual01.jpg" alt="">
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