package kr.com.yh.lotte.controller.signup.check;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.IJoinService;
import kr.com.yh.lotte.service.JoinServiceImpl;
import kr.com.yh.util.UpdateResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckEmailController", urlPatterns = {UrlPaths.CHECK_EMAIL})
public class CheckEmailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String email = req.getParameter("email");

		IJoinService joinService = JoinServiceImpl.getInstance();

		boolean checkEmail = joinService.checkEmail(email);
		
		
		UpdateResult result = new UpdateResult(resp);
		
		if (checkEmail) {
			result.addToResMap("code", "no");
			result.addToResMap("email", email);
			result.addToResMap("msg", "이미 존재하는 이메일입니다.");
		} else {
			result.addToResMap("code", "ok");
			result.addToResMap("email", email);
			result.addToResMap("msg", "사용 가능한 이메일입니다.");
		}
		
		result.write();
		
	}
	
	
}