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
                    <li><a href="#messages" data-toggle="tab"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="/beforeprofilepage"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="/admin/"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="wall">
                    </div>
                    <div class="tab-pane active" id="friends">

                        <p></p>

                        <div style="margin-left: 100px">

                            <div class="row">
                                <div class="col-sm-10 col-sm-offset-1">

                                    <table id="friendsTable" class="table">
                                        <tr>
                                            <th>#</th>
                                            <th><spring:message code="profile.page.text.fullname"/></th>
                                            <th><spring:message code="profile.page.text.age"/></th>
                                            <th><spring:message code="profile.page.text.city"/></th>
                                            <th><spring:message code="profile.page.text.gender"/></th>
                                        </tr>
                                        <c:forEach items="${allTheProfiles}" var="profile">
                                            <tr>
                                                <th scope="row"><a href="/addfriend/${pageContext.request.userPrincipal.name},${profile.profileID}"> Добавить </a>
                                                </th>
                                                <td>${profile.lastname} ${profile.firstname}</td>
                                                <td>${profile.age}</td>
                                                <td>${profile.city}</td>
                                                <td>${profile.sex}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                    <br/>
                                    <select for="friendsTable">
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="20" selected>20</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
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

                    <div class="tab-pane" id="profile">

                        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <div class="tab-pane" id="admin">
                            </c:if>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
