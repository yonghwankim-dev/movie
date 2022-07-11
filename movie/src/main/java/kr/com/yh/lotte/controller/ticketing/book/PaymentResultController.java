package kr.com.yh.lotte.controller.ticketing.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ticket/book/paymentResult")
public class PaymentResultController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = "ticket/paymentResult";
		req.setAttribute("fileNm", fileName);
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
	

}
