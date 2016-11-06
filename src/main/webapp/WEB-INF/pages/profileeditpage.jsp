<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>
<body>

<jsp:include page="secure/navbar.jsp"/>


<p>
<div style="margin: 10px">
    <form:form method="POST" action="/editprofile" commandName="profileDTO">

        <table>
            <form:hidden path="profileID"/>
            <tr>
                <td><form:input path="firstname" placeholder="firstname" size="30"/></td>
                <td><form:errors path="firstname"/></td>
            </tr>
            <tr>
                <td><form:input path="lastname" placeholder="lastname" size="30"/></td>
                <td><form:errors path="lastname"/></td>
            </tr>
            <tr>
                <td><form:input path="email" placeholder="email" size="30"/></td>
                <td><form:errors path="email"/></td>
            </tr>

            <tr>
                <td> Sex: <form:radiobutton path="sex" value="male"/>male
                    <form:radiobutton path="sex" value="female"/>female
                </td>
                <td><form:errors path="sex"/></td>

            </tr>
            <tr>
                <td><form:input type="date" path="birthDate"/></td>
                <td><form:errors path="birthDate"/></td>
            </tr>
            <tr>
                <td><form:input path="age" placeholder="age" size="30"/></td>
                <td><form:errors path="age"/></td>

            </tr>
            <tr>
                <td><form:input path="city" placeholder="city" size="30"/></td>
                <td><form:errors path="city"/></td>
            </tr>
            <tr>
                <td><form:input path="phoneNumber" placeholder="phoneNumber" size="30"/></td>
                <td><form:errors path="phoneNumber"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="complete"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>


<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
