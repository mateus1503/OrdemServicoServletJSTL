package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.ClienteDaoInterface;
import aula.prestaservico.DAO.ClienteDaoClasse;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Modelo.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/listarCliente.jsp")
public class ListarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            try(ClienteDaoInterface dao=new ClienteDaoClasse())
            {
                List<Cliente> clientes= dao.buscar();
                request.setAttribute("clientes",clientes);
                request.getRequestDispatcher("/WEB-INF/listarCliente.jsp").forward(request,response);
            }catch (ErroDao e)
            {
                response.sendRedirect("index.jsp?mensagem=erroaotentarlistar");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
