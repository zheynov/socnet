<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="profile.page.text.page"/></title>
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
                    <li><a href="/messages/"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photos"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li class="active"><a href="#profile" data-toggle="tab"><spring:message code="welcome.page.text.profile"/></a>
                    </li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>

                <div class="tab-content">

                    <div id="wall"></div>

                    <div class="tab-pane" id="friends"></div>

                    <jsp:include page="../additional/contactabout.jsp"/>

                    <div class="tab-pane" id="messages"></div>

                    <div class="tab-pane" id="photos"></div>

                    <div class="tab-pane active" id="profile" style="margin-left: 250px">

                        <h2><spring:message code="welcome.page.text.profile"/></h2>

                        <p>
                            <b> <spring:message code="profile.page.text.firstname"/>: </b> ${profileDTO.firstname} <br/>
                            <b> <spring:message code="profile.page.text.lastname"/>:</b> ${profileDTO.lastname} <br/>
                            <b> <spring:message code="profile.page.text.email"/>:</b> ${profileDTO.email} <br/>
                            <b> <spring:message code="profile.page.text.gender"/>:</b> ${profileDTO.sex} <br/>
                            <b> <spring:message code="profile.page.text.dateofbirth"/>:</b> ${profileDTO.birthDate} <br/>
                            <b> <spring:message code="profile.page.text.age"/>: </b> ${profileDTO.age} <br/>
                            <b> <spring:message code="profile.page.text.city"/>: </b> ${profileDTO.city} <br/>
                            <b> <spring:message code="profile.page.text.phone"/>:</b> ${profileDTO.phoneNumber} <br/>

                        <p><a href="/profile/profileedit"><spring:message code="profile.page.text.edit"/></a>
                        <p><a href="/profile/passwordchange"><spring:message
                                code="admin.page.text.changepassword"/></a>

                        <c:if test="${passwordchanged != null}">
                        <div class="alert alert-success" role="alert">
                            <div class="msg" align="center">
                                <b> <spring:message code="profile.page.text.password.changed"/> </b>
                            </div>
                        </div>
                        </c:if>

                    </div>

                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>
