<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/28/2025
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>List Product</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.productName}</td>
                <td>${item.price}</td>
                <td>
                    <a href="/product-detail/${item.id}">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/show-cart">List Product In Cart</a>
</body>
</html>
