package kr.com.yh.lotte.service.cinema;

import java.util.List;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.CinemaTheaterVO;

public interface ICinemaService {
	/**
	 * 지역 리스트를 반환
	 * @return 지역 리스트
	 */
	public List<CinemaLocationVO> getLocationList();
	
	/**
	 * 모든 영화관 지점들의 리스트를 반환
	 * @param loc 선택한 지역
	 * @return 영화관 지점 리스트 
	 */
	public List<CinemaVO> getCinemaList(String loc);
	
	
}
