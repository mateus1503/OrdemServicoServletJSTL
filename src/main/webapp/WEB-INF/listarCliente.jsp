<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <link rel="stylesheet" href="styleListarCliente.css">
  <table>
    <h2>Clientes</h2>
    <c:forEach var="cliente" items="${clientes}">
      <section class="cliente">
        <h1>ID: ${cliente.id}</h1>
        <h1>Nome: ${cliente.nome}</h1>
        <p>
          <a href="listarVeiculo.jsp?id=${cliente.id}">Listar Veículos</a>
          <a href="editarCliente.jsp?id=${cliente.id}&nome=${cliente.nome}&endereco=${cliente.endereco}&telefone=${cliente.telefone}">Editar Dados</a>
          <a href="deletarCliente?id=${cliente.id}">Deletar Cliente</a>
          <a href="listarOrdemServico?id=${cliente.id}">Ordem de Serviços</a>
          <a href="processarOrdemServico.jsp?id=${cliente.id}">Realizar Ordem de Serviço</a>
        </p>
      </section>
    </c:forEach>
  </table>
</main>
<%@include file="rodape.jsp"%>