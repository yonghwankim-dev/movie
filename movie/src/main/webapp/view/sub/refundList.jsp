<%@page import="kr.or.ddit.lottecgvbox.vo.RefundVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<RefundVO> list = (List<RefundVO>)request.getAttribute("list");
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
	for(RefundVO vo : list){
		if(i>0) out.print(",");
%>		
				{
					"ref_sc_num"		: "<%=vo.getRef_sc_num() %>",
					"mem_cd"			: "<%=vo.getMem_cd() %>",
					"nmem_cd"			: "<%=vo.getNmem_cd() %>",
					"ref_sc_wri"		: "<%=vo.getRef_sc_wri() %>",
<%					if(vo.getRef_sc_tit() != null){ %>
					"ref_sc_tit"		: "<%=vo.getRef_sc_tit().replaceAll("\r\n", "<br>") %>",
<%					}else{ %>
					"ref_sc_tit"		: "",
<%					} %>	
					"ref_sc_con"		: "<%=vo.getRef_sc_con().trim() %>"
				}
<%		
				i++;
			}
%>
			]
		}