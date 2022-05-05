package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 좌석 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class SeatVO {
	private String seat_code;		// 좌석코드
	private String seat_row;		// 좌석행
	private int seat_col;			// 좌석열
	private String theater_code;	// 상영관코드
	
	public SeatVO() {
		
	}

	public SeatVO(String seat_code, String seat_row, int seat_col, String theater_code) {
		this.seat_code = seat_code;
		this.seat_row = seat_row;
		this.seat_col = seat_col;
		this.theater_code = theater_code;
	}

	public String getSeat_code() {
		return seat_code;
	}

	public String getSeat_row() {
		return seat_row;
	}

	public int getSeat_col() {
		return seat_col;
	}

	public String getTheater_code() {
		return theater_code;
	}

	@Override
	public String toString() {
		return "SeatVO [seat_code=" + seat_code + ", seat_row=" + seat_row + ", seat_col=" + seat_col
				+ ", theater_code=" + theater_code + "]";
	}
}
