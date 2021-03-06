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
    <div class="row" >
        <div class="col-xs-12" >
            <h3><spring:message code="welcome.page.text.menu"/></h3>
            <!-- tabs -->
            <div class="tabbable tabs-left" >
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#wall" data-toggle="tab"><spring:message code="welcome.page.text.wall"/></a></li>
                    <li><a href="/friends"><spring:message code="welcome.page.text.friends"/></a></li>
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
                    <div class="tab-pane active" id="wall" style="margin-left: 250px; width: 600px" >


                        <a href="/posts/showusers" class="btn btn-default btn-lg btn-block"><spring:message
                                code="posts.page.text.choose.wall"/></a>
                        <br/>

                        <div align="center" class="form-horizontal">

                            <form:form action="/posts/sendaposttomyself" method="post" commandName="postDTO"
                                       enctype="multipart/form-data" onsubmit="return Validate(this);">

                                <spring:message code="messages.page.text.entertext" var="entertext"/>
                                <form:textarea class="form-control" id="texta" path="text" rows="3" name="text"
                                               placeholder="${entertext}"/>

                                <br/><action:fileupload/>

                            </form:form>

                        </div>
                        <br/>

                        <c:forEach items="${allThePosts}" var="post">

                            <c:choose>
                                <c:when test="${post.photoFileName.length() gt 1}">
                                    <img src="images/${post.photoFileName}" style="width: 600px"> <br/>
                                </c:when>
                            </c:choose>


                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <font size="1"> <b> <spring:message code="posts.page.text.author"/>:
                                    </b> ${post.senderProfileDTO.firstname} ${post.senderProfileDTO.lastname} </font>
                                    <font size="1"> <b style="margin-left: 7px;"> <spring:message
                                            code="posts.page.text.date"/>: </b> ${post.postDate.toLocaleString()}
                                        <a href="/posts/deleteapost/${post.postID}" style="margin-left: 5px;">
                                            <spring:message code="posts.page.text.delete"/></a> </font>

                                </div>

                                <c:choose>
                                    <c:when test="${post.text.length() gt 1}">
                                        <div class="panel-body"> ${post.text}
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>


                        </c:forEach>

                        <br/>

                    </div>

                    <jsp:include page="additional/contactabout.jsp"/>

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
