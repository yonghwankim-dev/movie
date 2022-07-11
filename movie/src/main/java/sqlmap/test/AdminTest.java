package sqlmap.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.service.seat.ISeatService;
import kr.com.yh.lotte.service.seat.SeatServiceImpl;
import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	@Test
	void getAllScreenAdminTest() {
		List<ScreenAdminVO> list = new ArrayList<ScreenAdminVO>();
		
		try {
			list = smc.queryForList("admin.getAllScreenAdmin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
	
	@Test
	void getAllScreenAdminByCinemaNameTest() {
		List<ScreenAdminVO> list = new ArrayList<ScreenAdminVO>();
		String cinema_name = "가양";
		try {
			list = smc.queryForList("admin.getAllScreenAdmin", cinema_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(list);
	}
	

	@Test
	void getMovieCodeByMovieNameTest() {
		String movie_name = "블랙 라이트";
		String movie_code = null;
		
		try {
			movie_code = (String) smc.queryForObject("admin.getMovieCodeByMovieName", movie_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("MOVIE4", movie_code);
	}

	@Test
	void getTheaterCodeByCinemaNameAndTheaterNameTest() {
		
		String theater_code = null;
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("cinema_name", "가산디지털");
		map.put("theater_name", "1관");
		
		try {
			theater_code = (String) smc.queryForObject("admin.getTheaterCodeByCinemaNameAndTheaterName", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("TH1", theater_code);
	}
	
	@Test
	void insertScreen() throws SQLException {
		String movie_code = "MOVIE4";
		String theater_code = "TH1";
		Date start_date = Date.valueOf("2022-05-09");
		Date end_date = Date.valueOf("2022-05-31");
		
		ScreenVO screen = new ScreenVO(null, movie_code, theater_code, start_date, end_date);
		
		int cnt = 0;
		try {
			smc.startTransaction();
			cnt = smc.update("admin.insertScreen",screen);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			smc.endTransaction();
		}
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	void getScreenSchByScreenCodeTest() {
		String screen_code = "SCREEN4";
		List<ScreenSchVO> list = null;
		
		try {
			list = smc.queryForList("admin.getScreenSchByScreenCode", screen_code);
		} catch (SQLException e) {
			System.out.println("getScreenSchByScreenCodeTest SQL 에러" + e);
		}
		System.out.println(list);		
	}
	
	@Test
	void insertScreenSchTest() {
		ScreenSchVO screenSch = new ScreenSchVO("SS24"
											  , Date.valueOf("2022-05-13")
											  , "13:00"
											  , "15:00"
											  , 3
											  , "MOVIE3"
											  , "TH1"
											  , "SCREEN4");
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = smc.update("admin.insertScreenSch", screenSch);
		} catch (SQLException e) {
			System.out.println("insertScreenSchTest SQL 에러" + e);
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		Assert.assertEquals(1, cnt);
	}
	
	@Test
	void insertScreenSchSeatTest() {
		ISeatService seatService = SeatServiceImpl.getInstance();
		int cnt = 0;
		Map<String, String> map = new HashMap<String, String>();
		String screen_sch_code = "SS21";
		String theater_code = "TH1";
		List<String> seat_codes = seatService.getSeatCodesBySeatNumAndTheaterCode(null, theater_code);
		
		map.put("screen_sch_code", screen_sch_code);
		
		try {
			smc.startTransaction();
			for(String seat_code : seat_codes) {
				map.put("seat_code", seat_code);
				cnt += smc.update("admin.insertScreenSchSeat", map);
			}
		} catch (SQLException e) {
			System.out.println("insertScreenSchSeatTest 수행중 오류" + e);
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		assertEquals(156, cnt);
	}
	
	@Test
	void deleteScreenSchSeatTest() {
		List<String> screen_sch_codes = new ArrayList<String>();
		screen_sch_codes.add("SS101");
		screen_sch_codes.add("SS102");
		int cnt = 0;
		
		try{
			smc.startTransaction();
			cnt = smc.delete("admin.deleteScreenSchSeat", screen_sch_codes);
			smc.endTransaction();
		} catch (SQLException e) {
			System.out.println("deleteScreenSeatSchTest SQL 에러 " + e);
			cnt = 0;
		}
		
		assertEquals(306, cnt);
	}
	
	@Test
	void deleteScreenSchTest() {
		List<String> screen_sch_codes = new ArrayList<String>();
		screen_sch_codes.add("SS9");
		screen_sch_codes.add("SS7");
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = smc.delete("admin.deleteScreenSch", screen_sch_codes);
		} catch (SQLException e) {
			System.out.println("deleteScreenSchTest SQL 에러 " + e);
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Assert.assertEquals(2, cnt);
	}
	
	
}
