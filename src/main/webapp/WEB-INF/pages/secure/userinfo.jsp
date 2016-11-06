<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 03.11.2016
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage user info</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>
<body>

<jsp:include page="navbar.jsp"/>


<div style="margin: 10px">

   <h3 class="h3"> User credentials: </h3>

    <b>Email: </b> ${userDTO.email} <br/>
    <b>Login: </b> ${userDTO.username} <br/>
    <b>Password: </b> encrypted <br/>
    <b>Account status: </b>

    <c:choose>
    <c:when test="${userDTO.enabled==true}"> active </c:when>
    <c:otherwise> disabled </c:otherwise>
    </c:choose>

</div>



<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
