package kr.com.yh.lotte.dao.cinema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.dao.movie.IMovieDao;
import kr.com.yh.lotte.dao.movie.MovieDaoImpl;
import kr.com.yh.lotte.dao.ticketing.ITicketingDao;
import kr.com.yh.lotte.dao.ticketing.TicketingDaoImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.CinemaTheaterVO;
import kr.com.yh.util.SqlMapClientFactory;


public class CinemaDaoImpl implements ICinemaDao {
	
	private SqlMapClient smc;
	
	private static ICinemaDao cinemaDao;

	private CinemaDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ICinemaDao getInstance() {
		if (cinemaDao == null) {
			cinemaDao = new CinemaDaoImpl();
		}
		return cinemaDao;
	}
	
	@Override
	public List<CinemaLocationVO> getLocationList() {
		List<CinemaLocationVO> list = new ArrayList<CinemaLocationVO>();
		
		try {
			list = smc.queryForList("cinema.getLocationList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CinemaVO> getCinemaList(String loc) {
		List<CinemaVO> list = new ArrayList<CinemaVO>();
		
		try {
			list = smc.queryForList("cinema.getCinemaList", loc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
