<html>
<head>

    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>

    <jsp:include page="/WEB-INF/pages/secure/navbar.jsp"/>

    <style>
    .tabs-left > .nav-tabs {
    border-bottom: 0;
    }

    .tab-content > .tab-pane,
    .pill-content > .pill-pane {
    display: none;
    }

    .tab-content > .active,
    .pill-content > .active {
    display: block;
    }

    .tabs-left > .nav-tabs > li {
    float: none;
    }

    .tabs-left > .nav-tabs > li > a {
    min-width: 74px;
    margin-right: 0;
    margin-bottom: 3px;
    }

    .tabs-left > .nav-tabs {
    float: left;
    margin-right: 19px;
    border-right: 1px solid #ddd;
    }

    .tabs-left > .nav-tabs > li > a {
    margin-right: -1px;
    -webkit-border-radius: 4px 0 0 4px;
    -moz-border-radius: 4px 0 0 4px;
    border-radius: 4px 0 0 4px;
    }

    .tabs-left > .nav-tabs > li > a:hover,
    .tabs-left > .nav-tabs > li > a:focus {
    border-color: #eeeeee #dddddd #eeeeee #eeeeee;
    }

    .tabs-left > .nav-tabs .active > a,
    .tabs-left > .nav-tabs .active > a:hover,
    .tabs-left > .nav-tabs .active > a:focus {
    border-color: #ddd transparent #ddd #ddd;
    *border-right-color: lightblue;;
    }
    </style>

    <script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

</body>
</html>
