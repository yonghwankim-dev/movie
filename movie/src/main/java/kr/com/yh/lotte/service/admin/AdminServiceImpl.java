package kr.com.yh.lotte.service.admin;


import java.util.List;
import java.util.Map;

import kr.com.yh.lotte.dao.admin.AdminDaoImpl;
import kr.com.yh.lotte.dao.admin.IAdminDao;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;


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
	public List<ScreenAdminVO> getAllScreenAdmin(){
		return adminDao.getAllScreenAdmin();
	}

	@Override
	public int insertScreen(ScreenVO screen) {
		return adminDao.insertScreen(screen);
	}

	@Override
	public String getMovieCodeByMovieName(String movie_name) {
		return adminDao.getMovieCodeByMovieName(movie_name);
	}

	@Override
	public String getTheaterCodeByCinemaNameAndTheaterName(Map<String,String> map) {
		return adminDao.getTheaterCodeByCinemaNameAndTheaterName(map);
	}

	@Override
	public int deleteScreen(List<String> screen_codes) {
		return adminDao.deleteScreen(screen_codes);
	}
	
	

}
