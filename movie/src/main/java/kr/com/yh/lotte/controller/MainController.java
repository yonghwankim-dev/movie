package kr.com.yh.lotte.controller;

import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = {"/main.do"})
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IMovieService movieService;
	
	public MainController() {
		movieService = MovieServiceImpl.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MovieVO> movieList = movieService.getMovieMain();

		System.out.println("hello main.do");

		req.setAttribute("movieList", movieList);
		req.getRequestDispatcher("/view/main.jsp").forward(req, resp);
	}
}
