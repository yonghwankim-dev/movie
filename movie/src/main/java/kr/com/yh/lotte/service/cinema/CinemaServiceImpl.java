package kr.com.yh.lotte.service.cinema;

import kr.com.yh.lotte.dao.cinema.CinemaDaoImpl;
import kr.com.yh.lotte.dao.cinema.ICinemaDao;
import kr.com.yh.lotte.vo.CinemaSearch;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;

import java.util.List;


public class CinemaServiceImpl implements ICinemaService {
	
	private static ICinemaService cinemaService;
	
	private ICinemaDao cinemaDao;
	
	private CinemaServiceImpl() {
		cinemaDao = CinemaDaoImpl.getInstance();
	}
	
	public static ICinemaService getInstance() {
		if (cinemaService == null) {
			cinemaService = new CinemaServiceImpl();
		}
		return cinemaService;
	}

	@Override
	public List<CinemaVO> findAll() {
		return cinemaDao.findAll();
	}

	@Override
	public List<CinemaVO> findAll(CinemaSearch cinemaSearch) {
		return cinemaDao.findAll(cinemaSearch);
	}

	@Override
	public List<String> findAllLocation() {
		return cinemaDao.findAllLocation();
	}

	@Override
	public List<CinemaLocationVO> getLocationList() {
		return cinemaDao.getLocationList();
	}

	@Override
	public List<CinemaVO> getCinemaList(String loc) {
		return cinemaDao.getCinemaList(loc);
	}
}
