package sqlmap.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibatis.sqlmap.client.SqlMapClient;


import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.util.SqlMapClientFactory;

class MovieTest {

	
	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	@Test
	void getMovieMainTest() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			list = smc.queryForList("movie.getMovieMain");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertNotNull(list);
	}


}
