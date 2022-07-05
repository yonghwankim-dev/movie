package kr.com.yh.lotte.controller.ticketing.orderSettlement;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.service.screensch.IScreenSchService;
import kr.com.yh.lotte.service.screensch.ScreenSchServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.SeatVO;
import kr.com.yh.lotte.vo.TheaterVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.CinemaTheaterVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/ticketing/orderSettlement")
public class OrderSettlementController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String fileNm = "ticket/orderSettlement"; // 매칭되는 jsp 파일명(확장자 제외)

		String movie_name   = req.getParameter("movie_name");
		Date screen_date    = Date.valueOf(req.getParameter("book_date"));
		String start_time   = req.getParameter("start_time");
		String end_time     = req.getParameter("end_time");
		String cinema_name  = req.getParameter("cinema_name");
		String theater_name = req.getParameter("theater_name");
		int teenager        = Integer.parseInt(req.getParameter("person_10"));
		int adult           = Integer.parseInt(req.getParameter("person_20"));
		int senior          = Integer.parseInt(req.getParameter("person_12"));
		int total_price     = Integer.parseInt(req.getParameter("total_price"));
		String[] seat       = req.getParameter("seat").split(" ");
		
		
		MovieVO movie = MovieVO.builder()
                               .name(movie_name)
                               .build();
		
		ScreenSchVO screenSch = ScreenSchVO.builder()
                                           .screen_date(screen_date)
                                           .start_time(start_time)
                                           .end_time(end_time)
                                           .build();
		
		CinemaVO cinema = CinemaVO.builder()
                                  .name(cinema_name)
                                  .build();
		
		TheaterVO theater = TheaterVO.builder()
				                     .name(theater_name)
				                     .build();
		
		BookVO book = BookVO.builder()
				            .teenager(teenager)
				            .adult(adult)
				            .senior(senior)
				            .total_price(total_price)
				            .build();
		
		List<SeatVO> seats = new ArrayList<SeatVO>();
		for(String s : seat) {
			seats.add(SeatVO.builder()
					        .seat_row(String.valueOf(s.charAt(0)))
					        .seat_col(Integer.parseInt(String.valueOf(s.charAt(1))))
					        .build()); 
		}
		
		req.setAttribute("movie",     movie);
		req.setAttribute("screenSch", screenSch);
		req.setAttribute("cinema",    cinema);
		req.setAttribute("theater",   theater);
		req.setAttribute("book",      book);
		req.setAttribute("seats",     seats);		
		req.setAttribute("fileNm", fileNm);

		System.out.println(cinema);
		System.out.println(theater);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
