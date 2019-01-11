<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Student Enrollment Form</title>
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/static/css/custom.css"/>" />
    <link rel="stylesheet" href="<c:url value="/static/gijgo/css/gijgo.min.css"/>" />
</head>
<body>
    <div class="container">
        <h1>Enrollment Form</h1>
        <form:form method="post" modelAttribute="student">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <form:input path="firstName" type="text" id="firstName" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="firstName" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="lastName">Last Name</label>
                <form:input path="lastName" cssErrorClass="form-control is-invalid" cssClass="form-control"/>
                <form:errors path="lastName" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="sex" class="d-block">Sex</label>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="sex" value="M" cssClass="form-check-input" />
                    <label class="form-check-label">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="sex" value="F" cssClass="form-check-input" />
                    <label class="form-check-label">Female</label>
                </div>
                <form:errors path="sex" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="dob">Date of Birth</label>
                <form:input path="dob" id="datepicker" cssErrorClass="form-control is-invalid"/>
                <form:errors path="dob" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" type="email" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="email" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="section" class="d-block">Section</label>
                <div id="section-buttons">
                    <form:radiobuttons path="section" element="div class='form-check form-check-inline'" cssClass="form-check-input" items="${sections}" />
                </div>
                <form:errors path="section" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="country">Country</label>
                <form:select path="country" cssClass="custom-select" cssErrorClass="form-control is-invalid">
                    <form:option value="">Select Country</form:option>
                    <form:options items="${countries}"/>
                </form:select>
                <form:errors path="country" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <div class="form-check form-check-inline">
                    <label for="firstAttempt" class="form-check-label mr-1">First Attempt?</label>
                    <form:checkbox path="firstAttempt" cssClass="form-check-input"/>
                </div>
                <form:errors path="firstAttempt" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <label for="subjects">Subjects</label>
                <form:select path="subjects" items="${subjects}" multiple="true" cssClass="custom-select" cssErrorClass="form-control is-invalid"/>
                <form:errors path="subjects" element="small" cssClass="form-text text-danger m-0" />
            </div>

            <div class="form-group">
                <input type="submit" class="btn btn-outline-primary" value="Register">
            </div>
        </form:form>
    </div>
    <script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js"/> " ></script>
    <script type="text/javascript" src="<c:url value="/static/gijgo/js/gijgo.min.js"/> " ></script>
    <script type="text/javascript">
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });

        $("#section-buttons label").addClass("form-check-label");
    </script>
</body>
</html>
