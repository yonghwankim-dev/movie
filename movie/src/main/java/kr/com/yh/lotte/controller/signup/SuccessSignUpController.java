package kr.com.yh.lotte.controller.signup;

import kr.com.yh.lotte.UrlPaths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SuccessSignUpController", urlPatterns = {UrlPaths.SIGNUP_SUCCESS})
public class SuccessSignUpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fileNm = "signUp/success"; // 매칭되는 jsp 파일명(확장자 제외)
		
		req.setAttribute("fileNm", fileNm);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
