<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <link rel="stylesheet" href="Stylesheet\styleListarVeiculo.css">
  <table>
    <h2>Clientes</h2>
    <c:forEach var="veiculo" items="${veiculos}">
      <section class="servico">
        <h1>ID: ${veiculo.numeroSerie}</h1>
        <h1>Nome: ${veiculo.nome}</h1>
        <p>
          <a href="editarVeiculo.jsp?numeroSerie=${veiculo.numeroSerie}&nome=${veiculo.nome}&modelo=${veiculo.modelo}&marca=${veiculo.marca}">Editar Dados</a>
          <a href="deletarVeiculo?numeroSerie=${veiculo.numeroSerie}">Deletar Veículo</a>
          <a href="anamneseCreate.jsp?id=${paciente.id}">Realizar Consulta</a>
        </p>
      </section>
    </c:forEach>
  </table>
</main>
<%@include file="rodape.jsp"%>