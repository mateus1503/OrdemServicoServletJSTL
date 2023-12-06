<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Editar Serviço</h2>
    <form action="editarServico" method="post">
        <label>
            <input type="hidden" name="id" value="${param.id}">
        </label>
        <label>Nome
            <input type="text" name="nome" value="${param.nome}" placeholder="Nome">
        </label>
        <label>Descrição
            <input type="text" name="descricao" value="${param.descricao}" placeholder="Descrição">
        </label>
        <label>Valor
            <input type="text" name="valor" value="${param.valor}" placeholder="Valor">
        </label>
        <input type="submit" value="Editar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>