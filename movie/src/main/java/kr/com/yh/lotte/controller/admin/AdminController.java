package kr.com.yh.lotte.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/admin/admin.do")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	private ICinemaService cinemaService;
	private IMovieService movieService;
	
	public AdminController() {
		adminService = AdminServiceImpl.getInstance();
		cinemaService = CinemaServiceImpl.getInstance();
		movieService = MovieServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "admin/screenAdmin"; // 매칭되는 jsp 파일명(확장자 제외)
		
		List<ScreenAdminVO> screenAdmin = adminService.getAllScreenAdmin(); 
		List<CinemaVO> cinemas = cinemaService.getCinemaList();
		List<MovieVO> movies = movieService.getMovie();
		List<CinemaLocationVO> locs = cinemaService.getLocationList();
		
		req.setAttribute("screenAdmin", screenAdmin);
		req.setAttribute("cinemas", cinemas);
		req.setAttribute("movies", movies);
		req.setAttribute("locs", locs);
		req.setAttribute("fileNm", fileNm);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
