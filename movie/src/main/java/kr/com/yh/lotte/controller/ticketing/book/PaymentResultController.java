package kr.com.yh.lotte.controller.ticketing.book;

import kr.com.yh.lotte.service.book.BookServiceImpl;
import kr.com.yh.lotte.service.book.IBookService;
import kr.com.yh.lotte.vo.component.PaymentResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ticket/book/paymentResult")
public class PaymentResultController extends HttpServlet{
	private IBookService bookService;

	public PaymentResultController() {
		this.bookService = BookServiceImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = "ticket/paymentResult";
		String book_code = req.getParameter("book_code");

		PaymentResultVO paymentResult = bookService.getPaymentResultInfo(book_code);
		paymentResult.setSeats(bookService.getPaymentResultSeatsInfo(book_code));

		System.out.println(paymentResult);
		req.setAttribute("paymentResult", paymentResult);
		req.setAttribute("fileNm", fileName);

		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
	

}
