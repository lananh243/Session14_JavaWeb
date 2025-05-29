<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Form Transaction</h3>
    <form action="/add-transaction" method="post">
        <label for="description">Mô tả giao dịch</label>
        <textarea name="description" id="description" cols="30" rows="10"></textarea>
        <br>
        <label for="amount">Số tiền</label>
        <input type="number" name="amount" id="amount">
        <br>
        <label for="type">Loại giao dịch</label>
        <select name="type" id="type">
            <option value="Thu">Thu</option>
            <option value="Chi">Chi</option>
        </select>
        <br>
        <button type="submit">Thêm giao dịch</button>
    </form>
</body>
</html>
