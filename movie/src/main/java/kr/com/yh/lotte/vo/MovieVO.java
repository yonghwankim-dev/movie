package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 영화 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-03-16
 */
public class MovieVO {
	private String movie_code;		// 영화코드
	private String movie_title;		// 영화제목
	private int    movie_spectator;	// 영화관람가
	
	public MovieVO() {
		
	}
	
	public MovieVO(Builder builder) {
		this.movie_code = builder.movie_code;
		this.movie_title = builder.movie_title;
		this.movie_spectator = builder.movie_spectator;
	}
	
	public static class Builder{
		private String movie_code;		// 영화코드
		private String movie_title;		// 영화제목
		private int movie_spectator;	// 영화관람가
		
		public Builder(String movie_code) {
			this.movie_code = movie_code;
		}
		
		public Builder movie_title(String movie_title) {
			this.movie_title = movie_title;
			return this;
		}
		
		public Builder movie_spectator(int movie_spectator) {
			this.movie_spectator = movie_spectator;
			return this;
		}
		
		public MovieVO build() {
			return new MovieVO(this);
		}
	}
	
	public String getMovie_code() {
		return movie_code;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public int getMovie_spectator() {
		return movie_spectator;
	}

	@Override
	public String toString() {
		return "MovieVO [movie_code=" + movie_code + ", movie_title=" + movie_title + ", movie_spectator="
				+ movie_spectator + "]";
	}
	
	
}
