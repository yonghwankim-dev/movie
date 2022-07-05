package kr.com.yh.lotte.vo.component;

import java.sql.Date;

import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.TheaterVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieScreenSchVO {
	private ScreenSchVO screenSch;
	private MovieVO movie;
	private TheaterVO theater;
	private CinemaVO cinema;
	private int theater_seat_cnt;	// 상영관 좌석수
	private int book_seat_cnt;		// 예약된 좌석수

}
