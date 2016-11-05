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
    <title>Main page</title>
    <style>
        .tabs-left > .nav-tabs {
            border-bottom: 0;
        }

        .tab-content > .tab-pane,
        .pill-content > .pill-pane {
            display: none;
        }

        .tab-content > .active,
        .pill-content > .active {
            display: block;
        }

        .tabs-left > .nav-tabs > li {
            float: none;
        }

        .tabs-left > .nav-tabs > li > a {
            min-width: 74px;
            margin-right: 0;
            margin-bottom: 3px;
        }

        .tabs-left > .nav-tabs {
            float: left;
            margin-right: 19px;
            border-right: 1px solid #ddd;
        }

        .tabs-left > .nav-tabs > li > a {
            margin-right: -1px;
            -webkit-border-radius: 4px 0 0 4px;
            -moz-border-radius: 4px 0 0 4px;
            border-radius: 4px 0 0 4px;
        }

        .tabs-left > .nav-tabs > li > a:hover,
        .tabs-left > .nav-tabs > li > a:focus {
            border-color: #eeeeee #dddddd #eeeeee #eeeeee;
        }

        .tabs-left > .nav-tabs .active > a,
        .tabs-left > .nav-tabs .active > a:hover,
        .tabs-left > .nav-tabs .active > a:focus {
            border-color: #ddd transparent #ddd #ddd;
            *border-right-color: #ffffff;
        }
    </style>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>
<body>

<nav class="navbar navbar-default top">

    <div style="margin: 10px">

        <spring:message code="login.page.filed.username" var="username"/>
        <spring:message code="page.text.logout.button" var="logoutButton"/>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <object align="right">${username}: <b> ${pageContext.request.userPrincipal.name} </b>
                | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></object>
        </c:if>

    </div>

</nav>

<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <h3>Menu</h3>
            <!-- tabs -->
            <div class="tabbable tabs-left">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
                    <li><a href="#about" data-toggle="tab">About</a></li>
                    <li><a href="#services" data-toggle="tab">Services</a></li>
                    <li><a href="#contact" data-toggle="tab">Contact</a></li>
                    <li><a href="#profile" data-toggle="tab">Profile</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="#admin" data-toggle="tab">Admin dashboard</a></li>
                    </c:if>

                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <div class="">
                            <h1>Home Tab</h1>
                            <p>These lists are meant to identify articles which deserve editor attention because they are the most
                                important for an encyclopedia to have, as determined by the community of participating editors.
                                They may also be of interest to readers as an alternative to lists of overview articles.</p>
                        </div>
                    </div>
                    <div class="tab-pane" id="about">
                        <div class="">
                            <h1>About Tab</h1>
                            <p>because they are the most important for an encyclopedia to have, as determined by the community of
                                participating editors. They may also be of interest to readers as an alternative to lists of
                                overview articles.</p>
                        </div>
                    </div>

                    <div class="tab-pane" id="services">
                        <div class="">
                            <h1>Services Tab</h1>
                            <p>meant to identify articles which deserve editor attention because they are the most important for
                                an encyclopedia to have, as determined by the community of participating editors. They may also be
                                of interest to readers as an alternative to lists of overview articles.</p>
                        </div>
                    </div>

                    <div class="tab-pane" id="contact">
                        <div class="">
                            <h1>Contact Tab</h1>
                            <p>deserve editor attention because they are the most important for an encyclopedia to have, as
                                determined by the community of participating editors. They may also be of interest to readers as
                                an alternative to lists of overview articles.</p>
                        </div>
                    </div>

                    <div class="tab-pane" id="profile">
                        <div class="">
                            <h1>Profile </h1>
                            <a href="/beforeprofilepage">Profile</a></div>
                    </div>

                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    <div class="tab-pane" id="admin">
                        <div class="">
                            <h1>Admin dashboard </h1>
                            <a href="/admin/">Admin dashboard</a>
                        </div>
                        </c:if>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
