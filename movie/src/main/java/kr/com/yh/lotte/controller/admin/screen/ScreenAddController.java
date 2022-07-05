package kr.com.yh.lotte.controller.admin.screen;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/admin/screen/add.do")
public class ScreenAddController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenAddController() {
		adminService = AdminServiceImpl.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movie_code		= null;											// 영화코드
		String movie_name 		= req.getParameter("movie_name");				// 영화제목
		String cinema_location  = req.getParameter("loc");						// 지역
		String cinema_name 		= req.getParameter("cinema_name");				// 지점명
		String theater_code		= null;											// 상영코드
		String theater_name 	= req.getParameter("theater_name");				// 상영관이름
		Date start_date 		= Date.valueOf(req.getParameter("start_date"));	// 상영시작일자
		Date end_date			= Date.valueOf(req.getParameter("end_date"));	// 상영종료일자
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("cinema_name", cinema_name);
		map.put("theater_name", theater_name);	

		// 삽입 결과
		UpdateResult result = new UpdateResult(resp);
		int cnt = 0;
		
		movie_code = adminService.getMovieCodeByMovieName(movie_name);
		theater_code = adminService.getTheaterCodeByCinemaNameAndTheaterName(map);
				
		ScreenVO screen = ScreenVO.builder()
				                  .movie_code(movie_code)
				                  .theater_code(theater_code)
				                  .start_date(start_date)
				                  .end_date(end_date)
				                  .build();
		
		cnt = adminService.insertScreen(screen);
		
		if(cnt>0)
		{
			result.addToResMap("code", "ok");
		}
		else
		{
			result.addToResMap("code", "no");
		}
		
		result.write();
	}
}
