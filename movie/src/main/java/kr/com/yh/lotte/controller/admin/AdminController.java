package kr.com.yh.lotte.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.com.yh.lotte.service.admin.AdminServiceImpl;
import kr.com.yh.lotte.service.admin.IAdminService;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;

@WebServlet("/admin/admin.do")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	
	public AdminController() {
		adminService = AdminServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm = "admin/admin"; // 매칭되는 jsp 파일명(확장자 제외)

		List<ScreenVO> screens = adminService.getAllScreenDate(); 
		
		req.setAttribute("screens", screens);
		req.setAttribute("fileNm", fileNm);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
