package kr.com.yh.lotte.dao.movie;

import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;

import java.util.List;

public interface IMovieDao {

	List<MovieVO> findAll();

	List<MovieVO> findAll(MovieSearch movieSearch);

	int save(MovieVO movie);
}
