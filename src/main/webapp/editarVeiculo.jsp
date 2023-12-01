<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <h2>Editar</h2>
    <form action="editarVeiculo" method="post">
        <label>
            <input type="hidden" name="numeroSerie" value="${param.numeroSerie}">
        </label>
        <label>Nome
            <input type="text" name="nome" value="${param.nome}" placeholder="Nome">
        </label>
        <label>Modelo
            <input type="text" name="modelo" value="${param.modelo}" placeholder="Modelo">
        </label>
        <label>Marca
            <input type="text" name="marca" value="${param.marca}" placeholder="Marca">
        </label>
        <input type="submit" value="Editar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>