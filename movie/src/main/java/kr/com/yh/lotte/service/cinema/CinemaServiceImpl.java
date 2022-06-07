package kr.com.yh.lotte.service.cinema;

import java.util.List;

import kr.com.yh.lotte.dao.cinema.CinemaDaoImpl;
import kr.com.yh.lotte.dao.cinema.ICinemaDao;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.CinemaTheaterVO;


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
	public List<CinemaLocationVO> getLocationList() {
		return cinemaDao.getLocationList();
	}

	@Override
	public List<CinemaVO> getCinemaList(String loc) {
		return cinemaDao.getCinemaList(loc);
	}
}
