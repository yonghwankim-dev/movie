package kr.com.yh.lotte.vo.component;

import java.util.List;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.TheaterVO;

public class CinemaTheaterVO {
	private CinemaVO cinema;
	private List<TheaterVO> theaters;
	
	public CinemaTheaterVO(){
		
	}
	
	public CinemaTheaterVO(CinemaVO cinema, List<TheaterVO> theaters) {
		this.cinema = cinema;
		this.theaters = theaters;
	}

	public CinemaVO getCinema() {
		return cinema;
	}

	public List<TheaterVO> getTheaters() {
		return theaters;
	}

	@Override
	public String toString() {
		return "CinemaTheaterVO [cinema=" + cinema + ", theaters=" + theaters + "]";
	}
	
	
}
