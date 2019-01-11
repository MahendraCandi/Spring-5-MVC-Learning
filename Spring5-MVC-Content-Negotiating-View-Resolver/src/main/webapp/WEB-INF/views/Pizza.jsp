<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Pizza JSP View</title>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>">
</head>
<body>
    <div class="container">
        <table class="table">
            <tr>
                <td>Name</td>
                <td>Flavor</td>
                <td>Toppings</td>
            </tr>
            <tr>
                <td>${pizza.name}</td>
                <td>${pizza.flavour}</td>
                <td>
                    <c:forEach var="item" items="${pizza.toppings}">
                        <c:out value="${item}"/> &nbsp;
                    </c:forEach>
                </td>
            </tr>
        </table>
    </div>


    <script src="<c:url value="/webjars/jquery/3.3.1-1/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/popper.js/1.14.3/popper.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
</html>
