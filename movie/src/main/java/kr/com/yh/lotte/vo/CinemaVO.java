package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 영화관 정보를 다음 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-12
 */
public class CinemaVO {
	private String cinema_code;		// 영화관 코드
	private String name;		// 영화관 이름
	private String loc;	// 영화관 지역
	
	public CinemaVO() {
		
	}

	public CinemaVO(String cinema_code, String name, String loc) {
		this.cinema_code = cinema_code;
		this.name = name;
		this.loc = loc;
	}

	public String getCinema_code() {
		return cinema_code;
	}

	public String getName() {
		return name;
	}

	public String getLoc() {
		return loc;
	}

	@Override
	public String toString() {
		return "CinemaVO [cinema_code=" + cinema_code + ", name=" + name + ", loc=" + loc + "]";
	}
		
}
