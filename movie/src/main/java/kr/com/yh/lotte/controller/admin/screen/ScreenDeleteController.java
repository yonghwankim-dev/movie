package kr.com.yh.lotte.controller.admin.screen;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.util.UpdateResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ScreenDeleteController", urlPatterns = UrlPaths.SCREEN_DELETE)
public class ScreenDeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenDeleteController() {
		adminService = AdminServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상영코드
		List<String> screen_codes = Arrays.asList(req.getParameterValues("screen_code"));

		System.out.println(">>>>>>>>>>" + screen_codes);

		// 삽입 결과
		UpdateResult result = new UpdateResult(resp);
				
		// 상영코드 삭제 수행
		int cnt = adminService.deleteScreen(screen_codes);
		
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
