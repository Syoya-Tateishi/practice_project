<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了画面</title>
</head>
<body>
	<h3>削除しました。</h3>
	<h3><%=session.getAttribute("Delete") %> の削除が完了。<h3>
	<a href="menu.jsp">メニューに戻る</a>
</body>
</html>