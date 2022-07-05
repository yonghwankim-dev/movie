package kr.com.yh.lotte.controller.ticketing.orderSettlement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.com.yh.lotte.service.book.BookServiceImpl;
import kr.com.yh.lotte.service.book.IBookService;
import kr.com.yh.util.UpdateResult;

@WebServlet("/ticketing/orderSettlement/getNextBookCode")
public class GetNextBookCodeController extends HttpServlet{

	private IBookService bookService;
	
	
	
	public GetNextBookCodeController() {
		this.bookService = BookServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateResult result = new UpdateResult(response);
		String book_code = bookService.getNextBookCode();
		
		
		if(book_code != null) {
			result.addToResMap("code", "ok");
			result.addToResMap("book_code", book_code);
		}else {
			result.addToResMap("code", "no");
		}
		
		result.write();
	}
}
