package kr.com.yh.lotte.controller.ticketing;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.service.screensch.IScreenSchService;
import kr.com.yh.lotte.service.screensch.ScreenSchServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "TicketingController", urlPatterns = {UrlPaths.TICKET})
public class TicketingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ITicketingService ticketingService;
	private ICinemaService cinemaService;
	private IScreenSchService screenSchService;
	
	public TicketingController() {
		ticketingService = TicketingServiceImpl.getInstance();
		cinemaService = CinemaServiceImpl.getInstance();
		screenSchService = ScreenSchServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm 		= "ticket/ticketing"; 				// 매칭되는 jsp 파일명(확장자 제외)
		String loc          = req.getParameter("loc");			// 선택한 지역
		String cinema_name 	= req.getParameter("cinema_name");	// 선택한 영화관 지점
		String movie_name 	= req.getParameter("movie_name");	// 선택한 영화
		String screen_date 	= req.getParameter("screenDate");	// 선택한 일자
	
		
		screen_date = screen_date == null ? LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) 
										  : screen_date;	// 오늘 or 선택한 일자
		
		List<CinemaLocationVO> locations = cinemaService.getLocationList();
		
		// 지역 기본값 설정
		loc = loc == null ? locations.get(0).getCinemaVO().getLoc() : loc;
		
		List<CinemaVO> cinemas = cinemaService.getCinemaList(loc);		
		List<MovieVO> movies = ticketingService.getMoviesByCinemaName(cinema_name);
		
		// 선택한 영화관에 모든 영화 상영일정 리스트 반환
		List<MovieScreenSchVO> screenSchs = ticketingService.findAllMovieScreenSch(cinema_name, movie_name, screen_date);
		screenSchs = screenSchService.findBookSeatCnt(screenSchs);

		req.setAttribute("locations", locations);
		req.setAttribute("cinemas", cinemas);
		req.setAttribute("loc", loc);
		req.setAttribute("movies", movies);
		req.setAttribute("screenSchs", screenSchs);
		req.setAttribute("cinema_name", cinema_name);
		req.setAttribute("movie_name", movie_name);
		req.setAttribute("screen_date", screen_date);
		req.setAttribute("fileNm", fileNm);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
