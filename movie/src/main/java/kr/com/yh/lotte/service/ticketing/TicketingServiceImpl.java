package kr.com.yh.lotte.service.ticketing;

import java.util.List;
import kr.com.yh.lotte.dao.ticketing.ITicketingDao;
import kr.com.yh.lotte.dao.ticketing.TicketingDaoImpl;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.MovieInfoVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;

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
	public List<MovieVO> getMoviesByCinemaNameAndMovieName(String cinema_name, String movie_name) {
		return ticketingDao.getMoviesByCinemaNameAndMovieName(cinema_name, movie_name);
	}

	@Override
	public List<MovieScreenSchVO> findAllMovieScreenSchList(String cinema_name, String movie_name, String screen_date) {
		return ticketingDao.findAllMovieScreenSchList(cinema_name, movie_name, screen_date);
	}

	@Override
	public MovieInfoVO getMovieInfoByScreenCode(String screen_code) {
		return ticketingDao.getMovieInfoByScreenCode(screen_code);
	}

//	@Override
//	public int insertTickting(TicketingVO ticketing) {
//		return ticketingDao.insertTickting(ticketing);
//	}
//
//	@Override
//	public int insertMovieTicket(TicketingVO ticketing) {
//		return ticketingDao.insertMovieTicket(ticketing);
//	}	
}
