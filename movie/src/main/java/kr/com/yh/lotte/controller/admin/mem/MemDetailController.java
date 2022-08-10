package kr.com.yh.lotte.controller.admin.mem;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.mem.IMemService;
import kr.com.yh.lotte.service.mem.MemServiceImpl;
import kr.com.yh.lotte.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemDetailController", urlPatterns = UrlPaths.MEM_DETAIL)
public class MemDetailController extends HttpServlet {

    private IMemService memberService;

    public MemDetailController(){
        memberService = MemServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileNm = "admin/mem/memDetail";
        String mem_code = req.getParameter("mem_code");

        MemberVO mem = memberService.findOne(mem_code);

        req.setAttribute("mem", mem);
        req.setAttribute("fileNm", fileNm);
        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }
}
