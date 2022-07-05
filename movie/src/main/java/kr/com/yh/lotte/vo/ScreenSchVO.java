package kr.com.yh.lotte.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 상영일정 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenSchVO {
	private String screen_sch_code;	// 상영일정코드
	private Date screen_date;		// 상영일자
	private String start_time;		// 시작시간
	private String end_time;		// 종료시간
	private int screen_num;			// 상영회차
	private String movie_code;		// 영화코드
	private String theater_code;	// 상영관코드
	private String screen_code;		// 상영코드

}
