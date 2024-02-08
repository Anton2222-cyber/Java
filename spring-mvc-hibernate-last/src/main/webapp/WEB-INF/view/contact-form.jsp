<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        div {
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            display: block;
            font-size: 12px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<h1>Contact form</h1>
<form:form action="saveContact" modelAttribute="contact">
    <form:hidden path="id"/>
    <div>
        <form:input path="firstName" placeholder="First Name"/>
        <form:errors path="firstName" cssClass="error-message"/>
    </div>
    <div>
        <form:input path="lastName" placeholder="Last Name"/>
        <form:errors path="lastName" cssClass="error-message"/>
    </div>
    <div>
        <form:input path="phone" placeholder="Phone"/>
        <form:errors path="phone" cssClass="error-message"/>
    </div>
    <div>
        <form:input path="email" placeholder="Email"/>
        <form:errors path="email" cssClass="error-message"/>
    </div>
    <div>
        <label>Marital Status:</label>
        <div>
            <label><form:radiobutton path="maritalStatus" value="true"/> Married</label>
            <label><form:radiobutton path="maritalStatus" value="false"/> Not Married</label>
        </div>
    </div>
    <input type="submit" value="OK"/>
</form:form>
</body>
</html>
