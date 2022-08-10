package kr.com.yh.lotte.vo;

import lombok.*;

/**
 * Class Description
 * 영화 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieVO {
	private String movie_code;	// 영화코드
	private String name;		// 영화제목
	private int    audi_rating;	// 관람등급
	private int    runtime;     // 상영시간
}
