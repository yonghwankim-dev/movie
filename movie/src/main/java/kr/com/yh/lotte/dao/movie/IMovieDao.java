package kr.com.yh.lotte.dao.movie;

import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;

import java.util.List;

public interface IMovieDao {

	List<MovieVO> findAll();

	/**
	 * 영화를 가져옴
	 * @return 영화 리스트
	 */
	List<MovieVO> findAll(MovieSearch movieSearch);
}
