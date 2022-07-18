package kr.com.yh.lotte.controller.signin;

import kr.com.yh.lotte.UrlPaths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = {UrlPaths.LOGOUT})
public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String fileNm = "/signin/logout"; // 매칭되는 jsp 파일명(확장자 제외)

		if(req.isRequestedSessionIdValid()) {
			session.invalidate();
			req.setAttribute("fileNm", fileNm);
			req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
		}
	}
}
