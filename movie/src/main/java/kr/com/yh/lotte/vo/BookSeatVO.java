package kr.com.yh.lotte.vo;

/**
 * Class Description
 * 예약된 좌석의 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class BookSeatVO {
	private String book_code;	// 예약코드
	private String seat_code;	// 좌석코드
	
	public BookSeatVO() {
		
	}
	
	public BookSeatVO(String book_code, String seat_code) {
		this.book_code = book_code;
		this.seat_code = seat_code;
	}

	public String getBook_code() {
		return book_code;
	}
	
	public String getSeat_code() {
		return seat_code;
	}

	@Override
	public String toString() {
		return "BookSeatVO [book_code=" + book_code + ", seat_code=" + seat_code + "]";
	}
	
	
}
