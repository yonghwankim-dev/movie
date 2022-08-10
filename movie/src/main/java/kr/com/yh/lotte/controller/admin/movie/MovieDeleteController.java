package kr.com.yh.lotte.controller.admin.movie;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MovieDeleteController", urlPatterns = UrlPaths.MOVIE_DELETE)
public class MovieDeleteController extends HttpServlet {

    private IMovieService movieService;

    public MovieDeleteController(){
        movieService = MovieServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> movie_codes = Arrays.asList(req.getParameterValues("movie_code"));
        AjaxResponse ajaxResponse = new AjaxResponse(resp);

        int cnt = movieService.deleteAll(movie_codes);

        if(cnt > 0){
            ajaxResponse.addToResMap("code", "ok");
        }else{
            ajaxResponse.addToResMap("code", "no");
        }

        ajaxResponse.write();
    }
}
