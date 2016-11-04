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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>.main-center {
        margin-top: 30px;
        margin: 0 auto;
        max-width: 330px;
        padding: 40px 40px;
    }</style>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/bootstrap.css">
    <!-- Website CSS style -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/main.css">
    <!-- Website Font style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
</head>
<body>

<h2>
    <c:choose>
        <c:when test="${pageNotification eq 'email'}">
            <spring:message code="registration.page.text.validation.email.exists"/>
        </c:when>
        <c:when test="${pageNotification eq 'username'}">
            <spring:message code="registration.page.text.validation.login.exists"/>
        </c:when>
        <c:otherwise> </c:otherwise>
    </c:choose>
</h2>

<div class="container" style="width: 500px">
    <div class="row main table-bordered">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title"><spring:message code="registration.page.text.title"/></h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" method="post" action="/registrationComplete" commandName="userDTO">

                <spring:message code="registration.page.text.email" var="email"/>
                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">${email}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input type="text" class="form-control" path="email" name="email" id="email"
                                        placeholder="${email}"/>
                        </div>
                        <form:errors path="email"/>
                    </div>
                </div>

                <spring:message code="login.page.filed.username" var="username"/>
                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">${username}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <form:input path="username" type="text" class="form-control" name="username" id="username"
                                        placeholder="${username}"/>
                        </div>
                        <form:errors path="username"/>
                    </div>
                </div>

                <spring:message code="login.page.filed.password" var="password"/>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">${password}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="password" type="password" class="form-control" name="password" id="password"
                                        placeholder="${password}"/>
                        </div>
                    </div>
                    <form:errors path="password"/>
                </div>

                <spring:message code="registration.page.filed.confirmpassword" var="confirmPassword"/>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">${confirmPassword}</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="confirmPassword" type="password" class="form-control" name="password" id="password"
                                        placeholder="${confirmPassword}"/>
                        </div>
                    </div>
                    <form:errors path="confirmPassword"/>
                </div>

                <spring:message code="registration.page.button.complete" var="complete"/>
                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">${complete}</button>
                </div>
                <div class="login-register" align="center"><a href="loginpage"><spring:message code="login.page.loginbutton"/></a>
                </div>


            </form:form>
        </div>
    </div>
</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.js"></script>

</body>
</html>
