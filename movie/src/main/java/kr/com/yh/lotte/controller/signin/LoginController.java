package kr.com.yh.lotte.controller.signin;

import kr.com.yh.lotte.service.IJoinService;
import kr.com.yh.lotte.service.JoinServiceImpl;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.UpdateResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;



@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "login/login"; // 매칭되는 jsp 파일명(확장자 제외)

		req.setAttribute("fileNm", fileNm);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");

		HttpSession session = req.getSession();
		String id = req.getParameter("loginId");
		String pwd = req.getParameter("loginPwd");
		String adminLogin = req.getParameter("adminLogin");
		

		UpdateResult result = new UpdateResult(resp);
		MemberVO mem;
		
		// 관리자 로그인
		if(adminLogin != null && id.equals("admin") && pwd.equals("admin1")) {

			mem = MemberVO.builder()
                          .id(id)
                          .name("관리자")
                          .build();
			session.setAttribute("mem", mem);
			result.addToResMap("code", "ok");
		} else {
			// 회원 로그인
			Map<String, Object> memMap = new HashMap<>();
			memMap.put("id", id);
			memMap.put("pwd", pwd);
			
			IJoinService joinService = JoinServiceImpl.getInstance();
			
			boolean chk = joinService.checkLogin(memMap);
			mem = joinService.getMemberInfo(memMap);
			
			if (chk) {
				session.setAttribute("mem", mem);
				result.addToResMap("code", "ok");
			} else {
				result.addToResMap("code", "no");
			}
		}
		
		result.write();
	}
}