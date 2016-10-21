<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

<form:form method="POST" action="/registrationComplete" commandName="userEntity">
    <table>
        <tr><spring:message code="registration.page.text.firstname" var="firstname"/>
            <td>
                    <form:input path="firstName" placeholder="${firstname}"/> *
            <td><form:errors path="firstName"/></td>
        </tr>
        <tr><spring:message code="registration.page.text.lastname" var="lastname"/>
            <td>
                    <form:input path="lastName" placeholder="${lastname}"/> *
            <td><form:errors path="lastName"/></td>
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
