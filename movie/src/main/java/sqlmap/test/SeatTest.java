package sqlmap.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibatis.sqlmap.client.SqlMapClient;


import kr.com.yh.util.SqlMapClientFactory;

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
		String theater_code = "TH1";
		
		seatList.add("A6");
		seatList.add("A7");
		
		map.put("seatList", seatList);
		map.put("theater_code", theater_code);
		
		
		try {
			seat_codes = smc.queryForList("seat.getSeatCodesBySeatNumAndTheaterCode", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("SEAT91", seat_codes.get(0));
		Assert.assertEquals("SEAT109", seat_codes.get(1));
	}

}
