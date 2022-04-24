<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 24.04.2022
  Time: 12:13
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

<form:form method="post" action="student" modelAttribute="student">
  First Name: <form:input path="firstName"/><br>
  Last Name: <form:input path="lastName"/><br>
  Male: <form:radiobutton path="gender" value="M"/>
  Female: <form:radiobutton path="gender" value="F"/><br>
  Country: <form:select path="country" items="Poland, Germany, Austria, France"/><br>
  Notes: <form:

  <input type="submit" name="submit">
</form:form>

</body>
</html>
