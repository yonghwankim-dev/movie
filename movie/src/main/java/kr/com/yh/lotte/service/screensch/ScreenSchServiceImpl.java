package kr.com.yh.lotte.service.screensch;

import java.util.List;

import kr.com.yh.lotte.dao.book.BookDaoImpl;
import kr.com.yh.lotte.dao.book.IBookDao;
import kr.com.yh.lotte.dao.screensch.IScreenSchDao;
import kr.com.yh.lotte.dao.screensch.ScreenSchDaoImpl;
import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;

public class ScreenSchServiceImpl implements IScreenSchService{

	private static IScreenSchService screenSchService;
	
	private IScreenSchDao screenSchDao;
	
	private ScreenSchServiceImpl() {
		screenSchDao = ScreenSchDaoImpl.getInstance();
	}
	
	public static IScreenSchService getInstance() {
		if(screenSchService == null) {
			screenSchService = new ScreenSchServiceImpl();
		}
		return screenSchService;
	}

	@Override
	public String getNextScreenSchCode() {
		return screenSchDao.getNextScreenSchCode();
	}

	@Override
	public List<MovieScreenSchVO> findBookSeatCnt(List<MovieScreenSchVO> screenSchs) {
		return screenSchDao.findBookSeatCnt(screenSchs);
	}
		
	
	
}
