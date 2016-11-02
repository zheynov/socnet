<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 02.11.2016
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile edition</title>
</head>
<body>

<form:form method="POST" action="/editprofile" commandName="profileDTO">

    <table>
        <form:hidden path="profileID"/>
        <tr>
            <td><form:input path="firstName" size="30"/></td>
        </tr>
        <tr>
            <td><form:input path="lastName" size="30"/></td>
        </tr>
        <tr>
            <td><form:input path="email" size="30"/></td>
        </tr>

        <tr>
            <td><form:radiobutton path="sex"/>$</td>
        </tr>
        <tr>
            <td>
            <form:input type="date" path="birthDate"/></tr>
        <tr>
            <td><form:input path="age" size="30"/></td>
        </tr>
        <tr>
            <td><form:input path="city" size="30"/></td>
        </tr>
        <tr>
            <td><form:input path="phoneNumber" size="30"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="complete"/>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
