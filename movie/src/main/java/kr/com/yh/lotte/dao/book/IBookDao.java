package kr.com.yh.lotte.dao.book;

import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.SeatVO;
import kr.com.yh.lotte.vo.component.PaymentResultVO;

import java.util.List;

public interface IBookDao {
	/**
	 * 다음 예약코드를 참조
	 * @return 다음 예약코드
	 */
	String getNextBookCode();
	
	/**
	 * 예약 정보를 입력
	 * @param book 예약정보 객체
	 * @return 삽입된 레코드 수
	 */
	int insertBook(BookVO book);
	
	/**
	 * 예약좌석 정보 입력
	 * @param bookSeatList 예약좌석 리스트
	 * @return 삽입된 레코드 수
	 */
	int insertBookSeat(List<BookSeatVO> bookSeatList);
	
	/**
	 * 상영일정좌석 정보를 예약(R)으로 변경
	 * @param screenSchSeatList 상영일정좌석 리스트
	 * @return 변경된 레코드 수
	 */
	int updateScreenSchSeatToBook(List<ScreenSchSeatVO> screenSchSeatList);
	
	/**
	 * 한개의 예약(book)에 대해서 여러 좌석을 예약하고 상태를 변경함
	 * 1. 예약 정보 입력
	 * 2. 예약 좌석 정보 입력
	 * 3. 상영 일정 좌석 정보 변경
	 * @param book 예약정보
	 * @param bookSeatList 예약좌석정보 
	 * @param screenSchSeatList 상영일정에 따른 좌석 정보
	 * @return 서비스가 완료되면 1 반환
	 */
	int bookSeat(BookVO book
					  , List<BookSeatVO> bookSeatList
					  , List<ScreenSchSeatVO> screenSchSeatList);
	/**
	 * 영화표 결제를 성공하였을때 결제 결과 정보를 가져옵니다.
	 * @param book_code 예약 코드
	 */
    PaymentResultVO getPaymentResultInfo(String book_code);

	/**
	 * 예약 코드에 따른 결제 정보의 좌석 정보를 가져옵니다.
	 * @param book_code 예약코드
	 * @return 좌석 리스트
	 */
    List<SeatVO> getPaymentResultSeatsInfo(String book_code);
}
