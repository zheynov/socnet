<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tab-pane" id="contact">
    <div class="" style="margin-left: 250px">
        <h1><spring:message code="welcome.page.text.contacts"/></h1>
        <p><spring:message code="contactabout.page.text.centr"/></p> <br/>
        <p>
            SaM Solutions Belarus <br/>
            <spring:message code="contactabout.page.text.street"/> <br/>
            <spring:message code="contactabout.page.text.address"/> <br/>
        </p>
        <p>
            +375-17-3091709<br/>
            +375-17-3091717
        </p>
        <br/>
        <p><a href="mailto:admin@admin.com"><spring:message code="contactabout.page.text.emailus"/> </a></p>
    </div>
</div>

<div class="tab-pane" id="about" style="margin-left: 250px">
    <div class="">
        <h1><spring:message code="welcome.page.text.about"/></h1>
        <p><spring:message code="contactabout.page.text.socialnetwork"/></p>
        <p><spring:message code="contactabout.page.text.weare"/></p>
    </div>
</div>



