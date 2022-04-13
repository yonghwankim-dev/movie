package kr.com.yh.lotte.dao.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.util.SqlMapClientFactory;

public class AdminDaoImpl implements IAdminDao{
	private SqlMapClient smc;
	
	private static IAdminDao adminDao;
	
	private AdminDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAdminDao getInstance() {
		if (adminDao == null) {
			adminDao = new AdminDaoImpl();
		}
		return adminDao;
	}
		
	@Override
	public List<ScreenVO> getAllScreenDate() {
		List<ScreenVO> list = new ArrayList<ScreenVO>();
		
		try {
			list = smc.queryForList("admin.getAllScreenDate");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertScreen(ScreenVO screen) {
		int cnt = 0;
		try {
			cnt = smc.update("admin.insertScreen",screen);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String getMovieCodeByMovieTitle(String movie_title) {
		String movie_code = null;
		
		try {
			movie_code = (String) smc.queryForObject("admin.getMovieCodeByMovieTitle", movie_title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("movie_code : " + movie_code);
		
		return movie_code;
	}

	@Override
	public String getTheaterCodeByTheaterName(Map<String,String> map) {
		String theater_code = null;
		
		try {
			theater_code = (String) smc.queryForObject("admin.getTheaterCodeByTheaterName", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theater_code;
	}

	@Override
	public int deleteScreen(List<String> screen_codes) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("admin.deleteScreen", screen_codes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
}
