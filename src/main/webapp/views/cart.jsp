<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Giỏ Hàng</h1>
    <form action="/add-product-cart" method="post">
        <input type="text" name="name" placeholder="Tên sản phẩm" required />
        <input type="number" name="quantity" placeholder="Số lượng" required />
        <button type="submit">Thêm vào giỏ hàng</button>
    </form>
</body>
</html>
