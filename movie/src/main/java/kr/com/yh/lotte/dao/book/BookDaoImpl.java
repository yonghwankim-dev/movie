package kr.com.yh.lotte.dao.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.util.SqlMapClientFactory;

public class BookDaoImpl implements IBookDao{

	private SqlMapClient smc;
	
	private static IBookDao bookDao;
	
	private BookDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IBookDao getInstance() {
		if(bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}
	
	@Override
	public String getNextBookCode() {
		String nextBookCode = null;
		
		try {
			smc.startTransaction();
			nextBookCode = (String) smc.queryForObject("book.getNextBookCode");
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("다음 예약코드 참조 실패" + e);
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				System.out.println("sqlMapClient 트랜잭션 종료 실패" + e);
			}
		}
		
		return nextBookCode;
	}

	@Override
	public int insertBook(BookVO book) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = smc.update("book.insertBook", book);
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("예약정보 입력 실패 (insertBook)");
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public int insertBookSeat(List<BookSeatVO> bookSeatList) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			for(BookSeatVO bookSeat : bookSeatList) {
				cnt += smc.update("book.insertBookSeat", bookSeat);
			}
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("예약좌석 정보 입력 실패 (insertBookSeat)" + e);
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				System.out.println("sqlMapClient 트랜잭션 종료 실패" + e);
			}
		}
		
		return cnt;
	}

	@Override
	public int updateScreenSchSeatToBook(List<ScreenSchSeatVO> screenSchSeatList) {
		int cnt = 0;

		try {
			smc.startTransaction();
			for(ScreenSchSeatVO screenSchSeat : screenSchSeatList) {
				cnt += smc.update("book.updateScreenSchSeatToBook", screenSchSeat);	
			}
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("상영일정좌석을 예약으로 변경중 실패" + e);
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				System.out.println("sqlMapClient 트랜잭션 종료 실패" + e);
			}
		}
		return cnt;
	}	
}
