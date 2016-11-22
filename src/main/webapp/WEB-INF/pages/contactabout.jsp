<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
</head>
<body >

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

<div class="tab-pane" id="about" style="margin-left: 250px">
    <div class="">
        <h1><spring:message code="welcome.page.text.about"/></h1>
        <p>Социальная сеть </p>
        <p> Мы - это социальная сеть! </p>
    </div>
</div>

</body>
</html>
