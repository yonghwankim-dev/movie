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



@WebServlet(name = "CheckIdController", urlPatterns = {UrlPaths.CHECK_ID})
public class CheckIdController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		
		IJoinService joinService = JoinServiceImpl.getInstance();
		
		boolean checkId = joinService.checkMember(id);
		
		
		UpdateResult result = new UpdateResult(resp);
		
		if (checkId) {
			result.addToResMap("code", "no");
			result.addToResMap("id", id);
			result.addToResMap("msg", "이미 존재하는 아이디입니다.");
		} else {
			result.addToResMap("code", "ok");
			result.addToResMap("id", id);
			result.addToResMap("msg", "사용 가능한 아이디입니다.");
		}
		
		result.write();
		
	}
	
	
}