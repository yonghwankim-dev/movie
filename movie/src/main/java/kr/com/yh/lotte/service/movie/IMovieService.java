package kr.com.yh.lotte.service.movie;

import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;

import java.util.List;

public interface IMovieService {

	List<MovieVO> findAll();

	/**
	 * 영화 리스트를 가져옴
	 * @return 영화 리스트
	 */
	List<MovieVO> findAll(MovieSearch movieSearch);
}
