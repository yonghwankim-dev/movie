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



@WebServlet(name = "CheckPhoneController", urlPatterns = {UrlPaths.CHECK_PHONE})
public class CheckPhoneController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String phone = req.getParameter("phone");
		
		IJoinService joinService = JoinServiceImpl.getInstance();
		
		boolean checkPhone = joinService.checkPhone(phone);
		
		
		UpdateResult result = new UpdateResult(resp);
		
		if (checkPhone) {
			result.addToResMap("code", "no");
			result.addToResMap("phone", phone);
			result.addToResMap("msg", "이미 존재하는 연락처입니다.");
		} else {
			result.addToResMap("code", "ok");
			result.addToResMap("phone", phone);
			result.addToResMap("msg", "사용 가능한 연락처입니다.");
		}
		
		result.write();
		
	}
	
	
}