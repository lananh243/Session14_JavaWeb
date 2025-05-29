<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/28/2025
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Register Form</h3>
    <form action="/login" method="post">
        <label for="username">Tên người dùng: </label>
        <input type="text" name="username" id="username">
        <br>
        <label for="password">Mật khẩu: </label>
        <input type="password" name="password" id="password">
        <br>
        <input type="submit" value="REGISTER">
    </form>
    <div style="color: red">${error}</div>
</body>
</html>
