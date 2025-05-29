<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Danh sách sản phẩm</h3>
    <table border="1">
       <thead>
       <tr>
           <th>ID</th>
           <th>Tên sản phẩm</th>
           <th>Giá</th>
           <th>Hành động</th>
       </tr>
       </thead>
        <tbody>
        <c:forEach var="item" items="${products}">
            <tr>
                <td>${item.id}</td>
                <td>${item.productName}</td>
                <td>${item.price}</td>
                <td>
                    <a href="/delete-product/${item.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/product">Quay lại trang thêm sản phẩm</a>
</body>
</html>
