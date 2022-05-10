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

import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.MovieInfoVO;

@WebServlet("/personSeat.do")
public class PersonSeatController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ITicketingService ticketingService;
	
	public PersonSeatController() {
		ticketingService = TicketingServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "personSeat"; // 매칭되는 jsp 파일명(확장자 제외)
		String screen_code = req.getParameter("screen_code");
		
		// 상영코드에 대한 영화정보 가져오기
		MovieInfoVO movieInfo = ticketingService.getMovieInfoByScreenCode(screen_code);
		
		System.out.println(movieInfo);
		req.setAttribute("screen_code", screen_code);
		req.setAttribute("movieInfo", movieInfo);
		req.setAttribute("fileNm", fileNm);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
