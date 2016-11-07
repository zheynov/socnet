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


<div class="alert-info" style="margin: 8px">
    <p>
        <b> User agent:</b> ${pageContext.request.getHeader("user-agent")} <br/>
        <b> Current host:</b> ${pageContext.request.getHeader("host")} <br/>
        <b> Current language:</b> ${pageContext.request.getHeader("accept-language")} <br/>
</div>



<h5 align="center"> All the profiles from DB:</h5>

<p></p>
<table class="table table-bordered">
    <thead class="navbar-inverse" style="color: white">
    <tr>
        <th>#</th>
        <th><spring:message code="profile.page.text.firstname"/></th>
        <th><spring:message code="profile.page.text.lastname"/></th>
        <th><spring:message code="profile.page.text.email"/></th>
        <th><spring:message code="profile.page.text.age"/></th>
        <th><spring:message code="profile.page.text.city"/></th>
        <th><spring:message code="profile.page.text.phone"/></th>
        <th><spring:message code="profile.page.text.gender"/></th>
        <th><spring:message code="profile.page.text.credentials"/></th>
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
