<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="contactabout" tagdir="/WEB-INF/tags/" %>
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

                        <table class="table">
                            <tr>
                                <th>#</th>
                                <th><spring:message code="profile.page.text.fullname"/></th>
                                <th><spring:message code="profile.page.text.age"/></th>
                                <th><spring:message code="profile.page.text.city"/></th>
                                <th><spring:message code="profile.page.text.gender"/></th>
                            </tr>
                            <c:forEach items="${allThePeople}" var="profile">

                                <tr>
                                    <th scope="row">
                                        <a href="/messages/sendmessage/${pageContext.request.userPrincipal.name}&${profile.profileID}">
                                            <spring:message code="messages.page.text.send.message"/> </a>
                                    </th>

                                    <td>${profile.firstname} ${profile.lastname}</td>
                                    <td>${profile.age}</td>
                                    <td>${profile.city}</td>
                                    <td>${profile.sex}</td>
                                </tr>

                            </c:forEach>
                        </table>
                        <br/>

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
