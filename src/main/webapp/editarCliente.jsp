<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@include file="WEB-INF/menu.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Editar Cliente</h2>
    <form action="editarCliente" method="post">
        <label>
            <input type="hidden" name="id" value="${param.id}">
        </label>
        <label>Nome
            <input type="text" name="nome" value="${param.nome}" placeholder="Nome">
        </label>
        <label>Endereco
            <input type="text" name="endereco" value="${param.endereco}" placeholder="Endereco">
        </label>
        <label>Telefone
            <input type="text" name="telefone" value="${param.telefone}" placeholder="Telefone">
        </label>
        <label>CPF
            <input type="text" name="cpf" value="${param.cpf}" placeholder="CPF">
        </label>
        <input type="submit" value="Editar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>