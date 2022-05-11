package kr.com.yh.lotte.service.book;

import java.util.List;

import kr.com.yh.lotte.dao.book.BookDaoImpl;
import kr.com.yh.lotte.dao.book.IBookDao;
import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;

public class BookServiceImpl implements IBookService{

	private static IBookService bookService;
	
	private IBookDao bookDao;
	
	private BookServiceImpl() {
		bookDao = BookDaoImpl.getInstance();
	}
	
	public static IBookService getInstance() {
		if(bookService == null) {
			bookService = new BookServiceImpl();
		}
		return bookService;
	}
	
	@Override
	public String getNextBookCode() {
		return bookDao.getNextBookCode();
	}

	@Override
	public int bookSeat(BookVO book, List<BookSeatVO> bookSeatList, List<ScreenSchSeatVO> screenSchSeatList) {
		int cnt = 0;
		
		// 1. 예약정보 입력
		cnt = bookDao.insertBook(book);
		if(cnt == 0) {
			return 0;
		}
		
		// 2. 예약정보를 기반으로 예약좌석 정보 입력
		cnt = bookDao.insertBookSeat(bookSeatList);
		if(cnt == 0) {
			return 0;
		}
		
		// 3. 상영일정 좌석의 상태를 에약상태로 변경
		cnt = bookDao.updateScreenSchSeatToBook(screenSchSeatList);
		if(cnt == 0) {
			return 0;
		}
		
		return cnt;
	}
	
	
}
