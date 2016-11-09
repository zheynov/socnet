<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Profile page</title>
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
                    <li><a href="#friends" data-toggle="tab"><spring:message code="welcome.page.text.friends"/></a></li>
                    <li><a href="#messages" data-toggle="tab"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li class="active"><a href="#profile" data-toggle="tab"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">
                    <div  id="wall">

                    </div>
                    <div class="tab-pane" id="friends">
                        <div class="">
                            <h1><spring:message code="welcome.page.text.friends"/></h1>
                            <p> Тут будет отображаться раздел о друзьях Юзера </p>
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

                    <div class="tab-pane active" id="profile">

                        <div style="margin-left: 200px">
                            <h2><spring:message code="welcome.page.text.profile"/> </h2>

                            <p>
                                <b> Firstname: </b> ${profileDTO.firstname} <br/>
                                <b> Lastname:</b> ${profileDTO.lastname} <br/>
                                <b> Email:</b> ${profileDTO.email} <br/>
                                <b> Sex:</b> ${profileDTO.sex} <br/>
                                <b> Date of birth:</b> ${profileDTO.birthDate} <br/>
                                <b> Age: </b> ${profileDTO.age} <br/>
                                <b> City: </b> ${profileDTO.city} <br/>
                                <b> Phone number:</b> ${profileDTO.phoneNumber} <br/>

                            <p><a href="/profileedit">Edit profile</a>

                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>
