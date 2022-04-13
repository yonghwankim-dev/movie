package kr.com.yh.lotte.vo.wrapper;

import kr.com.yh.lotte.vo.CinemaVO;

public class CinemaLocationVO {
	private CinemaVO cinemaVO;		// 영화관 객체
	private int		 cinema_cnt;	// 지역내 영화지점수
	
	public CinemaLocationVO() {
		
	}
	
	public CinemaLocationVO(CinemaVO cinemaVO, int cinema_cnt) {
		this.cinemaVO = cinemaVO;
		this.cinema_cnt = cinema_cnt;
	}
	
	public CinemaVO getCinemaVO() {
		return cinemaVO;
	}
	
	public int getCinema_cnt() {
		return cinema_cnt;
	}

	@Override
	public String toString() {
		return "CinemaLocationVO [cinemaVO=" + cinemaVO + ", cinema_cnt=" + cinema_cnt + "]";
	}	
}
