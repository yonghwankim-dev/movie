package kr.com.yh.lotte.dao.book;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.SeatVO;
import kr.com.yh.lotte.vo.component.PaymentResultVO;
import kr.com.yh.util.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.List;

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
	public int insertBook(BookVO book){
		try {
			return smc.update("book.insertBook", book);
		} catch (SQLException e) {
			System.out.println("insertBook 수행 실패" + e);
		};
		return 0;
	}

	@Override
	public int insertBookSeat(List<BookSeatVO> bookSeatList) {
		int cnt = 0;
		try {
			for(BookSeatVO bookSeat : bookSeatList) {
				cnt += smc.update("book.insertBookSeat", bookSeat);
			}
		}catch(SQLException e) {
			System.out.println("insertBookSeat 수행중 실패" + e);
			cnt = 0;
		}
		return cnt;
	}

	@Override
	public int updateScreenSchSeatToBook(List<ScreenSchSeatVO> screenSchSeatList) {
		int cnt = 0;
		
		try {
			for(ScreenSchSeatVO screenSchSeat : screenSchSeatList) {
				cnt += smc.update("book.updateScreenSchSeatToBook", screenSchSeat);	
			}
		}catch(SQLException e) {
			System.out.println("updateScreenSchSeatToBook 수행중 실패" + e);
			cnt = 0;
		}
		
		return cnt;
	}

	@Override
	public int bookSeat(BookVO book, List<BookSeatVO> bookSeatList, List<ScreenSchSeatVO> screenSchSeatList){
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = insertBook(book);
			if(cnt == 0) {
				return cnt;
			}
			cnt = insertBookSeat(bookSeatList);
			if(cnt == 0) {
				return cnt;
			}
			cnt = updateScreenSchSeatToBook(screenSchSeatList);
			if(cnt == 0) {
				return cnt;
			}
			smc.commitTransaction();
		} catch (SQLException e) {
			System.out.println("bookSeat 수행중 실패 " + e);
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
	public PaymentResultVO getPaymentResultInfo(String book_code) {
		PaymentResultVO paymentResult = null;

		try{
			paymentResult = (PaymentResultVO) smc.queryForObject("book.getPaymentResultInfo", book_code);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return paymentResult;
	}

	@Override
	public List<SeatVO> getPaymentResultSeatsInfo(String book_code) {
		List<SeatVO> seats = null;

		try {
			seats = smc.queryForList("book.getPaymentResultSeatsInfo", book_code);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return seats;
	}
}
