<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<link>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <link href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
    <header id="header">
        <tiles:insertAttribute name="header"/>
    </header>

    <section id="sidemenu">
        <tiles:insertAttribute name="menu"/>
    </section>

    <section id="site-content">
        <tiles:insertAttribute name="body"/>
    </section>

    <section id="footerApp">
        <tiles:insertAttribute name="footer"/>
    </section>

    <script src="<c:url value="/webjars/jquery/3.3.1-1/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/popper.js/1.14.3/popper.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
    </body>
</html>
