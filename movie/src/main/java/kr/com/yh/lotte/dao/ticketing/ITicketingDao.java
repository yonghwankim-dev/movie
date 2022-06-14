package kr.com.yh.lotte.dao.ticketing;

import java.util.List;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.MovieInfoVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;


public interface ITicketingDao {
		
	/**
	 * 영화관 지점에서 상영하는 영화 리스트 반환
	 * @param cinema_name 영화관 이름
	 * @return 영화 리스트
	 */
	public List<MovieVO> getMoviesByCinemaName(String cinema_name);
		
	/**
	 * 특정 상영일정코드에 대한 영화상영정보를 반환
	 * @param screen_sch_code 상영일정코드
	 * @return 상영일정객체
	 */
	public MovieScreenSchVO findAllMovieScreenSch(String screen_sch_code);
	
	/**
	 * 특정 영화관 지점에서 상영하는 영화들의 상영시간 리스트 반환
	 * @param map 
	 * key-value : "cinema_name"-cinema_name
	 * key-value : "screen_date"-screen_date
	 * @return
	 */
	public List<MovieScreenSchVO> findAllMovieScreenSch(String cinema_name, String movie_name, String screen_date);
		
	/**
	 * 선택한 영화 예매
	 * @param ticketing 예매 정보를 담은 객체
	 * @return 삽입 행 개수, 1이면 예매성공, 0이면 예매실패
	 */	
//	public int insertTickting(TicketingVO ticketing);
	
	/**
	 * 영화표 생성
	 * @param ticketing 예매 정보를 담은 객체
	 * @return 삽입 행 개수, 1이상이면 영퐈표 생성 성공, 0이면 생성 실패
	 */
//	public int insertMovieTicket(TicketingVO ticketing);
}
