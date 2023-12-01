<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <h2>Editar Usuário</h2>
    <form action="editarUsuario" method="post">
        <label>
            <input type="hidden" name="id" value="${param.id}">
        </label>
        <label>Nome
            <input type="text" name="nome" value="${param.nome}" placeholder="Nome">
        </label>
        <label>Login
            <input type="text" name="login" value="${param.login}" placeholder="Login">
        </label>
        <label>Senha
            <input type="text" name="senha" value="${param.senha}" placeholder="Senha">
        </label>
        <input type="submit" value="Editar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>