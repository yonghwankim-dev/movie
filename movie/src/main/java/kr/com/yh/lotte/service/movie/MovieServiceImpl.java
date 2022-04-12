package kr.com.yh.lotte.service.movie;

import java.util.List;

import kr.com.yh.lotte.dao.movie.IMovieDao;
import kr.com.yh.lotte.dao.movie.MovieDaoImpl;
import kr.com.yh.lotte.vo.MovieVO;


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
	public List<MovieVO> getMovieMain() {
		return movieDao.getMovieMain();
	}

	@Override
	public List<MovieVO> serchMovieList(String movNm) {
		return movieDao.serchMovieList(movNm);
	}
}
