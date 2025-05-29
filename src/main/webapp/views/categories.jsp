<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Language</h3>
    <form action="/categories-save" method="post">
      <label for="categoryNameVi">Tên danh mục (Tiếng Việt)</label>
      <input type="text" name="categoryNameVi" id="categoryNameVi">
      <br>
      <label for="descriptionVi">Mô tả (Tiếng Việt)</label>
        <textarea name="descriptionVi" id="descriptionVi" cols="30" rows="10"></textarea>
      <br>
        <label for="categoryNameEn">Tên danh mục (Tiếng Anh)</label>
        <input type="text" name="categoryNameEn" id="categoryNameEn">
        <br>
        <label for="descriptionEn">Mô tả (Tiếng Anh)</label>
        <textarea name="descriptionEn" id="descriptionEn" cols="30" rows="10"></textarea>
        <br>
      <button type="submit">Thêm danh mục</button>
    </form>
</body>
</html>
