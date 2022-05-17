package kr.com.yh.lotte.vo.component;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.TheaterVO;

public class MovieScreenSchVO {
	private ScreenSchVO screenSch;
	private MovieVO movie;
	private TheaterVO theater;
	private CinemaVO cinema;
	private int theater_seat_cnt;	// 상영관 좌석수
	private int book_seat_cnt;		// 예약된 좌석수
	
	public MovieScreenSchVO() {
		
	}

	public MovieScreenSchVO(ScreenSchVO screenSch, MovieVO movie, TheaterVO theater, CinemaVO cinema,
			int theater_seat_cnt, int book_seat_cnt) {
		this.screenSch = screenSch;
		this.movie = movie;
		this.theater = theater;
		this.cinema = cinema;
		this.theater_seat_cnt = theater_seat_cnt;
		this.book_seat_cnt = book_seat_cnt;
	}

	public ScreenSchVO getScreenSch() {
		return screenSch;
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

	public int getTheater_seat_cnt() {
		return theater_seat_cnt;
	}

	public int getBook_seat_cnt() {
		return book_seat_cnt;
	}
	
	public void setBook_seat_cnt(int book_seat_cnt) {
		this.book_seat_cnt = book_seat_cnt;
	}

	@Override
	public String toString() {
		return "MovieScreenSchVO [screenSch=" + screenSch + ", movie=" + movie + ", theater=" + theater + ", cinema="
				+ cinema + ", theater_seat_cnt=" + theater_seat_cnt + ", book_seat_cnt=" + book_seat_cnt + "]";
	}
}
