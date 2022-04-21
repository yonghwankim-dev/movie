package kr.com.yh.lotte.vo;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Class Description
 * 상영 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-12
 */
public class ScreenVO {
	private String 		screen_code;  // 상영코드
	private Date 		screen_date;  // 상영일자
	private Timestamp 	screen_time;  // 상영시간
	private String 		movie_code;   // 영화코드
	private String 		theater_code; // 상영관코드
	
	public ScreenVO() {
		
	}
	
	public ScreenVO(String screen_code, Date screen_date, Timestamp screen_time, String movie_code,
			String theater_code) {
		this.screen_code = screen_code;
		this.screen_date = screen_date;
		this.screen_time = screen_time;
		this.movie_code = movie_code;
		this.theater_code = theater_code;
	}


	public String getScreen_code() {
		return screen_code;
	}

	public Date getScreen_date() {
		return screen_date;
	}

	public Timestamp getScreen_time() {
		return screen_time;
	}

	public String getMovie_code() {
		return movie_code;
	}

	public String getTheater_code() {
		return theater_code;
	}

	@Override
	public String toString() {
		return "ScreenVO [screen_code=" + screen_code + ", screen_date=" + screen_date + ", screen_time=" + screen_time
				+ ", movie_code=" + movie_code + ", theater_code=" + theater_code + "]";
	}
	
	
}
