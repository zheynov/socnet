<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="welcome.page.text.photoes"/></title>
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
                    <li class="active"><a href="#photoes" data-toggle="tab"><spring:message code="welcome.page.text.photoes"/></a>
                    </li>
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

                    <div class="tab-pane" id="messages"></div>

                    <div class="tab-pane active" id="photos">

                        <div style="margin-left: 20%">

                            <form:form method="post" action="/photos/photoupload/${pageContext.request.userPrincipal.name}"
                                       enctype="multipart/form-data"
                                       commandName="photoDTO">

                                <label class="btn btn-default btn-primary">
                                    <spring:message code="photos.page.text.browse"/>
                                    <form:input path="photo" type="file" style="display: none;"/>
                                </label>
                                <input type="submit" class="btn btn-default"
                                       value="<spring:message code="photos.page.text.upload"/>">
                            </form:form>
                            <br/>

                            <!--list of images -->
                            <div id="links">

                                <c:forEach items="${allThePhotos}" var="photo">

                                    <a data-gallery="" href="images/${photo.photoFileName}"> <img
                                            src="images/${photo.photoFileName}" width="200"> </a>

                                    <a href="/photos/delete/${photo.id}"> <spring:message code="photos.page.text.delete"/> </a>

                                </c:forEach>

                            </div>

                            <jsp:include page="../../resources/jsps/photogallery.jsp"/>
                        </div>
                    </div>
                    <jsp:include page="../../resources/jsps/contactabout.jsp"/>

                    <div class="tab-pane" id="profile"></div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
