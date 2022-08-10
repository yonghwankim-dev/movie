package test.java.kr.com.yh.service;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MovieServiceTest {

	
	private SqlMapClient smc;
	private IMovieService movieService;
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
		movieService = MovieServiceImpl.getInstance();
	}

	@Test
	void 영화전체검색() {
		//given
		List<MovieVO> list = new ArrayList<MovieVO>();

		//when
		list = movieService.findAll();

		//then
		System.out.println(list);
		assertThat(list).isNotNull();
	}

	@Test
	void 영화전체검색_이름() {
		//given
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieSearch movieSearch = MovieSearch.createMovieSearch("더 배트맨", "NAME");

		//when
		list = movieService.findAll(movieSearch);

		//then
		assertThat(list).isNotNull();
		assertThat(list.get(0).getName()).isEqualTo("더 배트맨");
	}

	@Test
	public void 영화단일검색() throws Exception{
	    //given
	    String movie_code = "MOVIE1";

	    //when
		MovieVO movie = movieService.findOne(movie_code);

	    //then
		assertThat(movie.getName()).isEqualTo("더 배트맨");
	}

	@Test
	public void 영화추가() throws Exception{
	    //given
	    MovieVO movie = MovieVO.builder()
				               .name("토르4")
				               .audi_rating(12)
				               .runtime(150)
				               .build();

	    //when
		smc.startTransaction();
	    int cnt = smc.update("movie.save", movie);
		smc.endTransaction();

	    //then
		assertThat(cnt).isEqualTo(1);
	}

	@Test
	public void 영화제거() throws Exception{
	    //given
	    List<String> movie_codes = new ArrayList<>(Arrays.asList("MOVIE7"));

	    //when
		smc.startTransaction();
		int cnt = smc.delete("movie.deleteAll", movie_codes);
		smc.endTransaction();

	    //then
		assertThat(cnt).isEqualTo(1);
	}


}
