package kr.com.yh.lotte.service.screensch;

import java.util.List;

import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;

public interface IScreenSchService {

	/**
	 * 다음 상영일정코드를 참조
	 */
	public String getNextScreenSchCode();
	
	/**
	 * 각각의 영화상영일정의 예약좌석수를 탐색
	 * @param screenSchs 상영일정 리스트
	 * @return 상영일정 리스트 
	 */
	public List<MovieScreenSchVO> findBookSeatCnt(List<MovieScreenSchVO> screenSchs);
}
