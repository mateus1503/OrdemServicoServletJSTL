<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <table>
    <h4>Pesquisar Cliente</h4>
    <form method="GET" action="pesquisaCliente">
      <input type="text" name="nomeCliente" placeholder="Digite o nome do cliente">
      <button type="submit">Pesquisar</button>
      <a href="pesquisaCliente" class="btn-limpar">Limpar</a>
    </form>

    <h2>Clientes</h2>
    <c:forEach var="cliente" items="${clientes}">
      <section class="cliente">
        <h1>ID: ${cliente.id}</h1>
        <h1>Nome: ${cliente.nome}</h1>
        <p>
          <a href="editarCliente.jsp?id=${cliente.id}&nome=${cliente.nome}&endereco=${cliente.endereco}&telefone=${cliente.telefone}">Editar Dados</a>
          <a href="deletarCliente?id=${cliente.id}">Deletar Cliente</a>
          <a href="cadastrarOrdemServico.jsp?id=${cliente.id}&nome=${cliente.nome}&endereco=${cliente.endereco}&telefone=${cliente.telefone}">Realizar Ordem de Serviço</a>
        </p>
      </section>
    </c:forEach>
  </table>
</main>
<%@include file="rodape.jsp"%>