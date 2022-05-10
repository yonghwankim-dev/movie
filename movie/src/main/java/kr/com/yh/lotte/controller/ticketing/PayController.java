package kr.com.yh.lotte.controller.ticketing;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.com.yh.lotte.service.ticketing.ITicketingService;
import kr.com.yh.lotte.service.ticketing.TicketingServiceImpl;
import kr.com.yh.lotte.vo.CinemaVO;
import kr.com.yh.lotte.vo.MovieVO;
import kr.com.yh.lotte.vo.ScreenVO;

@WebServlet("/pay.do")
public class PayController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ITicketingService ticketingService;
	
	public PayController() {
		ticketingService = TicketingServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int	   ticket_num	  = -1;
		Date   ticket_date 	  = Date.valueOf(req.getParameter("ticket_date"));	// 에매일자
		String person_10      = req.getParameter("person_10");					// 청소년 인원수
		String person_20      = req.getParameter("person_20");					// 성인 인원수
		String person_12      = req.getParameter("person_12");					// 노약자 인원수
		int    ticket_cnt 	  = Integer.parseInt(person_10) 
				   			  + Integer.parseInt(person_20)
				   			  + Integer.parseInt(person_12);					// 예매인원수
		int ticket_price      = Integer.parseInt(req.getParameter("price"));	// 예매가격
		String mem_code 	  = req.getParameter("mem_code");					// 회원코드
		String screen_code 	  = req.getParameter("screen_code");				// 상영코드
		String seat           = req.getParameter("seat");						// 예매 좌석들
		
		// 실행 결과
		int cnt = 0;
		Map<String, Object> resMap = new HashMap<String, Object>();
		Gson gson = new Gson();
		String jsonData = null;
		PrintWriter out = resp.getWriter();
		
		
//		TicketingVO ticketing = new TicketingVO(ticket_num
//											  , ticket_date
//											  , ticket_cnt
//											  , ticket_price
//											  , mem_code
//											  , screen_code
//											  , seat);
//		
//		cnt = ticketingService.insertTickting(ticketing);
		
		if(cnt>0)
		{
			resMap.put("code", "ok");
		}
		else
		{
			resMap.put("code", "no");
		}
		
		jsonData = gson.toJson(resMap);
		out.write(jsonData);
		out.flush();
	}
}
