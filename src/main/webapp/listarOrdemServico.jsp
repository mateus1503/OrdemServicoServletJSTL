<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <link rel="stylesheet" href="Stylesheet\styleListarOS.css">
  <table>
    <thead>
    <tr>
      <th>Identificação</th>
      <th>ID do Cliente</th>
      <th>Nome do Cliente</th>
      <th>CPF do Cliente</th>
      <th>ID do Veículo</th>
      <th>Nome do Veículo</th>
      <th>Marca do Veículo</th>
      <th>Observação</th>
      <th>Data de Entrada</th>
      <th>Data de Saída</th>
      <th>Total dos Serviços</th>
      <th>Editar Ordem de Serviço</th>
      <th>Deletar Ordem de Serviço</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ordemServico" items="${ordemServicos}">
      <tr>
        <td>${ordemServico.id}</td>
        <td>${ordemServico.idCliente}</td>
        <td>${requestScope.cliente.nome}</td>
        <td>${requestScope.cliente.cpf}</td>
        <td>${ordemServico.numeroserieVeiculo}</td>
        <td>${requestScope.veiculo.nome}</td>
        <td>${requestScope.veiculo.marca}</td>
        <td>${ordemServico.observacao}</td>
        <td>${ordemServico.dataEntrada}</td>
        <td>${ordemServico.dataSaida}</td>
        <td>${ordemServico.valorTotal}</td>
        <td><a href="processarEditarOS?id=${ordemServico.id}&idCliente=${ordemServico.idCliente}">Editar</a></td>
        <td><a href="deletarOrdemServico?id=${ordemServico.id}">Deletar</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</main>
<%@include file="WEB-INF/rodape.jsp"%>