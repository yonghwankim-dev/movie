package kr.com.yh.lotte.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 영화관 정보를 다음 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaVO {
	private String cinema_code;		// 영화관 코드
	private String name;			// 영화관 이름
	private String loc;				// 영화관 지역
}
