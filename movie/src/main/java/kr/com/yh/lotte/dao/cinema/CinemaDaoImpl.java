package kr.com.yh.lotte.dao.cinema;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.CinemaSearch;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.util.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
	public List<CinemaVO> findAll() {
		return findAll(null);
	}

	@Override
	public List<CinemaVO> findAll(CinemaSearch cinemaSearch) {
		List<CinemaVO> cinemas = null;

		try {
			cinemas = smc.queryForList("cinema.findAll", cinemaSearch);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return cinemas;
	}

	@Override
	public List<String> findAllLocation() {
		List<String> locations = null;

		try {
			locations = smc.queryForList("cinema.findAllLocation");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return locations;
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
