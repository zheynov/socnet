<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 03.11.2016
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin dashboard</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>
<body>

<nav class="navbar navbar-default top">

    <div style="margin: 10px">
        <a href="/welcomePage">Main page</a>
        <spring:message code="login.page.filed.username" var="username"/>
        <spring:message code="page.text.logout.button" var="logoutButton"/>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <object align="right">${username}: <b> ${pageContext.request.userPrincipal.name} </b>
                | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></object>
        </c:if>

    </div>

</nav>

<div class="alert-info" style="margin: 8px">
    <p>
        <b> User agent:</b> ${pageContext.request.getHeader("user-agent")} <br/>
        <b> Current host:</b> ${pageContext.request.getHeader("host")} <br/>
        <b> Current language:</b> ${pageContext.request.getHeader("accept-language")} <br/>
</div>


<h2 class="h2" align="center"> All the profiles from DB:</h2>


<table class="table table-bordered">
    <thead class="navbar-inverse" style="color: white">
    <tr>
        <th>#</th>
        <th>Firstname</th>
        <th>lastname</th>
        <th>Email</th>
        <th>Age</th>
        <th>City</th>
        <th>Phone</th>
        <th>Gender</th>
        <th>Credentials</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${allTheProfiles}" var="profile">
        <tr>
            <th scope="row">${profile.profileID}</th>
            <td>${profile.firstname}</td>
            <td>${profile.lastname}</td>
            <td>${profile.email}</td>
            <td>${profile.age}</td>
            <td>${profile.city}</td>
            <td>${profile.phoneNumber}</td>
            <td>${profile.sex}</td>
            <td><a href="/admin/manageuserinfo/${profile.profileID}"> Manage user info </a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>




<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>