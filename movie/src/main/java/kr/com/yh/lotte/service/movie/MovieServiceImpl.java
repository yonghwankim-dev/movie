package kr.com.yh.lotte.service.movie;

import kr.com.yh.lotte.dao.movie.IMovieDao;
import kr.com.yh.lotte.dao.movie.MovieDaoImpl;
import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;

import java.util.List;


public class MovieServiceImpl implements IMovieService {
	
	private static IMovieService movieService;
	
	private IMovieDao movieDao;
	
	private MovieServiceImpl() {
		movieDao = MovieDaoImpl.getInstance();
	}
	
	public static IMovieService getInstance() {
		if (movieService == null) {
			movieService = new MovieServiceImpl();
		}
		return movieService;
	}

	@Override
	public List<MovieVO> findAll() {
		return movieDao.findAll();
	}

	@Override
	public List<MovieVO> findAll(MovieSearch movieSearch) {
		return movieDao.findAll(movieSearch);
	}

	@Override
	public MovieVO findOne(String movie_code) {
		return movieDao.findOne(movie_code);
	}

	@Override
	public int save(MovieVO movie) {
		return movieDao.save(movie);
	}

	@Override
	public int modifyOne(MovieVO movie) {
		return movieDao.modifyOne(movie);
	}

	@Override
	public int deleteAll(List<String> movie_codes) {
		return movieDao.deleteAll(movie_codes);
	}
}
