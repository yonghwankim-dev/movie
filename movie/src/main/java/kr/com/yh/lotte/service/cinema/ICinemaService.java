package kr.com.yh.lotte.service.cinema;

import kr.com.yh.lotte.vo.CinemaSearch;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;

import java.util.List;

public interface ICinemaService {
	/**
	 * 영화관검색
	 */
	List<CinemaVO> findAll();

	/**
	 * 영화관검색
	 */
	List<CinemaVO> findAll(CinemaSearch cinemaSearch);

	/**
	 * 지역검색
	 */
	List<String> findAllLocation();

	/**
	 * 지역 리스트를 반환
	 * @return 지역 리스트
	 */
	List<CinemaLocationVO> getLocationList();
	
	/**
	 * 모든 영화관 지점들의 리스트를 반환
	 * @param loc 선택한 지역
	 * @return 영화관 지점 리스트 
	 */
	List<CinemaVO> getCinemaList(String loc);
	
	
}
