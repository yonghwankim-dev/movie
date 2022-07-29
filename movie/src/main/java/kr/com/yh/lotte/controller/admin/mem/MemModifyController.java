package kr.com.yh.lotte.controller.admin.mem;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.mem.IMemService;
import kr.com.yh.lotte.service.mem.MemServiceImpl;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "MemModifyController", urlPatterns = UrlPaths.MEM_MODIFY)
public class MemModifyController extends HttpServlet {

    private IMemService memberService;

    public MemModifyController(){
        memberService = MemServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mem_code = req.getParameter("mem_code");
        String fileNm = "admin/mem/memModify";

        MemberVO mem = memberService.findMemberByMemberCode(mem_code);

        req.setAttribute("mem", mem);
        req.setAttribute("fileNm", fileNm);
        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mem_code = req.getParameter("mem_code");
        String name     = req.getParameter("name");
        Date birthday   = Date.valueOf(req.getParameter("year")
                                  + "-" + req.getParameter("month")
                                  + "-" + req.getParameter("day"));
        String contact  = req.getParameter("firstTel")
                        + "-"
                        + req.getParameter("middleTel")
                        + "-" + req.getParameter("lastTel");
        String addr     = req.getParameter("zip")
                        + " "
                        + req.getParameter("loadAdd")
                        + " "
                        + req.getParameter("detailAdd");
        String email    = req.getParameter("userId")
                        + "@"
                        + req.getParameter("userServer");
        String id       = req.getParameter("id");
        String gender   = req.getParameter("gender");

        MemberVO mem = MemberVO.builder()
                               .mem_code(mem_code)
                               .name(name)
                               .birthday(birthday)
                               .contact(contact)
                               .addr(addr)
                               .email(email)
                               .id(id)
                               .gender(gender)
                               .build();

        int cnt = memberService.modifyMemberByMemberCode(mem);
        AjaxResponse result = new AjaxResponse(resp);
        if(cnt > 0){
            result.addToResMap("code","ok");
        }else{
            result.addToResMap("code", "no");
        }

        result.write();
    }
}
