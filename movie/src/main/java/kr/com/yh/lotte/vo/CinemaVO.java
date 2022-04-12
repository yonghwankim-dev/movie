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
	private String cinema_name;		// 영화관 이름
	private String cinema_location;	// 영화관 지역
	
	public CinemaVO() {
		
	}

	public CinemaVO(Builder builder) {
		this.cinema_code = builder.cinema_code;
		this.cinema_name = builder.cinema_name;
		this.cinema_location = builder.cinema_location;
	}
	
	public static class Builder{
		private String cinema_code;		// 영화관 코드
		private String cinema_name;		// 영화관 이름
		private String cinema_location;	// 영화관 지역
		
		public Builder(String cinema_code) {
			this.cinema_code = cinema_code;
		}
		
		public Builder cinema_name(String cinema_name) {
			this.cinema_name = cinema_name;
			return this;
		}
		
		public Builder cinema_location(String cinema_location) {
			this.cinema_location = cinema_location;
			return this;
		}
		
		public CinemaVO build() {
			return new CinemaVO(this);
		}
	}
	
	public String getCinema_code() {
		return cinema_code;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public String getCinema_location() {
		return cinema_location;
	}

	@Override
	public String toString() {
		return "CinemaVO [cinema_code=" + cinema_code + ", cinema_name=" + cinema_name + ", cinema_location="
				+ cinema_location + "]";
	}
	
	
}
