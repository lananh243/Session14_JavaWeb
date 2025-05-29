<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Danh sách đơn hàng</h3>
    <table border="1">
      <thead>
      <tr>
        <th>Mã đơn hàng</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
          <th>Hành động</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="item" items="${orderList}">
        <tr>
          <td>${item.orderId}</td>
          <td>${item.productName}</td>
          <td>${item.quantity}</td>
            <td>
                <a href="/edit-order/${item.orderId}">Sửa</a>
                <a href="/delete-order/${item.orderId}" onclick="return confirm('Bạn có chắc muốn xóa không?');">Xóa</a>
            </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

    <a href="/orders">Quay lại</a>
</body>
</html>
