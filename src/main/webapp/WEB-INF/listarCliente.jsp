<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="cabecalho.jsp"%>
<%@include file="menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <link rel="stylesheet" href="Stylesheet\styleListarCliente.css">
  <table>
    <h2>Clientes</h2>
    <c:forEach var="cliente" items="${clientes}">
      <section class="cliente">
        <h1>ID: ${cliente.id}</h1>
        <h1>Nome: ${cliente.nome}</h1>
        <h4>CPF: ${cliente.cpf}</h4>
        <h4>Telefone: ${cliente.telefone}</h4>
        <h4>Endereço: ${cliente.endereco}</h4>
        <p>
          <a href="processarOrdemServico?id=${cliente.id}">Realizar Ordem de Serviço</a>
          <a href="cadastrarVeiculo.jsp?id=${cliente.id}">Cadastrar Veículo</a>
          <a href="listarVeiculo.jsp?id=${cliente.id}">Listar Veículos</a>
          <a href="listarOrdemServico?id=${cliente.id}">Ordem de Serviços</a>
          <a href="editarCliente.jsp?id=${cliente.id}&nome=${cliente.nome}&endereco=${cliente.endereco}&telefone=${cliente.telefone}&cpf=${cliente.cpf}">Editar Dados</a>
          <a href="deletarCliente?id=${cliente.id}">Deletar Cliente</a>
        </p>
      </section>
    </c:forEach>
  </table>
</main>
<%@include file="rodape.jsp"%>