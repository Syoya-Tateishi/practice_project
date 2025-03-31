<%@ page contentType="text/html; charset=UTF-8" import="javax.servlet.http.HttpSession" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニュー</title>
    
    <style>
        .button2 { padding: 5px 10px; border-radius: 5px; cursor: pointer; }
        .button-container { display: flex; flex-direction: column; gap: 30px; width: 120px; }

    	.container {
        	border: 2px solid black;
        	padding: 8px;
        	width: 200px;
        	margin: 0 auto;
        	box-sizing: border-box;
    	}


        
    </style>
</head>
<body>
    
<%@ include file="/header.jsp" %>
<div class = container>
    <h1>メニュー</h1>
    
    <div class="button-container">
        <form action="listCustomer" method="GET">
            <button class="button2 CustomerList-button" type="submit">顧客一覧</button>
        </form>
        
        <form action="registerCustomer" method="GET">
        <button class="button2 CustRegi-button" type="submit">新規顧客登録</button>
         </form>
    </div>
</div>
</body>
</html>
