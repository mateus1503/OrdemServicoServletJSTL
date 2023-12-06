<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <table>
    <thead>
    <tr>
      <th>Identificação</th>
      <th>ID do Cliente</th>
      <th>ID do Veículo</th>
      <th>Observação</th>
      <th>Data de Entrada</th>
      <th>Data de Saída</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ordemServico" items="${ordemServicos}">
      <tr>
        <td>${ordemServico.id}</td>
        <td>${ordemServico.idCliente}</td>
        <td>${ordemServico.numeroserieVeiculo}</td>
        <td>${ordemServico.observacao}</td>
        <td>${ordemServico.dataEntrada}</td>
        <td>${ordemServico.dataSaida}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</main>
<%@include file="WEB-INF/rodape.jsp"%>