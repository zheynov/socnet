<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="mainCss" uri="/WEB-INF/pages/tld/main.tag" %>--%>

<%--
  Created by IntelliJ IDEA.
  User: vazh
  Date: 20.10.2016
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <%--<mainCss: />--%>
    <jsp:include page="secure/navbar.jsp"/>

    <%--<style>--%>
        <%--.tabs-left > .nav-tabs {--%>
            <%--border-bottom: 0;--%>
        <%--}--%>

        <%--.tab-content > .tab-pane,--%>
        <%--.pill-content > .pill-pane {--%>
            <%--display: none;--%>
        <%--}--%>

        <%--.tab-content > .active,--%>
        <%--.pill-content > .active {--%>
            <%--display: block;--%>
        <%--}--%>

        <%--.tabs-left > .nav-tabs > li {--%>
            <%--float: none;--%>
        <%--}--%>

        <%--.tabs-left > .nav-tabs > li > a {--%>
            <%--min-width: 74px;--%>
            <%--margin-right: 0;--%>
            <%--margin-bottom: 3px;--%>
        <%--}--%>

        <%--.tabs-left > .nav-tabs {--%>
            <%--float: left;--%>
            <%--margin-right: 19px;--%>
            <%--border-right: 1px solid #ddd;--%>
        <%--}--%>

        <%--.tabs-left > .nav-tabs > li > a {--%>
            <%--margin-right: -1px;--%>
            <%---webkit-border-radius: 4px 0 0 4px;--%>
            <%---moz-border-radius: 4px 0 0 4px;--%>
            <%--border-radius: 4px 0 0 4px;--%>
        <%--}--%>

        <%--.tabs-left > .nav-tabs > li > a:hover,--%>
        <%--.tabs-left > .nav-tabs > li > a:focus {--%>
            <%--border-color: #eeeeee #dddddd #eeeeee #eeeeee;--%>
        <%--}--%>

        <%--.tabs-left > .nav-tabs .active > a,--%>
        <%--.tabs-left > .nav-tabs .active > a:hover,--%>
        <%--.tabs-left > .nav-tabs .active > a:focus {--%>
            <%--border-color: #ddd transparent #ddd #ddd;--%>
            <%--*border-right-color: lightblue;;--%>
        <%--}--%>
    <%--</style>--%>


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
                    <li><a href="#friends" data-toggle="tab"><spring:message code="welcome.page.text.friends"/></a></li>
                    <li><a href="#messages" data-toggle="tab"><spring:message code="welcome.page.text.mesagges"/></a></li>
                    <li><a href="#profile" data-toggle="tab"><spring:message code="welcome.page.text.profile"/></a></li>
                    <li><a href="#contact" data-toggle="tab"><spring:message code="welcome.page.text.contacts"/></a></li>
                    <li><a href="#about" data-toggle="tab"><spring:message code="welcome.page.text.about"/></a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="#admin" data-toggle="tab"><spring:message code="welcome.page.text.admin.dashboard"/></a></li>
                    </c:if>

                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="wall">
                        <div class="">
                            <h1><spring:message code="welcome.page.text.wall"/></h1>
                            <p>Скоро тут будут отображаться посты</p>


                            <%--                                <div align="center">
                                                                <form:form action="/makepost" method="post" commandName="newPost" enctype="multipart/form-data">

                                                                    <p><form:textarea path="text" rows="6" cols="100" name="text" placeholder="enter text"/></p>
                                                                    <form:input path="photo" type="file" name="photo" accept="image/*" data-buttonText="Your label here"/>

                                                                    <input type="submit" value="Submit">
                                                                </form:form>
                                                            </div>--%>


                        </div>
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

                    <div class="tab-pane" id="profile">
                        <div class="">
                            <h1><spring:message code="welcome.page.text.profile"/></h1>
                            <a href="/beforeprofilepage">Страница профиля</a></div>
                    </div>

                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    <div class="tab-pane" id="admin">
                        <p>
                        <div style="margin-left: 200px">

                            <jsp:include page="/admin/"/>
                        </div>
                        </c:if>
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
