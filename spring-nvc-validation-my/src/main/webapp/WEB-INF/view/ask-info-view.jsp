<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/registration.css"/>
</head>
<body>
    <h1>Hello, friend!</h1>
    <form:form action="showInfo" method="get" modelAttribute="user">
        <div>
           <span>First name: </span> <form:input path="firstName"/>
            <form:errors cssClass="error-message" path="firstName"/>
        </div>
        <div>
            <span>Last name: </span><form:input path="lastName"/>
            <form:errors cssClass="error-message" path="lastName"/>
        </div>
        <div>
            <span>Age: </span><form:input path="age"/>
            <form:errors cssClass="error-message" path="age"/>
        </div>
        <div>
            <label>Marital Status:</label>
            <div>
                <label><form:radiobutton path="maritalStatus" value="true"/> Married</label>
                <label><form:radiobutton path="maritalStatus" value="false"/> Not Married</label>
            </div>
        </div>
        <div>
            <label>Gender:</label>
            <div>
                <label><form:radiobutton path="gender" value="true"/> Man</label>
                <label><form:radiobutton path="gender" value="false"/> Woman</label>
            </div>
        </div>
        <div>
            <span>Phone: </span><form:input path="phone"/>
            <form:errors cssClass="error-message" path="phone"/>
        </div>
        <div>
            <span>Email: </span><form:input path="email"/>
            <form:errors cssClass="error-message" path="email"/>
        </div>
        <input type="submit">
    </form:form>
</body>
</html>
