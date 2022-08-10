package test.java.kr.com.yh.service;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.vo.CinemaSearch;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CinemaTest {

	private ICinemaService cinemaService;
	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		cinemaService = CinemaServiceImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}

	@Test
	public void 영화관전체검색() throws Exception{
	    //given
		List<CinemaVO> cinemas = null;

	    //when
		cinemas = cinemaService.findAll();

	    //then
		assertThat(cinemas).isNotNull();
	}
	
	@Test
	public void 영화관전체검색_이름() throws Exception{
	    //given
	    String category = "NAME";
		String content  = "당진";
		String loc      = "";
		CinemaSearch cinemaSearch = CinemaSearch.createCinemaSearch(content, category, loc);
		List<CinemaVO> cinemas = null;

	    //when
	    cinemas = cinemaService.findAll(cinemaSearch);

	    //then
		assertThat(cinemas).isNotNull();
	}
	
	@Test
	public void 영화관전체검색_지역() throws Exception{
		//given
		String category = "loc";
		String content  = "";
		String loc      = "광주/전라";
		CinemaSearch cinemaSearch = CinemaSearch.createCinemaSearch(content, category, loc);
		List<CinemaVO> cinemas = null;

		//when
		cinemas = cinemaService.findAll(cinemaSearch);

		//then
		assertThat(cinemas).isNotNull();
	}
	
	@Test
	public void 영화관지역전체검색() throws Exception{
	    //given
		List<String> locations = null;

	    //when
		locations = cinemaService.findAllLocation();

	    //then
		assertThat(locations).isNotNull();
	}
}
