<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh; /* ビューポートの高さを100%に設定 */
            margin: 0; /* デフォルトのマージンをリセット */
            background-color: #f0f0f0; /* 背景色を設定 */
        }
		form {
    		border: 1px solid #ccc;
    		border-radius: 10px;
    		padding: 20px;
    		background: linear-gradient(135deg, #f0f0f0 25%, #d9d9d9 25%, #d9d9d9 50%, #f0f0f0 50%, #f0f0f0 75%, #d9d9d9 75%, #d9d9d9); /* グラデーションの設定 */
    		background-size: 20px 20px; /* パターンのサイズを設定 */
    		box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
    		width: 215px;
		}
        .arrow {
            font-size: 20px;
            animation: moveArrow 1s infinite alternate;
            margin: 20px 0; /* 矢印の上下の余白 */
        }
        @keyframes moveArrow {
            0% { transform: translateX(0); }
            100% { transform: translateX(10px); }
        }
        input[type="submit"] {
            margin-top: 20px; /* ボタンの上に余白を追加 */
            width: 100px; /* ボタンの幅を150pxに設定 */
            display: block; /* ブロック要素にして中央に配置 */
            margin-left: auto; /* 左のマージンを自動に設定 */
            margin-right: auto; /* 右 */
            
  			border-radius : 50%;          /* 角丸       */
  			font-size     : 10pt;        /* 文字サイズ */
  			text-align    : center;      /* 文字位置   */
  			cursor        : pointer;     /* カーソル   */
  			padding       : 12px 12px;   /* 余白       */
  			background    : gray;     /* 背景色     */
  			color         : white;     /* 文字色     */
  			line-height   : 1em;         /* 1行の高さ  */
  			border        : 1px solid #999999;    /* 枠の指定 */
        }
        h2 {
            background-color: gray; /* 背景色を設定 */
            color: white; /* テキストの色を白に設定 */
            padding: 10px 20px; /* 内側の余白を設定 */
            border-radius: 10px; /* 角を丸くする */
        }
    </style>

</head>
<body>
	<h2>---LOGIN---</h2>
	<div class="arrow">↓入力してからポチッ↓</div>

	<form action="login" method="post">

		UserID :<br>
		<input type="text" name="userId" required size="25"><br>
		<br>
		Password :<br>
		<input type="password" name="pass" required size="25"><br>
		<br>
		<input type="submit" value="PUSH">
	</form>
</body>
</html>