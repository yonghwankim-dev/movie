package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 영화 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class MovieVO {
	private String movie_code;	// 영화코드
	private String name;		// 영화제목
	private int    audi_rating;	// 관람등급
	
	public MovieVO() {
		
	}
	
	public MovieVO(String movie_code, String name, int audi_rating) {
		this.movie_code = movie_code;
		this.name = name;
		this.audi_rating = audi_rating;
	}

	public String getMovie_code() {
		return movie_code;
	}

	public String getName() {
		return name;
	}

	public int getAudi_rating() {
		return audi_rating;
	}

	@Override
	public String toString() {
		return "MovieVO [movie_code=" + movie_code + ", name=" + name + ", audi_rating=" + audi_rating + "]";
	}
	
}
