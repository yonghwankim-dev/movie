package kr.com.yh.lotte.dao.movie;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.util.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<MovieVO> findAll() {
		return findAll(new MovieSearch());
	}

	@Override
	public List<MovieVO> findAll(MovieSearch movieSearch) {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("movie.findAll", movieSearch);
		} catch (SQLException e) {
			System.out.println("findAll 수행중 오류" + e);
		}
		
		return list;
	}
	
	
}
