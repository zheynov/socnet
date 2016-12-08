<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="welcome.page.text.wall"/></title>
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
                    <li class="active"><a href="#wall" data-toggle="tab"><spring:message code="welcome.page.text.wall"/></a></li>
                    <li><a href="/friends"><spring:message code="welcome.page.text.friends"/></a></li>
                    <li><a href="/messages/"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photos"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li><a href="/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="wall" style="margin-left: 250px">

                        <div align="center" class="form-horizontal" style="width: 500px">

                            <form:form action="/posts/sendapost" method="post" commandName="postDTO"
                                       enctype="multipart/form-data">

                                <spring:message code="messages.page.text.entertext" var="entertext"/>
                                <form:textarea class="form-control" id="textArea" path="text" rows="6" name="text"
                                               placeholder="${entertext}"/>

                                <form:input path="photo" type="file" data-filename-placement="inside" name="photo" accept="image/*"/>
                                <input type="submit" value="<spring:message code="messages.page.text.send.sendmessage"/>">

                            </form:form>

                        </div>

                    </div>

                    <jsp:include page="../additional/contactabout.jsp"/>

                    <div class="tab-pane" id="friends"></div>

                    <div class="tab-pane" id="messages"></div>

                    <div class="tab-pane" id="photos"></div>

                    <div class="tab-pane" id="profile"></div>

                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    <div class="tab-pane" id="admin">
                        <p>

                            </c:if>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
