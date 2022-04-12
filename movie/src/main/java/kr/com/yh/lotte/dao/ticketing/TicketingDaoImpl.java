package kr.com.yh.lotte.dao.ticketing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.LocationVO;
import kr.com.yh.lotte.vo.MovieInfoVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TicketingVO;
import kr.com.yh.util.SqlMapClientFactory;

public class TicketingDaoImpl implements ITicketingDao{
	private SqlMapClient smc;
	
	private static ITicketingDao ticketingDao;

	private TicketingDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ITicketingDao getInstance() {
		if (ticketingDao == null) {
			ticketingDao = new TicketingDaoImpl();
		}
		return ticketingDao;
	}
	
	@Override
	public List<LocationVO> getLocationList() {
		List<LocationVO> list = new ArrayList<LocationVO>();
		
		try {
			list = smc.queryForList("ticketing.getLocationList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CinemaVO> getCinemaList() {
		List<CinemaVO> list = new ArrayList<CinemaVO>();
		
		try {
			list = smc.queryForList("ticketing.getCinemaList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MovieVO> getAllMovieList() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("ticketing.getAllMovieList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MovieVO> findMovieListByCinemaName(String cinema_name) {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("ticketing.findMovieListByCinemaName",cinema_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ScreenVO> findAllScreenListByCinemaName(String cinema_name, String screen_date) {
		List<ScreenVO> list = new ArrayList<ScreenVO>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("cinema_name", cinema_name);
		map.put("screen_date", screen_date);
		
		try {
			list = smc.queryForList("ticketing.findAllScreenListByCinemaName", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MovieInfoVO getMovieInfoByScreenCode(String screen_code) {
		MovieInfoVO movieInfo = null;
		
		try {
			movieInfo = (MovieInfoVO) smc.queryForObject("ticketing.getMovieInfoByScreenCode", screen_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movieInfo;
	}

	@Override
	public int insertTickting(TicketingVO ticketing) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.insert("ticketing.insertTickting", ticketing);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertMovieTicket(TicketingVO ticketing) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.insert("ticketing.insertMovieTicket", ticketing);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
}
