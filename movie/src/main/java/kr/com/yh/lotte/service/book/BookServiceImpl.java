package kr.com.yh.lotte.service.book;

import kr.com.yh.lotte.dao.book.BookDaoImpl;
import kr.com.yh.lotte.dao.book.IBookDao;
import kr.com.yh.lotte.vo.BookSeatVO;
import kr.com.yh.lotte.vo.BookVO;
import kr.com.yh.lotte.vo.ScreenSchSeatVO;
import kr.com.yh.lotte.vo.SeatVO;
import kr.com.yh.lotte.vo.component.PaymentResultVO;

import java.util.List;

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
		return bookDao.bookSeat(book, bookSeatList, screenSchSeatList);
	}

	@Override
	public PaymentResultVO getPaymentResultInfo(String book_code) {
		return bookDao.getPaymentResultInfo(book_code);
	}

	@Override
	public List<SeatVO> getPaymentResultSeatsInfo(String book_code) {
		return bookDao.getPaymentResultSeatsInfo(book_code);
	}
}
