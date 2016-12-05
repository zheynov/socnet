<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="profile.page.text.edition"/></title>
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

                    <div class="tab-pane" id="wall"></div>

                    <div class="tab-pane" id="friends"></div>

                    <jsp:include page="additional/contactabout.jsp"/>

                    <div class="tab-pane" id="messages"></div>

                    <div class="tab-pane" id="photos"></div>


                    <div class="tab-pane active" id="profile" style="margin-left: 250px; width: 300px">

                        <div class="main-login main-center" >
                            <form:form method="POST" action="/editprofile" commandName="profileDTO" class="form-horizontal">

                                <form:hidden path="profileID"/>

                                <form:errors path="firstname"/>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <form:input class="form-control" type="text" path="firstname" name="name"
                                                id="name" placeholder="firstname"/>
                                </div>


                                <br/>
                                <form:errors path="lastname"/>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <form:input class="form-control" type="text" path="lastname" name="name" id="name"
                                                placeholder="lastname"/>
                                </div>

                                <br/>
                                <form:errors path="email"/>
                                <div class="cols-sm-10">
                                    <div class="input-group"> <span class="input-group-addon">
                                    <i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <form:input path="email" placeholder="email" type="text" class="form-control"
                                                    name="email" id="email"/>
                                    </div>
                                </div>


                                <br/>

                                Sex: <form:radiobutton path="sex" value="male"/> male
                                <form:radiobutton path="sex" value="female"/> female
                                <br/> <br/>

                                <form:errors path="phoneNumber"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-mobile" aria-hidden="true"></i></span>
                                        <form:input path="phoneNumber" type="text" class="form-control" name="mobile" id="mobile"
                                                    placeholder="phoneNumber"/>
                                    </div>
                                </div>

                                <br/>
                                <form:errors path="city"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true">
                                         </i></span> <form:input path="city" placeholder="city" type="text" class="form-control"
                                                                 name="country" id="country"/>
                                    </div>
                                </div>

                                <br/>

                                <form:errors path="birthDate"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <form:input path="birthDate" placeholder="city" type="date" class="form-control"
                                                    name="name" id="name"/> <br/>

                                    </div>
                                </div>

                                <br/>
                                <form:errors path="age"/>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <form:input path="age" placeholder="age" type="text" class="form-control"
                                                    name="name" id="name"/>
                                    </div>
                                </div>
                                <br/>

                                <button type="submit" class="btn btn-default btn-lg btn-block">Complete
                                </button>
                            </form:form>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
