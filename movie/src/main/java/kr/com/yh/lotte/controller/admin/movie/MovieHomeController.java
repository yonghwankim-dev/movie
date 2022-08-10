package kr.com.yh.lotte.controller.admin.movie;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieSearchCategory;
import kr.com.yh.lotte.vo.MovieVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieHomeController", urlPatterns = UrlPaths.MOVIE_HOME)
public class MovieHomeController extends HttpServlet {

    private IMovieService movieService;

    public MovieHomeController(){
        movieService = MovieServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String content  = req.getParameter("content");
        category = category == null ? "NAME" : category;

        MovieSearch movieSearch = MovieSearch.builder()
                                             .movieSearchCategory(MovieSearchCategory.valueOf(category))
                                             .content(content)
                                             .build();

        List<MovieVO> movies = movieService.findAll(movieSearch);
        String fileNm = "admin/movie/movieHome";

        req.setAttribute("movies", movies);
        req.setAttribute("fileNm", fileNm);

        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }
}
