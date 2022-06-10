<%@tag import="java.util.Locale"%>
<%@tag import="java.time.format.TextStyle"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty"%>

<%@ tag import="java.time.LocalDateTime" %>

<%@ tag trimDirectiveWhitespaces="true" %>

<%@ attribute name="value" required="true" type="java.lang.String" %>
<%
	LocalDateTime result = LocalDateTime.parse(value);
%>
<%= result.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN) %>