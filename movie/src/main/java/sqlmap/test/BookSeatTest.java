package sqlmap.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.util.SqlMapClientFactory;

class BookSeatTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	@Test
	void deleteBookSeatTest() {
		int cnt = 0;
		List<String> screen_sch_codes = new ArrayList<String>();
		screen_sch_codes.add("SS101");
		screen_sch_codes.add("SS102");
		
		
		try {
			smc.startTransaction();
			List<BookVO> books = smc.queryForList("book.selectBookByScreenSchCodes", screen_sch_codes);
			cnt = smc.delete("bookSeat.deleteBookSeat", books);
			
		} catch (SQLException e) {
			System.out.println("예매좌석 데이터 삭제 테스트중 예외발생");
			e.printStackTrace();
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		assertEquals(4, cnt);
		
		
	}
}
