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
    <title> Registration </title>
</head>
<body>

<form:form method="POST" action="/regComplete" commandName="UserEntity">
    <table>
        <tr>
            <td><form:input path="firstName" placeholder="firstName"/> *
            <td><form:errors path="firstName"/></td>
        </tr>
        <tr>
            <td><form:input path="lastName" placeholder="lastName"/> *
            <td><form:errors path="lastName"/></td>
        </tr>
        <tr>
            <td><form:input path="email" placeholder="email"/> *
            <td><form:errors path="email"/></td>
        </tr>
        <tr>
            <td><form:input path="login" placeholder="login"/> *
            <td><form:errors path="login"/></td>
        </tr>
        <tr>
            <td><form:password path="password" placeholder="password"/> *
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="buttonSignup" type="submit"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
