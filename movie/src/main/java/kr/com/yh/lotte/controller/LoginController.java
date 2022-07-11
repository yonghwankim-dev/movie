package kr.com.yh.lotte.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.com.yh.lotte.service.IJoinService;
import kr.com.yh.lotte.service.JoinServiceImpl;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.UpdateResult;



@WebServlet("/login.do")
public class LoginController extends HttpServlet {

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
		
		
		// 관리자 로그인
		if(adminLogin != null && id.equals("admin") && pwd.equals("admin1")) {
			session.setAttribute("name", "관리자");
			session.setAttribute("loginId", id);
			session.setAttribute("loginPw", pwd);
			result.addToResMap("code", "ok");
		} else {
			// 회원 로그인
			Map<String, Object> memMap = new HashMap<String, Object>();
			memMap.put("id", id);
			memMap.put("pwd", pwd);
			
			IJoinService joinService = JoinServiceImpl.getInstance();
			
			boolean chk = joinService.checkLogin(memMap);
			MemberVO mem = joinService.getMemberInfo(memMap);
			
			if (chk) {
//				session.setAttribute("name", mem.getName());
//				session.setAttribute("contact", mem.getContact());
//				session.setAttribute("memCd", mem.getMem_code());
//				session.setAttribute("loginId", mem.getId());
//				session.setAttribute("loginPw", mem.getPwd());
				session.setAttribute("mem", mem);
				result.addToResMap("code", "ok");
			} else {
				result.addToResMap("code", "no");
			}
		}
		
		result.write();
	}
}