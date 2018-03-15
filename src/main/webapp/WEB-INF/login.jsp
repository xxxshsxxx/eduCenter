<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Styopa
  Date: 12.03.2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div>
    <h2>Login to your account</h2>
    <form action="<c:url value="/login"/> " method="post" name="loginForm">
        <input type="text" placeholder="email" name="email"/>
        <input type="password" placeholder="password" name="password"/>
        <button type="submit">Login</button>
    </form>
</div><!--/login form-->
<br>
<br>
</body>
</html>
