package kr.com.yh.lotte.vo;

import java.sql.Date;

/**
 * Class Description
 * 예매 정보를 담은 클래스
 * 
 * @author 김용환
 * @version 1.0.0
 * @date 2022-04-12
 */
public class TicketingVO {
	private int 	ticket_num;		// 예매번호
	private Date 	ticket_date;	// 예매일자
	private int 	ticket_cnt;		// 예매개수
	private int		ticket_price;	// 예매가격
	private String	mem_code;		// 회원코드
	private String	screen_code;	// 상영코드
	
	public TicketingVO() {
		
	}
	
	public TicketingVO(int ticket_num, Date ticket_date, int ticket_cnt, int ticket_price, String mem_code,
			String screen_code) {
		this.ticket_num = ticket_num;
		this.ticket_date = ticket_date;
		this.ticket_cnt = ticket_cnt;
		this.ticket_price = ticket_price;
		this.mem_code = mem_code;
		this.screen_code = screen_code;
	}

	public int getTicket_num() {
		return ticket_num;
	}

	public Date getTicket_date() {
		return ticket_date;
	}

	public int getTicket_cnt() {
		return ticket_cnt;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public String getMem_code() {
		return mem_code;
	}

	public String getScreen_code() {
		return screen_code;
	}
	
}
