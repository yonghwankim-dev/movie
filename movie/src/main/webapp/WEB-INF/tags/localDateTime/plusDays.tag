<%@tag import="java.time.format.DateTimeFormatter"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty"%>
<%@ tag import="java.time.LocalDateTime" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ attribute name="value"  required="true" type="java.lang.String" %>
<%@ attribute name="days" required="true" type="java.lang.Integer" %>

<%
	LocalDateTime result = LocalDateTime.parse(value);
%>
<%= result.plusDays(days) %>