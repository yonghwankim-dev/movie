package kr.com.yh.lotte.controller.admin.screenSch;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.lotte.vo.ScreenSchVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ScreenSchHomeController", urlPatterns = UrlPaths.SCREEN_SCH_HOME)
public class ScreenSchHomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public ScreenSchHomeController() {
		adminService = AdminServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "admin/screenSch/screenSchHome"; // 매칭되는 jsp 파일명(확장자 제외)
		
		String movie_code = req.getParameter("movie_code");
		String theater_code = req.getParameter("theater_code");
		String screen_code = req.getParameter("screen_code");
		List<ScreenSchVO> screenSchs = adminService.getScreenSchByScreenCode(screen_code);
		
		req.setAttribute("theater_code", theater_code);
		req.setAttribute("movie_code", movie_code);
		req.setAttribute("screen_code", screen_code);
		req.setAttribute("screenSchs", screenSchs);
		req.setAttribute("fileNm", fileNm);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
