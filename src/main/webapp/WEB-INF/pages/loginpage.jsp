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
action="processLogin"  --%>


<form:form method="POST" action="<c:url value='/j_spring_security_check'/>" commandName="userDTO">
    <table>
        <tr><spring:message code="login.page.filed.login" var="login"/>
            <td><form:input path="login" placeholder="${login}"/>
            <td><form:errors path="login"/></td>
        </tr>
        <tr><spring:message code="login.page.filed.password" var="passwordLabel"/>
            <td><form:password path="password" placeholder="${passwordLabel}"/>
            <td><form:errors path="password"/></td>
        </tr>
        <td align="center">
            <spring:message code="login.page.loginbutton" var="loginbuttonLabel"/>
            <input type="submit" class="buttonLogin" value="${loginbuttonLabel}"/>
        </td>

    </table>
</form:form>


<a href="/registration"> Registration </a> <br/>
<a href="/showAllUsers"> All the users </a>
<a href="/welcome"> All the users </a>

</body>
</html>
