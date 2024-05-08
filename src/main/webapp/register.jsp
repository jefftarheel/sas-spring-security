<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Registration page</title>
</head>
<body>
<form th:action="@{/register}" method="post" th:object="${user}">
    <input name="username" type="text" placeholder="Username">
    <input name="password" type="password" placeholder="Password">
    <input type="submit" value="Register">
</form>
<a href="/">Main page</a>
<a href="/login">Login</a>
</body>
</html>