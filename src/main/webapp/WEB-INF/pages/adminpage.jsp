<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 03.11.2016
  Time: 19:33
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

<p>
    <b> User agent:</b> ${pageContext.request.getHeader("user-agent")} <br/>
    <b> Current host:</b> ${pageContext.request.getHeader("host")} <br/>
    <b> Current language:</b> ${pageContext.request.getHeader("accept-language")} <br/>


<h2> All the profiles from DB:</h2>

<c:forEach items="${allTheProfiles}" var="profile"><p>

    <b> Full name: </b>${profile.firstname} ${profile.lastname} <br/>
    <b> Email: </b>${profile.email}<br/>
    <b> Age: </b>${profile.age}<br/>
    <b> City: </b>${profile.city}<br/>
    <b> Phone number: </b>${profile.phoneNumber}<br/>
    <b> Gender: </b>${profile.sex}<br/>
 <a href="/userinfo/${profile.profileID}"><b> Get user info: </b></a>    <br/>


    </c:forEach>


</body>
</html>
