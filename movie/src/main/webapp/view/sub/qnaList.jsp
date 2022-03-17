<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lottecgvbox.vo.QnaVO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<QnaVO> list = (List<QnaVO>)request.getAttribute("list"); //list -> QnaList.java에서 set.Attribute로 세팅해준 값을 얻어옴
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
			for(QnaVO vo : list){
				if(i>0) out.print(",");
%>		
				{
					"qna_num"		: "<%=vo.getQna_num() %>",
					"mem_cd"	: "<%=vo.getMem_cd() %>",
					"nmem_cd"	: "<%=vo.getNmem_cd() %>",
					"qna_wri"		: "<%=vo.getQna_wri() %>",
<%					if(vo.getQna_tit() != null){ %>
					"qna_tit"		: "<%=vo.getQna_tit().replaceAll("\r\n", "<br>") %>",
<%					}else{ %>
					"qna_tit"		: "",
<%					} %>		
					"qna_con"		: "<%=vo.getQna_con().trim() %>"
				}
<%		
				i++;
			}
%>
			]
		}