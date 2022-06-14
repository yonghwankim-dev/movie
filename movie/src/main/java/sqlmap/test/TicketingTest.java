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

import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;
import kr.com.yh.util.SqlMapClientFactory;

class TicketingTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	@Test
	void getMoviesByCinemaNameAndMovieNameTest() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("ticketing.getMoviesByCinemaNameAndMovieName");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertNotNull(list);		
	}
	
	@Test
	void findAllMovieScreenSchListTest() {
		List<MovieScreenSchVO> list = new ArrayList<MovieScreenSchVO>();
		String cinema_name = "동해";
		String movie_name = "이상한 나라의 수학자";
		String screen_date = "2022-06-15";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("cinema_name", cinema_name);
		map.put("movie_name", movie_name);
		map.put("screen_date", screen_date);
		
		try {
			list = smc.queryForList("ticketing.findAllMovieScreenSch", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		Assert.assertNotNull(list);
	}
	
	@Test
	void findAllMovieScreenSchListByScreenSchCodeTest() {
		MovieScreenSchVO movieScreenSch = new MovieScreenSchVO();
		String screen_sch_code = "SS1";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("screen_sch_code", screen_sch_code);
		
		try {
			movieScreenSch = (MovieScreenSchVO) smc.queryForObject("ticketing.findAllMovieScreenSch", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(movieScreenSch);
	}
}
