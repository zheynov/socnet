<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 18.10.2016
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="login.page.text.title"/></title>
</head>
<body>

<h1><spring:message code="login.page.text.welcome"/></h1>


<%--
<c:if test="${sessionScope.get('userDTO') ne null}">
    ${pageContext.forward("/showAllUsers")}
</c:if>
action="processLogin"   commandName="userDTO"--%>


<c:if test="${not empty error}">
    <spring:message code="login.page.text.invalid.credentials" var="invalidCredentials"/>
    <div class="error">${invalidCredentials}</div>
</c:if>
<c:if test="${not empty msg}">
    <spring:message code="page.text.logout.message" var="logoutMessage"/>
    <div class="msg">${logoutMessage}</div>
</c:if>


<p>

<form method="POST" action="<c:url value='/j_spring_security_check' />">
    <table>

        <tr><spring:message code="login.page.filed.username" var="username"/>
            <td><input type='text' name='username' placeholder="${username}"/>

        </tr>
        <tr><spring:message code="login.page.filed.password" var="passwordLabel"/>
            <td><input type="password" name='password' placeholder="${passwordLabel}"/>

        </tr>

        <!-- if this is login for update, ignore remember me check -->
        <c:if test="${empty loginUpdate}">
            <tr><spring:message code="login.page.text.rememberme" var="rememberme"/>
                <td>${rememberme}: <input type="checkbox" name="remember-me" /></td>
            </tr>
        </c:if>
        <tr>
            <td colspan='2'>
                <spring:message code="login.page.loginbutton" var="loginbuttonLabel"/>
                <input type="submit" class="buttonLogin" value="${loginbuttonLabel}"/>
            </td>
        </tr>

    </table>
</form>


<a href="/registration"> Registration </a> <br/>
<a href="/showAllUsers"> All the users </a>

</body>
</html>
