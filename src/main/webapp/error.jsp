<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("message") %></title>
<jsp:include page="header.jsp" />
</head>
<body>
	<h3><%=session.getAttribute("message") %><h3>
	<a href="menu.jsp">MENUへ</a>
</body>
</html>