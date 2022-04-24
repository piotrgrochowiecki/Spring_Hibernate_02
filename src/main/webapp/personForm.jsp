<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 24.04.2022
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="person">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password">
    Email: <input type="email" name="email">
    <input type="submit" name="submit">
</form>

</body>
</html>
