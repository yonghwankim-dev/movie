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

class BookTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	
	@Test
	@Disabled
	void getNextBookCodeTest() {
		String nextBookCode = null;
		String regex = "BOOK\\d+";
		try {
			smc.startTransaction();
			nextBookCode = (String) smc.queryForObject("book.getNextBookCode");
			smc.endTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(nextBookCode.matches(regex));
	}

	@Test
	void insertBook() {
		Date book_date = Date.valueOf("2022-05-11");
		BookVO book = new BookVO("BOOK4", 24000, 3, 0, 0, book_date, "SS1", "MEM1");
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = smc.update("book.insertBook", book);
//			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("예약정보 입력 실패");
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	void insertBookSeat() {
		int cnt = 0;
		List<BookSeatVO> bookSeatList = new ArrayList<BookSeatVO>();
		bookSeatList.add(new BookSeatVO("BOOK4", "SEAT91"));
		bookSeatList.add(new BookSeatVO("BOOK4", "SEAT107"));
		
		try {
			smc.startTransaction();
			for(BookSeatVO bookSeat : bookSeatList) {
				cnt += smc.update("book.insertBookSeat", bookSeat);
			}
//			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("예약좌석 정보 입력 실패");
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Assert.assertEquals(2, cnt);
	}
}