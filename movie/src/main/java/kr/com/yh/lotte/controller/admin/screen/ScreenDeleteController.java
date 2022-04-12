package kr.com.yh.lotte.controller.admin.screen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenDateVO;
import kr.com.yh.lotte.vo.ScreenVO;

@WebServlet("/admin/screen/delete.do")
public class ScreenDeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenDeleteController() {
		adminService = AdminServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상영코드
		String[] screen_codes = req.getParameterValues("screen_code");
		List<String> screen_code_list = Arrays.asList(screen_codes);
		
		// 삽입 결과
		int cnt = 0;
		Map<String, Object> resMap = new HashMap<String, Object>();
		Gson gson = new Gson();
		String jsonData = null;
		PrintWriter out = resp.getWriter();
				
		// 상영코드 삭제 수행
		cnt = adminService.deleteScreen(screen_code_list);
		
		if(cnt>0)	// 삭제 성공
		{
			resMap.put("code", "ok");
		}
		else		// 삭젯 ㅣㄹ패
		{
			resMap.put("code", "no");
		}
		
		jsonData = gson.toJson(resMap);
		out.write(jsonData);
		out.flush();
		
		
		
		
	}
}
