package kr.com.yh.lotte.controller.ticketing;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.com.yh.lotte.service.cinema.CinemaServiceImpl;
import kr.com.yh.lotte.service.cinema.ICinemaService;
import kr.com.yh.lotte.service.screensch.IScreenSchService;
import kr.com.yh.lotte.service.screensch.ScreenSchServiceImpl;
import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.component.CinemaLocationVO;
import kr.com.yh.lotte.vo.component.CinemaTheaterVO;
import kr.com.yh.lotte.vo.component.MovieScreenSchVO;

@WebServlet("/ticketing/orderSettlement.do")
public class OrderSettlementController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public OrderSettlementController() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNm 		= "ticket/orderSettlement"; // 매칭되는 jsp 파일명(확장자 제외)

		req.setAttribute("fileNm", fileNm);
		
		req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
	}
}
