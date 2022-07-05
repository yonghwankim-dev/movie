package kr.com.yh.lotte.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 상영관 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterVO {
	private String theater_code;	// 상영관코드
	private String name;			// 이름
	private String cinema_code;		// 영화관코드		
}
