<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List,model.entity.CustomerBean" %>
<html>
<head>
    <title>顧客情報一覧画面</title>
    <jsp:include page="header.jsp" />
<style>

</style>
</head>
<body>
	<% 
	List<CustomerBean> customerList = (List<CustomerBean>)request.getAttribute("customerList");
	%>

<h2>顧客情報一覧</h2>
<table border="5">
    <tr>
        <th>顧客ID</th>
        <th>顧客名称</th>
        <th>顧客名称(かな)</th>
        <th>郵便番号</th>
        <th>所在地</th>
        <th>地区コード</th>
        <th>担当者名</th>
        <th>担当者名(かな)</th>
        <th>担当者電話番号</th>
        <th>ユーザーID</th>
    </tr>
    <% 
    for(CustomerBean customer:customerList){
    %>
    <tr>
    	<td><%= customer.getCustomerId() %></td>
    	<td><%= customer.getCustomerName() %></td>
    	<td><%= customer.getCustomerNameKana() %></td>
    	<td><%= customer.getPostalCode() %></td>
    	<td><%= customer.getAddress() %></td>
                                 
		<td>
    		<% 
    		String areacode = customer.getAreaCode(); 
    		if (areacode equals(0)) { %>地区未設定
    		<% } else if (sectioncode == 100) { %>北海道
    		<% } else if (sectioncode == 200) { %>東北
    		<% } else if (sectioncode == 300) { %>関東
    		<% } else if (sectioncode == 400) { %>中部
    		<% } else if (sectioncode == 500) { %>近畿
    		<% } else if (sectioncode == 600) { %>中国
    		<% } else if (sectioncode == 700) { %>四国
    		<% } else if (sectioncode == 800) { %>九州
    		<% } else if (sectioncode == 900) { %>沖縄
    		<% } %>
		</td>
                    
        <td><%= customer.getContactPersonName() %></td>
        <td><%= customer.getContactPersonNameKana() %></td>
        <td><%= customer.getContactPersonTell() %></td>              
        <td><%= customer.getUserId() %></td>
                    
        <td>
        	<form action ="editCustomer" method = "get" style = "display:inline;">
            	<input type = "hidden" name = "customerId" value = "<%= customer.getCustomerId()%>">
            	<input type = "submit" value = "編集">
            </form>
            <form action="customer-delete.jsp" method="post">
    			<input type="hidden" name="customerId" value="<%= customer.getCustomerId() %>">
    			<input type="hidden" name="action" value="delete">
            	<input type = "submit" value = "削除">
            </form>
        </td>
   </tr>
   	<%
   	}
   	%>
   </tbody>
</table>
   <form action ="registerCustomer" method = "post">
   		<input type = "submit" value = "新規登録">
   </form>
                
</body>
</html>

