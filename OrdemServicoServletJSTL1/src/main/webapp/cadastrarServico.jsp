<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@include file="WEB-INF/menu.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Cadastrar Serviço</h2>
    <form action="cadastrarServico" method="post">
        <label>Nome
            <input type="text" name="nome" placeholder="Nome">
        </label>
        <label>Descrição
            <input type="text" name="descricao" placeholder="Descrição">
        </label>
        </label>
        <label>Valor
            <input type="text" name="valor" placeholder="Valor">
        </label>
        <input type="submit" value="Cadastrar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>