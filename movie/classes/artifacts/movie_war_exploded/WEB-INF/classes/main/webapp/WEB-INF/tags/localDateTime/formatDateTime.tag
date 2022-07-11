<%@tag import="java.time.format.DateTimeFormatter"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty"%>

<%@ tag import="java.time.LocalDateTime" %>
<%@ tag import="java.time.format.DateTimeFormatter" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ attribute name="value" required="true" type="java.lang.String" %>
<%@ attribute name="pattern" required="false" type="java.lang.String" %>            
<%
	LocalDateTime result = LocalDateTime.parse(value);
	pattern = pattern == null ? "YYYY-MM-dd" : pattern;
%>
<%= result.format(DateTimeFormatter.ofPattern(pattern)) %>