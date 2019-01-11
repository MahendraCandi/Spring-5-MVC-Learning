<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta content="text/">
    <title>Student Enrollment Detail Confirmation</title>
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/static/css/custom.css"/>" />
</head>
<body>
    <div class="container">
        <div class="text-center display-4">
            Confirmation Message: ${success}
        </div>
        <div class="lead mt-5 text-center">
            We have also sent you a confirmation mail to your email address : ${student.email}.
        </div>
    </div>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js"/> " ></script>
</body>
</html>
