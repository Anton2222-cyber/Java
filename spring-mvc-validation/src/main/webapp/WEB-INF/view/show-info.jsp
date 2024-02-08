<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section>
    <h1>Welcome to SpringMVC</h1>
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
        City = ${user.city}
    </div>
    <div>
        Gender = ${user.gender}
    </div>
<%--    <div>--%>
<%--        Language = ${user.selectedLanguages}--%>
<%--    </div>--%>
    <div>
        Language =
        <ul>
            <c:forEach items="${user.selectedLanguages}" var="lang">
                <li>${lang}</li>
            </c:forEach>
        </ul>
    </div>
</section>
</body>
</html>
