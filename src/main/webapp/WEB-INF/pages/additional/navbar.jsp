<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default top">

    <div style="margin: 10px">

        <a href="?lang=en"> eng  </a>
        <a href="?lang=ru"> рус  </a>

        <%--<spring:message code="navbar.page.text.language.en"/>--%>
        <spring:message code="login.page.filed.username" var="username"/>
        <spring:message code="page.text.logout.button" var="logoutButton"/>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <object align="right">${username}: <b> ${pageContext.request.userPrincipal.name} </b>
                | <a href="<c:url value="/j_spring_security_logout" />"> ${logoutButton}</a></object>
        </c:if>

    </div>

</nav>
