<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 20.10.2016
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2> All the users from DB:</h2>

<c:forEach items="${allTheUsers}" var="user"><p>
    <b> Login: </b>${user.username} <br/>
    <b> Email: </b>${user.email}<br/> </p>
</c:forEach>


</body>
</html>
