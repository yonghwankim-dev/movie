package kr.com.yh.lotte.vo;

public class ScreenSchSeatVO {
	private String screen_sch_code;	// 상영일정코드
	private String seat_code;		// 좌석코드
	private String seat_status;		// 좌석상태

	public ScreenSchSeatVO() {
		
	}

	public ScreenSchSeatVO(String screen_sch_code, String seat_code, String seat_status) {
		this.screen_sch_code = screen_sch_code;
		this.seat_code = seat_code;
		this.seat_status = seat_status;
	}

	public String getScreen_sch_code() {
		return screen_sch_code;
	}

	public String getSeat_code() {
		return seat_code;
	}

	public String getSeat_status() {
		return seat_status;
	}

	@Override
	public String toString() {
		return "ScreenSchSeatVO [screen_sch_code=" + screen_sch_code + ", seat_code=" + seat_code + ", seat_status="
				+ seat_status + "]";
	}
	
	
}
