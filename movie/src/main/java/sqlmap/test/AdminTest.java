package sqlmap.test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.ScreenSchVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;
import kr.com.yh.util.SqlMapClientFactory;

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
}
