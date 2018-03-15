<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Styopa
  Date: 15.03.2018
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteUser</title>
</head>
<body>
<ul>
    <c:forEach items="${allUsers}" var="user">
        <li>${user.name}&nbsp;&nbsp;&nbsp;${user.surname}<br>
            <img src="/product/image?fileName=${user.picUrl}" alt="picture" width="90"><br>
            <a href="/deleteUsers?id = ${user.id}">&nbsp;Delete<hr></a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
