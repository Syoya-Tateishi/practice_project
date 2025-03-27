<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<jsp:include page="header.jsp" />
<style>

</style>
</head>
<body>
<h2>削除してよろしいですか？</h2>
	<form action="CustomerList" method="get">
		<input type="submit" value="顧客情報一覧へ戻る"><br>
	</form>
	<br>
<form action="ConfirmDelete" method="post">
    <input type="hidden" name="customerCode" value="<%= request.getParameter("customerCode") %>">
    <input type="hidden" name="action" value="delete">
    <input type="submit" value="削除">
</form>
</body>
</html>