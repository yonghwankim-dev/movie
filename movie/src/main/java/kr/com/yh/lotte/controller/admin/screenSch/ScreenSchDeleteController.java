package kr.com.yh.lotte.controller.admin.screenSch;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "ScreenSchDeleteController", urlPatterns = UrlPaths.SCREEN_SCH_DELETE)
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
		AjaxResponse result = new AjaxResponse(resp);
				
		// 상영코드 삭제 수행
		int cnt = adminService.deleteScreenSch(screen_sch_codes);
		
		result.addToResMap("movie_code", movie_code);
		result.addToResMap("theater_code", theater_code);
		result.addToResMap("screen_code", screen_code);
		
		if(cnt>0)	// 삭제 성공
		{
			result.addToResMap("code", "ok");
		}
		else		// 삭제 실패
		{
			result.addToResMap("code", "no");
		}
		
		result.write();
	}
}
