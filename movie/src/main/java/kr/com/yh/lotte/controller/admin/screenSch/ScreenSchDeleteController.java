package kr.com.yh.lotte.controller.admin.screenSch;

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
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/admin/screenSch/delete.do")
public class ScreenSchDeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenSchDeleteController() {
		adminService = AdminServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상영일정코드
		List<String> screen_sch_codes = Arrays.asList(req.getParameterValues("screen_sch_code"));
		String movie_code = req.getParameter("movie_code");
		String theater_code = req.getParameter("theater_code");
		String screen_code = req.getParameter("screen_code");
		
		// 삽입 결과
		UpdateResult result = new UpdateResult(resp);
				
		// 상영코드 삭제 수행
		int cnt = adminService.deleteScreenSch(screen_sch_codes);
		
		result.addToResMap("movie_code", movie_code);
		result.addToResMap("theater_code", theater_code);
		result.addToResMap("screen_code", screen_code);
		
		if(cnt>0)	// 삭제 성공
		{
			result.addToResMap("code", "ok");
		}
		else		// 삭젯 실패
		{
			result.addToResMap("code", "no");
		}
		
		result.write();
	}
}
