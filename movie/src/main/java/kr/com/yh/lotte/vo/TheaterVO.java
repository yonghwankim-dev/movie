package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 상영관의 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-12
 */
public class TheaterVO {
	private String theater_code;		// 상영관코드
	private String theater_name;		// 상영관이름	
	private int    theater_seat_num;	// 상영관좌석수
	private String cinema_code;			// 영화관코드
	
	public TheaterVO() {
		
	}	
	public TheaterVO(String theater_code, String theater_name, int theater_seat_num, String cinema_code) {
		this.theater_code = theater_code;
		this.theater_name = theater_name;
		this.theater_seat_num = theater_seat_num;
		this.cinema_code = cinema_code;
	}
	public String getTheater_code() {
		return theater_code;
	}
	public String getTheater_name() {
		return theater_name;
	}
	public int getTheater_seat_num() {
		return theater_seat_num;
	}
	public String getCinema_code() {
		return cinema_code;
	}
	
	
}
