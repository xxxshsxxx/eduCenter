<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Styopa
  Date: 12.03.2018
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Регистрация</h2>
<spring:form action="/addUser" modelAttribute="student" method="post" enctype="multipart/form-data">
    <div><spring:input path="name" placeholder="Ձեր անունը" type="text"/></div><br>
    <div><spring:input path="surname" placeholder="Ձեր ազգանունը" type="text"/></div><br>
    <div><spring:input path="email" placeholder="Ձեր Էլ. փոստի հասցեն" type="text"/></div><br>
    <div><spring:input path="password" placeholder="Գաղտնաբառ" type="password" value=""/></div>
    <label for="image">Image:</label>
    <input type="file" id="image" name="picture"/><br>
    <input type="submit" value="Register">
</spring:form>
</body>
</html>
