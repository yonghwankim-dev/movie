package kr.com.yh.lotte.service.admin;

import java.util.List;
import java.util.Map;

import kr.com.yh.lotte.dao.admin.AdminDaoImpl;
import kr.com.yh.lotte.dao.admin.IAdminDao;
import kr.com.yh.lotte.vo.ScreenDateVO;
import kr.com.yh.lotte.vo.ScreenVO;


public class AdminServiceImpl implements IAdminService{

	private static IAdminService adminService;
	
	private IAdminDao adminDao;
	
	private AdminServiceImpl() {
		adminDao = AdminDaoImpl.getInstance();
	}
	
	public static IAdminService getInstance() {
		if (adminService == null) {
			adminService = new AdminServiceImpl();
		}
		return adminService;
	}
	
	@Override
	public List<ScreenVO> getAllScreenDate() {
		return adminDao.getAllScreenDate();
	}

	@Override
	public int insertScreen(ScreenDateVO screen) {
		return adminDao.insertScreen(screen);
	}

	@Override
	public String getMovieCodeByMovieTitle(String movie_title) {
		return adminDao.getMovieCodeByMovieTitle(movie_title);
	}

	@Override
	public String getTheaterCodeByTheaterName(Map<String,String> map) {
		return adminDao.getTheaterCodeByTheaterName(map);
	}

	@Override
	public int deleteScreen(List<String> screen_codes) {
		return adminDao.deleteScreen(screen_codes);
	}
	
	

}
