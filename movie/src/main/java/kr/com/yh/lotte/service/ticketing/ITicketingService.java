package kr.com.yh.lotte.service.ticketing;

import java.util.List;
import java.util.Map;

import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.TicketingVO;
import kr.com.yh.lotte.vo.wrapper.CinemaLocationVO;
import kr.com.yh.lotte.vo.wrapper.ScreenDateVO;

/**
 * @title 회원 예매 서비스
 * @author 김용환
 * @date 2022-03-17
 * @version 1.0.0
 * 
 */
public interface ITicketingService {
	
	/**
	 * 지역 리스트를 반환
	 * @return 지역 리스트
	 */
	public List<CinemaLocationVO> getLocationList();
	
	/**
	 * 모든 영화관 지점들의 리스트를 반환
	 * @return 영화관 지점 리스트 
	 */
	public List<CinemaVO> getCinemaList();
	
	/**
	 * 영화관 지점에서 상영하는 영화 리스트 반환
	 * @param cinema_name 영화관 이름
	 * @return 영화 리스트
	 */
	public List<MovieVO> getMoviesByCinemaNameAndMovieTitle(String cinema_name, String movie_title);
		
	/**
	 * 특정 영화관 지점에서 상영하는 영화들의 상영시간 리스트 반환
	 * @param cinema_name 영화관지점
	 * @param screen_date 상영일자
	 * @return	상영 객체 리스트
	 */
	public List<ScreenDateVO> findAllScreenListByCinemaName(String cinema_name, String movie_title, String screen_date);

	/**
	 * 선택한 영화 상영 일정에 대한 영화정보 객체 반환
	 * @param screen_code 선택한 상영 일정
	 * @return 영화정보 객체
	 */
//	public MovieInfoVO getMovieInfoByScreenCode(String screen_code);

	/**
	 * 선택한 영화 예매
	 * @param ticketing 예매 정보를 담은 객체
	 * @return 삽입 행 개수, 1이면 예매성공, 0이면 예매실패
	 */
	public int insertTickting(TicketingVO ticketing);

	/**
	 * 영화표 생성
	 * @param ticketing 예매 정보를 담은 객체
	 * @return 삽입 행 개수, 1이상이면 영퐈표 생성 성공, 0이면 생성 실패
	 */
	public int insertMovieTicket(TicketingVO ticketing);
}
