package kr.com.yh.lotte.controller.join;

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



@WebServlet("/check.do")
public class CheckIdController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		
		IJoinService joinService = JoinServiceImpl.getInstance();
		
		boolean checkId = joinService.checkMember(id);
		
		Gson gson = new Gson();
		String jsonData = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (checkId) {
			map.put("code", "no");
			map.put("id", id);
			map.put("msg", "이미 존재하는 아이디입니다.");
		} else {
			map.put("code", "ok");
			map.put("id", id);
			map.put("msg", "사용 가능한 아이디입니다.");
		}
		
		jsonData = gson.toJson(map);
		PrintWriter out = resp.getWriter();
		out.write(jsonData);
		out.flush();
	}
	
	
}