$(function(){
	
	/* 메인 비주얼 */
	$('#mainVisualSlider').slick({
		infinite: true,
		autoplay: true,
		autoplaySpeed: 4000,
		pauseOnHover: false,
		draggable: false,
		//centerMode: true,
		slidesToShow: 1,
		arrows: true,
		prevArrow: '#mainVisualPrev',
		nextArrow: '#mainVisualNext',
    	dots: false
	});
	
	/* 무비차트 */
	$('#movieChartSlider').slick({
		infinite: false,
		autoplay: false,
		slidesToShow: 4,
		arrows: true,
		prevArrow: '#movieChartPrev',
		nextArrow: '#movieChartNext',
    	dots: false,
	});
	
	/* slider 정지,재생 버튼 공통 */
	$('.stop').on('click', function(){
		let slider = '#' + $(this).attr('data-slider');
		
		$(this).hide();
		$('.play[data-slider='+$(this).attr('data-slider')+']').show();
		$(slider).slick('slickPause');
	});
	
	$('.play').on('click', function(){
		let slider = '#' + $(this).attr('data-slider');
		
		$(this).hide();
		$('.stop[data-slider='+$(this).attr('data-slider')+']').show();
		$(slider).slick('slickPlay');
	});
});
