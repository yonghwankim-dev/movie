package kr.com.yh.lotte.dao.seat;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.util.SqlMapClientFactory;

public class SeatDaoImpl implements ISeatDao{

	private SqlMapClient smc;
	
	private static ISeatDao seatDao;
		
	public SeatDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ISeatDao getInstance() {
		if (seatDao == null) {
			seatDao = new SeatDaoImpl();
		}
		return seatDao;
	}
	
	@Override
	public List<String> getSeatCodesBySeatNumAndTheaterCode(List<String> seatList, String theater_code) {
		List<String> seatCodes = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("seatList", seatList);
		map.put("theater_code", theater_code);
		
		try {
			seatCodes = smc.queryForList("seat.getSeatCodesBySeatNumAndTheaterCode", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seatCodes;
	}

}
