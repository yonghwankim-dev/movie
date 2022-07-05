package kr.com.yh.lotte.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenSchSeatVO {
	private String screen_sch_code;	// 상영일정코드
	private String seat_code;		// 좌석코드
	private String seat_status;		// 좌석상태
}
