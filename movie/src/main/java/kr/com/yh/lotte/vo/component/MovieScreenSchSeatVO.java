package kr.com.yh.lotte.vo.component;

import java.sql.Date;

import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.SeatVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieScreenSchSeatVO {
	private SeatVO seat;
	private ScreenSchSeatVO screenSchSeat;	
}
