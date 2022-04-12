package kr.com.yh.lotte.service.ticketing;

import java.util.List;

import kr.com.yh.lotte.dao.ticketing.ITicketingDao;
import kr.com.yh.lotte.dao.ticketing.TicketingDaoImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.LocationVO;
import kr.com.yh.lotte.vo.MovieInfoVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TicketingVO;

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
	public List<LocationVO> getLocationList() {
		return ticketingDao.getLocationList();
	}

	@Override
	public List<CinemaVO> getCinemaList() {
		return ticketingDao.getCinemaList();
	}

	@Override
	public List<MovieVO> getAllMovieList() {
		return ticketingDao.getAllMovieList();
	}

	@Override
	public List<MovieVO> findMovieListByCinemaName(String cinema_name) {
		return ticketingDao.findMovieListByCinemaName(cinema_name);
	}

	@Override
	public List<ScreenVO> findAllScreenListByCinemaName(String cinema_name, String screen_date) {
		return ticketingDao.findAllScreenListByCinemaName(cinema_name, screen_date);
	}

	@Override
	public MovieInfoVO getMovieInfoByScreenCode(String screen_code) {
		return ticketingDao.getMovieInfoByScreenCode(screen_code);
	}

	@Override
	public int insertTickting(TicketingVO ticketing) {
		return ticketingDao.insertTickting(ticketing);
	}

	@Override
	public int insertMovieTicket(TicketingVO ticketing) {
		return ticketingDao.insertMovieTicket(ticketing);
	}	
}
