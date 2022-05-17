package kr.com.yh.lotte.dao.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;
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
	public List<ScreenAdminVO> getAllScreenAdmin(){
		List<ScreenAdminVO> list = new ArrayList<ScreenAdminVO>();
		
		try {
			list = smc.queryForList("admin.getAllScreenAdmin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getMovieCodeByMovieName(String movie_name) {
		String movie_code = null;
		
		try {
			movie_code = (String) smc.queryForObject("admin.getMovieCodeByMovieName", movie_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movie_code;
	}

	@Override
	public String getTheaterCodeByCinemaNameAndTheaterName(Map<String,String> map) {
		String theater_code = null;
		
		try {
			theater_code = (String) smc.queryForObject("admin.getTheaterCodeByCinemaNameAndTheaterName", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theater_code;
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
	public int insertScreenSchAndSeat(ScreenSchVO screenSchVO, List<String> seat_codes) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			
			cnt = insertScreenSch(screenSchVO); 
			if(cnt == 0) {
				return cnt;
			}
			
			cnt = insertScreenSchSeat(screenSchVO, seat_codes);
			if(cnt == 0) {
				return cnt;
			}
			
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("insertScreenSch SQL 에러 " + e);
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	@Override
	public int insertScreenSch(ScreenSchVO screenSch) {
		int cnt = 0;
	
		try {
			cnt = smc.update("admin.insertScreenSch", screenSch);
		} catch (SQLException e) {
			System.out.println("insertScreenSch 수행 실패 " + e);
		}
		return cnt;
	}
	
	@Override
	public int insertScreenSchSeat(ScreenSchVO screenSch, List<String> seat_codes) {
		int cnt = 0;
		Map<String, String> map = new HashMap<String, String>();
		String screen_sch_code = screenSch.getScreen_sch_code();
		
		map.put("screen_sch_code", screen_sch_code);
		
		try {
			for(String seat_code : seat_codes) {
				map.put("seat_code", seat_code);
				cnt += smc.update("admin.insertScreenSchSeat", map);
			}
		} catch (SQLException e) {
			System.out.println("insertScreenSchSeat 수행중 오류" + e);
			cnt = 0;
		}
		return cnt;
	}

	@Override
	public int deleteScreen(List<String> screen_codes) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = smc.delete("admin.deleteScreen", screen_codes);
			smc.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	

	@Override
	public int deleteScreenSch(List<String> screen_sch_codes) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = smc.delete("admin.deleteScreenSch", screen_sch_codes);
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("deleteScreenSch SQL 에러 " + e);
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public List<ScreenSchVO> getScreenSchByScreenCode(String screen_code) {
		List<ScreenSchVO> list = null;
		
		try {
			list = smc.queryForList("admin.getScreenSchByScreenCode", screen_code);
		} catch (SQLException e) {
			System.out.println("getScreenSchByScreenCode 쿼리 에러" + e);
		}
		return list;
	}
	
	
}
