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

@WebServlet("/editarUsuario")
public class EditarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String usuarioId=request.getParameter("id");
            String nome=request.getParameter("nome");
            String login=request.getParameter("login");
            String senha=request.getParameter("senha");
            int id = Integer.parseInt(usuarioId);

            if(Validador.temConteudo(usuarioId)&&Validador.temConteudo(nome)
                    &&Validador.temConteudo(login)&&Validador.temConteudo(senha)) {
                Usuario u = new Usuario(id,nome,login,senha);
                try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                    dao.editar(u);
                    response.sendRedirect("listarUsuario.jsp?mensagem=editadocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("index.jsp?mensagem=falhaaotentareditar");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("index.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        }
    }
}
