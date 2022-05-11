package kr.com.yh.lotte.dao.seat;

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
	 * @param seats 사용자가 선택한 좌석 리스트
	 * @param theater_code 상영관코드
	 * @return 좌석코드 리스트
	 */
	public List<String> getSeatCodesBySeatNumAndTheaterCode(List<String> seatList, String theater_code);
}
