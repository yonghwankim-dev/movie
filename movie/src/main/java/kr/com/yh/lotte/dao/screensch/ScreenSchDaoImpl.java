package kr.com.yh.lotte.dao.screensch;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.component.MovieScreenSchVO;
import kr.com.yh.util.SqlMapClientFactory;

public class ScreenSchDaoImpl implements IScreenSchDao{

	private SqlMapClient smc;
	
	private static IScreenSchDao screenSchDao;
	
	private ScreenSchDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IScreenSchDao getInstance() {
		if(screenSchDao == null) {
			screenSchDao = new ScreenSchDaoImpl();
		}
		return screenSchDao;
	}
	
	
	@Override
	public String getNextScreenSchCode() {
		String screen_sch_code = null;
		try {
			screen_sch_code = (String) smc.queryForObject("screensch.getNextScreenSchCode");
		} catch (SQLException e) {
			System.out.println("getNextScreenSchCode 수행 실패" + e);
		}
		return screen_sch_code;
	}

	@Override
	public List<MovieScreenSchVO> findBookSeatCnt(List<MovieScreenSchVO> screenSchs) {
		if(screenSchs != null) {
			try {
				for(MovieScreenSchVO screenSch : screenSchs) {
					int book_seat_cnt = (int) smc.queryForObject("screensch.findBookSeatCnt", screenSch);
					screenSch.setBook_seat_cnt(book_seat_cnt);
				}			
			}catch (SQLException e) {
				System.out.println("findBookSeatCnt SQL 실패" + e);
			}
		}		
		return screenSchs;
	}
}
