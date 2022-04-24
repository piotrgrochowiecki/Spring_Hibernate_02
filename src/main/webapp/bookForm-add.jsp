<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 24.04.2022
  Time: 14:21
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

<form:form method="POST" action="/bookForm/add" modelAttribute="book">
    Title: <form:input path="title"/> </br>
    Rating: <form:input path="rating"/> </br>
    Description: <form:input path="description"/> </br>

    Publishers:
    <form:select path="publisher.id" itemValue="id"
                 itemLabel="name" items="${publishers}"/> </br>

    <input type="submit">
</form:form>


</body>
</html>
