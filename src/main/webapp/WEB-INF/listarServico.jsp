<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <table>
    <h2>Serviços</h2>
    <c:forEach var="servico" items="${servicos}">
      <section class="servico">
        <h1>ID: ${servico.id}</h1>
        <h1>Nome: ${servico.nome}</h1>
        <p>
          <a href="editarServico.jsp?id=${servico.id}&nome=${servico.nome}&descricao=${servico.descricao}&valor=${servico.valor}">Editar Dados</a>
          <a href="deletarServico?id=${servico.id}">Deletar Serviço</a>
        </p>
      </section>
    </c:forEach>
  </table>
</main>
<%@include file="rodape.jsp"%>