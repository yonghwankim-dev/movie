package kr.com.yh.lotte.vo.component;

import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.SeatVO;

public class MovieScreenSchSeatVO {
	private SeatVO seat;
	private ScreenSchSeatVO screenSchSeat;

	public MovieScreenSchSeatVO() {
		
	}
	
	public MovieScreenSchSeatVO(SeatVO seat, ScreenSchSeatVO screenSchSeat) {
		this.seat = seat;
		this.screenSchSeat = screenSchSeat;
	}


	public SeatVO getSeat() {
		return seat;
	}


	public ScreenSchSeatVO getScreenSchSeat() {
		return screenSchSeat;
	}


	@Override
	public String toString() {
		return "MovieScreenSchSeatVO [seat=" + seat + ", screenSchSeat=" + screenSchSeat + "]";
	}
	
	
}
