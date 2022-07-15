package kr.com.yh.lotte.dao.seat;

import kr.com.yh.lotte.vo.component.MovieScreenSchSeatVO;

import java.util.List;

/**
 * @title 좌석 서비스
 * @author 김용환
 * @date 2022-05-10
 * @version 1.0.0
 */
public interface ISeatDao {
	
	/**
	 * 상영관코드와 선택한 좌석들에 대한 좌석코드를 반환
	 * @param theater_code 상영관코드
	 * @return 좌석코드 리스트
	 */
	List<String> getSeatCodesBySeatNumAndTheaterCode(List<String> seatList, String theater_code);

	/**
	 * 상영일정 코드를 이용하여 해당 일정의 좌석정보를 탐색
	 * @param screen_sch_code 상영일정코드
	 * @return 영화상영일정좌석 리스트
	 */
	List<MovieScreenSchSeatVO> findAllMovieScreenSchSeat(String screen_sch_code);
}
