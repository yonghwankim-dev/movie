package kr.com.yh.lotte.service.movie;

import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;

import java.util.List;

public interface IMovieService {

	/**
	 * 영화전체검색
	 */
	List<MovieVO> findAll();

	/**
	 * 영화전체검색
	 */
	List<MovieVO> findAll(MovieSearch movieSearch);

	/**
	 * 영화단일검색
	 */
	MovieVO findOne(String movie_code);

	/**
	 * 영화추가
	 */
	int save(MovieVO movie);

	/**
	 * 영화제거
	 */
	int deleteAll(List<String> movie_codes);

}
