<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="">

    <input type="text" required placeholder="login" name="login" minlength="3"><br>
    <input type="password" required placeholder="password" name="password" pattern="[\w]{6,}"><br><br>
    <input class="button" type="submit" value="Войти">

</form>
<a href="registration">Зарегистрироваться</a>
</body>
</html>
