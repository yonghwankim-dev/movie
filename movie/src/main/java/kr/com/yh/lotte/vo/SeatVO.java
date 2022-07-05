package kr.com.yh.lotte.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 좌석 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatVO {
	private String seat_code;		// 좌석코드
	private String seat_row;		// 좌석행
	private int seat_col;			// 좌석열
	private String theater_code;	// 상영관코드
}
