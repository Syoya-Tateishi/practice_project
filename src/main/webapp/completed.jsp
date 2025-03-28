<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("operation") %>完了画面</title>
</head>
<body>
	<h3><%=session.getAttribute("operation") %> が完了しました。<h3>
	<a href="menu.jsp">メニューに戻る</a>
</body>
</html>