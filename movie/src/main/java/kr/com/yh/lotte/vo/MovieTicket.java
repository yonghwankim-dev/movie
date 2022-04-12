package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 영화표에 대한 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-12
 */
public class MovieTicket {
	private String screen_code;	// 상영코드
	private String seat_code;	// 좌석코드
	private String mt_status;	// 영화표상태
	
	public MovieTicket() {
		
	}
	public MovieTicket(String screen_code, String seat_code, String mt_status) {
		this.screen_code = screen_code;
		this.seat_code = seat_code;
		this.mt_status = mt_status;
	}
	public String getScreen_code() {
		return screen_code;
	}
	public String getSeat_code() {
		return seat_code;
	}
	public String getMt_status() {
		return mt_status;
	}
	
	
}	
