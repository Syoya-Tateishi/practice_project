<%@ page import="java.util.List" %>
<%@ page import="model.entity.AreaBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>新規顧客登録</title>
    <style>
    .container {
        border: 2px solid black;
        padding: 20px;
        width: 400px;
        margin: 0 auto;
        box-sizing: border-box;
    }

</style>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="container">
    <h1>新規顧客登録</h1>
    
    <form action="customer-register-servlet" method="POST">

    <label for="customer_name">お名前:</label>
    <input type="text" id="customer_name" name="customer_name" required><br><br>
    
    <label for="customer_name_kana">かな:</label>
    <input type="text" id="customer_name_kana" name="customer_name_kana" required><br><br>
    
    <label for="postal_code">郵便番号:</label>
    <input type="text" id="postal_code" name="postal_code" required><br><br>
    
    <label for="address">ご住所:</label>
    <input type="text" id="address" name="address" required><br><br>
    
    <label for="area_code">都道府県:</label>
    <select id="area_code" name="area_code">
        <option value="1">---------</option>
        <% 
            List<AreaBean> areaList = (List<AreaBean>) request.getAttribute("areaList");
            if (areaList != null) {
                for (AreaBean area : areaList) {
        %>
            <option value="<%= area.getAreaCode() %>"><%= area.getAreaName() %></option>
        <% 
                }
            } else {
        %>
            <option value="0">エリアデータがありません</option>
        <% 
            }
        %>  
    </select><br><br>
    
    <label for="contact_person_name">担当者名:</label>
    <input type="text" id="contact_person_name" name="contact_person_name" required><br><br>
    
    <label for="contact_person_name_kana">担当者名かな:</label>
    <input type="text" id="contact_person_name_kana" name="contact_person_name_kana" required><br><br>

    <label for="contact_person_tel">担当者電話番号:</label>
    <input type="tel" id="limit_date" name="contact_person_tel" required><br><br>

    <label for="user">営業担当者:</label>
    <input type= "text" name="user" id="user" required><br><br>

    <button type="submit">登録</button>
</form>
</div>
</body>
</html>
