<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách danh mục</h2>

<table border="1">
  <tr>
    <th>Tên danh mục</th>
    <th>Mô tả</th>
  </tr>
  <c:forEach var="item" items="${categories}">
    <tr>
    <tr>
      <td>${item.categoryName}</td>
      <td>${item.description}</td>
    </tr>
    </tr>
  </c:forEach>
  <p>Ngôn ngữ hiện tại: ${lang}</p>
  <a href="/categories">Quay lại</a>
</table>

<a href="/list-category?lang=vi">Tiếng Việt</a> | <a href="/list-category?lang=en">English</a>


</body>
</html>
