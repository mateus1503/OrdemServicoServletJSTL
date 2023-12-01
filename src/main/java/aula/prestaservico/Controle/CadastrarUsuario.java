package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.UsuarioDaoInterface;
import aula.prestaservico.DAO.UsuarioDaoClasse;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String nome=request.getParameter("nome");
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");

        if(Validador.temConteudo(nome)&&Validador.temConteudo(login)
                &&Validador.temConteudo(senha)) {
            Usuario u = new Usuario(nome,login,senha);
            try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                dao.inserir(u);
                response.sendRedirect("listarUsuario.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("cadastrarUsuario?mensagem=falhaaotentarcadastrar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("cadastrarUsuario?mensagem=faltaparametros");
        }
        //System.out.println(aplicacao.getAttribute("usuarios"));
    }
}
