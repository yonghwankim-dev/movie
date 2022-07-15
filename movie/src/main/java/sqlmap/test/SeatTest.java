package sqlmap.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.component.MovieScreenSchSeatVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	@Test
	void getSeatCodesBySeatNumAndTheaterCodeTest() {
		List<String> seat_codes = null;
		List<String> seatList = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		String theater_code = "TH8";

		seatList.add("A7");
		
		map.put("seatList", seatList);
		map.put("theater_code", theater_code);
		
		
		try {
			seat_codes = smc.queryForList("seat.getSeatCodesBySeatNumAndTheaterCode", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("seat_codes : " + seat_codes);
	}
	
	@Test
	void findAllMovieScreenSchSeatTest() {
		List<MovieScreenSchSeatVO> seats = null;
		String screen_sch_code = "SS26";
		try {
			seats = smc.queryForList("seat.findAllMovieScreenSchSeat", screen_sch_code);
		} catch (SQLException e) {
			System.out.println("findAllMovieScreenSchSeatTest SQL 에러 " + e);
		}
		
		assertEquals(153, seats.size());
	}

}
