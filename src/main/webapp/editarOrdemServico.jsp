<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <link rel="stylesheet" href="Stylesheet\styleCadastrar.css">
    <h2>Editar Serviço</h2>
    <form action="editarOrdemServico" method="post">
        <h3>Dados do Cliente:</h3>
        <label>
            <input type="hidden" name="id" value="${requestScope.ordemServico.id}">
        </label>
        <label>ID Cliente:
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
            <textarea name="observacao" maxlength="500">${requestScope.ordemServico.observacao}</textarea>
        </label>
        <br>
        <label><h3>Escolha o(s) Serviço(s):</h3>
            <c:forEach var="servico" items="${servicos}">
                <input type="checkbox" name="idServico" value="${servico.id}">${servico.nome}
            </c:forEach>
        </label>
        <br>
        <label><h3>Data de Entrada</h3>
            <input type="date" name="dataEntrada" value="${requestScope.ordemServico.dataEntrada}">
        </label>
        <label><h3>Data de Saída</h3>
            <input type="date" name="dataSaida" value="${requestScope.ordemServico.dataSaida}">
        </label>
        <br>
        <input type="submit" value="Editar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>