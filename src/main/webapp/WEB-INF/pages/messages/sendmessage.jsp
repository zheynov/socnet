<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="welcome.page.text.mesagges"/></title>
    <action:actions/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <h3><spring:message code="welcome.page.text.menu"/></h3>
            <!-- tabs -->
            <div class="tabbable tabs-left">
                <ul class="nav nav-tabs">
                    <li><a href="/welcomePage"><spring:message code="welcome.page.text.wall"/></a></li>
                    <li><a href="/friends"><spring:message code="welcome.page.text.friends"/></a></li>
                    <li class="active" data-toggle="tab"><a href="#messages" data-toggle="tab"><spring:message
                            code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photoes"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li><a href="/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">

                    <div class="tab-pane" id="wall"></div>

                    <div class="tab-pane" id="friends"></div>

                    <div class="tab-pane active" id="messages" style="margin-left: 250px">

                        <form:form method="POST" action="/messages/sendmessage" modelAttribute="MessageDTO">


                            <form:hidden path="messageDate"/>


                            <spring:message code="messages.page.text.time" var="entertext"/>
                            <p><form:textarea path="text" rows="4" cols="100" maxlength="1023" placeholder="${entertext}"/></p>

                            <form:hidden path="senderProfileDTO"/>
                            <form:hidden path="destinationProfileDTO"/>

                            <a href="/messages/">
                                <button type="button" class="btn btn-default">
                                    <spring:message code="messages.page.text.send.manage.messages"/></button>
                            </a>

                            <spring:message code="messages.page.text.send.sendmessage" var="send"/>
                            <button type="submit" class="btn btn-primary login-button">${send}</button>


                        </form:form>
                        <br/>

                        <c:forEach items="${allTheMessages}" var="message">


                            <c:choose>
                                <c:when test="${pageContext.request.userPrincipal.name eq message.senderProfileDTO.firstname}">
                                    <br/>
                                    <div class="alert-info">
                                        <font size="1">
                                            <b ><spring:message code="messages.page.text.sender"/>:</b>
                                                ${message.senderProfileDTO.firstname} ${message.senderProfileDTO.lastname}
                                        </font> <font size="1">
                                        <b><spring:message code="messages.page.text.time"/>: </b> ${message.messageDate}
                                    </font><br/>
                                        <p><div style="margin-left: 5px"> <b> ${message.text} </b> </div>
                                    </div>
                                </c:when>

                                <c:otherwise>
                                    <br/>
                                    <div class="alert-success" style="margin-left: 20px">
                                        <font size="1">
                                            <b><spring:message code="messages.page.text.sender"/>:</b>
                                                ${message.senderProfileDTO.firstname} ${message.senderProfileDTO.lastname}
                                        </font> <font size="1">
                                        <b><spring:message code="messages.page.text.time"/>: </b> ${message.messageDate}
                                    </font><br/>
                                        <p> <div style="margin-left: 5px"><b > ${message.text} </b> </div>
                                    </div>

                                </c:otherwise>
                            </c:choose>

                        </c:forEach>

                    </div>

                    <div class="tab-pane" id="photoes"></div>

                    <jsp:include page="../contactabout.jsp"/>

                    <div class="tab-pane" id="profile"></div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
