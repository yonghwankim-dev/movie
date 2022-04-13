package kr.com.yh.lotte.dao.admin;

import java.util.List;
import java.util.Map;

import kr.com.yh.lotte.vo.ScreenVO;

public interface IAdminDao {
	/**
	 * 관리자가 상영일정을 관리하기 위해서 모든 상영일정을 가져옴
	 * @return 모든 상영일정이 담긴 리스트
	 */
	public List<ScreenVO> getAllScreenDate();

	
	/**
	 * 관리자가 상영일정을 추가함
	 * @return 상영 일정 추가행 개수
	 * 		   1 : 성공, 0 : 실패
	 */
	public int insertScreen(ScreenVO screen);


	/**
	 * 영화제목의 영화코드 반환
	 * @param movie_title 영화제목
	 * @return 영화코드
	 */
	public String getMovieCodeByMovieTitle(String movie_title);
	
	/**
	 * 상영관의 상영코드 반환
	 * @param cinema_name	영화관지점
	 * @param theater_name	상영관이름
	 * @return	상영코드
	 */
	public String getTheaterCodeByTheaterName(Map<String,String> map);

	/**
	 * 상영일정들을 제거
	 * @param screen_codes 상영코드들을 담은 리스트
	 * @return 삭제한 상영일정 개수
	 */
	public int deleteScreen(List<String> screen_codes);
}
