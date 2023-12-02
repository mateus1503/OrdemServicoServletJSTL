<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <h2>Cadastrar Ordem de Serviço</h2>
    <form action="cadastrarOrdemServico" method="post">
        <label>ID:
            <input type="text" name="id" value="id" placeholder="Id">
        </label>
        <label>Nome:
            <input type="text" name="nome" value="nome" placeholder="Nome">
        </label>
        <label>Telefone:
            <input type="text" name="telefone" value="telefone" placeholder="Telefone">
        </label>
        <br>
        <label>Endereco:
            <input type="text" name="endereco" value="endereco" placeholder="Endereco">
        </label>
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>