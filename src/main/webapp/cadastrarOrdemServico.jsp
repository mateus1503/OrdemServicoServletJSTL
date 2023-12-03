<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <h2>Cadastrar Ordem de Serviço</h2>
    <form action="cadastrarOrdemServico" method="post">
        <label>ID:
            <input type="text" name="idcliente" value="${param.id}">
        </label>
        <label>Cliente:
            <input type="text" name="nomecliente" value="${param.nome}">
        </label>
        <label>Telefone:
            <input type="text" name="telefonecliente" value="${param.telefone}">
        </label>
        <br>
        <label>Endereco:
            <input type="text" name="enderecoCliente" value="${param.endereco}">
        </label>
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>