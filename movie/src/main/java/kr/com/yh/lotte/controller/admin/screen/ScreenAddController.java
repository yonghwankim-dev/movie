package kr.com.yh.lotte.controller.admin.screen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import kr.com.yh.lotte.vo.TheaterVO;
import kr.com.yh.lotte.vo.wrapper.ScreenDateVO;

@WebServlet("/admin/screen/add.do")
public class ScreenAddController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenAddController() {
		adminService = AdminServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cinema_location  = req.getParameter("cinema_location");	// 영화관 지역
		String cinema_name 		= req.getParameter("cinema_name");		// 영화관 지점
		String theater_name 	= req.getParameter("theater_name");		// 상영관 이름
		String movie_title 		= req.getParameter("movie_title");		// 영화 제목
		
		Date screen_date 		= Date.valueOf(req.getParameter("screen_date"));	// 상영일자
		LocalDateTime ldt 		= LocalDateTime.parse
									(
											screen_date 
											+ " " 
											+ req.getParameter("screen_time")
											, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
									);
		Timestamp screen_time 	= Timestamp.valueOf(ldt);	// 상영시간
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("cinema_name", cinema_name);
		map.put("theater_name", theater_name);	
		
		String movie_code = adminService.getMovieCodeByMovieTitle(movie_title);	// 영화 코드
		String theater_code = adminService.getTheaterCodeByTheaterName(map);	// 상영관 코드
		
		// 삽입 결과
		int cnt = 0;
		Map<String, Object> resMap = new HashMap<String, Object>();
		Gson gson = new Gson();
		String jsonData = null;
		PrintWriter out = resp.getWriter();

		
		ScreenVO screen = new ScreenVO(""
				                     , screen_date
				                     , screen_time
				                     , movie_code
				                     , theater_code);
		
		cnt = adminService.insertScreen(screen);
		
		if(cnt>0)
		{
			resMap.put("code", "ok");
		}
		else
		{
			resMap.put("code", "no");
		}
		
		jsonData = gson.toJson(resMap);
		out.write(jsonData);
		out.flush();
	}
}
