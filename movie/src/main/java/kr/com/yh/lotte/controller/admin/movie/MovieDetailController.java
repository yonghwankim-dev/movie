package kr.com.yh.lotte.controller.admin.movie;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MovieDetailController", urlPatterns = UrlPaths.MOVIE_DETAIL)
public class MovieDetailController extends HttpServlet {

    private IMovieService movieService;

    public MovieDetailController(){
        movieService = MovieServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileNm     = "admin/movie/movieDetail";
        String movie_code = req.getParameter("movie_code");

        MovieVO movie = movieService.findOne(movie_code);

        req.setAttribute("movie", movie);
        req.setAttribute("fileNm", fileNm);
        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }
}
