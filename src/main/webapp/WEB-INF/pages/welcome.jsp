<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

<spring:message code="login.page.filed.username" var="username"/>
<spring:message code="page.text.logout.button" var="logoutButton"/>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>${username}: ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></h2>
</c:if>

Привет!

<p><a href="/beforeprofilepage">profile</a>


    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
        <p><a href="/admin/">Admin dashboard</a>
    </c:if>


</body>
</html>
