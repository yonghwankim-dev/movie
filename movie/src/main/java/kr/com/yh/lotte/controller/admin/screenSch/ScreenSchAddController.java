package kr.com.yh.lotte.controller.admin.screenSch;

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
import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.util.UpdateResult;

@WebServlet("/admin/screenSch/add.do")
public class ScreenSchAddController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenSchAddController() {
		adminService = AdminServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String screen_sch_code = null;
		Date screen_date = Date.valueOf(req.getParameter("screen_date"));
		String start_time = req.getParameter("start_time");
		String end_time = req.getParameter("end_time");
		int screen_num = Integer.parseInt(req.getParameter("screen_num"));
		String movie_code = req.getParameter("movie_code");
		String theater_code = req.getParameter("theater_code");
		String screen_code = req.getParameter("screen_code");
		
		ScreenSchVO screenSch = new ScreenSchVO(screen_sch_code
				                              , screen_date
				                              , start_time
				                              , end_time
				                              , screen_num
				                              , movie_code
				                              , theater_code
				                              , screen_code);	

		// 삽입 결과
		UpdateResult result = new UpdateResult(resp);
		int cnt = 0;
		
		cnt = adminService.insertScreenSch(screenSch);
		result.addToResMap("movie_code", movie_code);
		result.addToResMap("theater_code", theater_code);
		result.addToResMap("screen_code", screen_code);
		
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
