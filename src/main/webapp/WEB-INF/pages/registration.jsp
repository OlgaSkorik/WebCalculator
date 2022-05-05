<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration">

    Name:
    <input type="text" name="name" placeholder="Enter your name" minlength="3">

    Login:
    <input type="text" name="login" placeholder="Enter your login" minlength="3">

    Password:
    <input type="password" name="password" placeholder="Enter your password" pattern="[\w]{6,}">

    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
