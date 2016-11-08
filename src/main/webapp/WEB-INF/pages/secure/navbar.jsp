<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default top">

    <div style="margin: 10px">
        <a href="/welcomePage">Main page</a>
        <spring:message code="login.page.filed.username" var="username"/>
        <spring:message code="page.text.logout.button" var="logoutButton"/>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <object align="right">${username}: <b> ${pageContext.request.userPrincipal.name} </b>
                | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></object>
        </c:if>

    </div>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/main.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</nav>
