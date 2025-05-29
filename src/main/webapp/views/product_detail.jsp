<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/28/2025
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Product Detail</h3>
    <p>Id: ${product.id}</p>
    <p>ProductName: ${product.productName}</p>
    <p>Price: ${product.price}</p>
    <a href="/add-to-cart/${product.id}">Add To Cart</a>
</body>
</html>
