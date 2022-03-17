<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int del = (int)request.getAttribute("del");
	int a = del;
%>
{
	"data" : "<%=del %>"
}
