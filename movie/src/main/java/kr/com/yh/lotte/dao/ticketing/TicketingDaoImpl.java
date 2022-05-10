package kr.com.yh.lotte.dao.ticketing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.MovieInfoVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;
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
	public List<MovieVO> getMoviesByCinemaNameAndMovieName(String cinema_name, String movie_name) {
		List<MovieVO> list = new ArrayList<MovieVO>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("cinema_name", cinema_name);
		map.put("movie_name", movie_name);
		
		try {
			list = smc.queryForList("ticketing.getMoviesByCinemaNameAndMovieName", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MovieScreenSchVO> findAllMovieScreenSchList(String cinema_name, String movie_name, String screen_date) {
		List<MovieScreenSchVO> list = new ArrayList<MovieScreenSchVO>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("cinema_name", cinema_name);
		map.put("movie_name", movie_name);
		map.put("screen_date", screen_date);
		
		try {
			list = cinema_name != null ? smc.queryForList("ticketing.findAllMovieScreenSchList", map)
									   : null;
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

//	@Override
//	public int insertTickting(TicketingVO ticketing) {
//		int cnt = 0;
//		
//		try {
//			cnt = (int) smc.insert("ticketing.insertTickting", ticketing);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return cnt;
//	}

//	@Override
//	public int insertMovieTicket(TicketingVO ticketing) {
//		int cnt = 0;
//		
//		try {
//			cnt = (int) smc.insert("ticketing.insertMovieTicket", ticketing);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return cnt;
//	}
	
	
}
