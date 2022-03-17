$(function(){
	
	/* 상하 스크롤시 header 숨기기 */
    let lastScrollTop = 0;
    let curScrollTop = null;
    let body = $('body');

    $(window).on('load resize scroll', function(){
        curScrollTop = $(this).scrollTop();

        if ((curScrollTop < lastScrollTop) || curScrollTop < $('#container').offset().top + 60) { // up
            body.hasClass('scrollDown') && body.removeClass('scrollDown');
        } else { // down
            !body.hasClass('scrollDown') && body.addClass('scrollDown');
        }
        lastScrollTop = curScrollTop;
    });
	
	/* 메뉴 핸들링 */
	// 메뉴 높이 세팅
	function getMaxMenuHeight(el){
		let ht = 0;
	
		for (let i = 0; i < $(el).length; i++) {
			ht = Math.max(ht, $(el).eq(i).find('.depth2').removeAttr('style').innerHeight());
		}
		return ht;
	}
	
	// 2차메뉴 펼치기
	$('#menu .depth1 > li > a').on('mouseover', function(){
		if (!$('#header').hasClass('menuOpen')) {
			return openDepth2();
		}
	});
	
	// 2차메뉴 닫기
	$('#menu').on('mouseleave', closeDepth2);
	
	// 3차메뉴 펼치기/닫기
	$('#menu .depth2 > li.child > a').on('click', toggleDepth3);
	
	function toggleDepth3(){
		if ($(this).parent().hasClass('on')) {
			$(this).parent().removeClass('on');
			$(this).next().stop().fadeOut(100, function(){
				$('#menu, #menu .blind, #menu .depth2').stop().animate({
					height: getMaxMenuHeight('#menu .depth1 > li') + 60 + 'px'
				}, 0);
			});
		} else {
			$(this).parent().addClass('on');
			$(this).next().stop().fadeIn(100);
			$('#menu, #menu .blind, #menu .depth2').stop().animate({
				height: getMaxMenuHeight('#menu .depth1 > li') + 60 + 'px'
			}, 0);
		}
	}
	
	function openDepth2(){
		$('#menu .depth1 > li').removeClass('on');
		$(this).parent().addClass('on');
		$('#menu .depth2').removeClass('on');
		$(this).next().addClass('on');
		
		$(this).parent().addClass('on');
		$('#header').addClass('menuOpen');
		$('#menu').stop().animate({
			height: getMaxMenuHeight('#menu .depth1 > li') + 60 + 'px'
		}, 250);
		$('#menu .blind, #menu .depth2').stop().animate({
			height: getMaxMenuHeight('#menu .depth1 > li') + 'px'
		}, 250);
		$('#menu .depth2').on('mouseover', function(){
			$('#menu .depth1 > li').removeClass('on');
			$('#menu .depth2').removeClass('on');
			$(this).parent().addClass('on');
			$(this).addClass('on');
		});
	}
	
	function closeDepth2(){
		$('#menu li').removeClass('on');
		$('#menu').stop().animate({
			height: 60 + 'px'
		}, 250);
		$('#menu .blind').stop().animate({
			height: 0
		}, 250);
		$('#menu .depth2').removeClass('on');
		$('#menu .depth3').stop().fadeOut(150);
		setTimeout(function(){
			$('#header').removeClass('menuOpen');
		}, 250);
	}
});


/* 포스터 클릭 시 예고편 영상 팝업 뜨게 하기 */
function showTrailer(cd){
	window.open('https://res.cloudinary.com/dbrgfvqgb/video/upload/v1647223252/video/trailer0'+cd+'.mp4', '', 'top=200, left=200, width=1000, height=1000');
}
