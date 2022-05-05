package kr.com.yh.lotte.vo;

import java.sql.Date;

/**
 * Class Description
 * 상영 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class ScreenVO {
	private String movie_code;		// 영화코드
	private String theater_code;	// 상영관코드
	private Date start_date;		// 시작일자
	private Date end_date;			// 종료일자
	
	public ScreenVO() {
		
	}
	
	public ScreenVO(String movie_code, String theater_code, Date start_date, Date end_date) {
		this.movie_code = movie_code;
		this.theater_code = theater_code;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getMovie_code() {
		return movie_code;
	}

	public String getTheater_code() {
		return theater_code;
	}

	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	@Override
	public String toString() {
		return "ScreenVO [movie_code=" + movie_code + ", theater_code=" + theater_code + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}	
}
