package kr.com.yh.lotte.dao.cinema;

import kr.com.yh.lotte.vo.CinemaSearch;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;

import java.util.List;

public interface ICinemaDao {

	List<CinemaVO> findAll();

	List<CinemaVO> findAll(CinemaSearch cinemaSearch);

	List<String> findAllLocation();

	List<CinemaLocationVO> getLocationList();

	List<CinemaVO> getCinemaList(String loc);
	
	
}
