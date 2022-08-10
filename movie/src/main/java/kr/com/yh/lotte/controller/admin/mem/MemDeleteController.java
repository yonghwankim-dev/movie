package kr.com.yh.lotte.controller.admin.mem;

import kr.com.yh.lotte.UrlPaths;
import kr.com.yh.lotte.service.mem.IMemService;
import kr.com.yh.lotte.service.mem.MemServiceImpl;
import kr.com.yh.util.AjaxResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MemDeleteController", urlPatterns = UrlPaths.MEM_DELETE)
public class MemDeleteController extends HttpServlet {

    private IMemService memberService;

    public MemDeleteController(){
        memberService = MemServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> mem_codes = Arrays.asList(req.getParameterValues("mem_code"));
        AjaxResponse ajaxResponse = new AjaxResponse(resp);

        int cnt = memberService.delete(mem_codes);

        if(cnt > 0){
            ajaxResponse.addToResMap("code", "ok");
        }else{
            ajaxResponse.addToResMap("code", "no");
        }

        ajaxResponse.write();
    }
}
