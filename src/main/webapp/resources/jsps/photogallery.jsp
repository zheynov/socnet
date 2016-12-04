<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<%--    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css"/>" type="text/css" rel="stylesheet">
    <script src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"/>"></script>
    <script src="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="http://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"/>"></script>--%>


    <link href="<c:url value="/resources/css/bootstrap302.min.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/blueimp-gallery.min.css"/>" type="text/css" rel="stylesheet">

    <script src="<c:url value="/resources/js/1102jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/302bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.blueimp-gallery.min.js"/>"></script>

</head>
<body>


<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery">
    <!-- The container for the modal slides -->
    <div class="slides"></div>
    <!-- Controls for the borderless lightbox -->
    <h3 class="title"></h3>
    <a class="prev">‹</a>
    <a class="next">›</a>
    <a class="close">×</a>
    <a class="play-pause"></a>
    <ol class="indicator"></ol>
    <!-- The modal dialog, which will be used to wrap the lightbox content -->
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" aria-hidden="true">×</button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body next"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left prev">
                        <i class="glyphicon glyphicon-chevron-left"></i>
                        Previous
                    </button>
                    <button type="button" class="btn btn-primary next">
                        Next
                        <i class="glyphicon glyphicon-chevron-right"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
