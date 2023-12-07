<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Ordem de Serviço</title>
    <link rel="stylesheet" href="Stylesheet/styleCabecalho.css">
</head>
<body>
<header>
    <h1>Sistema de Ordem de Serviço</h1>
    <c:if test="${not empty sessionScope.usuario}">
        <p>Olá <c:out value="${sessionScope.usuario.nome}" /></p>
    </c:if>
</header>
<div class="mensagem">
    <c:choose>
        <c:when test="${param.mensagem eq 'cadastradocomsucesso'}">
            <c:out value="Cadastrado com sucesso" />
        </c:when>
        <c:when test="${param.mensagem eq 'falhaaotentarcadastrar'}">
            <c:out value="Falha ao tentar cadastrar" />
        </c:when>
        <c:when test="${param.mensagem eq 'faltaparametros'}">
            <c:out value="Falta informar os parâmetros" />
        </c:when>
        <c:when test="${param.mensagem eq 'loginousenhaincorretos'}">
            <c:out value="Login ou senha incorretos" />
        </c:when>
        <c:when test="${param.mensagem eq 'tchau'}">
            <c:out value="Tchau" />
        </c:when>
        <c:when test="${param.mensagem eq 'sempermissao'}">
            <c:out value="Você não tem permissão. Faça o login." />
        </c:when>
        <c:when test="${param.mensagem eq 'telefonecadastradocomsucesso'}">
            <c:out value="Telefone cadastrado com sucesso" />
        </c:when>
        <c:when test="${param.mensagem eq 'acessonegado'}">
            <c:out value="Acesso negado! Faça login." />
        </c:when>
        <c:when test="${param.mensagem eq 'deletadocomsucesso'}">
            <c:out value="Deletado com sucesso" />
        </c:when>
        <c:when test="${param.mensagem eq 'comordemservico'}">
            <c:out value="Impossível deletar. Pois tem Ordem Serviço cadastrada" />
        </c:when>
        <c:when test="${param.mensagem eq 'falhaaotentardeletar'}">
            <c:out value="Erro ao tentar deletar" />
        </c:when>
        <c:when test="${param.mensagem eq 'editadocomsucesso'}">
            <c:out value="Editado com sucesso" />
        </c:when>
        <c:when test="${param.mensagem eq 'falhaaotentareditar'}">
            <c:out value="Erro ao tentar editar" />
        </c:when>
        <c:when test="${param.mensagem eq 'falhaaotentarlistar'}">
            <c:out value="Erro ao tentar listar" />
        </c:when>
        <c:when test="${param.mensagem eq 'logadocomsucesso'}">
            <c:out value="Logado com sucesso" />
        </c:when>
        <c:when test="${param.mensagem eq 'erroaotentarlogar'}">
            <c:out value="Erro ao tentar logar" />
        </c:when>
    </c:choose>
</div>
</body>
</html>
