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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletarUsuario")
public class DeletarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String usuarioId=request.getParameter("id");
            int id = Integer.parseInt(usuarioId);

            if(Validador.temConteudo(usuarioId)) {
                Usuario u = new Usuario(id);
                try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                    dao.deletar(u);
                    response.sendRedirect("listarUsuario.jsp?mensagem=deletadocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("listarUsuario.jsp?mensagem=falhaaotentardeletar");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("listarUsuario.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
