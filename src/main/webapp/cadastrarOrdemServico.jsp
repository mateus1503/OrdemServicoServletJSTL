<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <h2>Cadastrar Ordem de Serviço</h2>
        <form action="cadastrarOrdemServico" method="get">
            <h3>Dados do Cliente:</h3>
            <label>ID:
                <input type="text" name="idcliente" value="${requestScope.cliente.id}">
            </label>
            <label>Cliente:
                <input type="text" name="nomecliente" value="${requestScope.cliente.nome}">
            </label>
            <label>CPF:
                <input type="text" name="cpfcliente" value="${requestScope.cliente.cpf}">
            </label>
            <label>Endereco:
                <input type="text" name="enderecoCliente" value="${requestScope.cliente.endereco}">
            </label>
            <label>Telefone:
                <input type="text" name="telefonecliente" value="${requestScope.cliente.telefone}">
            </label>
            <br>
            <br>
            <label><h3>Escolha o Veículo:</h3>
                <select id="veiculos" name="veiculo">
                    <c:forEach var="veiculo" items="${veiculos}">
                        <option value="${veiculo.numeroSerie}">${veiculo.nome}</option>
                    </c:forEach>
                </select>
            </label>
            <br>
            <br>
            <label>Escolha o(s) Serviço(s):
                <c:forEach var="servico" items="${servicos}">
                    <input type="checkbox" name="id" value="${servico.id}">${servico.nome}
                </c:forEach>
            </label>
            <br>
            <input type="submit" value="Cadastrar">
        </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>