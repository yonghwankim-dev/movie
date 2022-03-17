<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lottecgvbox.vo.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 타이틀 -->
<h2 class="pageTitle">영화 검색</h2>
<!-- //페이지 타이틀 -->

<!-- 여기부터 페이지 내용 -->
<div class="searchMovie">
	<form action="searchMovie.do" method="post">
		<div class="top">
			<input type="text" name="movNm" id="movNm" title="영화명" placeholder="영화명" value="${requestScope.movNm != '' ? requestScope.movNm : '' }">
			
			<button type="button" class="btn btnSearch">
				<i class="xi-search" aria-hidden="true"></i>
				<span class="sr-only">검색</span>
			</button>
		</div>
		
		<div class="resultBox">
		
				<%
					List<MovieVO> movieList = (List<MovieVO>) request.getAttribute("movieList");
					String movNm = (String) request.getAttribute("movNm");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					DecimalFormat df = new DecimalFormat("0.00");
					
					if (movNm != null) {
						if (movieList != null && movieList.size() > 0) {
				%>
					<p class="count"><%=movieList.size()%>개 검색됨</p>
					
					<ul>
						<% for (int i = 0; i < movieList.size(); i++) { %>
							<% 
								MovieVO vo = movieList.get(i);
							
								String movPt = String.valueOf((double) vo.getMovPt() / 60);
								String movPtBegin = movPt.substring(0, movPt.lastIndexOf("."));
								String movPtLast = movPt.substring(movPt.lastIndexOf(".")).replace(".", "");
								String movPtLastRes = "";
								
								if (Double.parseDouble(movPtLast) > 0) {
									String val = df.format(Double.parseDouble(movPtLast) / 60);
									movPtLastRes = val.substring(val.lastIndexOf(".")+1) + "분";
								}
							%>
							
							<li>
								<a href="javascript:void(0);" title="예고편 보기" data-cd="<%=vo.getMovCd() %>">
									<span class="img">
										<img src="<%=request.getContextPath() %>/images/common/movie0<%=vo.getMovCd() %>.jpg" alt="<%=vo.getMovNm() %>">
									</span>
									
									<div class="txt">
										<strong class="title"><%=vo.getMovNm().replace(movNm, "<span class='highlight'>"+movNm+"</span>") %></strong>
										<ul class="list_st1">
											<li>개봉일 : <%=sdf.format(sdf.parse(vo.getMovPd())) %></li>
											<li>상영시간 : <%=movPtBegin %>시간 <%=movPtLastRes %></li>
										</ul>
									</div>
								</a>
							</li>
						<% } %>
					</ul>
				<% } else { %>
					<p class="noData">데이터가 없습니다.</p>
				<% } %>
			<% } %>
		</div>
	</form>
</div>

<script>
	$('#movNm').on('keydown', doSearchKeyDown);
	$('.btnSearch').on('click', doSearch);
	
	/* 포스터 클릭 시 예고편 영상 팝업 뜨게 하기 */
	$('.searchMovie .resultBox li a').on('click', function(){
		let cd = $(this).attr('data-cd');
		return showTrailer(cd);
	});
	
	function doSearchKeyDown(){
		// Enter 키 눌렀을 때
		if (event.keyCode == 13) {
			return doSearch();
		}
	}
	
	function doSearch(){
		if ($('#movNm').val().trim() == '') {
			alert('영화명을 입력하세요.');
			$('#movNm').focus();
			return false;
		}
		this.form.submit();
	}
</script>
<!-- //여기까지 페이지 내용 -->