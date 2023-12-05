<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <h2>Cadastrar Ordem de Serviço</h2>
        <form action="cadastrarOrdemServico" method="get">
            <h3>Dados do Cliente:</h3>
            <label>ID:
                <input type="text" name="idCliente" value="${requestScope.cliente.id}">
            </label>
            <label>Cliente:
                <input type="text" name="nomeCliente" value="${requestScope.cliente.nome}">
            </label>
            <label>CPF:
                <input type="text" name="cpfCliente" value="${requestScope.cliente.cpf}">
            </label><br>
            <label>Endereco:
                <input type="text" name="enderecoCliente" value="${requestScope.cliente.endereco}">
            </label>
            <label>Telefone:
                <input type="text" name="telefoneCliente" value="${requestScope.cliente.telefone}">
            </label>
            <br>
            <label><h3>Escolha o Veículo:</h3>
                <select id="veiculos" name="numeroserieVeiculo">
                    <c:forEach var="veiculo" items="${veiculos}">
                        <option value="${veiculo.numeroSerie}">${veiculo.nome}</option>
                    </c:forEach>
                </select>
            </label>
            <br>
            <label><h3>Observação:</h3>
                <textarea name="observacao" maxlength="500"></textarea>
            </label>
            <br>
            <label><h3>Escolha o(s) Serviço(s):</h3>
                <c:forEach var="servico" items="${servicos}">
                    <input type="checkbox" name="idServico" value="${servico.id}">${servico.nome}
                </c:forEach>
            </label>
            <br>
            <label><h3>Data de Entrada</h3>
                <input type="date" name="dataEntrada">
            </label>
            <label><h3>Data de Saída</h3>
                <input type="date" name="dataSaida">
            </label>
            <br>
            <input type="submit" value="Cadastrar">
        </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>