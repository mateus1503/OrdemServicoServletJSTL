<%@ page import="java.util.Set" %>
<%@ page import="aula.prestaservico.Modelo.Cliente" %>
<%@page pageEncoding="utf-8" %>
<%@include file="cabecalho.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
  <link rel="stylesheet" href="Stylesheet\styleListarUsuario.css">
  <table>
    <h2>Usuários</h2>
    <c:forEach var="usuario" items="${usuarios}">
      <section class="usuario">
        <h1>ID: ${usuario.id}</h1>
        <h1>Nome: ${usuario.nome}</h1>
        <p>
          <a href="editarUsuario.jsp?id=${usuario.id}&nome=${usuario.nome}&login=${usuario.login}&senha=${usuario.senha}">Editar Dados</a>
          <a href="deletarUsuario?id=${usuario.id}">Deletar Usuário</a>
        </p>
      </section>
    </c:forEach>
  </table>
</main>
<%@include file="rodape.jsp"%>