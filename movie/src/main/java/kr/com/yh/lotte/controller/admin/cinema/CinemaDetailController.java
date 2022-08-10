package kr.com.yh.lotte.controller.admin.cinema;

import kr.com.yh.lotte.UrlPaths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CinemaDetailController", urlPatterns = UrlPaths.CINEMA_DETAIL)
public class CinemaDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
