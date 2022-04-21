package kr.com.yh.lotte.vo.wrapper;

import java.sql.Timestamp;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TheaterVO;

/**
 * Class Description
 * 개인 좌석 선택 페이지에 대한 정보를 담은 페이지
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-21
 */
public class MovieInfoVO {
	private MovieVO 	movie;
	private ScreenVO  	screen;
	private CinemaVO	cinema;
	private TheaterVO	theater;
	private Timestamp	end_time;	// 영화 종료 시간

	public MovieInfoVO() {
		
	}
	
	public MovieInfoVO(MovieVO movie, ScreenVO screen, CinemaVO cinema, TheaterVO theater, Timestamp end_time) {
		this.movie = movie;
		this.screen = screen;
		this.cinema = cinema;
		this.theater = theater;
		this.end_time = end_time;
	}

	public MovieVO getMovie() {
		return movie;
	}

	public ScreenVO getScreen() {
		return screen;
	}

	public CinemaVO getCinema() {
		return cinema;
	}

	public TheaterVO getTheater() {
		return theater;
	}

	public Timestamp getEnd_time() {
		return end_time;
	}

	@Override
	public String toString() {
		return "MovieInfoVO [movie=" + movie + ", screen=" + screen + ", cinema=" + cinema + ", theater=" + theater
				+ ", end_time=" + end_time + "]";
	}	
}
