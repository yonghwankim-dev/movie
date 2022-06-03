package kr.com.yh.lotte.dao.movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.util.SqlMapClientFactory;

public class MovieDaoImpl implements IMovieDao {

	private SqlMapClient smc;
	
	private static IMovieDao movieDao;
	
	private MovieDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IMovieDao getInstance() {
		if (movieDao == null) {
			movieDao = new MovieDaoImpl();
		}
		return movieDao;
	}
	
	@Override
	public List<MovieVO> getMovieMain() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("movie.getMovieMain");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MovieVO> serchMovieList(String movNm) {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("movie.searchMovieList", movNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MovieVO> getMovie() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("movie.getMovie");
		} catch (SQLException e) {
			System.out.println("getMovie 수행중 오류" + e);
		}
		
		return list;
	}
	
	
}
