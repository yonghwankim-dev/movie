<%@page import="kr.or.ddit.lottecgvbox.vo.LostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<LostVO> list = (List<LostVO>)request.getAttribute("list");
int sPage = (Integer)request.getAttribute("sPage");
int ePage = (Integer)request.getAttribute("ePage");
int ttPage = (Integer)request.getAttribute("ttPage");
%>
		{
			"sp"		: "<%=sPage%>",
			"ep"		: "<%=ePage%>",
			"tp"		: "<%=ttPage%>",
			"datas"	: [
<%
			int i = 0;
			for(LostVO vo : list){
				if(i>0) out.print(",");
%>		
				{
					"lost_num"		: "<%=vo.getLost_num() %>",
					"mem_cd"		: "<%=vo.getMem_cd() %>",
					"nmem_cd"		: "<%=vo.getNmem_cd() %>",
					"lost_wri"		: "<%=vo.getLost_wri() %>",
<%					if(vo.getLost_tit() != null){ %>
					"lost_tit"		: "<%=vo.getLost_tit().replaceAll("\r\n", "<br>") %>",
<%					}else{ %>
					"lost_tit"		: "",	
<%					} %>
					"lost_con"		: "<%=vo.getLost_con().trim() %>"
				}
<%	
				i++;
			}
%>
			]
		}