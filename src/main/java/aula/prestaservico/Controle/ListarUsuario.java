package aula.prestaservico.Controle;

import aula.prestaservico.DAO.UsuarioDaoClasse;
import aula.prestaservico.DAO.UsuarioDaoInterface;
import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet("/listarUsuario.jsp")
public class ListarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            try(UsuarioDaoInterface dao=new UsuarioDaoClasse())
            {
                Set<Usuario> usuarios= dao.buscar();
                request.setAttribute("usuarios",usuarios);
                request.getRequestDispatcher("/WEB-INF/listarUsuario.jsp").forward(request,response);
            }catch (ErroDao e)
            {
                response.sendRedirect("index.jsp?mensagem=erroaotentarlistar");

            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        }
    }
}
