package sqlmap.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.util.SqlMapClientFactory;

class CinemaTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	@Test
	void getLocationListTest() {
		List<CinemaLocationVO> list = new ArrayList<CinemaLocationVO>();
		
		try {
			list = smc.queryForList("cinema.getLocationList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertNotNull(list);
	}
	
	@Test
	void getCinemaListTest() {
		List<CinemaVO> list = new ArrayList<CinemaVO>();
		
		try {
			list = smc.queryForList("cinema.getCinemaList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertNotNull(list);
	}

}
