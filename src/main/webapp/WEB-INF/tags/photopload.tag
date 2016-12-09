<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="position:relative;">
    <div class="file_upload" style="width: 90px"><font color="#6495ed"> + </font>
        <input type="file"
               style='position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);
                                               -ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
                                               opacity:0;background-color:transparent;color:transparent;'
               name="photo" size=" 50"
               onchange='$("#upload-file-info").html($(this).val());'> <br/>
    </div>
    <br/>
    <span class='label label-info' id="upload-file-info"></span>
    <input type="submit" class="btn btn-default" style="width: 90px" value="<spring:message code="photos.page.text.upload" />">

</div>

