package kr.com.yh.lotte.controller.admin.screen;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "screenHomeController", urlPatterns = UrlPaths.SCREEN_HOME)
public class ScreenHomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	private ICinemaService cinemaService;
	private IMovieService movieService;
	
	public ScreenHomeController() {
		adminService = AdminServiceImpl.getInstance();
		cinemaService = CinemaServiceImpl.getInstance();
		movieService = MovieServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "admin/screen/screenHome"; // 매칭되는 jsp 파일명(확장자 제외)
		MovieSearch movieSearch = new MovieSearch();
		List<ScreenAdminVO> screenAdmin = adminService.getAllScreenAdmin(); 
		List<CinemaVO> cinemas = cinemaService.getCinemaList(null);
		List<MovieVO> movies = movieService.findAll(movieSearch);
		List<CinemaLocationVO> locs = cinemaService.getLocationList();
		
		req.setAttribute("screenAdmin", screenAdmin);
		req.setAttribute("cinemas", cinemas);
		req.setAttribute("movies", movies);
		req.setAttribute("locs", locs);
		req.setAttribute("fileNm", fileNm);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
