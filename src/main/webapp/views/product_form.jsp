<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/28/2025
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Product Form</h3>
    <form:form method="post" action="/add-product" modelAttribute="product">
        <label for="id">ID:</label>
        <form:input path="id" id="id" /><br/>

        <label for="productName">Tên sản phẩm:</label>
        <form:input path="productName" id="productName" /><br/>

        <label for="price">Giá:</label>
        <form:input path="price" id="price" /><br/>

        <input type="submit" value="Thêm sản phẩm" />
    </form:form>
</body>
</html>
