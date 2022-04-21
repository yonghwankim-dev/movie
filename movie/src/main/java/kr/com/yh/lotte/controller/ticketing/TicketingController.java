package kr.com.yh.lotte.controller.ticketing;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.com.yh.lotte.vo.wrapper.CinemaLocationVO;
import kr.com.yh.lotte.vo.wrapper.ScreenDateVO;

@WebServlet("/ticketing/ticketing.do")
public class TicketingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ITicketingService ticketingService;
	
	public TicketingController() {
		ticketingService = TicketingServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm 		= "ticketing"; 						// 매칭되는 jsp 파일명(확장자 제외)
		String cinema_name 	= req.getParameter("cinema_name");	// 선택한 영화관 지점
		String movie_title 	= req.getParameter("movie_title");	// 선택한 영화
		String screen_date 	= req.getParameter("screen_date");	// 선택한 일자
		
		screen_date = screen_date==null ? LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) 
										: screen_date;	// 오늘 or 선택한 일자
		
		List<CinemaLocationVO> locations = ticketingService.getLocationList();		
		List<CinemaVO> cinemas = ticketingService.getCinemaList();		
		List<MovieVO> movies = ticketingService.getMoviesByCinemaNameAndMovieTitle(cinema_name, movie_title);
		
		// 선택한 영화관에 모든 영화 상영일정 리스트 반환
		List<ScreenDateVO> screens = ticketingService.findAllScreenListByCinemaName(cinema_name, movie_title, screen_date);	
		
		req.setAttribute("locations", locations);
		req.setAttribute("cinemas", cinemas);
		req.setAttribute("movies", movies);
		req.setAttribute("screens", screens);
		req.setAttribute("cinema_name", cinema_name);
		req.setAttribute("movie_title", movie_title);
		req.setAttribute("screen_date", screen_date);
		req.setAttribute("fileNm", fileNm);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
