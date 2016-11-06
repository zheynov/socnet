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
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>
<body>

<jsp:include page="secure/navbar.jsp"/>

<div style="margin: 10px">
    <h2>Profile </h2>

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
    <p><a href="/welcomePage">Main page</a>

</div>

<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
