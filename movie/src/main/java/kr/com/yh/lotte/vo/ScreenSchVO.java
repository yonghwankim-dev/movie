package kr.com.yh.lotte.vo;

import java.sql.Date;

/**
 * Class Description
 * 상영일정 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class ScreenSchVO {
	private String screen_sch_code;	// 상영일정코드
	private Date screen_date;		// 상영일자
	private String start_time;		// 시작시간
	private String end_time;		// 종료시간
	private int screen_num;			// 상영회차
	private String movie_code;		// 영화코드
	private String theater_code;	// 상영관코드
	private String screen_code;		// 상영코드
	
	public ScreenSchVO() {
		
	}

	public ScreenSchVO(String screen_sch_code, Date screen_date, String start_time, String end_time, int screen_num,
			String movie_code, String theater_code, String screen_code) {
		this.screen_sch_code = screen_sch_code;
		this.screen_date = screen_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.screen_num = screen_num;
		this.movie_code = movie_code;
		this.theater_code = theater_code;
		this.screen_code = screen_code;
	}

	public String getScreen_sch_code() {
		return screen_sch_code;
	}

	public Date getScreen_date() {
		return screen_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public int getScreen_num() {
		return screen_num;
	}

	public String getMovie_code() {
		return movie_code;
	}

	public String getTheater_code() {
		return theater_code;
	}

	public String getScreen_code() {
		return screen_code;
	}

	@Override
	public String toString() {
		return "ScreenSchVO [screen_sch_code=" + screen_sch_code + ", screen_date=" + screen_date + ", start_time="
				+ start_time + ", end_time=" + end_time + ", screen_num=" + screen_num + ", movie_code=" + movie_code
				+ ", theater_code=" + theater_code + ", screen_code=" + screen_code + "]";
	}

}
