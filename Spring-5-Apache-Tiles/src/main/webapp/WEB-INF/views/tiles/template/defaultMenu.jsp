<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a href="${pageContext.request.contextPath}/" class="navbar-brand"><img
            src="<%--${pageContext.request.contextPath}--%>/static/image/pict-01.png" alt="You Dead" width="25 px" height="25 px"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/products">Products</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
        </ul>
    </div>
</nav>