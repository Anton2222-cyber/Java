<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Profile</title>
    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css"/>
</head>
<body>
<div class="show-profile-container">
    <h1>User Profile</h1>
    <p>Name: ${name}</p>
    <p>Surname: ${surname}</p>
    <p>Patronymic: ${patronymic}</p>
    <p>Birth Year: ${birthYear}</p>
    <p>Location: ${location}</p>

</div>
</body>
</html>
