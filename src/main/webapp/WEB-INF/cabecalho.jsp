<%@ page import="aula.prestaservico.Modelo.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <header>
        <h1>Sistema de Ordem de Serviço</h1>
        <%
            Usuario usuarioLogado=(Usuario) session.getAttribute("usuario");
            if(usuarioLogado!=null)
                out.print("<p>Olá "+usuarioLogado.getNome()+"</p>");
        %>
    </header>
    <div class="mensagem">
        <%
            String mensagem=request.getParameter("mensagem");
            if("cadastradocomsucesso".equals(mensagem))
                out.print("Cadastrado com sucesso");
            if("falhaaotentarcadastrar".equals(mensagem))
                out.print("Falha ao tentar cadastrar");
            if("faltaparametros".equals(mensagem))
                out.print("Falta informar os parâmetros");
            if("loginousenhaincorretos".equals(mensagem))
                out.print("Login ou senha incorretos");
            if("tchau".equals(mensagem))
                out.print("Tchau");
            if("sempermissao".equals(mensagem))
                out.print("Você não tem permissão. Faça o login.");
            if("telefonecadastradocomsucesso".equals(mensagem))
                out.print("Telefone cadastrado com sucesso");
        %>
    </div>
    <%@include file="menu.jsp"%>
