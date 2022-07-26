package kr.com.yh.lotte.controller.signup;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.IJoinService;
import kr.com.yh.lotte.service.JoinServiceImpl;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;



@WebServlet(name = "SignUpController", urlPatterns = {UrlPaths.SIGNUP})
public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IJoinService joinService;
	
	public SignUpController() {
		joinService = JoinServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "signUp/signUp"; // 매칭되는 jsp 파일명(확장자 제외)

		req.setAttribute("fileNm", fileNm);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String contact = req.getParameter("firstTel") 
				       + "-" 
				       + req.getParameter("middleTel")
				       + "-" 
				       + req.getParameter("lastTel");
		String email = req.getParameter("userId") + "@" + req.getParameter("userServer");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String gender = req.getParameter("gender").equals("남성") ? "M" : "F";
		Date birthday = Date.valueOf(
						req.getParameter("year")
				        + "-" 
				        + req.getParameter("month") 
				        + "-" 
				        + req.getParameter("day")
						); 
					
		String addr = req.getParameter("zip")
				    + " " 
				    + req.getParameter("loadAdd")
				    + " "
				    + req.getParameter("detailAdd");
		
		MemberVO mem = MemberVO.builder()
				               .name(name)
				               .birthday(birthday)
				               .contact(contact)
				               .addr(addr)
				               .email(email)
				               .id(id)
				               .pwd(pw)
				               .gender(gender)
				               .build();
		
		AjaxResponse result = new AjaxResponse(resp);
		int cnt = 0;
		
		if(!joinService.checkEmail(mem.getEmail())){
			cnt = joinService.insertMember(mem);
		}
		
		if(cnt > 0) {
			result.addToResMap("code", "ok");
		} else {
			result.addToResMap("code", "no");
		}
		
		result.write();
	}
}