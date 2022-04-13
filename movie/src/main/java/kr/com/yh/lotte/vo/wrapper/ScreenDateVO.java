package kr.com.yh.lotte.vo.wrapper;

import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TheaterVO;

public class ScreenDateVO {
	private ScreenVO 	screen;
	private MovieVO 	movie;
	private TheaterVO 	theater;
	private int 		cur_seat;	// 현재 남은 좌석
	
	public ScreenDateVO() {
		
	}

	public ScreenDateVO(ScreenVO screen, MovieVO movie, TheaterVO theater, int cur_seat) {
		this.screen = screen;
		this.movie = movie;
		this.theater = theater;
		this.cur_seat = cur_seat;
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

	public int getCur_seat() {
		return cur_seat;
	}	
}
