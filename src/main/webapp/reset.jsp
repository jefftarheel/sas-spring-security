<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
</head>
<body>
<form th:action="@{/reset}" method="put" th:object="${user}">
    <input name="username" type="text" placeholder="Username">
    <input name="password" type="password" placeholder="Password">
    <input type="submit" value="Reset Password">
</form>
<a href="/login">Login</a>
</body>
</html>