<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/29/2025
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>${title}</h3>
    <p>${message}</p>

    <form action="/set-language" method="post">
        <button type="submit" name="lang" value="en">Tiếng Anh</button>
        <button type="submit" name="lang" value="vi">Tiếng Việt</button>
    </form>
</body>
</html>
