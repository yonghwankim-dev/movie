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
			throw new RuntimeException(e);
		}
		
		return list;
	}

	@Override
	public MovieVO findOne(String movie_code) {
		MovieVO movie = null;

		try {
			movie = (MovieVO) smc.queryForObject("movie.findOne", movie_code);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return movie;
	}

	@Override
	public int save(MovieVO movie) {
		int cnt = 0;
		try {
			smc.startTransaction();
			cnt = smc.update("movie.save", movie);
			smc.commitTransaction();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return cnt;
	}

	@Override
	public int modifyOne(MovieVO movie) {
		int cnt = 0;

		try {
			smc.startTransaction();
			cnt = smc.update("movie.modifyOne", movie);
			smc.commitTransaction();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return cnt;
	}

	@Override
	public int deleteAll(List<String> movie_codes) {
		int cnt = 0;

		try {
			smc.startTransaction();
			cnt = smc.delete("movie.deleteAll", movie_codes);
			smc.commitTransaction();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}
}
