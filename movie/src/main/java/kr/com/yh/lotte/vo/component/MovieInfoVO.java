package kr.com.yh.lotte.vo.component;

import java.sql.Date;
import java.sql.Timestamp;

import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TheaterVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description
 * 개인 좌석 선택 페이지에 대한 정보를 담은 페이지
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieInfoVO {
	private MovieVO 	movie;
	private ScreenVO  	screen;
	private CinemaVO	cinema;
	private TheaterVO	theater;
	private Timestamp	end_time;	// 영화 종료 시간	
}
