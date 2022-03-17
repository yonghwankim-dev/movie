<%@page import="kr.or.ddit.lottecgvbox.vo.PaymentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<PaymentVO> list = (List<PaymentVO>)request.getAttribute("list");
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
			for(PaymentVO vo : list){
				if(i>0) out.print(",");
%>		
				{
					"pay_sc_num"		: "<%=vo.getPay_sc_num() %>",
					"mem_cd"			: "<%=vo.getMem_cd() %>",
					"nmem_cd"			: "<%=vo.getNmem_cd() %>",
					"pay_sc_wri"		: "<%=vo.getPay_sc_wri() %>",
<%					if(vo.getPay_sc_tit() != null){ %>
					"pay_sc_tit"		: "<%=vo.getPay_sc_tit().replaceAll("\r\n", "<br>") %>",
<%					}else{ %>
					"pay_sc_tit"		: "",
<%					} %>
					"pay_sc_con"		: "<%=vo.getPay_sc_con().trim() %>"
				}
<%		
				i++;
			}
%>
			]
		}