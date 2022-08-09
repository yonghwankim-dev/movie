package test.java.kr.com.yh.service;


import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.service.screensch.IScreenSchService;
import kr.com.yh.lotte.service.screensch.ScreenSchServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class ScreenSchTest {
	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}

	@Test
	void getNextScreenSchCodeTest() {
		String screen_sch_code = null;
		try {
			screen_sch_code = (String) smc.queryForObject("screensch.getNextScreenSchCode");
		} catch (SQLException e) {
			System.out.println("getNextScreenSchCodeTest 실패" + e);
		}
		System.out.println(screen_sch_code);
		
	}

	@Test
	void findBookSeatCntTest() {
		IScreenSchService screenSchService = ScreenSchServiceImpl.getInstance();
		ITicketingService ticketingService = TicketingServiceImpl.getInstance();
		
		List<MovieScreenSchVO> screenSchs = ticketingService.findAllMovieScreenSch("가산디지털", "메리 미", "2022-05-17");
		screenSchs = screenSchService.findBookSeatCnt(screenSchs);
		
		for(MovieScreenSchVO screenSch : screenSchs) {
			System.out.println(screenSch);
		}
	}
}
