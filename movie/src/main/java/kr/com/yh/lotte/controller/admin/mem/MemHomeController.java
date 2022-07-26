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
import java.util.List;

@WebServlet(name = "MemHomeController", urlPatterns = UrlPaths.MEM_HOME)
public class MemHomeController extends HttpServlet {

    private IMemService memberService;

    public MemHomeController(){
        memberService = MemServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MemberVO> mems = memberService.findMemberAll();
        String fileNm = "admin/mem/memHome";

        req.setAttribute("mems", mems);
        req.setAttribute("fileNm", fileNm);

        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }
}
