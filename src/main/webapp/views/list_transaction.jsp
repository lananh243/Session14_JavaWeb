<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Danh sách giao dịch</h3>
<table border="1">
    <thead>
    <tr>
        <th>Mô tả</th>
        <th>Số tiền</th>
        <th>Loại</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${transactions}" var="item">
        <tr>
            <td>${item.description}</td>
            <td>${item.amount}</td>
            <td>${item.type}</td>
            <td><a href="/delete-transaction/${item.description}" onclick="return confirm('Ban có chắc chắn muốn xóa không ?');">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
    <a href="/transaction">Quay lại</a>
</table>
</body>
</html>
