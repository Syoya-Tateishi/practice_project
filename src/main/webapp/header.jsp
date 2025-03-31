<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ヘッダー</title>
	<style>

	.header {
    	position: relative;
    	text-align:center;
    	margin: 0;
    	padding: 0;
    	background-color: gray; /* ヘッダーの背景色を追加 */
    	background-position: center;
    	height: 10vh;
    	border-radius: 10px; /* 角を丸くする */
	}
    .header img {
        height: 50px;
        padding-top: 7px;
        
    }
    .menu-button, .logout-button {
        position: absolute;
        top: 7px;
        background-color: transparent;
        border: outset; /* ボーダーを無くす */
        padding: 10px;
        cursor: pointer;
        text-decoration: none;
        color: white;
        font-size: 15px; /* フォントサイズを調整 */
        border-radius: 5px; /* ボタンの角を丸くする */
        transition: background-color 0.3s; /* ホバー時のアニメーション */
    }
    .menu-button:hover, .logout-button:hover {
        background-color: black; /* ホバー時の背景色 */
        }
    .menu-button {
        left: 10px;
        text-align: center;
        padding: 10px;
    }
    .logout-button {
        right: 10px;
        text-align: center;
        padding: 10px;
    }
	</style>
	<body>
    <div class="header">
        <img src="ti.jpg" alt="logo">
        <a class="menu-button" href="menu.jsp">MENU</a>
		<form action="logout" method="post" style="display: inline;">
        <input type="submit" class="logout-button" value="ログアウト">;
    </body>
    
    