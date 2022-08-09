package test.java.kr.com.yh.service;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.service.movie.IMovieService;
import kr.com.yh.lotte.service.movie.MovieServiceImpl;
import kr.com.yh.lotte.vo.MovieSearch;
import kr.com.yh.lotte.vo.MovieSearchCategory;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
	void findAllTest() {
		//given
		List<MovieVO> list = new ArrayList<MovieVO>();

		//when
		list = movieService.findAll();

		//then
		System.out.println(list);
		assertThat(list).isNotNull();
	}

	@Test
	void findAllByNameTest() {
		//given
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieSearch movieSearch = MovieSearch.builder()
											 .content("더 배트맨")
											 .movieSearchCategory(MovieSearchCategory.NAME)
											 .build();

		//when
		list = movieService.findAll(movieSearch);

		//then
		assertThat(list).isNotNull();
		assertThat(list.get(0).getName()).isEqualTo("더 배트맨");
	}


}
