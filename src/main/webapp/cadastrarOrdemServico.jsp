<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <h2>Cadastrar Ordem de Serviço</h2>
    <form action="cadastrarOrdemServico" method="post">
        <label>ID:
            <input type="text" name="id" value="${param.id}" placeholder="Id">
        </label>
        <label>Nome:
            <input type="text" name="nome" value="${param.nome}" placeholder="Nome">
        </label>
        <label>Telefone:
            <input type="text" name="telefone" value="${param.telefone}" placeholder="Telefone">
        </label>
        <br>
        <label>Endereco:
            <input type="text" name="endereco" value="${param.endereco}" placeholder="Endereco">
        </label>
        <br>
        <br>
        <br>
        <label>Serviços
            <input type="checkbox" name="teste">Teste
            <c:forEach var="servico" items="${servicos}">
                <section class="servico">
                    <p>
                        <input type="checkbox" name="${servico.nome}">Teste
                    </p>
                </section>
            </c:forEach>
        </label>
        <input type="submit" value="Editar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>