<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 18.10.2016
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="registration.page.text.title"/></title>
</head>
<body>

<h1><spring:message code="registration.page.text.welcome"/></h1>

<h2>
    <c:choose>
        <c:when test="${pageNotification eq 'email'}">
            <spring:message code="registration.page.text.validation.email.exists"/>
        </c:when>
        <c:when test="${pageNotification eq 'login'}">
            <spring:message code="registration.page.text.validation.login.exists"/>
        </c:when>
        <c:otherwise> </c:otherwise>
    </c:choose>
</h2>

<form:form method="POST" action="/registrationComplete" commandName="userDTO">
    <table>
        <tr><spring:message code="registration.page.text.firstname" var="firstname"/>
            <td>
                    <form:input path="firstname" placeholder="${firstname}"/> *
            <td><form:errors path="firstname"/></td>
        </tr>
        <tr><spring:message code="registration.page.text.lastname" var="lastname"/>
            <td>
                    <form:input path="lastname" placeholder="${lastname}"/> *
            <td><form:errors path="lastname"/></td>
        </tr>
        <tr><spring:message code="registration.page.text.email" var="email"/>
            <td>
                    <form:input path="email" placeholder="${email}"/> *
            <td><form:errors path="email"/></td>
        </tr>
        <tr><spring:message code="login.page.filed.login" var="login"/>
            <td>
                    <form:input path="login" placeholder="${login}"/> *
            <td><form:errors path="login"/></td>
        </tr>
        <tr><spring:message code="login.page.filed.password" var="password"/>
            <td>
                    <form:password path="password" placeholder="${password}"/> *
            <td><form:errors path="password"/></td>
        </tr>
        <tr><spring:message code="registration.page.button.complete" var="complete"/>
            <td colspan="2"><input type="submit" value="${complete}"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
