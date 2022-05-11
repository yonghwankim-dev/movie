package kr.com.yh.lotte.vo;

import java.sql.Date;

/**
 * Class Description
 * 예약 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-05-05
 */
public class BookVO {
	private String book_code;	// 예약코드
	private int total_price;	// 총가격
	private int teenager;		// 청소년 인원수
	private int adult;			// 성인 인원수
	private int senior;			// 노약자 인원수
	private Date book_date;		// 에약일자
	private String screen_sch_code;	// 상영일정코드
	private String mem_code;		// 회원코드
	
	
	public BookVO() {
		
	}

	public BookVO(String book_code, int total_price, int teenager, int adult, int senior, Date book_date,
			String screen_sch_code, String mem_code) {
		this.book_code = book_code;
		this.total_price = total_price;
		this.teenager = teenager;
		this.adult = adult;
		this.senior = senior;
		this.book_date = book_date;
		this.screen_sch_code = screen_sch_code;
		this.mem_code = mem_code;
	}

	public String getBook_code() {
		return book_code;
	}

	public int getTotal_price() {
		return total_price;
	}

	public int getTeenager() {
		return teenager;
	}

	public int getAdult() {
		return adult;
	}

	public int getSenior() {
		return senior;
	}

	public Date getBook_date() {
		return book_date;
	}

	public String getScreen_sch_code() {
		return screen_sch_code;
	}

	public String getMem_code() {
		return mem_code;
	}

	@Override
	public String toString() {
		return "BookVO [book_code=" + book_code + ", total_price=" + total_price + ", teenager=" + teenager + ", adult="
				+ adult + ", senior=" + senior + ", book_date=" + book_date + ", screen_sch_code=" + screen_sch_code
				+ ", mem_code=" + mem_code + "]";
	}
	
	
}
