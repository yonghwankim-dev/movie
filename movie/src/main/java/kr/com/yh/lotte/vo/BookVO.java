package kr.com.yh.lotte.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 예약 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVO {
	private String book_code;	    // 예약코드
	private int total_price;	    // 총가격
	private int teenager;		    // 청소년 인원수
	private int adult;			    // 성인 인원수
	private int senior;				// 노약자 인원수
	private Date book_date;			// 에약일자
	private String screen_sch_code;	// 상영일정코드
	private String mem_code;		// 회원코드	
}
