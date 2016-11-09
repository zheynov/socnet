<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile edition</title>
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
                    <div class="tab-pane" id="wall">

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
                            <form:form method="POST" action="/editprofile" commandName="profileDTO">

                                <table>
                                    <form:hidden path="profileID"/>
                                    <tr>
                                        <td><form:input path="firstname" placeholder="firstname" size="30"/></td>
                                        <td><form:errors path="firstname"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:input path="lastname" placeholder="lastname" size="30"/></td>
                                        <td><form:errors path="lastname"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:input path="email" placeholder="email" size="30"/></td>
                                        <td><form:errors path="email"/></td>
                                    </tr>

                                    <tr>
                                        <td> Sex: <form:radiobutton path="sex" value="male"/>male
                                            <form:radiobutton path="sex" value="female"/>female
                                        </td>
                                        <td><form:errors path="sex"/></td>

                                    </tr>
                                    <tr>
                                        <td><form:input type="date" path="birthDate"/></td>
                                        <td><form:errors path="birthDate"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:input path="age" placeholder="age" size="30"/></td>
                                        <td><form:errors path="age"/></td>

                                    </tr>
                                    <tr>
                                        <td><form:input path="city" placeholder="city" size="30"/></td>
                                        <td><form:errors path="city"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:input path="phoneNumber" placeholder="phoneNumber" size="30"/></td>
                                        <td><form:errors path="phoneNumber"/></td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <input type="submit" value="complete"/>
                                        </td>
                                    </tr>
                                </table>
                            </form:form>

                        </div>

                    </div>

                </div>

            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
