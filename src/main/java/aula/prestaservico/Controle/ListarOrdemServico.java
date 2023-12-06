package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.OrdemServicoDaoClasse;
import aula.prestaservico.DAO.OrdemServicoDaoInterface;
import aula.prestaservico.Modelo.OrdemServico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarOrdemServico")
public class ListarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(OrdemServicoDaoInterface dao=new OrdemServicoDaoClasse())
        {
            String clienteId=request.getParameter("id");
            int id = Integer.parseInt(clienteId);

            List<OrdemServico> ordemServicos= dao.buscar(id);
            request.setAttribute("ordemServicos",ordemServicos);
            request.getRequestDispatcher("listarOrdemServico.jsp").forward(request,response);
        }catch (ErroDao e)
        {
            response.sendRedirect("listarCliente.jsp?mensagem=erroaotentarlistar");

        }
    }
}
