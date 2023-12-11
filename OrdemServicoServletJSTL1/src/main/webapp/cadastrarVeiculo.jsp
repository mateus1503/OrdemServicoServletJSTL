<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@include file="WEB-INF/menu.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Cadastrar Veículo</h2>
    <form action="cadastrarVeiculo" method="post">
        <label>
            <input type="hidden" name="id" value="${param.id}">
        </label>
        <label>Nome
            <input type="text" name="nome" placeholder="Nome">
        </label>
        <label>Modelo
            <input type="text" name="modelo" placeholder="Modelo">
        </label>
        </label>
        <label>Marca
            <input type="text" name="marca" placeholder="Marca">
        </label>
        <input type="submit" value="Cadastrar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>