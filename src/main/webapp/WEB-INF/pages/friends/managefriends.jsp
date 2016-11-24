<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friends</title>
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

                    <div class="tab-pane active" id="friends" style="margin-left: 250px">

                        <a class="button" href="/friends/allthepeople/${pageContext.request.userPrincipal.name}">

                            <button type="button" class="btn btn-default">
                                <spring:message code="friend.page.text.showallprofiles"/>
                            </button>
                        </a>

                        <a class="button" href="/friends/allthefriends/${pageContext.request.userPrincipal.name}">
                            <button type="button" class="btn btn-default">
                                <spring:message code="friend.page.text.showallfriends"/>
                            </button>
                        </a>

                        <a class="button" href="/friends/pendingrequests/${pageContext.request.userPrincipal.name}">
                            <button type="button" class="btn btn-default">
                                <spring:message code="friend.page.text.friend.requests"/>
                            </button>
                        </a>
                    </div>

                    <div class="tab-pane" id="messages"></div>

                    <div class="tab-pane" id="photoes"></div>

                    <jsp:include page="../contactabout.jsp"/>

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
