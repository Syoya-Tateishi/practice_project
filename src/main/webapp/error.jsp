<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("operation") %>エラー画面</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<h3><%=session.getAttribute("operation") %>エラーが発生しました。<h3>
	<a href="menu.jsp">MENUへ</a>
</body>
</html>