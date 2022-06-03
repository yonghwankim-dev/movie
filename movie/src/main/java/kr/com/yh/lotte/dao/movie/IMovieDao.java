package kr.com.yh.lotte.dao.movie;

import java.util.List;

import kr.com.yh.lotte.vo.MovieVO;

public interface IMovieDao {
	
	/**
	 * 
	 * @return 영화 정보를 담고 있는 MovieVO 객체
	 */
	public List<MovieVO> getMovieMain();

	/**
	 * 
	 * @param  movNm 검색할 영화명
	 * @return 검색된 영화들을 담고 있는 MovieVO 객체
	 */
	public List<MovieVO> serchMovieList(String movNm);

	/**
	 * 영화를 가져옴
	 * @return 영화 리스트
	 */
	public List<MovieVO> getMovie();
}
