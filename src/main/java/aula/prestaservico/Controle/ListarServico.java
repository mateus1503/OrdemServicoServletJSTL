package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ServicoDaoClasse;
import aula.prestaservico.DAO.ServicoDaoInterface;
import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.Modelo.Servico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/listarServico.jsp")
public class ListarServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ServicoDaoInterface dao=new ServicoDaoClasse())
        {
            Set<Servico> servicos= dao.buscar();
            request.setAttribute("servicos",servicos);
            request.getRequestDispatcher("/WEB-INF/listarServico.jsp").forward(request,response);
        }catch (ErroDao e)
        {
            response.sendRedirect("index.jsp?mensagem=erroaotentarlistar");

        }
    }
}
