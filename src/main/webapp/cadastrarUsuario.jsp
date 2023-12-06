<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Cadastrar Usuário</h2>
    <form action="cadastrarUsuario" method="post">
        <label>Nome
            <input type="text" name="nome" placeholder="Nome">
        </label>
        <label>Login
            <input type="text" name="login" placeholder="Login">
        </label>
        <label>Senha
            <input type="password" name="senha" placeholder="Senha">
        </label>
        <input type="submit" value="Cadastrar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>