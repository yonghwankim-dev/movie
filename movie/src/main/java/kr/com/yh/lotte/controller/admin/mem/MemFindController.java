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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "MemFindController", urlPatterns = UrlPaths.MEM_FIND)
public class MemFindController extends HttpServlet {

    private IMemService memberService;

    public MemFindController(){
        memberService = MemServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        String fileNm = "admin/mem/memHome";
        String category = req.getParameter("category");
        String content     = req.getParameter("content");

        List<MemberVO> mems = new ArrayList<>();

        if(category.equals("name")){
            mems = memberService.findMemberByName(content);
        }else if(category.equals("id")){
            mems = memberService.findMemberById(content);
        }else if(category.equals("contact")){
            mems = memberService.findMemberByContact(content);
        }

        req.setAttribute("mems", mems);
        req.setAttribute("fileNm", fileNm);

        req.getRequestDispatcher("/view/sub.jsp").forward(req, resp);
    }
}
