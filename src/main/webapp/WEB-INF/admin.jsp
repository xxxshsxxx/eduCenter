<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Styopa
  Date: 12.03.2018
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

Add Lecturer:<br>
<spring:form action="/addLecturer" method="post" modelAttribute="addlecturer">

    <spring:label path="name">Name:</spring:label>
    <spring:input path="name"></spring:input>
    ]<spring:label path="name">Surname:</spring:label>
    <spring:input path="surname"></spring:input>
    <input type="submit" value="ADD">

</spring:form>

Add Lesson:<br>
<spring:form action="/addLesson" method="post" modelAttribute="addlesson">

    <spring:label path="name">Name:</spring:label>
    <spring:input path="name"></spring:input>
    <spring:label path="name">Price:</spring:label>
    <spring:input path="price"></spring:input>
    <spring:label path="name">Duration:</spring:label>
    <spring:input path="duration"></spring:input>
    <spring:select path="lectureID" items="${allLecturer}" itemLabel="name"></spring:select>
    <input type="submit" value="ADD">

</spring:form>

<%--<spring:form action="/deleteUser" method="post" modelAttribute="allUsers">--%>
    <%--<spring:select path="" items="${allUsers}" itemLabel="name"></spring:select>--%>
    <%--<input type="submit" value="Delete">--%>

<%--</spring:form>--%>

<a href="/register">Register</a><br>
<a href="/deleteUser">DeleteUsers</a><br>

</body>
</html>
