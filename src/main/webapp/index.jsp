<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="Stylesheet\styleLogin.css">
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="login">
    <h1>Login do Usuário</h1>
    <label>
        Login
        <input type="text" name="login" placeholder="Nome">
    </label>
    <label>
        Senha
        <input type="password" name="senha" placeholder="Senha">
    </label>
    <input type="submit" value="Login">
</form>
</body>
</html>