<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Cadastrar Cliente</h2>
    <form action="cadastrarCliente" method="post">
        <label>Nome
            <input type="text" name="nome" placeholder="Nome">
        </label>
        <label>Endereço
            <input type="text" name="endereco" placeholder="Endereço">
        </label>
        <label>Telefone
            <input type="text" name="telefone" placeholder="Telefone">
        </label>
        <label>CPF
            <input type="text" name="cpf" placeholder="CPF">
        </label>
        <input type="submit" value="Cadastrar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>