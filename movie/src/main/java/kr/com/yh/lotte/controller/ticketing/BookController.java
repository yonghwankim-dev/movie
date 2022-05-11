package kr.com.yh.lotte.controller.ticketing;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.com.yh.lotte.service.book.BookServiceImpl;
import kr.com.yh.lotte.service.book.IBookService;
import kr.com.yh.lotte.service.seat.ISeatService;
import kr.com.yh.lotte.service.seat.SeatServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/bookSeat.do")
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ITicketingService ticketingService;
	private ISeatService seatService;
	private IBookService bookService;
	
	public BookController() {
		ticketingService = TicketingServiceImpl.getInstance();
		seatService = SeatServiceImpl.getInstance();
		bookService = BookServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String book_code	   = null;
		Date   book_date 	   = Date.valueOf(req.getParameter("book_date"));		// 예약일자
		int    teenager        = Integer.parseInt(req.getParameter("person_10"));	// 청소년 인원수
		int    adult           = Integer.parseInt(req.getParameter("person_20"));	// 성인 인원수
		int    senior          = Integer.parseInt(req.getParameter("person_12"));	// 노약자 인원수
		int    total_price     = Integer.parseInt(req.getParameter("price"));		// 예매가격
		String mem_code 	   = req.getParameter("mem_code");						// 회원코드
		String screen_sch_code = req.getParameter("screen_sch_code");				// 상영코드
		String theater_code    = req.getParameter("theater_code");					// 상영관코드
		String[] seats         = req.getParameter("seat").split(" ");			    // 예매 좌석들
		List<String> seatList = Arrays.asList(seats);
		List<String> seatCodes = null;
		List<BookSeatVO> bookSeatList = new ArrayList<BookSeatVO>();
		List<ScreenSchSeatVO> screenSchSeatList = new ArrayList<ScreenSchSeatVO>();
		
		// 실행 결과
		UpdateResult result = new UpdateResult(resp);
		int cnt = 0;
		
		// 좌석코드 참조
		seatCodes = seatService.getSeatCodesBySeatNumAndTheaterCode(seatList, theater_code); 
		// 예약코드 생성
		book_code = bookService.getNextBookCode();
		
		BookVO book = new BookVO(book_code
							   , total_price 
							   , teenager
							   , adult
							   , senior
							   , book_date
							   , screen_sch_code
							   , mem_code);

		for(String seat_code : seatCodes) {
			bookSeatList.add(new BookSeatVO(book_code, seat_code));
			screenSchSeatList.add(new ScreenSchSeatVO(screen_sch_code, seat_code, "R"));
		}
		
		cnt = bookService.bookSeat(book, bookSeatList, screenSchSeatList);
//		
//		if(cnt>0)
//		{
//			result.addToResMap("code", "ok");
//		}
//		else
//		{
//			result.addToResMap("code", "no");
//		}
//		
//		result.write();
	}
}
