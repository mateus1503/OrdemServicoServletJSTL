package aula.prestaservico.Controle;

import aula.prestaservico.DAO.UsuarioDaoClasse;
import aula.prestaservico.DAO.UsuarioDaoInterface;
import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletarUsuario")
public class DeletarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String usuarioId=request.getParameter("id");
        int id = Integer.parseInt(usuarioId);

        if(Validador.temConteudo(usuarioId)) {
            Usuario u = new Usuario(id);
            try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                dao.deletar(u);
                response.sendRedirect("listarUsuario.jsp?mensagem=deletadocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("index.jsp?mensagem=falhaaotentareditar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("index.jsp?mensagem=faltaparametros");
        }
        //System.out.println(aplicacao.getAttribute("usuarios"));
    }
}
