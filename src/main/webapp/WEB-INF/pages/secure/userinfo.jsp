<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin dashboard</title>
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
                    <li><a href="#messages" data-toggle="tab"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/photoes"><spring:message code="welcome.page.text.photoes"/></a></li>
                    <li><a href="/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li class="active"><a href="#admin" data-toggle="tab"><spring:message
                                code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>

                <div class="tab-content">
                    <div  id="wall" style="margin-left: 250px">

                    </div>

                    <div class="tab-pane" id="friends">
                        <div class="">
                        </div>
                    </div>

                    <div class="tab-pane" id="about">
                        <div class="">
                            <h1><spring:message code="welcome.page.text.about"/></h1>
                            <p>Социальная сеть </p>
                            <p> Мы - это социальная сеть! </p>
                        </div>
                    </div>

                    <div class="tab-pane" id="messages">
                        <div class="">
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
                        <div class="" style="margin-left: 250px">
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
                        <div class="">
                            <h1><spring:message code="welcome.page.text.profile"/></h1>
                            <a href="/beforeprofilepage">Страница профиля</a></div>
                    </div>


                    <div class="tab-pane active" id="admin"  style="margin-left: 250px" >

                            <h3 class="h3"> User credentials: </h3>

                            <b>Email: </b> ${userDTO.email} <br/>
                            <b>Login: </b> ${userDTO.username} <br/>
                            <b>Password: </b> encrypted <br/>
                            <b>Account status: </b>

                            <c:choose>
                                <c:when test="${userDTO.enabled == true}"> active </c:when>
                                <c:otherwise> disabled </c:otherwise>
                            </c:choose> <br/> <br/>

                            <p> <a href="/admin/"><spring:message code="admin.page.text.backtomain"/></a>
                        </div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
