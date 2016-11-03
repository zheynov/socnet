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
</head>
<body>

<spring:message code="login.page.filed.username" var="username"/>
<spring:message code="page.text.logout.button" var="logoutButton"/>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>${username}: ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></h2>
</c:if>

<p>

    <b>Email: </b> ${userDTO.email} <br/>
    <b>Login: </b> ${userDTO.username} <br/>
    <b>Password: </b> ${userDTO.password} <br/>
    <b>Active user: </b>
        <c:choose>
        <c:when test="${userDTO.enabled==true}">
        yes </c:when>

        <c:otherwise>
        no </c:otherwise>
        </c:choose>
<p>
<p><a href="/admin/">admin dashboard</a>
<p><a href="/beforeprofilepage">profile</a>
<p><a href="/welcomePage">Main page</a>


</body>
</html>
