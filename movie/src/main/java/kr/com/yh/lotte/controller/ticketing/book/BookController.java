package kr.com.yh.lotte.controller.ticketing.book;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.book.BookServiceImpl;
import kr.com.yh.lotte.service.book.IBookService;
import kr.com.yh.lotte.service.seat.ISeatService;
import kr.com.yh.lotte.service.seat.SeatServiceImpl;
import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "BookController", urlPatterns = {UrlPaths.BOOK})
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ISeatService seatService;
	private IBookService bookService;
	
	public BookController() {
		seatService = SeatServiceImpl.getInstance();
		bookService = BookServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String book_code	   = req.getParameter("book_code");                     // 예약코드
		int    total_price     = Integer.parseInt(req.getParameter("total_price"));	// 총가격
		int    teenager        = Integer.parseInt(req.getParameter("teenager"));	// 청소년 인원수
		int    adult           = Integer.parseInt(req.getParameter("adult"));	    // 성인 인원수
		int    senior          = Integer.parseInt(req.getParameter("senior"));	    // 노약자 인원수
		Date   book_date 	   = Date.valueOf(req.getParameter("book_date"));		// 예약일자
		String screen_sch_code = req.getParameter("screen_sch_code");				// 상영일정코드
		String mem_code 	   = (String) req.getParameter("mem_code");				// 회원코드
		
		String theater_code    = req.getParameter("theater_code");					// 상영관코드
		String[] seats         = req.getParameter("seats").split(" ");	            // 예매 좌석들
		
		List<String> seatList = Arrays.asList(seats);
		List<String> seatCodes = null;
		List<BookSeatVO> bookSeatList = new ArrayList<BookSeatVO>();
		List<ScreenSchSeatVO> screenSchSeatList = new ArrayList<ScreenSchSeatVO>();
		
		// 실행 결과
		AjaxResponse result = new AjaxResponse(resp);
		int cnt = 0;
				
		// 좌석코드 참조
		seatCodes = seatService.getSeatCodesBySeatNumAndTheaterCode(seatList, theater_code);
		
		BookVO book = BookVO.builder()
				            .book_code(book_code)
				            .total_price(total_price)
				            .teenager(teenager)
				            .adult(adult)
				            .senior(senior)
				            .book_date(book_date)
				            .screen_sch_code(screen_sch_code)
				            .mem_code(mem_code)
				            .build();

		for(String seat_code : seatCodes) {
			bookSeatList.add(BookSeatVO.builder()
					                   .book_code(book_code)
					                   .seat_code(seat_code)
					                   .build());
			screenSchSeatList.add(ScreenSchSeatVO.builder()
					                             .screen_sch_code(screen_sch_code)
					                             .seat_code(seat_code)
					                             .seat_status("R")
					                             .build());
		}
		
		cnt = bookService.bookSeat(book, bookSeatList, screenSchSeatList);
		
		if(cnt>0)
		{
			result.addToResMap("code", "ok");
		}
		else
		{
			result.addToResMap("code", "no");
		}
		
		result.write();
	}
}
