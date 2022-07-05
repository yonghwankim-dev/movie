package kr.com.yh.lotte.vo.component;

import java.sql.Date;

import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TheaterVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenAdminVO {
	private ScreenVO screen;
	private MovieVO movie;
	private TheaterVO theater;
	private CinemaVO cinema;	
}
