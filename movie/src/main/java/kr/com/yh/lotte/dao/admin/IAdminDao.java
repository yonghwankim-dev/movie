package kr.com.yh.lotte.dao.admin;

import java.util.List;
import java.util.Map;

import kr.com.yh.lotte.vo.ScreenVO;
import kr.com.yh.lotte.vo.component.ScreenAdminVO;

public interface IAdminDao {

	/**
	 * 관리자가 관리하는 상영일정 정보를 가져옴
	 * - 영화코드
	 * - 영화제목
	 * - 지역
	 * - 영화관 이름
	 * - 상영관 코드
	 * - 상영관 이름
	 * - 상영시작 일자
	 * - 상영종료 일자
	 * @param cinema_name 영화관 지점
	 * @return 모든 상영일정 정보가 담긴 리스트
	 */
	public List<ScreenAdminVO> getAllScreenAdmin();

	
	/**
	 * 관리자가 상영일정을 추가함
	 * @return 상영 일정 추가행 개수
	 * 		   1 : 성공, 0 : 실패
	 */
	public int insertScreen(ScreenVO screen);


	/**
	 * 영화제목의 영화코드 반환
	 * @param movie_name 영화제목
	 * @return 영화코드
	 */
	public String getMovieCodeByMovieName(String movie_name);
	
	/**
	 * 상영관의 상영코드 반환
	 * @param cinema_name	영화관지점
	 * @param theater_name	상영관이름
	 * @return	상영코드
	 */
	public String getTheaterCodeByCinemaNameAndTheaterName(Map<String,String> map);

	/**
	 * 상영일정들을 제거
	 * @param screen_codes 상영코드들을 담은 리스트
	 * @return 삭제한 상영일정 개수
	 */
	public int deleteScreen(List<String> screen_codes);
}
