<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 2:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Order Form</h3>
    <form action="${pageContext.request.contextPath}/${order != null ? 'update-order' : 'add-order'}" method="post">
        <label for="orderId">Mã đơn hàng</label>
        <input type="number" name="orderId" id="orderId" value="${order != null ? order.orderId : ''}">
        <br>
        <label for="productName">Tên sản phẩm</label>
        <input type="text" name="productName" id="productName" value="${order != null ? order.productName : ''}">
        <br>
        <label for="quantity">Số lượng</label>
        <input type="number" name="quantity" id="quantity" value="${order != null ? order.quantity : ''}">
        <br>
        <input type="submit" value="${order != null ? 'Cập nhật' : 'Thêm mới'}">
    </form>
</body>
</html>
