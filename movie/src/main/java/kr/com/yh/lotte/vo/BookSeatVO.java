package kr.com.yh.lotte.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 예약된 좌석의 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookSeatVO {
	private String book_code;	// 예약코드
	private String seat_code;	// 좌석코드	
}
