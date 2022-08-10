package kr.com.yh.lotte.controller.admin.cinema;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.vo.CinemaSearch;
import kr.com.yh.lotte.vo.CinemaVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CinemaHomeController", urlPatterns = UrlPaths.CINEMA_HOME)
public class CinemaHomeController extends HttpServlet {

    private ICinemaService cinemaService;

    public CinemaHomeController() {
        this.cinemaService = CinemaServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileNm = "admin/cinema/cinemaHome";
        String category = req.getParameter("category");
        String content  = req.getParameter("content");
        String loc      = req.getParameter("loc");

        CinemaSearch cinemaSearch = CinemaSearch.createCinemaSearch(content, category, loc);

        List<String> locations = cinemaService.findAllLocation();
        List<CinemaVO> cinemas = cinemaService.findAll(cinemaSearch);

        req.setAttribute("locations", locations);
        req.setAttribute("cinemas", cinemas);
        req.setAttribute("fileNm", fileNm);
        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }
}
