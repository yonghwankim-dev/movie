package kr.com.yh.lotte.service.ticketing;

import java.util.List;
import java.util.Map;

import kr.com.yh.lotte.dao.ticketing.ITicketingDao;
import kr.com.yh.lotte.dao.ticketing.TicketingDaoImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TicketingVO;
import kr.com.yh.lotte.vo.wrapper.CinemaLocationVO;
import kr.com.yh.lotte.vo.wrapper.ScreenDateVO;

public class TicketingServiceImpl implements ITicketingService{

	private static ITicketingService ticketingService;
	
	private ITicketingDao ticketingDao;
	
	public TicketingServiceImpl() {
		ticketingDao = TicketingDaoImpl.getInstance();
	}
	
	public static ITicketingService getInstance() {
		if (ticketingService == null) {
			ticketingService = new TicketingServiceImpl();
		}
		return ticketingService;
	}
	
	@Override
	public List<CinemaLocationVO> getLocationList() {
		return ticketingDao.getLocationList();
	}

	@Override
	public List<CinemaVO> getCinemaList() {
		return ticketingDao.getCinemaList();
	}
	
	@Override
	public List<MovieVO> getMoviesByCinemaNameAndMovieTitle(String cinema_name, String movie_title) {
		return ticketingDao.getMoviesByCinemaNameAndMovieTitle(cinema_name, movie_title);
	}

	@Override
	public List<ScreenDateVO> findAllScreenListByCinemaName(String cinema_name, String movie_title, String screen_date) {
		return ticketingDao.findAllScreenListByCinemaName(cinema_name, movie_title, screen_date);
	}

//	@Override
//	public MovieInfoVO getMovieInfoByScreenCode(String screen_code) {
//		return ticketingDao.getMovieInfoByScreenCode(screen_code);
//	}

	@Override
	public int insertTickting(TicketingVO ticketing) {
		return ticketingDao.insertTickting(ticketing);
	}

	@Override
	public int insertMovieTicket(TicketingVO ticketing) {
		return ticketingDao.insertMovieTicket(ticketing);
	}	
}
