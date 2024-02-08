<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello, friend!</h1>
<form:form action="showInfo" method="get" modelAttribute="user">
    <div>
        <span>FIRST NAME: </span> <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </div>
    <div>
        <span>LAST NAME: </span> <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </div>
    <div>
        <span>AGE: </span> <form:input path="age"/>
        <form:errors path="age"/>

    </div>
    <%--    <div>--%>
    <%--        <span>CITY: </span>--%>
    <%--        <form:select path="city">--%>
    <%--            <form:option value="Dn" label="Dnepr"/>--%>
    <%--            <form:option value="Mr" label="Mariupol"/>--%>
    <%--            <form:option value="Lv" label="Lviv"/>--%>
    <%--        </form:select>--%>
    <%--    </div>--%>
    <div>
        <span>CITY: </span>
        <form:select path="city">
            <form:options items="${user.cities}"/>
        </form:select>
    </div>
<%--    <div>--%>
<%--        <span>GENDER: </span>--%>
<%--        <form:radiobutton path="gender" value="m" label="male"/>--%>
<%--        <form:radiobutton path="gender" value="f" label="female"/>--%>
<%--        <form:radiobutton path="gender" value="o" label="other"/>--%>
<%--    </div>--%>
    <div>
        <span>GENDER: </span>
        <form:radiobuttons path="gender" items="${user.genders}"/>
    </div>
    <div>
        <span>LANGUAGE: </span>
        <form:checkboxes path="selectedLanguages" items="${user.languages}"/>
    </div>

    <input type="submit">
</form:form>
</body>
</html>
