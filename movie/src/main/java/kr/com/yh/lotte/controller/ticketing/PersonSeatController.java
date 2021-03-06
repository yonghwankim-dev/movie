package kr.com.yh.lotte.controller.ticketing;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.seat.ISeatService;
import kr.com.yh.lotte.service.seat.SeatServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.component.MovieScreenSchSeatVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PersonSeatController", urlPatterns = {UrlPaths.PERSON_SEAT})
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
		String fileNm = "ticket/personSeat"; // 매칭되는 jsp 파일명(확장자 제외)
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
