<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="welcome.page.text.friends"/></title>
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
                    <li class="active"><a href="#friends" data-toggle="tab"><spring:message code="welcome.page.text.friends"/></a>
                    </li>
                    <li><a href="/messages/"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photos"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li><a href="/profile/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">

                    <div class="tab-pane" id="wall"></div>

                    <div class="tab-pane active" id="friends" style="margin-left: 250px">

                        <p>
                            <a href="/friends">
                                <button type="button" class="btn btn-default btn-lg btn-block">
                                    <spring:message code="friend.page.text.friend.managefriends"/></button>
                            </a>
                        </p>
                        <br/> <br/>

                        <c:choose>
                            <c:when test="${allTheFriends.size()==0}">
                                <div class="warning">
                                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                    <spring:message code="friend.page.text.friend.nofriends"/>
                                </div>
                                <p></p>

                            </c:when>
                            <c:otherwise>
                                <table id="friendsTable" class="table">
                                    <tr>
                                        <th>#</th>
                                        <th><spring:message code="profile.page.text.fullname"/></th>
                                        <th><spring:message code="profile.page.text.age"/></th>
                                        <th><spring:message code="profile.page.text.city"/></th>
                                        <th><spring:message code="profile.page.text.gender"/></th>
                                    </tr>
                                    <c:forEach items="${allTheFriends}" var="friend">
                                        <tr>
                                            <th scope="row"><a
                                                    href="/friends/delete/friend/${pageContext.request.userPrincipal.name}&${friend.profileID}">
                                                <spring:message code="friend.page.text.friend.deleteafriend"/> </a>
                                            </th>
                                            <td>${friend.firstname} ${friend.lastname}</td>
                                            <td>${friend.age}</td>
                                            <td>${friend.city}</td>
                                            <td>${friend.sex}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:otherwise>
                        </c:choose>
                        <br/>

                    </div>

                    <jsp:include page="../additional/contactabout.jsp"/>

                    <div class="tab-pane" id="messages"></div>

                    <div class="tab-pane" id="photos"></div>


                    <div class="tab-pane" id="profile"></div>

                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <div class="tab-pane" id="admin">
                        </div>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
