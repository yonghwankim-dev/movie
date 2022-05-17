package kr.com.yh.lotte.service.seat;

import java.util.List;

import kr.com.yh.lotte.dao.seat.ISeatDao;
import kr.com.yh.lotte.dao.seat.SeatDaoImpl;
import kr.com.yh.lotte.vo.component.MovieScreenSchSeatVO;

public class SeatServiceImpl implements ISeatService{

	private static ISeatService seatService;
	
	private ISeatDao seatDao;
	
	public SeatServiceImpl() {
		seatDao = SeatDaoImpl.getInstance();
	}
	
	public static ISeatService getInstance() {
		if (seatService == null) {
			seatService = new SeatServiceImpl();
		}
		return seatService;
	}
	
	@Override
	public List<String> getSeatCodesBySeatNumAndTheaterCode(List<String> seatList, String theater_code) {
		return seatDao.getSeatCodesBySeatNumAndTheaterCode(seatList, theater_code);
	}

	@Override
	public List<MovieScreenSchSeatVO> findAllMovieScreenSchSeat(String screen_sch_code) {
		return seatDao.findAllMovieScreenSchSeat(screen_sch_code);
	}

	
	
}
