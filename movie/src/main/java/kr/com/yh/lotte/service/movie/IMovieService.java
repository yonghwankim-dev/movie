package kr.com.yh.lotte.service.movie;

import java.util.List;

import kr.com.yh.lotte.vo.MovieVO;

public interface IMovieService {
	
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
	 * 영화 리스트를 가져옴
	 * @return 영화 리스트
	 */
	public List<MovieVO> getMovie();
}
