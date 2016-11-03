<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Redlaw
  Date: 27.10.2016
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page</title>
</head>
<body>

<spring:message code="login.page.filed.username" var="username"/>
<spring:message code="page.text.logout.button" var="logoutButton"/>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>${username}: ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></h2>
</c:if>


<h2>Profile page</h2>
<p>
    Profile data:
<p>

    <b> Firstname: </b> ${profileDTO.firstname} <br/>
    <b> Lastname:</b> ${profileDTO.lastname} <br/>
    <b> Email:</b> ${profileDTO.email} <br/>
    <b> Sex:</b> ${profileDTO.sex} <br/>
    <b> Date of birth:</b> ${profileDTO.birthDate} <br/>
    <b> Age: </b> ${profileDTO.age} <br/>
    <b> City: </b> ${profileDTO.city} <br/>
    <b> Phone number:</b> ${profileDTO.phoneNumber} <br/>


<p><a href="/profileedit">Edit profile</a>
<p><a href="/showAllUsers">Main page</a>


</body>
</html>
