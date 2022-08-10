package kr.com.yh.lotte.controller.admin.movie;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MovieModifyController", urlPatterns = UrlPaths.MOVIE_MODIFY)
public class MovieModifyController extends HttpServlet {

    private IMovieService movieService;

    public MovieModifyController(){
        movieService = MovieServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileNm = "admin/movie/movieModify";
        String movie_code = req.getParameter("movie_code");

        MovieVO movie = movieService.findOne(movie_code);

        req.setAttribute("movie", movie);
        req.setAttribute("fileNm", fileNm);
        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AjaxResponse ajaxResponse = new AjaxResponse(resp);
        String movie_code = req.getParameter("movie_code");
        String name       = req.getParameter("name");
        int audi_rating   = Integer.parseInt(req.getParameter("audi_rating"));
        int runtime       = Integer.parseInt(req.getParameter("runtime"));

        MovieVO movie = MovieVO.builder()
                               .movie_code(movie_code)
                               .name(name)
                               .audi_rating(audi_rating)
                               .runtime(runtime)
                               .build();

        int cnt = movieService.modifyOne(movie);

        if(cnt > 0){
            ajaxResponse.addToResMap("code", "ok");
        }else{
            ajaxResponse.addToResMap("code", "no");
        }
        ajaxResponse.write();
    }
}
