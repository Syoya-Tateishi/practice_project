<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>顧客情報編集画面</title>

<style>
    .container {
        border: 5px solid blue;
        padding: 20px;
        width: 300px;
        margin: 0 auto;
        box-sizing: border-box;
    }

</style>
</head>
<body>

<%@ include file="/header.jsp" %>
<div class = container>
    <h1>顧客情報編集</h1>
    
    
    <form action="customer-edit-servlet" method="POST">
    <input type="hidden" name="customer_id" value="${customer.customerId}" />

    <label for="customer_name">顧客名称:</label>
    <input type="text" id="customer_name" name="customer_name" value="${customer.customerName}" required><br><br>

    <label for="customer_name_kana">顧客名称かな:</label>
    <input type="text" id="customer_name_kana" name="customer_name_kana" value="${customer.customerNameKana}" required><br><br>

    <label for="postal_code">郵便番号:</label>
    <input type="text" id="postal_code" name="postal_code" value="${customer.postalCode}" required><br><br>

    <label for="address">所在地:</label>
    <input type="text" id="address" name="address" value="${customer.address}" required><br><br>

    <label for="area_code">地区名:</label>
    <select id="area_code" name="area_code" onchange="updateAreaCode()">
    	<option value="A000" ${customer.areaCode == 'A000' ? 'selected' : ''}>地区未設定</option>
        <option value="A100" ${customer.areaCode == 'A100' ? 'selected' : ''}>北海道</option>
        <option value="A200" ${customer.areaCode == 'A200' ? 'selected' : ''}>東北</option>
        <option value="A300" ${customer.areaCode == 'A300' ? 'selected' : ''}>関東</option>
        <option value="A400" ${customer.areaCode == 'A400' ? 'selected' : ''}>中部</option>
        <option value="A500" ${customer.areaCode == 'A500' ? 'selected' : ''}>近畿</option>
        <option value="A600" ${customer.areaCode == 'A600' ? 'selected' : ''}>中国</option>
        <option value="A700" ${customer.areaCode == 'A700' ? 'selected' : ''}>四国</option>
        <option value="A800" ${customer.areaCode == 'A800' ? 'selected' : ''}>九州</option>
        <option value="A900" ${customer.areaCode == 'A900' ? 'selected' : ''}>沖縄</option>
    </select><br><br>

    <input type="hidden" id="selected_area_code" name="selected_area_code" value="${customer.areaCode}">

    <label for="contact_person_name">担当者名:</label>
    <input type="text" id="contact_person_name" name="contact_person_name" value="${customer.contactPersonName}" required><br><br>

    <label for="contact_person_name_kana">担当者名かな:</label>
    <input type="text" id="contact_person_name_kana" name="contact_person_name_kana" value="${customer.contactPersonNameKana}" required><br><br>

    <label for="contact_person_tel">担当者電話番号:</label>
    <input type="text" id="contact_person_tel" name="contact_person_tel" value="${customer.contactPersonTel}" required><br><br>

    <button type="submit">更新</button>
</form>

<script>
    function updateAreaCode() {
        var areaSelect = document.getElementById('area_code');
        var selectedCode = areaSelect.value;
        document.getElementById('selected_area_code').value = selectedCode;
    }

    updateAreaCode();
</script>

</div>
</body>
</html>