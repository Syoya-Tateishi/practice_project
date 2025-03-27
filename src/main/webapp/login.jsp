<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>

<style>

</style>
</head>
<body>
	<h2>ログインしましょう！</h2>

	<form action="login" method="post">

		ユーザーID<br>
		<input type="text" name="userId" required size="20"><br>
		<br>
		パスワード<br>
		<input type="password" name="pass" required size="20"><br>
		<br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>