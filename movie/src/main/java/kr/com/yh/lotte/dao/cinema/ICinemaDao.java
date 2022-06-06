package kr.com.yh.lotte.dao.cinema;

import java.util.List;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.CinemaTheaterVO;

public interface ICinemaDao {
	/**
	 * 지역 리스트를 반환
	 * @return 지역 리스트
	 */
	public List<CinemaLocationVO> getLocationList();
	
	/**
	 * 모든 영화관 지점들의 리스트를 반환
	 * @return 영화관 지점 리스트 
	 */
	public List<CinemaVO> getCinemaList();
	
	
}
