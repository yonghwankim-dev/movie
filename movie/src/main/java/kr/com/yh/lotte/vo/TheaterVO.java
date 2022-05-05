package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 상영관 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class TheaterVO {
	private String theater_code;	// 상영관코드
	private String name;			// 이름
	private String cinema_code;		// 영화관코드
	
	public TheaterVO() {
		
	}

	public TheaterVO(String theater_code, String name, String cinema_code) {
		this.theater_code = theater_code;
		this.name = name;
		this.cinema_code = cinema_code;
	}

	public String getTheater_code() {
		return theater_code;
	}

	public String getName() {
		return name;
	}

	public String getCinema_code() {
		return cinema_code;
	}

	@Override
	public String toString() {
		return "TheaterVO [theater_code=" + theater_code + ", name=" + name + ", cinema_code=" + cinema_code + "]";
	}
		
}
