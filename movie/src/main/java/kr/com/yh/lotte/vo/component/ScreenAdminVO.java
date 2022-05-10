package kr.com.yh.lotte.vo.component;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TheaterVO;

public class ScreenAdminVO {
	private ScreenVO screen;
	private MovieVO movie;
	private TheaterVO theater;
	private CinemaVO cinema;
	
	public ScreenAdminVO() {
		
	}
	
	public ScreenAdminVO(ScreenVO screen, MovieVO movie, TheaterVO theater, CinemaVO cinema) {
		this.screen = screen;
		this.movie = movie;
		this.theater = theater;
		this.cinema = cinema;
	}

	public ScreenVO getScreen() {
		return screen;
	}

	public MovieVO getMovie() {
		return movie;
	}

	public TheaterVO getTheater() {
		return theater;
	}

	public CinemaVO getCinema() {
		return cinema;
	}

	@Override
	public String toString() {
		return "ScreenAdminVO [screen=" + screen + ", movie=" + movie + ", theater=" + theater + ", cinema=" + cinema
				+ "]";
	}	
}
