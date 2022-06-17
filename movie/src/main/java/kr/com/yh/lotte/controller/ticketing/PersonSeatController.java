package kr.com.yh.lotte.controller.ticketing;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.com.yh.lotte.service.seat.ISeatService;
import kr.com.yh.lotte.service.seat.SeatServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.MovieInfoVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchSeatVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/personSeat.do")
public class PersonSeatController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ITicketingService ticketingService;
	private ISeatService seatService;
	
	public PersonSeatController() {
		ticketingService = TicketingServiceImpl.getInstance();
		seatService = SeatServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "personSeat"; // 매칭되는 jsp 파일명(확장자 제외)
		String screen_sch_code = req.getParameter("screen_sch_code");
		
		// 상영코드에 대한 영화정보 가져오기
		MovieScreenSchVO screenSch = ticketingService.findAllMovieScreenSch(screen_sch_code);
		List<MovieScreenSchSeatVO> seats = seatService.findAllMovieScreenSchSeat(screenSch.getScreenSch().getScreen_sch_code());
				
		req.setAttribute("screen_sch_code", screen_sch_code);
		req.setAttribute("screenSch", screenSch);
		req.setAttribute("seats", seats);
		req.setAttribute("fileNm", fileNm);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
