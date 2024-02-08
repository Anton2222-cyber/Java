<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/infoProfile.css"/>
</head>
<body>
<h1>Welcome to SpringMVC</h1>
<div>
    <div>
        First Name = ${user.firstName}
    </div>
    <div>
        Last Name = ${user.lastName}
    </div>
    <div>
        Age = ${user.age}
    </div>
    <div>
        <c:if test="${user.gender}">
            Man
        </c:if>
        <c:if test="${!user.gender}">
            Woman
        </c:if>
    </div>

</div>
</body>
</html>
