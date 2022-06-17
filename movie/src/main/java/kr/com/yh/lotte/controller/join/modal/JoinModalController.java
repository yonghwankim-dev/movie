package kr.com.yh.lotte.controller.join.modal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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



@WebServlet("/joinModal.do")
public class JoinModalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IJoinService joinService;
	
	public JoinModalController() {
		joinService = JoinServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello modal");
		req.getRequestDispatcher("/view/sub/join.jsp").forward(req, resp);
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
		
		MemberVO mem = new MemberVO("", name, birthday, contact, addr, email, id, pw, gender);
		
		UpdateResult result = new UpdateResult(resp);
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