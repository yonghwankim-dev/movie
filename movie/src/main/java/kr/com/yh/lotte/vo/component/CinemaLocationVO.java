package kr.com.yh.lotte.vo.component;

import kr.com.yh.lotte.vo.CinemaVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaLocationVO {
	private CinemaVO cinemaVO;		// 영화관 객체
	private int		 cinema_cnt;	// 지역내 영화지점수	
}
