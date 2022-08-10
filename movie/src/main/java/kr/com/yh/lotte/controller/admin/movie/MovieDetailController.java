package kr.com.yh.lotte.controller.admin.movie;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MovieHomeController", urlPatterns = UrlPaths.MOVIE_HOME)
public class MovieDetailController extends HttpServlet {

    private IMovieService movieService;

    public MovieDetailController(){
        movieService = MovieServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
