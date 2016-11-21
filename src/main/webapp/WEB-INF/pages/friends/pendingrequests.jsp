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
                    <li><a href="#messages" data-toggle="tab"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photoes"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li><a href="/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="wall" style="margin-left: 200px">
                    </div>
                    <div class="tab-pane active" id="friends" style="margin-left: 200px">
                        <p>
                            <a href="/friends">
                                <button type="button" class="btn btn-default btn-lg btn-block">
                                    <spring:message code="friend.page.text.friend.managefriends"/></button>
                            </a>
                        </p>
                        <br/> <br/>
                        <c:choose>
                            <c:when test="${allThePendingRequests.size()==0}">
                                <div class="warning">
                                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                    <spring:message code="friend.page.text.friend.nopendingrequests"/>
                                </div>


                            </c:when>
                            <c:otherwise>
                                <table id="friendsTable" class="table">
                                    <tr>
                                        <th><spring:message code="friend.page.text.friend.good"/></th>
                                        <th><spring:message code="friend.page.text.friend.bad"/></th>
                                        <th><spring:message code="profile.page.text.fullname"/></th>
                                        <th><spring:message code="profile.page.text.age"/></th>
                                        <th><spring:message code="profile.page.text.city"/></th>
                                        <th><spring:message code="profile.page.text.gender"/></th>
                                    </tr>
                                    <c:forEach items="${allThePendingRequests}" var="friend">
                                        <tr>
                                            <th scope="row"><a
                                                    href="/friends/approve/${pageContext.request.userPrincipal.name}&${friend.profileDTO.profileID}">
                                                <spring:message code="friend.page.text.friend.approverequest"/> </a>
                                            </th>
                                            <th scope="row"><a
                                                    href="/friends/reject/${pageContext.request.userPrincipal.name}&${friend.profileDTO.profileID}">
                                                <spring:message code="friend.page.text.friend.rejectrequest"/> </a>
                                            </th>
                                            <td>${friend.profileDTO.firstname} ${friend.profileDTO.lastname}</td>
                                            <td>${friend.profileDTO.age}</td>
                                            <td>${friend.profileDTO.city}</td>
                                            <td>${friend.profileDTO.sex}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:otherwise>
                        </c:choose>
                        <br/>


                    </div>

                    <div class="tab-pane" id="about" style="margin-left: 200px">
                        >
                        <h1><spring:message code="welcome.page.text.about"/></h1>
                        <p>Социальная сеть </p>
                        <p> Мы - это социальная сеть! </p>

                    </div>

                    <div class="tab-pane" id="messages">
                        <div class="" style="margin-left: 200px">
                            <h1><spring:message code="welcome.page.text.mesagges"/></h1>
                            <p>Здесь будут отображаться сообщения</p>
                        </div>
                    </div>

                    <div class="tab-pane" id="photoes">
                        <div class="">
                            <h1><spring:message code="welcome.page.text.photoes"/></h1>
                            <p>Здесь будут отображаться фотографии</p>
                        </div>
                    </div>

                    <div class="tab-pane" id="contact">
                        <div class="" style="margin-left: 200px">
                            <h1><spring:message code="welcome.page.text.contacts"/></h1>
                            <p> ЦЕНТР РАЗРАБОТКИ В БЕЛАРУСИ </p> <br/>
                            <p>
                                SaM Solutions Belarus <br/>
                                ул.Филимонова, 15,<br/>
                                Минск, 220037, Республика Беларусь <br/>
                            </p>
                            <p>
                                +375-17-3091709<br/>
                                +375-17-3091717
                            </p>
                            <br/>
                            <p><a href="mailto:admin@admin.com">Задавайте вопросы по электронной почте</a></p>
                        </div>
                    </div>

                    <div class="tab-pane" id="profile">
                    </div>

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