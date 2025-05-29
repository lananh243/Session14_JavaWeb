<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Sản phẩm trong giỏ hàng</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cartList}" var="cart">
            <tr>
                <td>${cart.name}</td>
                <td>${cart.quantity}</td>
                <td>
                    <a href="/delete-cart/${cart.name}" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm khỏi giỏ hàng không?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/cart">Quay lại</a>
</body>
</html>
