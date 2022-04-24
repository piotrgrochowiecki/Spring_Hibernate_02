<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 24.04.2022
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${books}" var="b">
    ${b.id} - ${b.title}, ${b.rating}, ${b.description} </br>
</c:forEach>

</body>
</html>

</body>
</html>
