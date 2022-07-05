package kr.com.yh.lotte.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 상영 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenVO {
	private String screen_code;		// 상영코드
	private String movie_code;		// 영화코드
	private String theater_code;	// 상영관코드
	private Date start_date;		// 시작일자
	private Date end_date;			// 종료일자
		
}
